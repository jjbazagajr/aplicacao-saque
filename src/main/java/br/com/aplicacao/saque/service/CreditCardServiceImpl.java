package br.com.aplicacao.saque.service;

import br.com.aplicacao.saque.mapper.CreditCardMapper;
import br.com.aplicacao.saque.entity.CreditCard;
import br.com.aplicacao.saque.repository.CreditCardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

import java.time.Duration;

@Service
public class CreditCardServiceImpl implements CreditCardService {

    @Autowired
    private CreditCardRepository creditCardRepository;

    @Autowired
    private CreditCardMapper creditCardMapper;

    @Override
    public Flux<CreditCard> findAll() {
        return creditCardRepository.findAll().delayElements(Duration.ofMillis(500));
    }
}
