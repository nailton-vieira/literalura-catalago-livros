package com.nailton.literaluralivros.menu;

import java.util.List;
import java.util.Scanner;

import com.nailton.literaluralivros.dto.DTOlivro;
import com.nailton.literaluralivros.dto.DTOresults;
import com.nailton.literaluralivros.model.Autor;
import com.nailton.literaluralivros.model.Livro;
import com.nailton.literaluralivros.repository.RepositoryAutor;
import com.nailton.literaluralivros.repository.RepositoryLivro;
import com.nailton.literaluralivros.service.ConverterDados;
import com.nailton.literaluralivros.service.ConsumoApi;


public class Menu {
    
    private final Scanner scanner = new Scanner(System.in);
    private final ConsumoApi api = new ConsumoApi();
    private ConverterDados conversor = new ConverterDados();
    private final String endereco = "http://gutendex.com/books/?search=";
    private List<Autor> autores;
    private List<Livro> livros;

    private RepositoryLivro repositoryLivro;
    private RepositoryAutor repositoryAutor;

    public Menu(RepositoryLivro repositoryLivro, RepositoryAutor repositoryAutor) {
        this.repositoryLivro = repositoryLivro;
        this.repositoryAutor = repositoryAutor;
    }

    public void menu() {
        var escolha = -1;
        while (escolha != 0) {
            System.out.println("\nBem-vindo(a) ao LiterAlura!");
            var menu = """
                          Escolha uma opção:
                    1 - Busca de Livro por título.
                    2 - Lista de Livros registrados.
                    3 - Lista de Autores registrados.
                    4 - Lista de Autores vivos num determinado ano.
                    5 - Lista de Livros num determinado idioma.
                    0 - Sair de Literalura.
                    """;

            System.out.println(menu);
            escolha = scanner.nextInt();
            scanner.nextLine();

            switch (escolha) {
                case 1:
                    buscarLivroPorTitulo();
                    break;
                case 2:
                    listarLivrosRegistrados();
                    break;
                case 3:
                    listarAutoresRegistrados();
                    break;
                case 4:
                    listarAutoresVivosNumDeterminadoAno();
                    break;
                case 5:

                    ListarLivrosPorIdioma();
                    break;
                case 0:
                    System.out.println("Saindo do programa");
                    break;
                default:
                    System.out.println("Opção inválida");
            }
        }
    }

    private void buscarLivroPorTitulo() {
        System.out.println("Escreva o nome do livro: ");
        var buscaLivroPorNome = scanner.nextLine();
        var json = api.consumirApi(endereco + buscaLivroPorNome.replace(" ", "%20"));

        DTOlivro dadosLivros = conversor.obterDados(json, DTOlivro.class);

        if (dadosLivros.resultados() != null && !dadosLivros.resultados().isEmpty()) {
            DTOresults livroBuscado = dadosLivros.resultados().get(0);
            Livro livro = new Livro(livroBuscado);
            System.out.println(livro);

            repositoryLivro.save(livro);
        } else {
            System.out.println("Nenhum livro foi encontrado.\n");
        }

    }

    private void listarLivrosRegistrados() {
        livros = repositoryLivro.findAll();

        if (livros.isEmpty()) {
            System.out.println("Não há nenhum livro registrado.\n");
        } else {
            livros.forEach(System.out::println);
        }
    }

    private void listarAutoresRegistrados() {
        autores = repositoryAutor.findAll();

        if (autores.isEmpty()) {
            System.out.println("Não há nenhum autor registrado.\n");
        } else {
            autores.forEach(System.out::println);
        }
    }

    private void listarAutoresVivosNumDeterminadoAno() {
        System.out.println("Digite o ano:");
        var ano = scanner.nextInt();
        autores = repositoryAutor.findAllByAno(ano);

        if (autores.isEmpty()) {
            System.out.println("Não há nenhum autor registrado para esse ano.\n");
        } else {
            autores.forEach(System.out::println);
        }
    }

    private void ListarLivrosPorIdioma() {
        System.out.println("""
                Escolha um idioma:
                Português - (Pt)
                Inglês - (En)
                Espanhol - (Es)
                Francês - (Fr)
                """);
        var idiomaEscolhido = scanner.nextLine();
        livros = repositoryLivro.findAllByIdioma(idiomaEscolhido);

        if (livros.isEmpty()) {
            System.out.println("Não há nenhum resultado nesse idioma.\n");
        } else {
            livros.forEach(System.out::println);
        }
    }
}
