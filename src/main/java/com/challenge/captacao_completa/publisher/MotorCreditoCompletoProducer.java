package com.challenge.captacao_completa.publisher;

import com.challenge.captacao_completa.domain.CaptacaoCompletaRequest;

public interface MotorCreditoCompletoProducer {
    void sendMessage(CaptacaoCompletaRequest message);
}
