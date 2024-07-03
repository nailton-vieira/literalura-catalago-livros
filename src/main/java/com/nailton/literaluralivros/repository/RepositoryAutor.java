package com.nailton.literaluralivros.repository;

import com.nailton.literaluralivros.model.Autor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface RepositoryAutor extends JpaRepository<Autor, Long> {

    @Query("SELECT a FROM Autor a WHERE a.dataNascimento <= :ano AND (a.dataFalecimento IS NULL OR a.dataFalecimento >= :ano)")
    List<Autor> findAllByAno(Integer ano);
}