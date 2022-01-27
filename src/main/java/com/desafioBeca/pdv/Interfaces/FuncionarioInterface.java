package com.desafioBeca.pdv.Interfaces;

import com.desafioBeca.pdv.model.Funcionario;

import java.util.List;

public interface FuncionarioInterface {

    Funcionario criar (Funcionario funcionario);

    List<Funcionario> lista ();

    Funcionario atualizar (Funcionario funcionario, Integer id);

    void deletar (Integer id);

    Funcionario obter (Integer id);

}
