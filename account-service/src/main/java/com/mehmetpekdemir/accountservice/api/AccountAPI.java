package com.mehmetpekdemir.accountservice.api;

import java.util.List;

import javax.validation.Valid;

import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mehmetpekdemir.accountservice.service.AccountService;
import com.mehmetpekdemir.commonservice.client.contract.AccountCreateDTO;
import com.mehmetpekdemir.commonservice.client.contract.AccountUpdateDTO;
import com.mehmetpekdemir.commonservice.client.contract.AccountViewDTO;
import com.mehmetpekdemir.commonservice.shared.GenericResponse;

import lombok.RequiredArgsConstructor;

/**
 * 
 * @author MEHMET PEKDEMIR
 * @since 1.0
 */
@RestController
@RequestMapping("api/")
@RequiredArgsConstructor // Constructor Injection with lombok
public class AccountAPI {

	private final AccountService accountService;

	@GetMapping("v1/account")
	public ResponseEntity<List<AccountViewDTO>> getAccounts() {
		final List<AccountViewDTO> accounts = accountService.getAccounts();
		return ResponseEntity.ok(accounts);
	}

	@GetMapping("v1/account/slice")
	public ResponseEntity<List<AccountViewDTO>> paginationForAccounts(Pageable pageable) {
		final List<AccountViewDTO> accounts = accountService.paginationForAccounts(pageable);
		return ResponseEntity.ok(accounts);
	}

	@GetMapping("v1/account/{id}")
	public ResponseEntity<AccountViewDTO> getAccountById(@PathVariable("id") String id) {
		final AccountViewDTO account = accountService.getAccountById(id);
		return ResponseEntity.ok(account);
	}

	@PostMapping("v1/account")
	public ResponseEntity<AccountViewDTO> createAccount(@Valid @RequestBody AccountCreateDTO accountCreateDTO) {
		final AccountViewDTO account = accountService.createAccount(accountCreateDTO);
		return ResponseEntity.ok(account);
	}

	@PutMapping("v1/account/{id}")
	public ResponseEntity<AccountViewDTO> updateAccount(@PathVariable("id") String id,
			@Valid @RequestBody AccountUpdateDTO accountUpdateDTO) {
		final AccountViewDTO account = accountService.updateAccount(id, accountUpdateDTO);
		return ResponseEntity.ok(account);
	}

	@DeleteMapping("v1/account/{id}")
	public ResponseEntity<?> deleteAccount(@PathVariable("id") String id) {
		accountService.deleteAccount(id);
		return ResponseEntity.ok(new GenericResponse("Account removed ! "));
	}

}
