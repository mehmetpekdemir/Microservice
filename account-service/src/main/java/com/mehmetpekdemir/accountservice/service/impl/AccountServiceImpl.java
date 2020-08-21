package com.mehmetpekdemir.accountservice.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.mehmetpekdemir.accountservice.dto.AccountCreateDTO;
import com.mehmetpekdemir.accountservice.dto.AccountUpdateDTO;
import com.mehmetpekdemir.accountservice.dto.AccountViewDTO;
import com.mehmetpekdemir.accountservice.entity.Account;
import com.mehmetpekdemir.accountservice.exception.AccountNotFoundException;
import com.mehmetpekdemir.accountservice.repository.AccountRepository;
import com.mehmetpekdemir.accountservice.service.AccountService;

import lombok.RequiredArgsConstructor;

/**
 * 
 * @author MEHMET PEKDEMIR
 * @since 1.0
 */
@Service
@RequiredArgsConstructor
public class AccountServiceImpl implements AccountService {

	private final AccountRepository accountRepository;

	@Override
	public List<AccountViewDTO> getAccounts() {
		return accountRepository.findAll().stream().map(AccountViewDTO::of).collect(Collectors.toList());
	}

	@Override
	public List<AccountViewDTO> sliceForAccounts(Pageable pageable) {
		return accountRepository.findAll(pageable).stream().map(AccountViewDTO::of).collect(Collectors.toList());
	}

	@Override
	public AccountViewDTO getAccountById(String id) {
		final Account account = accountRepository.findById(id)
				.orElseThrow(() -> new AccountNotFoundException(String.format("Account not found with id %d", id)));

		return AccountViewDTO.of(account);
	}

	@Override
	public AccountViewDTO createAccount(AccountCreateDTO accountCreateDTO) {
		final Account account = accountRepository.save(new Account(accountCreateDTO.getUsername(),
				accountCreateDTO.getEmail(), accountCreateDTO.getPassword()));

		return AccountViewDTO.of(account);
	}

	@Override
	public AccountViewDTO updateAccount(String id, AccountUpdateDTO accountUpdateDTO) {
		final Account account = accountRepository.findById(id)
				.orElseThrow(() -> new AccountNotFoundException(String.format("Account not found with id %d", id)));

		account.setEmail(accountUpdateDTO.getEmail());
		account.setUsername(accountUpdateDTO.getUsername());
		account.setHashPassword(accountUpdateDTO.getPassword());

		final Account updatedAccount = accountRepository.save(account);
		return AccountViewDTO.of(updatedAccount);
	}

	@Override
	public void deleteAccount(String id) {
		final Account account = accountRepository.findById(id)
				.orElseThrow(() -> new AccountNotFoundException(String.format("Account not found with id %d", id)));

		accountRepository.deleteById(account.getId());
	}

}
