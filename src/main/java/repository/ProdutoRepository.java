package repository;

import java.util.List;

import model.Produto;

public interface ProdutoRepository {
    void inserir(Produto produto);
    List<Produto> listar();

    List<Produto> listarByCodigoCategoria(Integer idCategoria);

    List<Produto> listarByNome(String nome);
    
    Produto porCodigo(Integer id) throws Exception;

    void editar(Produto produto) throws Exception;

    void deletar(Integer codigo) throws Exception;

}
