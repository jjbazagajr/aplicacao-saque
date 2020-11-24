package br.com.aplicacao.saque.dto;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
public class CreditCardDTO implements Serializable {
    private String cardNumber;
    private Double availableAmount;
    private List<TransactionDTO> transactions;
}
