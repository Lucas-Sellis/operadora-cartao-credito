package com.lucassellis.operadora_cartao_credito.porters.out;

import com.lucassellis.operadora_cartao_credito.application.domain.ClienteDomain;

import java.util.Optional;

public interface IClienteRepository {

    ClienteDomain salvar(ClienteDomain clienteDomain);

    Boolean buscarUsuarioPorEmail(String email);

    Optional<ClienteDomain> buscaUsuarioPorCpf(String cpf);
}
