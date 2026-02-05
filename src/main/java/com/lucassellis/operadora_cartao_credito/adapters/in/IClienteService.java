package com.lucassellis.operadora_cartao_credito.adapters.in;

import com.lucassellis.operadora_cartao_credito.application.domain.ClienteDomain;

public interface IClienteService {

    ClienteDomain solicitarCartao(ClienteDomain cliente);

    public ClienteDomain buscarPorCpf(String cpf);
}
