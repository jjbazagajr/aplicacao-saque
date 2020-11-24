package br.com.aplicacao.saque.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class WithDrawDTO implements Serializable {
    private String action;
    private String cardNumber;
    private Double amount;
}
