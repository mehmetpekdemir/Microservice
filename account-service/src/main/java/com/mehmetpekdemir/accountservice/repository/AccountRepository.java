package com.mehmetpekdemir.accountservice.repository;

import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.stereotype.Repository;

import com.mehmetpekdemir.commonservice.entity.Account;

/**
 * 
 * @author MEHMET PEKDEMIR
 * @since 1.0
 */
@Repository
public interface AccountRepository extends CassandraRepository<Account, String> {

}
