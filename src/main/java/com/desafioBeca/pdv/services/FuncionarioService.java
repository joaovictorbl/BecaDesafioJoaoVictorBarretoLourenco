package com.desafioBeca.pdv.services;

import com.desafioBeca.pdv.Interfaces.FuncionarioInterface;
import com.desafioBeca.pdv.dtos.requests.PatchClienteResquest;
import com.desafioBeca.pdv.dtos.requests.PatchFuncionarioRequest;
import com.desafioBeca.pdv.dtos.requests.PostFuncionarioRequest;
import com.desafioBeca.pdv.dtos.responses.*;
import com.desafioBeca.pdv.models.Funcionario;
import com.desafioBeca.pdv.repositories.FuncionarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class FuncionarioService implements FuncionarioInterface {

    @Autowired
    private FuncionarioRepository funcionarioRepository;


    public PostFuncionarioResponse criar(PostFuncionarioRequest postFuncionarioRequest) {

        Funcionario funcionarioNovo = this.funcionarioPost(postFuncionarioRequest);
        funcionarioRepository.save(funcionarioNovo);
        PostFuncionarioResponse funcionarioPost = this.postFuncionarioResponse(funcionarioNovo);

        return funcionarioPost;
    }


    public List<GetFuncionarioListarResponse> lista() {

        List<Funcionario> listaFuncionario = funcionarioRepository.findAll();

        return listaFuncionario.stream().map(funcionario ->
                this.converte(funcionario)).collect(Collectors.toList());
    }

    public PatchFuncionarioResponse atualizar(PatchFuncionarioRequest patchFuncionarioRequest, Integer id) {

        Funcionario funcionarioObtido = funcionarioRepository.findById(id).get();
       funcionarioObtido = this.patchFuncionarioRequest(patchFuncionarioRequest);
        funcionarioRepository.save(funcionarioObtido);

        return this.patchFuncionarioResponse(funcionarioObtido);
    }


    public void deletar(Integer id) {
        funcionarioRepository.deleteById(id);

    }


    public GetFuncionarioObterResponse obter(Integer id) {

        Funcionario funcionario = funcionarioRepository.findById(id).get();

        if (funcionario == null) {
            throw new RuntimeException("Id funcionario não existe! ");
        }
        return this.getFuncionarioObterResponse(funcionario);
    }

    private Funcionario funcionarioPost(PostFuncionarioRequest postFuncionarioRequest) {
        Funcionario funcionario = new Funcionario();
        funcionario.setNome(postFuncionarioRequest.getNome());
        funcionario.setCpf(postFuncionarioRequest.getCpf());
        funcionario.setTelefone(postFuncionarioRequest.getTelefone());
        funcionario.setLogradouro(postFuncionarioRequest.getLogradouro());
        funcionario.setCep(postFuncionarioRequest.getCep());

        return funcionario;
    }

    private PostFuncionarioResponse postFuncionarioResponse(Funcionario funcionario) {
        PostFuncionarioResponse postFuncionarioResponse = new PostFuncionarioResponse();
        postFuncionarioResponse.setNome(funcionario.getNome());

        return postFuncionarioResponse;
    }

    private GetFuncionarioObterResponse getFuncionarioObterResponse(Funcionario funcionario) {
        GetFuncionarioObterResponse funcionarioGet = new GetFuncionarioObterResponse();
        funcionarioGet.setNome(funcionario.getNome());
        funcionarioGet.setCpf(funcionario.getCpf());
        funcionarioGet.setTelefone(funcionario.getTelefone());
        funcionarioGet.setCep(funcionario.getCep());
        funcionarioGet.setLogradouro(funcionarioGet.getLogradouro());

        return funcionarioGet;
    }

    private Funcionario patchFuncionarioRequest(PatchFuncionarioRequest patchFuncionarioRequest) {
        Funcionario funcionarioAtualizar = new Funcionario();
        funcionarioAtualizar.setNome(patchFuncionarioRequest.getNome());
        funcionarioAtualizar.setCpf(patchFuncionarioRequest.getCpf());
        funcionarioAtualizar.setTelefone(patchFuncionarioRequest.getTelefone());
        funcionarioAtualizar.setCep(patchFuncionarioRequest.getCep());
        funcionarioAtualizar.setLogradouro(patchFuncionarioRequest.getLogradouro());

        return funcionarioAtualizar;
    }

    private PatchFuncionarioResponse patchFuncionarioResponse(Funcionario funcionario) {
        PatchFuncionarioResponse funcionairoPacht = new PatchFuncionarioResponse();
        funcionairoPacht.setNome(funcionario.getNome());
        funcionairoPacht.setCpf(funcionario.getCpf());
        funcionairoPacht.setTelefone(funcionario.getTelefone());
        funcionairoPacht.setCep(funcionario.getCep());
        funcionairoPacht.setLogradouro(funcionario.getLogradouro());

        return  funcionairoPacht;
    }

    private  GetFuncionarioListarResponse converte(Funcionario funcionario) {
        GetFuncionarioListarResponse listarFuncioanrio = new GetFuncionarioListarResponse();
        listarFuncioanrio.setId(funcionario.getId());
        listarFuncioanrio.setNome(funcionario.getNome());

        return listarFuncioanrio;
    }

}
