package dao.tests;


import org.junit.Test;

import dao.EnderecoDAO;
import dao.helper.HibernateUtil;
import model.Endereco;

import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.junit.Assert;

/**
 *
 * @author Aluno
 */
public class EnderecoDaoTEST {

    private Endereco endereco;
    private Session session;
    private EnderecoDAO enderecoDAO;

    public EnderecoDaoTEST() {
        enderecoDAO = new EnderecoDAO();
    }

    @Test
    public void testSalvar() {
        System.out.println("salvar");
        endereco = new Endereco(null, "Rua sem cascade", 12, "APT12", "123123", null);
        session = HibernateUtil.abrirSessao();
        enderecoDAO.salvarOuAlterar(endereco, session);
        session.close();
        Assert.assertNotNull(endereco.getId());
    }

    @Test
    public void testAlterar() {
        System.out.println("alterar");
        primeiroEnderecoBanco();
        endereco.setComplemento("Estreito");
        session = HibernateUtil.abrirSessao();
        enderecoDAO.salvarOuAlterar(endereco, session);
        Endereco prodAlterado = enderecoDAO.pesquisarPorId(endereco.getId(), session);
        session.close();
        Assert.assertEquals(prodAlterado.getComplemento(), endereco.getComplemento());
    }

    @Test
    public void testPesquisarPorId() {
        System.out.println("pesquisarPorId");
        primeiroEnderecoBanco();
        session = HibernateUtil.abrirSessao();
        Endereco prodPesquisado = enderecoDAO.pesquisarPorId(endereco.getId(), session);
        session.close();
        Assert.assertNotNull(prodPesquisado);
    }
    
    @Test
    public void testExcluir() {
        System.out.println("excluir");
        primeiroEnderecoBanco();
        session = HibernateUtil.abrirSessao();
        enderecoDAO.excluir(endereco, session);
        Endereco enderecoExcluido = enderecoDAO.pesquisarPorId(endereco.getId(), session);
        session.close();
        Assert.assertNull(enderecoExcluido);
    }
    
    @Test
    public void testPesquisarTodos() {
        System.out.println("pesquisarTodos");
        primeiroEnderecoBanco();
        session = HibernateUtil.abrirSessao();
        List<Endereco> enderecos = enderecoDAO.listarTodos(session);
        session.close();
        Assert.assertFalse(enderecos.isEmpty());
    }
    
    

    public Endereco primeiroEnderecoBanco() {
        session = HibernateUtil.abrirSessao();
        Query consulta = session.createQuery("from Endereco");
        consulta.setMaxResults(1);
        endereco = (Endereco) consulta.uniqueResult();
        session.close();
        if (endereco == null) {
            testSalvar();
        }
        return endereco;
    }

}