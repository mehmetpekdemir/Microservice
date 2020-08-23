package com.mehmetpekdemir.accountservice.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.data.domain.Pageable;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.mehmetpekdemir.accountservice.dto.AccountCreateDTO;
import com.mehmetpekdemir.accountservice.dto.AccountUpdateDTO;
import com.mehmetpekdemir.accountservice.dto.AccountViewDTO;
import com.mehmetpekdemir.accountservice.entity.Account;
import com.mehmetpekdemir.accountservice.error.AccountNotFoundException;
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

	private final PasswordEncoder passwordEncoder;

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
		encodeThePassword(accountCreateDTO); // Password encoded

		final Account account = accountRepository.save(new Account(accountCreateDTO.getFirstName(),
				accountCreateDTO.getLastName(), accountCreateDTO.getUsername(), accountCreateDTO.getEmail(),
				accountCreateDTO.getPassword(), accountCreateDTO.getActive()));

		return AccountViewDTO.of(account);
	}

	@Override
	public AccountViewDTO updateAccount(String id, AccountUpdateDTO accountUpdateDTO) {
		final Account account = accountRepository.findById(id)
				.orElseThrow(() -> new AccountNotFoundException(String.format("Account not found with id %d", id)));

		account.setFirstName(accountUpdateDTO.getFirstName());
		account.setLastName(accountUpdateDTO.getLastName());
		account.setUsername(accountUpdateDTO.getUsername());
		account.setEmail(accountUpdateDTO.getEmail());
		encodeThePassword(accountUpdateDTO); // Password encoded
		account.setPassword(accountUpdateDTO.getPassword());

		final Account updatedAccount = accountRepository.save(account);
		return AccountViewDTO.of(updatedAccount);
	}

	@Override
	public void deleteAccount(String id) {
		final Account account = accountRepository.findById(id)
				.orElseThrow(() -> new AccountNotFoundException(String.format("Account not found with id %d", id)));

		accountRepository.deleteById(account.getId());
	}

	private void encodeThePassword(AccountCreateDTO accountCreateDTO) {
		accountCreateDTO.setPassword(this.passwordEncoder.encode(accountCreateDTO.getPassword()));
	}

	private void encodeThePassword(AccountUpdateDTO accountUpdateDTO) {
		accountUpdateDTO.setPassword(this.passwordEncoder.encode(accountUpdateDTO.getPassword()));
	}

}
