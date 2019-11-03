
package dao.tests;

import java.util.Date;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.junit.Assert;
import org.junit.Test;

import dao.UsuarioDAO;
import dao.helper.HibernateUtil;
import model.PessoaFisica;
import model.Usuario;

import static org.junit.Assert.*;

public class UsuarioDaoTEST {
    
    private Usuario usuario;
    private Session session;
    private UsuarioDAO usuarioDAO;  
    
    public UsuarioDaoTEST() {
    usuarioDAO = new UsuarioDAO();
    }
    
 
    @Test
    public void testSalvar() {
        System.out.println("salvar");
        session = HibernateUtil.abrirSessao();
        PessoaFisica p = new PessoaFisica(null, "kevin", new Date(), "12312321", "kevin@usuario", "12365487", "M");
        usuario = new Usuario(null, "loginKevin", "123456", "Developer", p);
        usuarioDAO.salvarOuAlterar(usuario, session);
        session.close();
        assertNotNull(usuario.getId());
    }
    
    @Test
    public void testAlterar() {
        System.out.println("alterar");
        primeiroUsuarioDoBancoDeDados();
        usuario.setCargo("cargo alterado");
        session = HibernateUtil.abrirSessao();
        usuarioDAO.salvarOuAlterar(usuario, session);
        Usuario usuarioAlterada = usuarioDAO.pesquisarPorId(usuario.getId(), session);
        session.close();
        assertEquals(usuario.getCargo(), usuarioAlterada.getCargo());
    }
    
  @Test
    public void testPesquisarPorId() {
        System.out.println("pesquisarPorId");
        primeiroUsuarioDoBancoDeDados();
        session = HibernateUtil.abrirSessao();
        Usuario usuarioPesquisada = usuarioDAO.pesquisarPorId(usuario.getId(), session);
        session.close();
        assertNotNull(usuarioPesquisada);
    }
     
    
 @Test
    public void excluir() {
        System.out.println("excluir");
        primeiroUsuarioDoBancoDeDados();
        session = HibernateUtil.abrirSessao();
        usuarioDAO.excluir(usuario, session);
        Usuario produtoExcluido = usuarioDAO.pesquisarPorId(usuario.getId(), session);
        session.close();
        assertNull(produtoExcluido);
    }
 
	 @Test
	 public void testPesquisarTodos() {
	     System.out.println("pesquisarTodos");
	     primeiroUsuarioDoBancoDeDados();
	     session = HibernateUtil.abrirSessao();
	     List<Usuario> pessoasFisicas = usuarioDAO.listarTodos(session);
	     session.close();
	     Assert.assertFalse(pessoasFisicas.isEmpty());
	 }
   
    
     private void primeiroUsuarioDoBancoDeDados() {
        session = HibernateUtil.abrirSessao();
        Query consulta = session.createQuery("from Usuario");//para buscar dados no BD
        consulta.setMaxResults(1);//busca o primeiro dado do BD
        usuario = (Usuario) consulta.uniqueResult();
        session.close();
        if (usuario == null) {
            testSalvar();
        }
    }
}

