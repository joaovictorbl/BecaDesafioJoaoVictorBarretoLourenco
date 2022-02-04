package com.desafioBeca.pdv.services;

import com.desafioBeca.pdv.Interfaces.FuncionarioInterface;
import com.desafioBeca.pdv.dtos.requests.PostFuncionarioRequest;
import com.desafioBeca.pdv.dtos.responses.PostFuncionarioResponse;
import com.desafioBeca.pdv.models.Funcionario;
import com.desafioBeca.pdv.repositories.FuncionarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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


    public List<Funcionario> lista() {

        List<Funcionario> listaFuncionario = funcionarioRepository.findAll();

        return listaFuncionario;
    }


    public Funcionario atualizar(Funcionario funcionario, Integer id) {

        Funcionario funcionarioObtido = this.obter(id);
        funcionarioObtido.setNome(funcionario.getNome());
        funcionarioObtido.setCpf(funcionario.getCpf());
        funcionarioObtido.setTelefone(funcionario.getTelefone());
        funcionarioObtido.setCep(funcionario.getCep());
        funcionarioObtido.setLogradouro(funcionario.getLogradouro());
        funcionarioRepository.save(funcionarioObtido);

        return funcionarioObtido;
    }


    public void deletar(Integer id) {
        funcionarioRepository.deleteById(id);

    }


    public Funcionario obter(Integer id) {

        Funcionario funcuinarioSelecao = funcionarioRepository.findById(id).get();

        if (funcuinarioSelecao == null) {
            throw new RuntimeException("Id funcionario não existe! ");
        }
        return funcuinarioSelecao;
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

}
