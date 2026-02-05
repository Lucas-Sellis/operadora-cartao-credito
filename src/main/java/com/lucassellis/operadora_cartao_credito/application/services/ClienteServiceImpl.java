package com.lucassellis.operadora_cartao_credito.application.services;



import com.lucassellis.operadora_cartao_credito.adapters.in.IClienteService;
import com.lucassellis.operadora_cartao_credito.application.domain.CartaoDomain;
import com.lucassellis.operadora_cartao_credito.application.domain.ClienteDomain;
import com.lucassellis.operadora_cartao_credito.porters.out.IClienteRepository;
import org.springframework.stereotype.Service;

@Service
public class ClienteServiceImpl implements IClienteService {

    private final IClienteRepository clienteRepository;
    private final GeraDadosCartaoService geraCartao;

    public ClienteServiceImpl(IClienteRepository clienteRepository, GeraDadosCartaoService geraCartao) {
        this.clienteRepository = clienteRepository;
        this.geraCartao = geraCartao;
    }

    @Override
    public ClienteDomain solicitarCartao(ClienteDomain cliente) {
        if (clienteRepository.buscarUsuarioPorEmail(cliente.getEmail())) {
            throw new IllegalArgumentException("Usuário já possui um cartão.");
        }

        CartaoDomain cartao = geraCartao.gerarParaCliente(cliente);
        cliente.setCartao(cartao);
        return clienteRepository.salvar(cliente);

    }

    @Override
    public ClienteDomain buscarPorCpf(String cpf) {
        return clienteRepository.buscaUsuarioPorCpf(cpf).
                orElseThrow(()-> new IllegalArgumentException("Cliente não encontrado"));
    }
}