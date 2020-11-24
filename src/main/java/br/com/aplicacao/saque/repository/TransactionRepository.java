package br.com.aplicacao.saque.repository;

import br.com.aplicacao.saque.entity.Transaction;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TransactionRepository extends ReactiveMongoRepository<Transaction, String> {
}
