package com.challenge.captacao_completa.publisher.impl;

import com.challenge.captacao_completa.config.RabbitMQConfig;
import com.challenge.captacao_completa.domain.CaptacaoCompletaRequest;
import com.challenge.captacao_completa.publisher.MotorCreditoCompletoProducer;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class MotorCreditoCompletoProducerImpl implements MotorCreditoCompletoProducer {
    private final RabbitTemplate rabbitTemplate;

    public void sendMessage(CaptacaoCompletaRequest message) {
        log.info("Enviado os dados da captacao completa para o motor de credito completo");
        rabbitTemplate.convertAndSend(RabbitMQConfig.APP_EXCHANGE, RabbitMQConfig.CAPTACAO_COMPLETA_CONCUIDA_ROUTING_KEY, message);
    }
}
