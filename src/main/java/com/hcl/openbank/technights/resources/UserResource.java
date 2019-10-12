package com.hcl.openbank.technights.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.hcl.openbank.technights.clientapi.OpenBankAPIClient;
import com.hcl.openbank.technights.dto.AccountDto;
import com.hcl.openbank.technights.dto.AccountRoutingDto;
import com.hcl.openbank.technights.dto.BalanceDto;
import com.hcl.openbank.technights.dto.UserDto;
import com.hcl.openbank.technights.model.Account;
import com.hcl.openbank.technights.model.User;

@RestController
public class UserResource {

	@Autowired
	private OpenBankAPIClient openBankAPIClient;

	@PostMapping("/register")
	public Account register(@RequestBody UserDto user) {
		User users = openBankAPIClient.createUser(user);
		AccountDto accountDto = new AccountDto();
		AccountRoutingDto accountRoutingDto = new AccountRoutingDto();
		accountRoutingDto.setAddress("UK123456");
		accountRoutingDto.setScheme("OBP");
		BalanceDto balanceDto = new BalanceDto();
		balanceDto.setAmount("100");
		balanceDto.setCurrency("EUR");
		accountDto.setBalance(balanceDto);
		accountDto.setUser_id(users.getUserId());
		accountDto.setType("CURRENT");
		accountDto.setLabel("Label");
		accountDto.setAccount_routing(accountRoutingDto);
		Account account = openBankAPIClient.createAccount("at02-1465--01", "3242424245", accountDto);
		return account;
	}
}
