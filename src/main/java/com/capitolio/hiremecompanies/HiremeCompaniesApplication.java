package com.capitolio.hiremecompanies;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class HiremeCompaniesApplication {

	public static void main(String[] args) {
		SpringApplication.run(HiremeCompaniesApplication.class, args);
	}

}
