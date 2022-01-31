package com.desafioBeca.pdv.services;

import com.desafioBeca.pdv.Interfaces.FuncionarioInterface;
import com.desafioBeca.pdv.models.Funcionario;
import com.desafioBeca.pdv.repositories.FuncionarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FuncionarioService implements FuncionarioInterface {

    @Autowired
    private FuncionarioRepository funcionarioRepository;


    public Funcionario criar (Funcionario funcionario) {

       Funcionario funcionarioNovo = funcionarioRepository.save(funcionario);

        return funcionarioNovo;
    }


    public List<Funcionario> lista() {

       List<Funcionario> listaFuncionario = funcionarioRepository.findAll();

        return listaFuncionario;
    }


    public Funcionario atualizar (Funcionario funcionario, Integer id) {

        Funcionario funcionarioObtido = this.obter(id);
        funcionarioObtido.setNome(funcionario.getNome());
        funcionarioObtido.setCpf(funcionario.getCpf());
        funcionarioObtido.setNumero(funcionario.getNumero());
        funcionarioObtido.setCep(funcionario.getCep());
        funcionarioObtido.setLogradouro(funcionario.getLogradouro());
        funcionarioRepository.save(funcionarioObtido);

        return funcionarioObtido;
    }


    public void deletar (Integer id) {
        funcionarioRepository.deleteById(id);

    }


    public Funcionario obter (Integer id ) {

        Funcionario funcuinarioSelecao = funcionarioRepository.findById(id).get();

        if (funcuinarioSelecao == null) {
            throw new RuntimeException("Id funcionario não existe! ");
        }
        return funcuinarioSelecao;
    }

}
