package br.com.aplicacao.saque.initialize;

import br.com.aplicacao.saque.repository.CreditCardRepository;
import br.com.aplicacao.saque.repository.ResultTransactionRepository;
import br.com.aplicacao.saque.repository.TransactionRepository;
import br.com.aplicacao.saque.entity.CreditCard;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;

import java.util.ArrayList;


@Slf4j
@Component
public class PopulateData implements CommandLineRunner {

    @Autowired
    private CreditCardRepository creditCardRepository;

    @Autowired
    private TransactionRepository transactionRepository;

    @Autowired
    private ResultTransactionRepository resultTransactionRepository;

    @Override
    public void run(String... args) throws Exception {

        transactionRepository.deleteAll().subscribe();
        resultTransactionRepository.deleteAll().subscribe();

        creditCardRepository.deleteAll()
                .thenMany(
                        Flux.just("5223025221438234", "5384050025777947")
                                .map(numero -> new CreditCard(
                                        null,
                                        numero,
                                        1000.00,
                                        new ArrayList<>()
                                ))
                                .flatMap(creditCardRepository::save))
                .subscribe(System.out::println);

        log.info("Cartões iniciais criados com sucesso.");
    }
}
