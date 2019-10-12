package com.hcl.openbank.technights.dto;

import lombok.Data;

@Data
public class AccountDto {
	private String user_id;
	private String label;
	private String type;
	BalanceDto balance;
	private String branch_id;
	AccountRoutingDto account_routing;
}
