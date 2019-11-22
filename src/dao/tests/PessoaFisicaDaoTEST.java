
package dao.tests;

import java.util.Date;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.junit.Assert;
import org.junit.Test;

import dao.PessoaFisicaDAO;
import dao.helper.HibernateUtil;
import model.Endereco;
import model.PessoaFisica;

import static org.junit.Assert.*;

public class PessoaFisicaDaoTEST {
    
    private PessoaFisica pessoaFisica;
    private Session session;
    private PessoaFisicaDAO pessoaFisicaDAO;  
    
    public PessoaFisicaDaoTEST() {
    pessoaFisicaDAO = new PessoaFisicaDAO();
    }
    
 
    @Test
    public void testSalvar() {
        System.out.println("salvar");
        pessoaFisica = new PessoaFisica(null, "Jorge", new Date(), "12345678", "kevin@senac.br", "088123213", "M");
        Endereco endereco = new Endereco(null, "Rua sem cascade", 12, "APT12", "123132",  null);
        pessoaFisica.setEndereco(endereco);
        session = HibernateUtil.abrirSessao();
        pessoaFisicaDAO.salvarOuAlterar(pessoaFisica, session);
        session.close();
        assertNotNull(pessoaFisica.getId());
        assertNotNull(endereco.getId());
    }
    
    @Test
    public void testAlterar() {
        System.out.println("alterar");
        primeiroPessoaFisicaDoBancoDeDados();
        pessoaFisica.setNome("Nome alterado");
        session = HibernateUtil.abrirSessao();
        pessoaFisicaDAO.salvarOuAlterar(pessoaFisica, session);
        PessoaFisica pessoaFisicaAlterada = pessoaFisicaDAO.pesquisarPorId(pessoaFisica.getId(), session);
        session.close();
        assertEquals(pessoaFisica.getNome(), pessoaFisicaAlterada.getNome());
    }
    
  @Test
    public void testPesquisarPorId() {
        System.out.println("pesquisarPorId");
        primeiroPessoaFisicaDoBancoDeDados();
        session = HibernateUtil.abrirSessao();
        PessoaFisica pessoaFisicaPesquisada = pessoaFisicaDAO.pesquisarPorId(pessoaFisica.getId(), session);
        session.close();
        assertNotNull(pessoaFisicaPesquisada);
    }
     
    
 @Test
    public void excluir() {
        System.out.println("excluir");
        primeiroPessoaFisicaDoBancoDeDados();
        session = HibernateUtil.abrirSessao();
        pessoaFisicaDAO.excluir(pessoaFisica, session);
        PessoaFisica produtoExcluido = pessoaFisicaDAO.pesquisarPorId(pessoaFisica.getId(), session);
        session.close();
        assertNull(produtoExcluido);
    }
 
	 @Test
	 public void testPesquisarTodos() {
	     System.out.println("pesquisarTodos");
	     primeiroPessoaFisicaDoBancoDeDados();
	     session = HibernateUtil.abrirSessao();
	     List<PessoaFisica> pessoasFisicas = pessoaFisicaDAO.listarTodos(session);
	     session.close();
	     Assert.assertFalse(pessoasFisicas.isEmpty());
	 }
   
    
     private void primeiroPessoaFisicaDoBancoDeDados() {
        session = HibernateUtil.abrirSessao();
        Query consulta = session.createQuery("from PessoaFisica");//para buscar dados no BD
        consulta.setMaxResults(1);//busca o primeiro dado do BD
        pessoaFisica = (PessoaFisica) consulta.uniqueResult();
        session.close();
        if (pessoaFisica == null) {
            testSalvar();
        }
    }
}

