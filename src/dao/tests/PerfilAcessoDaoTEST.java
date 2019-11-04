package dao.tests;


import org.junit.Test;

import dao.PerfilAcessoDAO;
import dao.helper.HibernateUtil;
import model.PerfilAcesso;

import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.junit.Assert;

/**
 *
 * @author Aluno
 */
public class PerfilAcessoDaoTEST {

    private PerfilAcesso perfilAcesso;
    private Session session;
    private PerfilAcessoDAO perfilAcessoDAO;

    public PerfilAcessoDaoTEST() {
        perfilAcessoDAO = new PerfilAcessoDAO();
    }

    @Test
    public void testSalvar() {
        System.out.println("salvar");
        perfilAcesso = new PerfilAcesso(null, null, null);
        session = HibernateUtil.abrirSessao();
        perfilAcessoDAO.salvarOuAlterar(perfilAcesso, session);
        session.close();
        Assert.assertNotNull(perfilAcesso.getId());
    }

    @Test
    public void testPesquisarPorId() {
        System.out.println("pesquisarPorId");
        primeiroPerfilAcessoBanco();
        session = HibernateUtil.abrirSessao();
        PerfilAcesso prodPesquisado = perfilAcessoDAO.pesquisarPorId(perfilAcesso.getId(), session);
        session.close();
        Assert.assertNotNull(prodPesquisado);
    }
    
    @Test
    public void testExcluir() {
        System.out.println("excluir");
        primeiroPerfilAcessoBanco();
        session = HibernateUtil.abrirSessao();
        perfilAcessoDAO.excluir(perfilAcesso, session);
        PerfilAcesso perfilAcessoExcluido = perfilAcessoDAO.pesquisarPorId(perfilAcesso.getId(), session);
        session.close();
        Assert.assertNull(perfilAcessoExcluido);
    }
    
    @Test
    public void testPesquisarTodos() {
        System.out.println("pesquisarTodos");
        primeiroPerfilAcessoBanco();
        session = HibernateUtil.abrirSessao();
        List<PerfilAcesso> perfilAcessos = perfilAcessoDAO.listarTodos(session);
        session.close();
        Assert.assertFalse(perfilAcessos.isEmpty());
    }
    
    

    public PerfilAcesso primeiroPerfilAcessoBanco() {
        session = HibernateUtil.abrirSessao();
        Query consulta = session.createQuery("from PerfilAcesso");
        consulta.setMaxResults(1);
        perfilAcesso = (PerfilAcesso) consulta.uniqueResult();
        session.close();
        if (perfilAcesso == null) {
            testSalvar();
        }
        return perfilAcesso;
    }

}