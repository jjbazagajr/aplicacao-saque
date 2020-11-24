package br.com.aplicacao.saque.mapper;

import br.com.aplicacao.saque.dto.TransactionDTO;
import br.com.aplicacao.saque.entity.Transaction;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

@Component
@Mapper(componentModel = "spring")
public interface TransactionMapper extends EntityMapper<TransactionDTO, Transaction> {

    TransactionDTO toDto(Transaction transaction);

    Transaction toEntity(TransactionDTO transactionDTO);

    default Transaction fromId(String id) {
        if (id == null) {
            return null;
        }
        Transaction entidade = new Transaction();
        entidade.setId(id);
        return entidade;
    }
}
