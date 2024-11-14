package produto.controller;

import java.util.ArrayList;
import java.util.List;

import produto.model.Livro;
import produto.repository.Repository;

public class LivroController implements Repository {
	
    private List<Livro> livros = new ArrayList<>();

    @Override
    public void criar(Livro livro) {
        getLivros().add(livro);
        System.out.println("Livro adicionado com sucesso!");
    }

    @Override
    public Livro ler(int id) {
        for (Livro livro : getLivros()) {
            if (livro.getId() == id) {
                return livro;
            }
        }
        System.out.println("Livro não encontrado.");
        return null;
    }

    public void atualizar(int id, Livro novoLivro) {
        Livro livro = ler(id);
        if (livro != null) {
        	livro.setTitulo(novoLivro.getTitulo());
            livro.setAutor(novoLivro.getAutor());
            livro.setPreco(novoLivro.getPreco());
            livro.setQuantidadeEmEstoque(novoLivro.getQuantidadeEmEstoque());
            System.out.println("Livro atualizado com sucesso!");
        }
    }

    @Override
    public void deletar(int id) {
        Livro livro = ler(id);
        if (livro != null) {
            getLivros().remove(livro);
            System.out.println("Livro removido com sucesso!");
        }
    }

    @Override
    public void listar() {
        if (getLivros().isEmpty()) {
            System.out.println("Nenhum livro no estoque.");
        } else {
            for (Livro livro : getLivros()) {
                livro.exibirDetalhes();
            }
        }
    }

	public List<Livro> getLivros() {
		return livros;
	}

	public void setLivros(List<Livro> livros) {
		this.livros = livros;
	}
}

