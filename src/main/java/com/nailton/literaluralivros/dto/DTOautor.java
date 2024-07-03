package com.nailton.literaluralivros.dto;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record DTOautor(@JsonAlias("name") String nome,
                       @JsonAlias("birth_year") Integer dataNascimento,
                       @JsonAlias("death_year") Integer dataFalecimento) {
}