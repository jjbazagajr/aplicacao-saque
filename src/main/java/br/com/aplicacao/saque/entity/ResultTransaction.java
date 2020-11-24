package br.com.aplicacao.saque.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.Size;
import java.io.Serializable;

@Document
@AllArgsConstructor
@NoArgsConstructor
@Data
public class ResultTransaction implements Serializable {
    @Id
    @JsonIgnore
    private String id;
    private String code;
    @Size(max = 6, min = 6)
    private String authorizationCode;
    private String action;
    @DBRef
    @JsonIgnore
    private Transaction transaction;
}
