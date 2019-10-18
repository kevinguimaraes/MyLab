package dao;


import org.junit.Test;

import model.Pessoa;

import java.util.Date;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.junit.Assert;

/**
 *
 * @author Aluno
 */
public class PessoaDAOImplTest {

    private Pessoa pessoa;
    private Session session;
    private PessoaDAO pessoaDAO;

    public PessoaDAOImplTest() {
        pessoaDAO = new PessoaDAOImpl();
    }

    @Test
    public void testSalvar() {
        System.out.println("salvar");
        
        pessoa = new Pessoa(null, "Kevin", new Date(), "48984210016", "kevinsiob@hotmail.com");
        session = HibernateUtil.abrirSessao();
        pessoaDAO.salvarOuAlterar(pessoa, session);
        session.close();
        Assert.assertNotNull(pessoa.getId());
    }

    @Test
    public void testAlterar() {
        System.out.println("alterar");
        primeiroProdutoBanco();
        pessoa.setNome("nome alterado");
        session = HibernateUtil.abrirSessao();
        pessoaDAO.salvarOuAlterar(pessoa, session);
        Pessoa prodAlterado = pessoaDAO.pesquisarPorId(pessoa.getId(), session);
        session.close();
        Assert.assertEquals(prodAlterado.getNome(), pessoa.getNome());
    }

    @Test
    public void testPesquisarPorId() {
        System.out.println("pesquisarPorId");
        primeiroProdutoBanco();
        session = HibernateUtil.abrirSessao();
        Pessoa prodPesquisado = pessoaDAO.pesquisarPorId(pessoa.getId(), session);
        session.close();
        Assert.assertNotNull(prodPesquisado);
    }
    
    @Test
    public void testExcluir() {
        System.out.println("excluir");
        primeiroProdutoBanco();
        session = HibernateUtil.abrirSessao();
        pessoaDAO.excluir(pessoa, session);
        Pessoa produtoExcluido = pessoaDAO.pesquisarPorId(pessoa.getId(), session);
        session.close();
        Assert.assertNull(produtoExcluido);
    }
    
    @Test
    public void testPesquisarTodos() {
        System.out.println("pesquisarTodos");
        primeiroProdutoBanco();
        session = HibernateUtil.abrirSessao();
        List<Pessoa> pessoas = pessoaDAO.listarTodos(session);
        session.close();
        Assert.assertFalse(pessoas.isEmpty());
    }
    
    

    public Pessoa primeiroProdutoBanco() {
        session = HibernateUtil.abrirSessao();
        Query consulta = session.createQuery("from Produto");
        consulta.setMaxResults(1);
        pessoa = (Pessoa) consulta.uniqueResult();
        session.close();
        if (pessoa == null) {
            testSalvar();
        }
        return pessoa;
    }

}