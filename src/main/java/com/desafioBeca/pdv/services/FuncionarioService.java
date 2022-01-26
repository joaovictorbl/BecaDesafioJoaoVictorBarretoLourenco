package com.desafioBeca.pdv.services;

import com.desafioBeca.pdv.model.Funcionario;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FuncionarioService {

    public Funcionario criar (Funcionario funcionario) {

        System.out.println(funcionario);

        funcionario.setId(1);

        System.out.println("novo fucionario");

        return funcionario;

    }


    public List<Funcionario> lista () {

        Funcionario fu1 = new Funcionario();
        fu1.setId(1);
        fu1.setNome("carlos");

        Funcionario fu2 = new Funcionario();
        fu2.setId(2);
        fu2.setNome("pedro");

        return List.of(fu1, fu2);
    }


    public Funcionario atualizar (Funcionario funcionario, Integer id) {

        funcionario.setId(id);

        return funcionario;

    }


    public void deletar (Integer id) {


    }


    public Funcionario obter (Integer id ) {

        Funcionario fu1 = new Funcionario();
        fu1.setId(id);
        fu1.setNome("patrão");

        return fu1;
    }

}
