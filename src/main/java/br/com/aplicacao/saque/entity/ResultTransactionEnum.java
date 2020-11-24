package br.com.aplicacao.saque.entity;

public enum ResultTransactionEnum {
    APROVADA("aprovada", "00"),
    SALDO_INSUFICIENTE("saldo insuficiente", "51"),
    CONTA_INVALIDA("conta inválida", "14"),
    ERRO_PROCESSAMENTO("erro de processamento", "96");

    String nome;
    String code;


    ResultTransactionEnum(String nome, String code) {
        this.code = code;
        this.nome = nome;
    }
    public String getNome() {
        return nome;
    }

    public String getCode() {
        return code;
    }
}
