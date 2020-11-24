package br.com.aplicacao.saque.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.text.SimpleDateFormat;
import java.util.Date;

@Document
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Transaction {
    @Id
    private String id;
    @JsonIgnore
    private Date date;
    private Double amount;
    @Transient
    @JsonProperty(value = "date")
    private String formatedDate;

    public String getFormatedDate() {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-dd-MM HH:mm:ss");
        formatedDate = simpleDateFormat.format(this.date);
        return formatedDate;
    }
}
