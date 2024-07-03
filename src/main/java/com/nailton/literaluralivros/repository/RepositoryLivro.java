package com.nailton.literaluralivros.repository;

import com.nailton.literaluralivros.model.Livro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface RepositoryLivro extends JpaRepository<Livro, Long> {

    @Query("SELECT i FROM Livro i WHERE i.idioma LIKE %:idiomaEscolhido%")
    List<Livro> findAllByIdioma(String idiomaEscolhido);
}