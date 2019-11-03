package dao.tests;


import org.junit.Test;

import dao.AmostraDAO;
import dao.helper.HibernateUtil;
import model.Amostra;

import java.util.Date;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.junit.Assert;

/**
 *
 * @author Aluno
 */
public class AmostraDaoTEST {

    private Amostra amostra;
    private Session session;
    private AmostraDAO amostraDAO;

    public AmostraDaoTEST() {
        amostraDAO = new AmostraDAO();
    }

    @Test
    public void testSalvar() {
        System.out.println("salvar");
        amostra = new Amostra(null, "codigo amostra", new Date(), "obs create");
        session = HibernateUtil.abrirSessao();
        amostraDAO.salvarOuAlterar(amostra, session);
        session.close();
        Assert.assertNotNull(amostra.getId());
    }

    @Test
    public void testAlterar() {
        System.out.println("alterar");
        primeiroAmostraBanco();
        amostra.setCodigo("nome alterado");
        session = HibernateUtil.abrirSessao();
        amostraDAO.salvarOuAlterar(amostra, session);
        Amostra amostraAlterado = amostraDAO.pesquisarPorId(amostra.getId(), session);
        session.close();
        Assert.assertEquals(amostraAlterado.getCodigo(), amostra.getCodigo());
    }

    @Test
    public void testPesquisarPorId() {
        System.out.println("pesquisarPorId");
        primeiroAmostraBanco();
        session = HibernateUtil.abrirSessao();
        Amostra prodPesquisado = amostraDAO.pesquisarPorId(amostra.getId(), session);
        session.close();
        Assert.assertNotNull(prodPesquisado);
    }
    
    @Test
    public void testExcluir() {
        System.out.println("excluir");
        primeiroAmostraBanco();
        session = HibernateUtil.abrirSessao();
        amostraDAO.excluir(amostra, session);
        Amostra amostraExcluido = amostraDAO.pesquisarPorId(amostra.getId(), session);
        session.close();
        Assert.assertNull(amostraExcluido);
    }
    
    @Test
    public void testPesquisarTodos() {
        System.out.println("pesquisarTodos");
        primeiroAmostraBanco();
        session = HibernateUtil.abrirSessao();
        List<Amostra> amostras = amostraDAO.listarTodos(session);
        session.close();
        Assert.assertFalse(amostras.isEmpty());
    }
    
    

    public Amostra primeiroAmostraBanco() {
        session = HibernateUtil.abrirSessao();
        Query consulta = session.createQuery("from Amostra");
        consulta.setMaxResults(1);
        amostra = (Amostra) consulta.uniqueResult();
        session.close();
        if (amostra == null) {
            testSalvar();
        }
        return amostra;
    }

}