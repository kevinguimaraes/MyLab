package dao.tests;


import org.junit.Test;

import dao.CidadeDAO;
import dao.helper.HibernateUtil;
import model.Cidade;

import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.junit.Assert;

/**
 *
 * @author Aluno
 */
public class CidadeDaoTEST {

    private Cidade cidade;
    private Session session;
    private CidadeDAO cidadeDAO;

    public CidadeDaoTEST() {
        cidadeDAO = new CidadeDAO();
    }

    @Test
    public void testSalvar() {
        System.out.println("salvar");
        cidade = new Cidade(null, "cidade1", null);
        session = HibernateUtil.abrirSessao();
        cidadeDAO.salvarOuAlterar(cidade, session);
        session.close();
        Assert.assertNotNull(cidade.getId());
    }

    @Test
    public void testAlterar() {
        System.out.println("alterar");
        primeiroCidadeBanco();
        cidade.setNome("nome alterado");
        session = HibernateUtil.abrirSessao();
        cidadeDAO.salvarOuAlterar(cidade, session);
        Cidade cidadeAlterado = cidadeDAO.pesquisarPorId(cidade.getId(), session);
        session.close();
        Assert.assertEquals(cidadeAlterado.getNome(), cidade.getNome());
    }

    @Test
    public void testPesquisarPorId() {
        System.out.println("pesquisarPorId");
        primeiroCidadeBanco();
        session = HibernateUtil.abrirSessao();
        Cidade prodPesquisado = cidadeDAO.pesquisarPorId(cidade.getId(), session);
        session.close();
        Assert.assertNotNull(prodPesquisado);
    }
    
    @Test
    public void testExcluir() {
        System.out.println("excluir");
        primeiroCidadeBanco();
        session = HibernateUtil.abrirSessao();
        cidadeDAO.excluir(cidade, session);
        Cidade cidadeExcluido = cidadeDAO.pesquisarPorId(cidade.getId(), session);
        session.close();
        Assert.assertNull(cidadeExcluido);
    }
    
    @Test
    public void testPesquisarTodos() {
        System.out.println("pesquisarTodos");
        primeiroCidadeBanco();
        session = HibernateUtil.abrirSessao();
        List<Cidade> cidades = cidadeDAO.listarTodos(session);
        session.close();
        Assert.assertFalse(cidades.isEmpty());
    }
    
    

    public Cidade primeiroCidadeBanco() {
        session = HibernateUtil.abrirSessao();
        Query consulta = session.createQuery("from Cidade");
        consulta.setMaxResults(1);
        cidade = (Cidade) consulta.uniqueResult();
        session.close();
        if (cidade == null) {
            testSalvar();
        }
        return cidade;
    }

}