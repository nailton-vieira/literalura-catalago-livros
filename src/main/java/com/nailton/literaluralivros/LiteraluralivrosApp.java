package com.nailton.literaluralivros;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.nailton.literaluralivros.menu.Menu;
import com.nailton.literaluralivros.repository.RepositoryAutor;
import com.nailton.literaluralivros.repository.RepositoryLivro;

@SpringBootApplication
public class LiteraluralivrosApp implements CommandLineRunner {

	@Autowired
	private RepositoryLivro repositoryLivro;

	@Autowired
	private RepositoryAutor repositoryAutor;

	public static void main(String[] args) {
		SpringApplication.run(LiteraluralivrosApp.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Menu principal = new Menu(repositoryLivro, repositoryAutor);
		principal.menu();
	}
}
	


