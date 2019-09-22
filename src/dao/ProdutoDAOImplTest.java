package dao;


import org.junit.Test;

import model.Produto;

import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.junit.Assert;

/**
 *
 * @author Aluno
 */
public class ProdutoDAOImplTest {

    private Produto produto;
    private Session session;
    private ProdutoDAO produtoDAO;

    public ProdutoDAOImplTest() {
        produtoDAO = new ProdutoDAOImpl();
    }

    @Test
    public void testSalvar() {
        System.out.println("salvar");
        
        produto = new Produto(null, "Produto Teste", "Descricao Teste", 10, 20, 30);
        session = HibernateUtil.abrirSessao();
        produtoDAO.salvarOuAlterar(produto, session);
        session.close();
        Assert.assertNotNull(produto.getId());
    }

    @Test
    public void testAlterar() {
        System.out.println("alterar");
        primeiroProdutoBanco();
        produto.setNome("nome alterado");
        session = HibernateUtil.abrirSessao();
        produtoDAO.salvarOuAlterar(produto, session);
        Produto prodAlterado = produtoDAO.pesquisarPorId(produto.getId(), session);
        session.close();
        Assert.assertEquals(prodAlterado.getNome(), produto.getNome());
    }

    @Test
    public void testPesquisarPorId() {
        System.out.println("pesquisarPorId");
        primeiroProdutoBanco();
        session = HibernateUtil.abrirSessao();
        Produto prodPesquisado = produtoDAO.pesquisarPorId(produto.getId(), session);
        session.close();
        Assert.assertNotNull(prodPesquisado);
    }
    
    @Test
    public void testExcluir() {
        System.out.println("excluir");
        primeiroProdutoBanco();
        session = HibernateUtil.abrirSessao();
        produtoDAO.excluir(produto, session);
        Produto produtoExcluido = produtoDAO.pesquisarPorId(produto.getId(), session);
        session.close();
        Assert.assertNull(produtoExcluido);
    }
    
    @Test
    public void testPesquisarTodos() {
        System.out.println("pesquisarTodos");
        primeiroProdutoBanco();
        session = HibernateUtil.abrirSessao();
        List<Produto> produtos = produtoDAO.listarTodos(session);
        session.close();
        Assert.assertFalse(produtos.isEmpty());
    }
    
    

    public Produto primeiroProdutoBanco() {
        session = HibernateUtil.abrirSessao();
        Query consulta = session.createQuery("from Produto");
        consulta.setMaxResults(1);
        produto = (Produto) consulta.uniqueResult();
        session.close();
        if (produto == null) {
            testSalvar();
        }
        return produto;
    }

}