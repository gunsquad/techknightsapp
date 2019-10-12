package com.hcl.openbank.technights.clientapi;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.hcl.openbank.technights.dto.AccountDto;
import com.hcl.openbank.technights.dto.UserDto;
import com.hcl.openbank.technights.model.Account;
import com.hcl.openbank.technights.model.Bank;
import com.hcl.openbank.technights.model.User;

import lombok.Data;

@FeignClient(name = "openBankVersion", url = "${openbank.api.versionedUrl}")
public interface OpenBankAPIClient {

	@GetMapping(value = "banks", consumes = MediaType.APPLICATION_JSON_VALUE)
	Banks getBanks();

	@PostMapping(value = "users", consumes = MediaType.APPLICATION_JSON_VALUE)
	User createUser(@RequestBody UserDto user);

	@PostMapping(value = "banks/{bank_id}/accounts/{account_id}", consumes = MediaType.APPLICATION_JSON_VALUE)
	Account createAccount(@PathVariable(name = "bank_id") String bankId,
			@PathVariable(name = "account_id") String accountId, @RequestBody AccountDto account);

	@Data
	class Banks {
		private List<Bank> banks;
	}
}
