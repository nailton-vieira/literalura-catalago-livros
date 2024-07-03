package com.nailton.literaluralivros.dto;
import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public record DTOlivro(@JsonAlias("results") List<DTOresults> resultados) {
}
