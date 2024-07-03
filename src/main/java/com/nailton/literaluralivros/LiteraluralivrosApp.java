package com.nailton.literaluralivros;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.nailton.literaluralivros.menu.Menu;

@SpringBootApplication
public class LiteraluralivrosApp implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(LiteraluralivrosApp.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		Menu menu = new Menu();
		menu.menu();
		
	}

}
