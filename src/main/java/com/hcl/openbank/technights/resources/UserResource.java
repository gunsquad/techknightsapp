package com.hcl.openbank.technights.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.hcl.openbank.technights.clientapi.OpenBankAPIClient;
import com.hcl.openbank.technights.dto.UserDto;
import com.hcl.openbank.technights.model.User;

@RestController
public class UserResource {
	
	@Autowired
	private OpenBankAPIClient openBankAPIClient;
	
	@PostMapping("/register")
	public User register(@RequestBody UserDto user) {
		return openBankAPIClient.createUser(user);
	}
}
