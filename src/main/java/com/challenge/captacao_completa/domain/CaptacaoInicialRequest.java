package com.challenge.captacao_completa.domain;

import lombok.Data;

@Data
public class CaptacaoInicialRequest {
    private String nome;
    private String cpf;
    private String email;
}
