package dao.tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import java.util.Date;

import org.hibernate.Query;
import org.hibernate.Session;
import org.junit.Test;

import dao.PessoaJuridicaDAO;
import dao.helper.HibernateUtil;
import model.Endereco;
import model.PessoaJuridica;

public class PessoaJuridicaDaoTEST {
    
    private PessoaJuridica pessoaJuridica;
    private Session session;
    private PessoaJuridicaDAO pessoaJuridicaDAO;  
    
    public PessoaJuridicaDaoTEST() {
    pessoaJuridicaDAO = new PessoaJuridicaDAO();
    }
    
 
    @Test
    public void testSalvar() {
        System.out.println("salvar");
        pessoaJuridica = new PessoaJuridica(null, "Jorge", new Date(), "12345678", "kevin@senac.br", "088123213", "M");
        Endereco endereco = new Endereco(null, "Rua sem cascade", 12, "APT12",  null);
        pessoaJuridica.setEndereco(endereco);
        session = HibernateUtil.abrirSessao();
        pessoaJuridicaDAO.salvarOuAlterar(pessoaJuridica, session);
        session.close();
        assertNotNull(pessoaJuridica.getId());
        assertNotNull(endereco.getId());
    }
    
    @Test
    public void testAlterar() {
        System.out.println("alterar");
        primeiroPessoaJuridicaDoBancoDeDados();
        pessoaJuridica.setNome("Nome alterado");
        session = HibernateUtil.abrirSessao();
        pessoaJuridicaDAO.salvarOuAlterar(pessoaJuridica, session);
        PessoaJuridica pessoaJuridicaAlterada = pessoaJuridicaDAO.pesquisarPorId(pessoaJuridica.getId(), session);
        session.close();
        assertEquals(pessoaJuridica.getNome(), pessoaJuridicaAlterada.getNome());
    }
    
  @Test
    public void testPesquisarPorId() {
        System.out.println("pesquisarPorId");
        primeiroPessoaJuridicaDoBancoDeDados();
        session = HibernateUtil.abrirSessao();
        PessoaJuridica pessoaJuridicaPesquisada = pessoaJuridicaDAO.pesquisarPorId(pessoaJuridica.getId(), session);
        session.close();
        assertNotNull(pessoaJuridicaPesquisada);
    }
     
    
 @Test
    public void excluir() {
        System.out.println("excluir");
        primeiroPessoaJuridicaDoBancoDeDados();
        session = HibernateUtil.abrirSessao();
        pessoaJuridicaDAO.excluir(pessoaJuridica, session);
        PessoaJuridica produtoExcluido = pessoaJuridicaDAO.pesquisarPorId(pessoaJuridica.getId(), session);
        session.close();
        assertNull(produtoExcluido);
    }
   
    
     private void primeiroPessoaJuridicaDoBancoDeDados() {
        session = HibernateUtil.abrirSessao();
        Query consulta = session.createQuery("from PessoaJuridica");//para buscar dados no BD
        consulta.setMaxResults(1);//busca o primeiro dado do BD
        pessoaJuridica = (PessoaJuridica) consulta.uniqueResult();
        session.close();
        if (pessoaJuridica == null) {
            testSalvar();
        }
    }
}
