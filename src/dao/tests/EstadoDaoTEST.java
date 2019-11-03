package dao.tests;


import org.junit.Test;

import dao.EstadoDAO;
import dao.helper.HibernateUtil;
import model.Estado;

import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.junit.Assert;

/**
 *
 * @author Aluno
 */
public class EstadoDaoTEST {

    private Estado estado;
    private Session session;
    private EstadoDAO estadoDAO;

    public EstadoDaoTEST() {
        estadoDAO = new EstadoDAO();
    }

    @Test
    public void testSalvar() {
        System.out.println("salvar");
        estado = new Estado(null, "estado1", null);
        session = HibernateUtil.abrirSessao();
        estadoDAO.salvarOuAlterar(estado, session);
        session.close();
        Assert.assertNotNull(estado.getId());
    }

    @Test
    public void testAlterar() {
        System.out.println("alterar");
        primeiroEstadoBanco();
        estado.setNome("nome alterado");
        session = HibernateUtil.abrirSessao();
        estadoDAO.salvarOuAlterar(estado, session);
        Estado estadoAlterado = estadoDAO.pesquisarPorId(estado.getId(), session);
        session.close();
        Assert.assertEquals(estadoAlterado.getNome(), estado.getNome());
    }

    @Test
    public void testPesquisarPorId() {
        System.out.println("pesquisarPorId");
        primeiroEstadoBanco();
        session = HibernateUtil.abrirSessao();
        Estado prodPesquisado = estadoDAO.pesquisarPorId(estado.getId(), session);
        session.close();
        Assert.assertNotNull(prodPesquisado);
    }
    
    @Test
    public void testExcluir() {
        System.out.println("excluir");
        primeiroEstadoBanco();
        session = HibernateUtil.abrirSessao();
        estadoDAO.excluir(estado, session);
        Estado estadoExcluido = estadoDAO.pesquisarPorId(estado.getId(), session);
        session.close();
        Assert.assertNull(estadoExcluido);
    }
    
    @Test
    public void testPesquisarTodos() {
        System.out.println("pesquisarTodos");
        primeiroEstadoBanco();
        session = HibernateUtil.abrirSessao();
        List<Estado> estados = estadoDAO.listarTodos(session);
        session.close();
        Assert.assertFalse(estados.isEmpty());
    }
    
    

    public Estado primeiroEstadoBanco() {
        session = HibernateUtil.abrirSessao();
        Query consulta = session.createQuery("from Estado");
        consulta.setMaxResults(1);
        estado = (Estado) consulta.uniqueResult();
        session.close();
        if (estado == null) {
            testSalvar();
        }
        return estado;
    }

}