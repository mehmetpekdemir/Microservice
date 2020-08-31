package com.mehmetpekdemir.commonservice.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.mehmetpekdemir.commonservice.client.contract.AccountViewDTO;

/**
 * 
 * @author MEHMET PEKDEMIR
 * @since 1.0
 */
@FeignClient("account-service")
public interface AccountServiceClient {

	@RequestMapping("/api/v1/account/{id}")
	ResponseEntity<AccountViewDTO> getAccountById(@PathVariable("id") String id);
}
