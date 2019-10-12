package com.hcl.openbank.technights.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hcl.openbank.technights.clientapi.OpenBankAPIClient;
import com.hcl.openbank.technights.model.Bank;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
public class BankResource {

	@Autowired
	private OpenBankAPIClient openBankAPIClient;

	@GetMapping("/banks")
	public List<Bank> allBanks() {
		List<Bank> allBanks = openBankAPIClient.getBanks().getBanks();
		log.info("Fetching branches for " + allBanks);
		return allBanks;
	}
}
