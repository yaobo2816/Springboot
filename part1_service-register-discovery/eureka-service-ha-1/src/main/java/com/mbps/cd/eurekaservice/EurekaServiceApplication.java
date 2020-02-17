package com.mbps.cd.eurekaservice;

import org.example.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * @author EdisonZhou
 */
@SpringBootApplication
@EnableEurekaServer
public class EurekaServiceApplication {
	@Autowired
	private PersonService personService;




	public static void main(String[] args) {

		SpringApplication.run(EurekaServiceApplication.class, args);

	}


}
