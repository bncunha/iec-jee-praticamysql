package business;

import java.util.List;
import java.util.Objects;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;

import exceptions.ProdutoException;
import model.Categoria;
import model.Produto;
import repository.ProdutoRepository;
import repository.RepositorySession;

@Stateless
public class ProdutoService {
    @EJB
    private RepositorySession repository;
    
    @EJB
	private CategoriaService categoriaService;

    private ProdutoRepository produtoRepository;

    @PostConstruct
    public void initialize() {
        produtoRepository = repository.getProdutoRepository();
    }

    @TransactionAttribute(TransactionAttributeType.REQUIRED)
    public void inserir(String nome, Float valor, int idCategoria) throws Exception, ProdutoException {
        Categoria categoria = categoriaService.porCodigo(idCategoria);
        if (Objects.isNull(categoria)) {
            throw new ProdutoException("Categoria não encontrada");
        }
        Produto produto = new Produto();
        produto.setCategoria(categoria);
        produto.setPreco(valor);
        produto.setNome(nome);
        produtoRepository.inserir(produto);
    }

    public List<Produto> listar() {
        return produtoRepository.listar();
    }

    public List<Produto> listarPorCodigoCategoria(Integer codigoCategoria) {
        return produtoRepository.listarByCodigoCategoria(codigoCategoria);
    }

    public Produto porCodigo(Integer codigo) throws Exception {
        return produtoRepository.porCodigo(codigo);
    }

    @TransactionAttribute(TransactionAttributeType.REQUIRED)
    public void editar(Integer idProduto, String nome, Float valor, Integer idCategoria) throws Exception {
        Categoria categoria = categoriaService.porCodigo(idCategoria);
        if (Objects.isNull(categoria)) {
            throw new Exception("Categoria não encontrada");
        }
        Produto produto = produtoRepository.porCodigo(idProduto);
        if (Objects.isNull(produto)) {
            throw new Exception("Produto não encontrado");
        }
        System.out.println("OIIIIII");
        System.out.println(idProduto);
        produto.setCategoria(categoria);
        produto.setPreco(valor);
        produto.setNome(nome);
        System.out.println(produto.getId());
        produtoRepository.editar(produto);
    }

    @TransactionAttribute(TransactionAttributeType.REQUIRED)
    public void deletar(Integer codigo) throws Exception {
        produtoRepository.deletar(codigo);
    } 

}
