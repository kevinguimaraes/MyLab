package dao.tests;


import org.junit.Test;

import dao.PaisDAO;
import dao.helper.HibernateUtil;
import model.Pais;

import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.junit.Assert;

/**
 *
 * @author Aluno
 */
public class PaisDaoTEST {

    private Pais pais;
    private Session session;
    private PaisDAO paisDAO;

    public PaisDaoTEST() {
        paisDAO = new PaisDAO();
    }

    @Test
    public void testSalvar() {
        System.out.println("salvar");
        pais = new Pais(null, "pais1");
        session = HibernateUtil.abrirSessao();
        paisDAO.salvarOuAlterar(pais, session);
        session.close();
        Assert.assertNotNull(pais.getId());
    }

    @Test
    public void testAlterar() {
        System.out.println("alterar");
        primeiroPaisBanco();
        pais.setNome("nome alterado");
        session = HibernateUtil.abrirSessao();
        paisDAO.salvarOuAlterar(pais, session);
        Pais paisAlterado = paisDAO.pesquisarPorId(pais.getId(), session);
        session.close();
        Assert.assertEquals(paisAlterado.getNome(), pais.getNome());
    }

    @Test
    public void testPesquisarPorId() {
        System.out.println("pesquisarPorId");
        primeiroPaisBanco();
        session = HibernateUtil.abrirSessao();
        Pais prodPesquisado = paisDAO.pesquisarPorId(pais.getId(), session);
        session.close();
        Assert.assertNotNull(prodPesquisado);
    }
    
    @Test
    public void testExcluir() {
        System.out.println("excluir");
        primeiroPaisBanco();
        session = HibernateUtil.abrirSessao();
        paisDAO.excluir(pais, session);
        Pais paisExcluido = paisDAO.pesquisarPorId(pais.getId(), session);
        session.close();
        Assert.assertNull(paisExcluido);
    }
    
    @Test
    public void testPesquisarTodos() {
        System.out.println("pesquisarTodos");
        primeiroPaisBanco();
        session = HibernateUtil.abrirSessao();
        List<Pais> paiss = paisDAO.listarTodos(session);
        session.close();
        Assert.assertFalse(paiss.isEmpty());
    }
    
    

    public Pais primeiroPaisBanco() {
        session = HibernateUtil.abrirSessao();
        Query consulta = session.createQuery("from Pais");
        consulta.setMaxResults(1);
        pais = (Pais) consulta.uniqueResult();
        session.close();
        if (pais == null) {
            testSalvar();
        }
        return pais;
    }

}