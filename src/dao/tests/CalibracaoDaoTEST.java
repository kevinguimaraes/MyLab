package dao.tests;


import org.junit.Test;

import dao.CalibracaoDAO;
import dao.helper.HibernateUtil;
import model.Calibracao;

import java.util.Date;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.junit.Assert;

/**
 *
 * @author Aluno
 */
public class CalibracaoDaoTEST {

    private Calibracao calibracao;
    private Session session;
    private CalibracaoDAO calibracaoDAO;

    public CalibracaoDaoTEST() {
        calibracaoDAO = new CalibracaoDAO();
    }

    @Test
    public void testSalvar() {
        System.out.println("salvar");
        calibracao = new Calibracao(null, 4.1, new Date(), null);
        session = HibernateUtil.abrirSessao();
        calibracaoDAO.salvarOuAlterar(calibracao, session);
        session.close();
        Assert.assertNotNull(calibracao.getId());
    }

    @Test
    public void testAlterar() {
        System.out.println("alterar");
        primeiroCalibracaoBanco();
        calibracao.setValor(1.3);
        session = HibernateUtil.abrirSessao();
        calibracaoDAO.salvarOuAlterar(calibracao, session);
        Calibracao calibracaoAlterado = calibracaoDAO.pesquisarPorId(calibracao.getId(), session);
        session.close();
        Assert.assertEquals(String.valueOf(calibracaoAlterado.getValor()), String.valueOf(calibracao.getValor()));
    }

    @Test
    public void testPesquisarPorId() {
        System.out.println("pesquisarPorId");
        primeiroCalibracaoBanco();
        session = HibernateUtil.abrirSessao();
        Calibracao prodPesquisado = calibracaoDAO.pesquisarPorId(calibracao.getId(), session);
        session.close();
        Assert.assertNotNull(prodPesquisado);
    }
    
    @Test
    public void testExcluir() {
        System.out.println("excluir");
        primeiroCalibracaoBanco();
        session = HibernateUtil.abrirSessao();
        calibracaoDAO.excluir(calibracao, session);
        Calibracao calibracaoExcluido = calibracaoDAO.pesquisarPorId(calibracao.getId(), session);
        session.close();
        Assert.assertNull(calibracaoExcluido);
    }
    
    @Test
    public void testPesquisarTodos() {
        System.out.println("pesquisarTodos");
        primeiroCalibracaoBanco();
        session = HibernateUtil.abrirSessao();
        List<Calibracao> calibracaos = calibracaoDAO.listarTodos(session);
        session.close();
        Assert.assertFalse(calibracaos.isEmpty());
    }
    
    

    public Calibracao primeiroCalibracaoBanco() {
        session = HibernateUtil.abrirSessao();
        Query consulta = session.createQuery("from Calibracao");
        consulta.setMaxResults(1);
        calibracao = (Calibracao) consulta.uniqueResult();
        session.close();
        if (calibracao == null) {
            testSalvar();
        }
        return calibracao;
    }

}