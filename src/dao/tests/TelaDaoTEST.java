package dao.tests;


import org.junit.Test;

import dao.TelaDAO;
import dao.helper.HibernateUtil;
import model.Tela;

import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.junit.Assert;

/**
 *
 * @author Aluno
 */
public class TelaDaoTEST {

    private Tela tela;
    private Session session;
    private TelaDAO telaDAO;

    public TelaDaoTEST() {
        telaDAO = new TelaDAO();
    }

    @Test
    public void testSalvar() {
        System.out.println("salvar");
        tela = new Tela(null, "tela1");
        session = HibernateUtil.abrirSessao();
        telaDAO.salvarOuAlterar(tela, session);
        session.close();
        Assert.assertNotNull(tela.getId());
    }

    @Test
    public void testAlterar() {
        System.out.println("alterar");
        primeiroTelaBanco();
        tela.setNome("nome alterado");
        session = HibernateUtil.abrirSessao();
        telaDAO.salvarOuAlterar(tela, session);
        Tela telaAlterado = telaDAO.pesquisarPorId(tela.getId(), session);
        session.close();
        Assert.assertEquals(telaAlterado.getNome(), tela.getNome());
    }

    @Test
    public void testPesquisarPorId() {
        System.out.println("pesquisarPorId");
        primeiroTelaBanco();
        session = HibernateUtil.abrirSessao();
        Tela prodPesquisado = telaDAO.pesquisarPorId(tela.getId(), session);
        session.close();
        Assert.assertNotNull(prodPesquisado);
    }
    
    @Test
    public void testExcluir() {
        System.out.println("excluir");
        primeiroTelaBanco();
        session = HibernateUtil.abrirSessao();
        telaDAO.excluir(tela, session);
        Tela telaExcluido = telaDAO.pesquisarPorId(tela.getId(), session);
        session.close();
        Assert.assertNull(telaExcluido);
    }
    
    @Test
    public void testPesquisarTodos() {
        System.out.println("pesquisarTodos");
        primeiroTelaBanco();
        session = HibernateUtil.abrirSessao();
        List<Tela> telas = telaDAO.listarTodos(session);
        session.close();
        Assert.assertFalse(telas.isEmpty());
    }
    
    

    public Tela primeiroTelaBanco() {
        session = HibernateUtil.abrirSessao();
        Query consulta = session.createQuery("from Tela");
        consulta.setMaxResults(1);
        tela = (Tela) consulta.uniqueResult();
        session.close();
        if (tela == null) {
            testSalvar();
        }
        return tela;
    }

}