package com.challenge.captacao_completa.service;

import com.challenge.captacao_completa.domain.CaptacaoInicialRequest;

public interface CaptcaoCompletaService {

    void process(CaptacaoInicialRequest message);
}
