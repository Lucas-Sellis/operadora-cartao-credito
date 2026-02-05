package com.lucassellis.operadora_cartao_credito.adapters.out;

import com.lucassellis.operadora_cartao_credito.adapters.mapper.ClienteMapper;
import com.lucassellis.operadora_cartao_credito.adapters.out.repositories.ClienteJpaRepository;
import com.lucassellis.operadora_cartao_credito.application.domain.ClienteDomain;
import com.lucassellis.operadora_cartao_credito.porters.out.IClienteRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@RequiredArgsConstructor
public class ClienteRepositoryImpl implements IClienteRepository {

    private final ClienteJpaRepository clienteJpaRepository;
    private final ClienteMapper clienteMapper;

    @Override
    public ClienteDomain salvar(ClienteDomain clienteDomain) {
        return clienteMapper.paraDomain
                (clienteJpaRepository.save
                        (clienteMapper.paraEntity(clienteDomain)));
    }

    @Override
    public Boolean buscarUsuarioPorEmail(String email) {
        return clienteJpaRepository.existsByEmail(email);
    }

    @Override
    public Optional<ClienteDomain> buscaUsuarioPorCpf(String cpf) {
        return clienteJpaRepository.findByCpf(cpf)
                .map(clienteMapper::paraDomain);
    }
}
