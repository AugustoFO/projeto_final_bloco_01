package produto.model;

	public abstract class Produto {
	
    protected int id;
    protected String titulo;
    protected double preco;
    protected int quantidadeEmEstoque;

    
    public Produto(int id, String titulo, double preco, int quantidadeEmEstoque) {
        this.id = id;
        this.titulo = titulo;
        this.preco = preco;
        this.quantidadeEmEstoque = quantidadeEmEstoque;
    }

    
    public int getId() {
        return id;
    }
    
    public void setId(int id) {
        this.id = id;
    }

    public String geTitulo() {
        return titulo;
    }
    
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public double getPreco() {
        return preco;
    }
    
    public void setPreco(int preco) {
        this.preco = preco;
    }

    public int getQuantidadeEmEstoque() {
        return quantidadeEmEstoque;
    }

    public void setQuantidadeEmEstoque(int quantidadeEmEstoque) {
        this.quantidadeEmEstoque = quantidadeEmEstoque;
    }

    
    public abstract void exibirDetalhes();
}
