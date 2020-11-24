package br.com.aplicacao.saque.service;

import br.com.aplicacao.saque.entity.CreditCard;
import reactor.core.publisher.Flux;

public interface CreditCardService {

    Flux<CreditCard> findAll();

}
