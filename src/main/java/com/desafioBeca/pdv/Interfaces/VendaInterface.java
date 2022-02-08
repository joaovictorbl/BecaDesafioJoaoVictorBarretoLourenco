package com.desafioBeca.pdv.Interfaces;

import com.desafioBeca.pdv.dtos.requests.PatchVendaRequest;
import com.desafioBeca.pdv.dtos.requests.PostVendaRequest;
import com.desafioBeca.pdv.dtos.responses.GetVendaListarResponse;
import com.desafioBeca.pdv.dtos.responses.GetVendaObterResponse;
import com.desafioBeca.pdv.dtos.responses.PatchVendaResponse;
import com.desafioBeca.pdv.dtos.responses.PostVendaResponse;
import com.desafioBeca.pdv.models.Venda;

import java.util.List;

public interface VendaInterface {

    PostVendaResponse criar(PostVendaRequest postVendaRequest);

    List<GetVendaListarResponse> lista();

    PatchVendaResponse atualizar(PatchVendaRequest patchVendaRequest, Integer id);

    void deleta(Integer id);

    GetVendaObterResponse obter(Integer id);
}
