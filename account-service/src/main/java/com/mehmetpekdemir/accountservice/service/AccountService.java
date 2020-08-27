package com.mehmetpekdemir.accountservice.service;

import java.util.List;

import org.springframework.data.domain.Pageable;

import com.mehmetpekdemir.commonservice.dto.AccountCreateDTO;
import com.mehmetpekdemir.commonservice.dto.AccountUpdateDTO;
import com.mehmetpekdemir.commonservice.dto.AccountViewDTO;

/**
 * 
 * @author MEHMET PEKDEMIR
 * @since 1.0
 */
public interface AccountService {

	List<AccountViewDTO> getAccounts();

	List<AccountViewDTO> paginationForAccounts(Pageable pageable);

	AccountViewDTO getAccountById(String id);

	AccountViewDTO createAccount(AccountCreateDTO accountCreateDTO);

	AccountViewDTO updateAccount(String id, AccountUpdateDTO accountUpdateDTO);

	void deleteAccount(String id);

}
