package com.challenge.captacao_completa.service.impl;


import com.challenge.captacao_completa.domain.CaptacaoCompletaRequest;
import com.challenge.captacao_completa.domain.CaptacaoInicialRequest;
import com.challenge.captacao_completa.factory.CaptacaoCompletaRequestDataFactory;
import com.challenge.captacao_completa.publisher.MotorCreditoCompletoProducer;
import com.challenge.captacao_completa.service.CaptcaoCompletaService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CaptcaoCompletaServiceImpl implements CaptcaoCompletaService {
    private final MotorCreditoCompletoProducer motorCreditoCompletoProducer;
    @Override
    public void process(CaptacaoInicialRequest message) {
        CaptacaoCompletaRequest captacaoCompletaRequest = CaptacaoCompletaRequestDataFactory
                .criarCaptacaoCompletaRequestAleatorio(message);

        motorCreditoCompletoProducer.sendMessage(captacaoCompletaRequest);
    }
}
