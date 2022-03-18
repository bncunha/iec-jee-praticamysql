package repository;

import java.util.List;

import javax.persistence.EntityManager;

import model.Produto;

public class ProdutoRepositoryImpl implements ProdutoRepository {
    private EntityManager em;
    public ProdutoRepository setEntityManager(EntityManager em) {
        this.em = em;
        return this;
    }
    @Override
    public void inserir(Produto produto) {
        em.persist(produto);
    }

    @Override
    public List<Produto> listarByCodigoCategoria(Integer idCategoria) {
        return em.createQuery("select p from Produto p WHERE p.categoria.codigo = :idCategoria", Produto.class)
        .setParameter("idCategoria", idCategoria)
        .getResultList();
    }

    @Override
    public List<Produto> listar() {
        return em.createQuery("select p from Produto p", Produto.class)
            .getResultList();
    }

    @Override
    public List<Produto> listarByNome(String nome) {
        return em.createQuery("select p from Produto p where p.nome like :nome", Produto.class)
        .setParameter("nome", "%" + nome + "%")
        .getResultList();
    }

    @Override
    public Produto porCodigo(Integer id) throws Exception {
        return em.find(Produto.class, id);
    }
    @Override
    public void editar(Produto produto) throws Exception {
        em.merge(produto);
    }
    @Override
    public void deletar(Integer codigo) throws Exception {
        Produto produto = em.find(Produto.class, codigo);
        em.remove(produto);
    }
}
