package com.desafioBeca.pdv.services;

import com.desafioBeca.pdv.Interfaces.ProdutoInterface;
import com.desafioBeca.pdv.dtos.requests.PatchProdutoRequest;
import com.desafioBeca.pdv.dtos.requests.PostProdutoRequest;
import com.desafioBeca.pdv.dtos.responses.*;
import com.desafioBeca.pdv.models.Funcionario;
import com.desafioBeca.pdv.models.Produto;
import com.desafioBeca.pdv.repositories.FuncionarioRepository;
import com.desafioBeca.pdv.repositories.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProdutoService implements ProdutoInterface {

    @Autowired
    private ProdutoRepository produtoRepository;


    public PostProdutoReponse criar(PostProdutoRequest postProdutoRequest) {

        Produto produtoNovo = this.produtoPost(postProdutoRequest);
        produtoRepository.save(produtoNovo);
        PostProdutoReponse produtoResposta = this.postProdutoReponse(produtoNovo);

        return produtoResposta;
    }


    public List<GetProdutoListarResponse> lista() {

        List<Produto> listaProdutos = produtoRepository.findAll();
        return listaProdutos.stream().map(produto -> this.converte(produto))
                .collect(Collectors.toList());
    }


    public PatchProdutoResponse atualizar(PatchProdutoRequest patchProdutoRequest, Integer id) {

        Produto produtoObtido = produtoRepository.findById(id).get();
        produtoObtido = this.patchProdutoRequest(patchProdutoRequest);
        produtoRepository.save(produtoObtido);

        return this.patchProdutoResponse(produtoObtido);
    }

    public void deletar(Integer id) {
        produtoRepository.deleteById(id);
    }

    public GetProdutoObterResponse obter(Integer id) {

        Produto produtoSelecao = produtoRepository.findById(id).get();

        if (produtoSelecao == null){
            throw new RuntimeException("Id funcionario não existe");
        }

        return this.getProdutoObterResponse(produtoSelecao);
    }

    private Produto produtoPost(PostProdutoRequest postProdutoRequest) {
     Produto produto = new Produto();
     produto.setNome(postProdutoRequest.getNome());
     produto.setValor(postProdutoRequest.getValor());
     produto.setQuantidade(postProdutoRequest.getQuantidade());
     produto.setDescricao(postProdutoRequest.getDescricao());

     return produto;
    }

    private  PostProdutoReponse postProdutoReponse (Produto produto) {
        PostProdutoReponse postProdutoReponse = new PostProdutoReponse();
        postProdutoReponse.setNome(produto.getNome());
        postProdutoReponse.setValor(produto.getValor());
        postProdutoReponse.setQuantidade(produto.getQuantidade());
        postProdutoReponse.setDescricao(produto.getDescricao());

        return postProdutoReponse;
    }

    private GetProdutoObterResponse getProdutoObterResponse (Produto produto) {
        GetProdutoObterResponse produtoGet = new GetProdutoObterResponse();
        produtoGet.setNome(produto.getNome());
        produtoGet.setQuantidade(produto.getQuantidade());
        produtoGet.setValor(produto.getValor());
        produtoGet.setDescricao(produto.getDescricao());

        return produtoGet;
    }

    private Produto patchProdutoRequest(PatchProdutoRequest patchProdutoRequest) {
        Produto produtoAtualizar = new Produto();
        produtoAtualizar.setNome(patchProdutoRequest.getNome());
        produtoAtualizar.setValor(patchProdutoRequest.getValor());
        produtoAtualizar.setQuantidade(patchProdutoRequest.getQuantidade());
        produtoAtualizar.setDescricao(produtoAtualizar.getDescricao());

        return produtoAtualizar;
    }

    private PatchProdutoResponse patchProdutoResponse(Produto produto) {
        PatchProdutoResponse produtoPath = new PatchProdutoResponse();
        produtoPath.setNome(produto.getNome());
        produtoPath.setQuantidade(produto.getQuantidade());
        produtoPath.setValor(produto.getValor());
        produtoPath.setDescricao(produto.getDescricao());

        return produtoPath;
    }

    private GetProdutoListarResponse converte(Produto produto) {
        GetProdutoListarResponse listarProduto = new GetProdutoListarResponse();
        listarProduto.setId(produto.getId());
        listarProduto.setNome(produto.getNome());

        return listarProduto;
    }

}
