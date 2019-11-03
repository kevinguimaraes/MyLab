package dao.tests;


import org.junit.Test;

import dao.PerfilDAO;
import dao.helper.HibernateUtil;
import model.Perfil;

import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.junit.Assert;

/**
 *
 * @author Aluno
 */
public class PerfilDaoTEST {

    private Perfil perfil;
    private Session session;
    private PerfilDAO perfilDAO;

    public PerfilDaoTEST() {
        perfilDAO = new PerfilDAO();
    }

    @Test
    public void testSalvar() {
        System.out.println("salvar");
        perfil = new Perfil(null, "perfil1");
        session = HibernateUtil.abrirSessao();
        perfilDAO.salvarOuAlterar(perfil, session);
        session.close();
        Assert.assertNotNull(perfil.getId());
    }

    @Test
    public void testAlterar() {
        System.out.println("alterar");
        primeiroPerfilBanco();
        perfil.setNome("nome alterado");
        session = HibernateUtil.abrirSessao();
        perfilDAO.salvarOuAlterar(perfil, session);
        Perfil perfilAlterado = perfilDAO.pesquisarPorId(perfil.getId(), session);
        session.close();
        Assert.assertEquals(perfilAlterado.getNome(), perfil.getNome());
    }

    @Test
    public void testPesquisarPorId() {
        System.out.println("pesquisarPorId");
        primeiroPerfilBanco();
        session = HibernateUtil.abrirSessao();
        Perfil perfilPesquisado = perfilDAO.pesquisarPorId(perfil.getId(), session);
        session.close();
        Assert.assertNotNull(perfilPesquisado);
    }
    
    @Test
    public void testExcluir() {
        System.out.println("excluir");
        primeiroPerfilBanco();
        session = HibernateUtil.abrirSessao();
        perfilDAO.excluir(perfil, session);
        Perfil perfilExcluido = perfilDAO.pesquisarPorId(perfil.getId(), session);
        session.close();
        Assert.assertNull(perfilExcluido);
    }
    
    @Test
    public void testPesquisarTodos() {
        System.out.println("pesquisarTodos");
        primeiroPerfilBanco();
        session = HibernateUtil.abrirSessao();
        List<Perfil> perfils = perfilDAO.listarTodos(session);
        session.close();
        Assert.assertFalse(perfils.isEmpty());
    }
    
    

    public Perfil primeiroPerfilBanco() {
        session = HibernateUtil.abrirSessao();
        Query consulta = session.createQuery("from Perfil");
        consulta.setMaxResults(1);
        perfil = (Perfil) consulta.uniqueResult();
        session.close();
        if (perfil == null) {
            testSalvar();
        }
        return perfil;
    }

}