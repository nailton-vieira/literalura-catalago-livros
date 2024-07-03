package com.nailton.literaluralivros.service;

public interface IConverterDados {
  
   <T> T obterDados(String json, Class<T> classe);
    
}
