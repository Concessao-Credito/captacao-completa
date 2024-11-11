package com.challenge.captacao_completa.listerner;

import com.challenge.captacao_completa.config.RabbitMQConfig;
import com.challenge.captacao_completa.domain.CaptacaoInicialRequest;
import com.challenge.captacao_completa.service.CaptcaoCompletaService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class MotorCreditoInicialConsumer {
    private final CaptcaoCompletaService captcaoCompletaService;

    @RabbitListener(queues = RabbitMQConfig.MOTOR_CREDITO_P1_CONCLUIDO_QUEUE)
    public void receiveMessage(CaptacaoInicialRequest message) {
        log.info("Inicio do processamento da captacao completa");
        captcaoCompletaService.process(message);
    }
}
