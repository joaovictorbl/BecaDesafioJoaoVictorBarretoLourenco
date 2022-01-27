package com.desafioBeca.pdv.services;


import com.desafioBeca.pdv.Interfaces.VendaInterface;
import com.desafioBeca.pdv.model.Venda;;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VendaService implements VendaInterface {



    public Venda criar(Venda venda) {

        System.out.println(venda);

        venda.setId(1);

        System.out.println("Nova venda ");

        return venda;

    }


    public List<Venda> lista() {

        Venda ven1 = new Venda();
        ven1.setId(1);
        ven1.setNome("venda concluida");

        Venda ven2 = new Venda();
        ven2.setId(2);
        ven2.setNome("venda efetuada");

        Venda ven3 = new Venda();
        ven3.setId(3);
        ven3.setNome("ficando rico");

        return List.of(
                ven1,
                ven2,
                ven3
        );

    }


    public Venda atualizar(Venda venda, Integer id) {

        venda.setId(id);

        return venda;
    }


    public void deleta(Integer id) {

    }


    public Venda obter(Integer id ) {

        Venda ven1 = new Venda();
        ven1.setId(id);
        ven1.setNome("ta de boa ");

        return ven1;

    }
}
