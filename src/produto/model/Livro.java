package produto.model;

public class Livro extends Produto {
    private String autor;

    public Livro(int codigo, String titulo, String autor, float preco, int quantidade) {
        super(codigo, titulo, preco, quantidade);  
        this.autor = autor;  
    }

    @Override
    public void exibirDetalhes() {
        System.out.println("ID: " + id);
        System.out.println("Nome: " + titulo);
        System.out.println("Autor: " + autor);
        System.out.println("Preço: R$" + preco);
        System.out.println("Quantidade em Estoque: " + quantidadeEmEstoque);
    }
    
    @Override
    public String toString() {
        return "\n Livro ID: " + id + "\n Título: " + titulo + "\n Autor: " + autor + "\n Preço: " + preco + "\n Quantidade em Estoque: " + quantidadeEmEstoque;
    }

    public String getAutor() {
        return autor;
    }
    
    public void setAutor(String autor) {
        this.autor = autor;
    }

	public String getTitulo() {
		return titulo;
	}
	
	public void setTitulo(String titulo) {
		this.titulo = titulo;
		
	}

	public void setPreco(double preco) {
		this.preco = preco;
		
	}

}

