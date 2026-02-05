package com.lucassellis.operadora_cartao_credito.adapters.in.dto.response;

public record CartaoResponseDTO(String numero,
                                String dataExpiracao,
                                String cvv,
                                double limite) {}
