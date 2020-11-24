package br.com.aplicacao.saque.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreditCard {
    @Id
    private String id;
    private String cardNumber;
    private Double availableAmount;
    @DBRef
    private List<Transaction> transactions;

}
