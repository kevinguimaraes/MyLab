package dao.tests;


import org.junit.Test;

import dao.EquipamentoDAO;
import dao.helper.HibernateUtil;
import model.Equipamento;

import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.junit.Assert;

/**
 *
 * @author Aluno
 */
public class EquipamentoDaoTEST {

    private Equipamento equipamento;
    private Session session;
    private EquipamentoDAO equipamentoDAO;

    public EquipamentoDaoTEST() {
        equipamentoDAO = new EquipamentoDAO();
    }

    @Test
    public void testSalvar() {
        System.out.println("salvar");
        equipamento = new Equipamento(null, "nome equipamento", "123", "1.3", "2.56");
        session = HibernateUtil.abrirSessao();
        equipamentoDAO.salvarOuAlterar(equipamento, session);
        session.close();
        Assert.assertNotNull(equipamento.getId());
    }

    @Test
    public void testAlterar() {
        System.out.println("alterar");
        primeiroEquipamentoBanco();
        equipamento.setNome("nome alterado");
        session = HibernateUtil.abrirSessao();
        equipamentoDAO.salvarOuAlterar(equipamento, session);
        Equipamento equipamentoAlterado = equipamentoDAO.pesquisarPorId(equipamento.getId(), session);
        session.close();
        Assert.assertEquals(equipamentoAlterado.getNome(), equipamento.getNome());
    }

    @Test
    public void testPesquisarPorId() {
        System.out.println("pesquisarPorId");
        primeiroEquipamentoBanco();
        session = HibernateUtil.abrirSessao();
        Equipamento prodPesquisado = equipamentoDAO.pesquisarPorId(equipamento.getId(), session);
        session.close();
        Assert.assertNotNull(prodPesquisado);
    }
    
    @Test
    public void testExcluir() {
        System.out.println("excluir");
        primeiroEquipamentoBanco();
        session = HibernateUtil.abrirSessao();
        equipamentoDAO.excluir(equipamento, session);
        Equipamento equipamentoExcluido = equipamentoDAO.pesquisarPorId(equipamento.getId(), session);
        session.close();
        Assert.assertNull(equipamentoExcluido);
    }
    
    @Test
    public void testPesquisarTodos() {
        System.out.println("pesquisarTodos");
        primeiroEquipamentoBanco();
        session = HibernateUtil.abrirSessao();
        List<Equipamento> equipamentos = equipamentoDAO.listarTodos(session);
        session.close();
        Assert.assertFalse(equipamentos.isEmpty());
    }
    
    

    public Equipamento primeiroEquipamentoBanco() {
        session = HibernateUtil.abrirSessao();
        Query consulta = session.createQuery("from Equipamento");
        consulta.setMaxResults(1);
        equipamento = (Equipamento) consulta.uniqueResult();
        session.close();
        if (equipamento == null) {
            testSalvar();
        }
        return equipamento;
    }

}