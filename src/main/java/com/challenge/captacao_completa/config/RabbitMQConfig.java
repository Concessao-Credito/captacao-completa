package com.challenge.captacao_completa.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMQConfig {
    public static final String APP_EXCHANGE = "appExchange";
    public static final String MOTOR_CREDITO_P1_CONCLUIDO_QUEUE = "motor_credito_p1_concluido";
    public static final String CAPTACAO_COMPLETA_CONCUIDA_QUEUE = "captacao_completa_concluida";
    public static final String CAPTACAO_COMPLETA_CONCUIDA_ROUTING_KEY = "captacao.completa.concluida.key";

    @Bean
    public Queue motorCreditoP1ConcluidoQueue() {
        return new Queue(MOTOR_CREDITO_P1_CONCLUIDO_QUEUE, true);
    }

    @Bean
    public TopicExchange exchange() {
        return new TopicExchange(APP_EXCHANGE);
    }

    @Bean
    public Queue captacaoCompletaConcluidaQueue() {
        return new Queue(CAPTACAO_COMPLETA_CONCUIDA_QUEUE, true);
    }

    @Bean
    public Binding captacaoCompletaConcluidaBinding(Queue captacaoCompletaConcluidaQueue, TopicExchange exchange) {
        return BindingBuilder.bind(captacaoCompletaConcluidaQueue).to(exchange).with(CAPTACAO_COMPLETA_CONCUIDA_ROUTING_KEY);
    }

    @Bean
    public Jackson2JsonMessageConverter messageConverter() {
        return new Jackson2JsonMessageConverter();
    }

    @Bean
    public RabbitTemplate rabbitTemplate(ConnectionFactory connectionFactory, Jackson2JsonMessageConverter messageConverter) {
        RabbitTemplate rabbitTemplate = new RabbitTemplate(connectionFactory);
        rabbitTemplate.setMessageConverter(messageConverter);
        return rabbitTemplate;
    }
}
