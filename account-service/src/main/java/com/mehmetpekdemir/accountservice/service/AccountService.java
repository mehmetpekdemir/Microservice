package com.mehmetpekdemir.accountservice.service;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.mehmetpekdemir.accountservice.dto.AccountCreateDTO;
import com.mehmetpekdemir.accountservice.dto.AccountUpdateDTO;
import com.mehmetpekdemir.accountservice.dto.AccountViewDTO;

/**
 * 
 * @author MEHMET PEKDEMIR
 * @since 1.0
 */
public interface AccountService {

	@Transactional(readOnly = true, propagation = Propagation.SUPPORTS)
	List<AccountViewDTO> getAccounts();

	@Transactional(readOnly = true, propagation = Propagation.SUPPORTS)
	List<AccountViewDTO> sliceForAccounts(Pageable pageable);

	@Transactional(readOnly = true, propagation = Propagation.SUPPORTS)
	AccountViewDTO getAccountById(String id);

	AccountViewDTO createAccount(AccountCreateDTO accountCreateDTO);

	AccountViewDTO updateAccount(String id, AccountUpdateDTO accountUpdateDTO);

	void deleteAccount(String id);

}
