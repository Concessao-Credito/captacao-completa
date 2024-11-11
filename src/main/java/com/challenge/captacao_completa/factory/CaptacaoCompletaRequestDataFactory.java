package com.challenge.captacao_completa.factory;

import com.challenge.captacao_completa.domain.CaptacaoCompletaRequest;
import com.challenge.captacao_completa.domain.CaptacaoInicialRequest;
import com.github.javafaker.Faker;
import lombok.experimental.UtilityClass;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.concurrent.ThreadLocalRandom;

@UtilityClass
public class CaptacaoCompletaRequestDataFactory {

    private static final Faker faker = new Faker();

    public static CaptacaoCompletaRequest criarCaptacaoCompletaRequestAleatorio(CaptacaoInicialRequest request) {
        CaptacaoCompletaRequest cliente = new CaptacaoCompletaRequest();
        
        cliente.setNome(request.getNome());
        cliente.setCpf(request.getCpf());
        cliente.setEmail(request.getEmail());
        cliente.setDataNascimento(gerarDataNascimentoAleatoria());
        cliente.setRg(faker.number().digits(9));
        cliente.setCep(faker.number().digits(8));
        cliente.setEndereco(faker.address().streetAddress());
        cliente.setProfissao(faker.job().title());
        cliente.setRenda(BigDecimal.valueOf(faker.number().randomDouble(2, 1000, 10000)));

        return cliente;
    }

    private static LocalDate gerarDataNascimentoAleatoria() {
        long startEpochDay = LocalDate.now().minusYears(80).toEpochDay();
        long endEpochDay = LocalDate.now().minusYears(18).toEpochDay();
        long randomDay = ThreadLocalRandom.current().nextLong(startEpochDay, endEpochDay);
        return LocalDate.ofEpochDay(randomDay);
    }
}
