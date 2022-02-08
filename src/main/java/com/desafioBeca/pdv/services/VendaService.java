package com.desafioBeca.pdv.services;


import com.desafioBeca.pdv.Interfaces.VendaInterface;
import com.desafioBeca.pdv.dtos.requests.PatchVendaRequest;
import com.desafioBeca.pdv.dtos.requests.PostVendaRequest;
import com.desafioBeca.pdv.dtos.responses.*;
import com.desafioBeca.pdv.models.Produto;
import com.desafioBeca.pdv.models.Venda;;
import com.desafioBeca.pdv.repositories.VendaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class VendaService implements VendaInterface {

    private final VendaRepository vendaRepository;

    private final ProdutoService produtoService;

    public PostVendaResponse criar(PostVendaRequest postVendaRequest) {

        Venda novaVenda = this.postVenda(postVendaRequest);

        vendaRepository.save(novaVenda);
        return this.vendaResponse(novaVenda);
    }

    public List<GetVendaListarResponse> lista() {

        List<Venda> listaVenda = vendaRepository.findAll();
        return listaVenda.stream().map(
                venda -> this.converte(venda)
        ).collect(Collectors.toList());
    }

    public PatchVendaResponse atualizar(PatchVendaRequest patchVendaRequest, Integer id) {

        Venda vendaObtida = vendaRepository.findById(id).get();
        vendaObtida = this.patchVendaRequest(patchVendaRequest);
        vendaRepository.save(vendaObtida);

        return this.patchVendaResponse(vendaObtida);
    }


    public void deleta(Integer id) {
        vendaRepository.deleteById(id);

    }

    public GetVendaObterResponse obter(Integer id) {

        Venda vendaSelecao = vendaRepository.findById(id).get();

        if (vendaSelecao == null) {
            throw new RuntimeException("Id de venda não existe! ");
        }
        return this.getVendaObterResponse(vendaSelecao);
    }

    public Venda postVenda(PostVendaRequest postVendaRequest) {
        Venda venda = new Venda();
        venda.getProduto().setId(postVendaRequest.getProduto());
        venda.setValorFinal(postVendaRequest.getValorFinal());
        venda.setQuantidadeFinal(postVendaRequest.getQuantidadeFinal());

        return venda;
    }

    public PostVendaResponse vendaResponse(Venda venda) {
        PostVendaResponse postVendaResponse = new PostVendaResponse();
        postVendaResponse.setId(venda.getId());
        postVendaResponse.setProduto(venda.getProduto().getNome());
        postVendaResponse.setQuantidadeFinal(venda.getQuantidadeFinal());
        postVendaResponse.setValorFinal(venda.getValorFinal());

        return postVendaResponse;
    }

    private GetVendaObterResponse getVendaObterResponse(Venda venda) {
        GetVendaObterResponse vendaGet = new GetVendaObterResponse();
        vendaGet.setValorFinal(venda.getValorFinal());
        vendaGet.setQuantidadeFinal(venda.getQuantidadeFinal());

        return vendaGet;
    }

    private Venda patchVendaRequest(PatchVendaRequest patchVendaRequest) {
        Venda vendaAtualizar = new Venda();
        vendaAtualizar.setQuantidadeFinal(patchVendaRequest.getQuantidadeFinal());
        vendaAtualizar.setValorFinal(patchVendaRequest.getValorFinal());

        return vendaAtualizar;
    }

    private  PatchVendaResponse patchVendaResponse (Venda venda) {
        PatchVendaResponse vendaPatch = new PatchVendaResponse();
        vendaPatch.setQuantidadeFinal(venda.getQuantidadeFinal());
        vendaPatch.setValorFinal(venda.getValorFinal());

        return vendaPatch;
    }

    private GetVendaListarResponse converte(Venda venda) {
        GetVendaListarResponse vendaListar = new GetVendaListarResponse();
        vendaListar.setId(venda.getId());

        return vendaListar;
    }
}
