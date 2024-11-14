package produto;

import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

import produto.model.Livro;
import produto.controller.LivroController;

public class Menu {

    private static LivroController repo = new LivroController();

    public static void main(String[] args) {

    Scanner leia = new Scanner(System.in);

    int opcao, codigo, quantidade;
    float preco;
    String titulo, autor;

        while (true) {

            System.out.println("*****************************************************");
            System.out.println("                                                     ");
            System.out.println("          Controle de Estoque da Livravira           ");
            System.out.println("                                                     ");
            System.out.println("*****************************************************");
            System.out.println("                                                     ");
            System.out.println("            1 - Cadastrar livro                      ");
            System.out.println("            2 - Listar todos os livros em estoque    ");
            System.out.println("            3 - Buscar livro por código ou título    ");
            System.out.println("            4 - Atualizar dados do livro             ");
            System.out.println("            5 - Apagar livro                         ");
            System.out.println("            6 - Registrar saída de livro             ");
            System.out.println("            7 - Registrar entrada de livro           ");
            System.out.println("            0 - Sair                                 ");
            System.out.println("                                                     ");
            System.out.println("*****************************************************");
            System.out.print("Entre com a opção desejada: ");

            try {
                opcao = leia.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("\nDigite valores inteiros!");
                leia.nextLine();
                opcao = 0;
            }

            if (opcao == 0) {
                System.out.println("\nFinalizando programa...");
                leia.close();
                System.exit(0);
            }

            switch (opcao) {
                case 1:
                    System.out.println("\nCadastrar Livro");

                    System.out.println("Digite o código do livro: ");
                    codigo = leia.nextInt();
                    System.out.println("Digite o título do livro: ");
                    leia.skip("\\R?");
                    titulo = leia.nextLine();
                    System.out.println("Digite o autor do livro: ");
                    autor = leia.nextLine();
                    System.out.println("Digite o preço do livro (R$): ");
                    preco = leia.nextFloat();
                    System.out.println("Digite a quantidade em estoque: ");
                    quantidade = leia.nextInt();

                    Livro livro = new Livro(codigo, titulo, autor, preco, quantidade);
                    repo.criar(livro);


                    keyPress();
                    break;

                case 2:
                    System.out.println("\nListar todos os livros em estoque");
                    repo.listar();
                    keyPress();
                    break;

                case 3:
                    System.out.println("\nBuscar Livro por Código ou Título");

                    System.out.println("Digite o código do livro (ou -1 para buscar pelo título): ");
                    codigo = leia.nextInt();
                    if (codigo == -1) {
                        System.out.println("Digite o título do livro: ");
                        leia.skip("\\R?");
                        titulo = leia.nextLine();
                        for (Livro l : repo.getLivros()) {
                            if (((String) l.getTitulo()).equalsIgnoreCase(titulo)) {
                                System.out.println(l);
                                break;
                            }
                        }
                    } else {
                        Livro livroEncontrado = repo.ler(codigo);
                        if (livroEncontrado != null) {
                            System.out.println(livroEncontrado);
                        } else {
                            System.out.println("Livro não encontrado!");
                        }
                    }

                    keyPress();
                    break;

                case 4:
                    System.out.println("\nAtualizar Dados do Livro");

                    System.out.println("Digite o código do livro que deseja atualizar: ");
                    codigo = leia.nextInt();
                    System.out.println("Digite o novo título do livro: ");
                    leia.skip("\\R?");
                    titulo = leia.nextLine();
                    System.out.println("Digite o novo autor do livro: ");
                    autor = leia.nextLine();
                    System.out.println("Digite o novo preço do livro (R$): ");
                    preco = leia.nextFloat();
                    System.out.println("Digite a nova quantidade em estoque: ");
                    quantidade = leia.nextInt();

                    Livro livroAtualizado = new Livro(codigo, titulo, autor, preco, quantidade);
                    repo.atualizar(codigo, livroAtualizado);


                    keyPress();
                    break;

                case 5:
                    System.out.println("\nApagar Livro");

                    System.out.println("Digite o código do livro que deseja apagar: ");
                    codigo = leia.nextInt();
                    repo.deletar(codigo);


                    keyPress();
                    break;

                case 6:
                    System.out.println("\nRegistrar Saída de Livro");

                    System.out.println("Digite o código do livro: ");
                    codigo = leia.nextInt();
                    System.out.println("Digite a quantidade de saída: ");
                    quantidade = leia.nextInt();

                    Livro livroSaida = repo.ler(codigo);
                    if (livroSaida != null) {
                        livroSaida.setQuantidadeEmEstoque(livroSaida.getQuantidadeEmEstoque() - quantidade);
                        System.out.println("Saída registrada com sucesso!");
                    } else {
                        System.out.println("Livro não encontrado!");
                    }

                    keyPress();
                    break;

                case 7:
                    System.out.println("\nRegistrar Entrada de Livro");

                    System.out.println("Digite o código do livro: ");
                    codigo = leia.nextInt();
                    System.out.println("Digite a quantidade de entrada: ");
                    quantidade = leia.nextInt();

                    Livro livroEntrada = repo.ler(codigo);
                    if (livroEntrada != null) {
                        livroEntrada.setQuantidadeEmEstoque(livroEntrada.getQuantidadeEmEstoque() + quantidade);
                        System.out.println("Entrada registrada com sucesso!");
                    } else {
                        System.out.println("Livro não encontrado!");
                    }

                    keyPress();
                    break;

                default:
                    System.out.println("\nOpção Inválida");

                    keyPress();
                    break;
            }

        }
    }

    public static void sobre() {
        System.out.println("\n*********************************************************");
        System.out.println("Projeto Desenvolvido por: ");
        System.out.println("Generation Brasil - generation@generation.org");
        System.out.println("github.com/conteudoGeneration");
        System.out.println("*********************************************************");
    }

    public static void keyPress() {
        try {
            System.out.println("\n\nPressione Enter para Continuar...");
            System.in.read();
        } catch (IOException e) {
            System.out.println("Você pressionou uma tecla diferente de enter!");
        }
    }
}
