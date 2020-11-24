package br.com.aplicacao.saque.service;

import br.com.aplicacao.saque.dto.WithDrawDTO;
import br.com.aplicacao.saque.entity.CreditCard;
import br.com.aplicacao.saque.entity.ResultTransaction;

public interface WithDrawService {
    ResultTransaction sacar(WithDrawDTO withDraw);
    void salvaTransacao(WithDrawDTO withDraw, ResultTransaction resultTransaction);
    void atualizaCartao(CreditCard creditCard, ResultTransaction resultTransaction);
}
