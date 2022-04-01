package com.lulobank.authorizer;

import com.lulobank.authorizer.entity.Account;
import com.lulobank.authorizer.repository.implementation.AccountRepository;
import com.lulobank.authorizer.repository.interfaces.IAccountRepository;
import com.lulobank.authorizer.service.implementation.AccountServiceImpl;
import com.lulobank.authorizer.service.interfaces.IAccountService;
import com.lulobank.authorizer.util.persistence.AccountPersistence;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class AuthorizerApplication {

	public static void main(String[] args) {
		SpringApplication.run(AuthorizerApplication.class, args);


	}

}
