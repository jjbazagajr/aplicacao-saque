package br.com.aplicacao.saque.dto;

import br.com.aplicacao.saque.util.ConvertUTCDate;
import lombok.Data;

import java.io.Serializable;
import java.text.ParseException;
import java.util.Date;

@Data
public class TransactionDTO implements Serializable {
    private Date date;
    private Double amount;


    public Date getDate() {
        try {
            return ConvertUTCDate.toLocalTimeZone(this.date.toString());
        } catch (ParseException e) {
            return date;
        }
    }
}
