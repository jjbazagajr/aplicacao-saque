package br.com.aplicacao.saque.mapper;

import br.com.aplicacao.saque.dto.CreditCardDTO;
import br.com.aplicacao.saque.entity.CreditCard;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CreditCardMapper extends EntityMapper<CreditCardDTO, CreditCard> {

    CreditCardDTO toDto(CreditCard creditCard);

    CreditCard toEntity(CreditCardDTO creditCardDTO);

    default CreditCard fromId(String id) {
        if (id == null) {
            return null;
        }
        CreditCard entidade = new CreditCard();
        entidade.setId(id);
        return entidade;
    }
}
