package dao.tests;


import org.junit.Test;

import dao.MedicaoDAO;
import dao.helper.HibernateUtil;
import model.Medicao;

import java.util.Date;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.junit.Assert;

/**
 *
 * @author Aluno
 */
public class MedicaoDaoTEST {

    private Medicao medicao;
    private Session session;
    private MedicaoDAO medicaoDAO;

    public MedicaoDaoTEST() {
        medicaoDAO = new MedicaoDAO();
    }

    @Test
    public void testSalvar() {
        System.out.println("salvar");
        medicao = new Medicao(null, 1.2, "mg/l", new Date(), null, null);
        session = HibernateUtil.abrirSessao();
        medicaoDAO.salvarOuAlterar(medicao, session);
        session.close();
        Assert.assertNotNull(medicao.getId());
    }

    @Test
    public void testAlterar() {
        System.out.println("alterar");
        primeiroMedicaoBanco();
        medicao.setUnidade("unidade alterada");
        session = HibernateUtil.abrirSessao();
        medicaoDAO.salvarOuAlterar(medicao, session);
        Medicao medicaoAlterado = medicaoDAO.pesquisarPorId(medicao.getId(), session);
        session.close();
        Assert.assertEquals(medicaoAlterado.getUnidade(), medicao.getUnidade());
    }

    @Test
    public void testPesquisarPorId() {
        System.out.println("pesquisarPorId");
        primeiroMedicaoBanco();
        session = HibernateUtil.abrirSessao();
        Medicao prodPesquisado = medicaoDAO.pesquisarPorId(medicao.getId(), session);
        session.close();
        Assert.assertNotNull(prodPesquisado);
    }
    
    @Test
    public void testExcluir() {
        System.out.println("excluir");
        primeiroMedicaoBanco();
        session = HibernateUtil.abrirSessao();
        medicaoDAO.excluir(medicao, session);
        Medicao medicaoExcluido = medicaoDAO.pesquisarPorId(medicao.getId(), session);
        session.close();
        Assert.assertNull(medicaoExcluido);
    }
    
    @Test
    public void testPesquisarTodos() {
        System.out.println("pesquisarTodos");
        primeiroMedicaoBanco();
        session = HibernateUtil.abrirSessao();
        List<Medicao> medicaos = medicaoDAO.listarTodos(session);
        session.close();
        Assert.assertFalse(medicaos.isEmpty());
    }
    
    

    public Medicao primeiroMedicaoBanco() {
        session = HibernateUtil.abrirSessao();
        Query consulta = session.createQuery("from Medicao");
        consulta.setMaxResults(1);
        medicao = (Medicao) consulta.uniqueResult();
        session.close();
        if (medicao == null) {
            testSalvar();
        }
        return medicao;
    }

}