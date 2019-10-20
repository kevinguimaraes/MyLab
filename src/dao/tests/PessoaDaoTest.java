package dao.tests;


import org.junit.Test;

import dao.PessoaDAO;
import dao.helper.HibernateUtil;
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
public class PessoaDaoTest {

    private Pessoa pessoa;
    private Session session;
    private PessoaDAO pessoaDAO;

    public PessoaDaoTest() {
        pessoaDAO = new PessoaDAO();
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
        primeiroPessoaBanco();
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
        primeiroPessoaBanco();
        session = HibernateUtil.abrirSessao();
        Pessoa prodPesquisado = pessoaDAO.pesquisarPorId(pessoa.getId(), session);
        session.close();
        Assert.assertNotNull(prodPesquisado);
    }
    
    @Test
    public void testExcluir() {
        System.out.println("excluir");
        primeiroPessoaBanco();
        session = HibernateUtil.abrirSessao();
        pessoaDAO.excluir(pessoa, session);
        Pessoa pessoaExcluido = pessoaDAO.pesquisarPorId(pessoa.getId(), session);
        session.close();
        Assert.assertNull(pessoaExcluido);
    }
    
    @Test
    public void testPesquisarTodos() {
        System.out.println("pesquisarTodos");
        primeiroPessoaBanco();
        session = HibernateUtil.abrirSessao();
        List<Pessoa> pessoas = pessoaDAO.listarTodos(session);
        session.close();
        Assert.assertFalse(pessoas.isEmpty());
    }
    
    

    public Pessoa primeiroPessoaBanco() {
        session = HibernateUtil.abrirSessao();
        Query consulta = session.createQuery("from Pessoa");
        consulta.setMaxResults(1);
        pessoa = (Pessoa) consulta.uniqueResult();
        session.close();
        if (pessoa == null) {
            testSalvar();
        }
        return pessoa;
    }

}