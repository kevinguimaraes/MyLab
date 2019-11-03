
package dao.tests;

import java.util.Date;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.junit.Assert;
import org.junit.Test;

import dao.ClienteDAO;
import dao.helper.HibernateUtil;
import model.PessoaFisica;
import model.Cliente;

import static org.junit.Assert.*;

public class ClienteDaoTEST {
    
    private Cliente cliente;
    private Session session;
    private ClienteDAO clienteDAO;  
    
    public ClienteDaoTEST() {
    clienteDAO = new ClienteDAO();
    }
    
 
    @Test
    public void testSalvar() {
        System.out.println("salvar");
        session = HibernateUtil.abrirSessao();
        PessoaFisica p = new PessoaFisica(null, "kevin", new Date(), "12312321", "kevin@cliente", "12365487", "M");
        cliente = new Cliente("codcliente", p);
        clienteDAO.salvarOuAlterar(cliente, session);
        session.close();
        assertNotNull(cliente.getId());
    }
    
    @Test
    public void testAlterar() {
        System.out.println("alterar");
        primeiroClienteDoBancoDeDados();
        cliente.setCodigo("codigo alterado");
        session = HibernateUtil.abrirSessao();
        clienteDAO.salvarOuAlterar(cliente, session);
        Cliente clienteAlterada = clienteDAO.pesquisarPorId(cliente.getId(), session);
        session.close();
        assertEquals(cliente.getCodigo(), clienteAlterada.getCodigo());
    }
    
  @Test
    public void testPesquisarPorId() {
        System.out.println("pesquisarPorId");
        primeiroClienteDoBancoDeDados();
        session = HibernateUtil.abrirSessao();
        Cliente clientePesquisada = clienteDAO.pesquisarPorId(cliente.getId(), session);
        session.close();
        assertNotNull(clientePesquisada);
    }
     
    
 @Test
    public void excluir() {
        System.out.println("excluir");
        primeiroClienteDoBancoDeDados();
        session = HibernateUtil.abrirSessao();
        clienteDAO.excluir(cliente, session);
        Cliente produtoExcluido = clienteDAO.pesquisarPorId(cliente.getId(), session);
        session.close();
        assertNull(produtoExcluido);
    }
 
	 @Test
	 public void testPesquisarTodos() {
	     System.out.println("pesquisarTodos");
	     primeiroClienteDoBancoDeDados();
	     session = HibernateUtil.abrirSessao();
	     List<Cliente> pessoasFisicas = clienteDAO.listarTodos(session);
	     session.close();
	     Assert.assertFalse(pessoasFisicas.isEmpty());
	 }
   
    
     private void primeiroClienteDoBancoDeDados() {
        session = HibernateUtil.abrirSessao();
        Query consulta = session.createQuery("from Cliente");//para buscar dados no BD
        consulta.setMaxResults(1);//busca o primeiro dado do BD
        cliente = (Cliente) consulta.uniqueResult();
        session.close();
        if (cliente == null) {
            testSalvar();
        }
    }
}

