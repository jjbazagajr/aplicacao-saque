package br.com.aplicacao.saque.repository;

import br.com.aplicacao.saque.entity.ResultTransaction;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ResultTransactionRepository extends ReactiveMongoRepository<ResultTransaction, String> {
}
