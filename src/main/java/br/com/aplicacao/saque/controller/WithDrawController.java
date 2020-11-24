package br.com.aplicacao.saque.controller;

import br.com.aplicacao.saque.dto.WithDrawDTO;
import br.com.aplicacao.saque.repository.CreditCardRepository;
import br.com.aplicacao.saque.service.WithDrawService;
import br.com.aplicacao.saque.entity.ResultTransaction;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.messaging.simp.annotation.SendToUser;
import org.springframework.stereotype.Controller;

import java.security.Principal;

@Controller
@Slf4j
public class WithDrawController {

    @Autowired
    private SimpMessagingTemplate messagingTemplate;

    @Autowired
    private WithDrawService withDrawService;

    private CreditCardRepository creditCardRepository;


    @MessageMapping("/saque")
    @SendToUser("/queue/saque")
    public ResultTransaction sacar(@Payload WithDrawDTO withDrawDTO,
                                   Principal user) {
        log.info("sacando...");
        return withDrawService.sacar(withDrawDTO);
    }
}
