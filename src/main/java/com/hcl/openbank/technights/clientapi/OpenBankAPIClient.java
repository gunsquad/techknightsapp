package com.hcl.openbank.technights.clientapi;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.hcl.openbank.technights.dto.UserDto;
import com.hcl.openbank.technights.model.Bank;
import com.hcl.openbank.technights.model.User;

import lombok.Data;

@FeignClient(name="openBankVersion", url="${openbank.api.versionedUrl}")
public interface OpenBankAPIClient {

    @GetMapping(value = "banks", consumes = MediaType.APPLICATION_JSON_VALUE)
    Banks getBanks();
    
    @PostMapping(value = "users", consumes = MediaType.APPLICATION_JSON_VALUE)
    User createUser(@RequestBody UserDto user);

    @Data
    class Banks {
        private List<Bank> banks;
    }
}
