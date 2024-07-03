package com.nailton.literaluralivros.dto;


import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public record DTOresults(@JsonAlias("title") String titulo,
                         @JsonAlias("authors") List<DTOautor> autor,
                         @JsonAlias("languages") List<String> idioma,
                         @JsonAlias("download_count") Integer numeroDownloads) {
}