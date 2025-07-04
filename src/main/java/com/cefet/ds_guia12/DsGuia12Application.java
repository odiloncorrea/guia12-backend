package com.cefet.ds_guia12;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication
public class DsGuia12Application {

	public static void main(String[] args) {
		SpringApplication.run(DsGuia12Application.class, args);
		
		 BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
	        String hash = encoder.encode("123456");
	        System.out.println(hash);
	        		
	}

}
