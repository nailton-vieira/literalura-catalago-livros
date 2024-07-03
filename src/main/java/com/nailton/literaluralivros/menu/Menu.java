package com.nailton.literaluralivros.menu;

public class Menu {
    
    public void menu() {

        var menu = """
                \nSELECIONE UM NUMERO DE SUA OPÇÃO:
                
                1) Buscar livro pelo seu título
                2) Listar livros registrados
                3) Listar autores registrados
                4) Listar autores vivos em um determinado ano
                5) Listar livro em um determinado idioma
                0) Sair
                """;
                System.out.println(menu);
    
    }
}
