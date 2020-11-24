package br.com.aplicacao.saque.controller;

import br.com.aplicacao.saque.service.CreditCardService;
import br.com.aplicacao.saque.entity.CreditCard;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

@RestController
@RequestMapping(value = "/credit-card")
public class CreditCardController {

    @Autowired
    private CreditCardService creditCardService;

    @GetMapping //(produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public Flux<CreditCard> getCreditCards() {
        return creditCardService.findAll();
    }

}
