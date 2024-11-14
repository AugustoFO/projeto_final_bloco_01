package produto.repository;

import produto.model.Livro;

public interface Repository<T> {
	   
	void criar(Livro livro);
	T ler(int id);
	void atualizar(int id, Livro novoLivro);
	void deletar(int id);
	void listar();
	
	
}

