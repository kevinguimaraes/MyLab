package dao.server;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.hibernate.Session;

import com.google.gson.Gson;

import dao.PessoaFisicaDAO;
import dao.helper.HibernateUtil;
import model.PessoaFisica;

@Path("/pessoafisica")
public class PessoaFisicaServer {

	
	@GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<PessoaFisica> getPessoaFisica(){
		 PessoaFisicaDAO pessoaFisicaDAO = new PessoaFisicaDAO();
		 Session session = HibernateUtil.abrirSessao();
		 List<PessoaFisica> tmp  = pessoaFisicaDAO.listarTodos(session);
		 session.close();
		 return tmp;
    }
	 
	@GET
    @Produces(MediaType.APPLICATION_JSON)
	@Path("{id}")
    public PessoaFisica getPessoaFisica(@PathParam("id") Long id){
		 PessoaFisicaDAO pessoaFisicaDAO = new PessoaFisicaDAO();
		 Session session = HibernateUtil.abrirSessao();
		 PessoaFisica pessoaFisica = pessoaFisicaDAO.pesquisarPorId(id, session);
		 session.close();
		 return pessoaFisica;
    }
	 
	 @POST
	 @Produces(MediaType.APPLICATION_JSON)
	 @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	 public Long cadastrar(@FormParam("dado") String dadosJSON ) {
		 Gson gson = new Gson();
	     PessoaFisica pessoaFisica = gson.fromJson(dadosJSON, PessoaFisica.class);
	     PessoaFisicaDAO pessoaFisicaDAO = new PessoaFisicaDAO();
	     Session session = HibernateUtil.abrirSessao();
	     pessoaFisicaDAO.salvarOuAlterar(pessoaFisica, session);
		 session.close();
	     return pessoaFisica.getId();
	 }
	 
	 @PUT
	 @Produces(MediaType.APPLICATION_JSON)
	 @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	 @Path("{id}")
	 public Long alterar(@PathParam("id") Integer id, @FormParam("dado") String dadosJSON ) {
		 Gson gson = new Gson();
	     PessoaFisica pessoaFisica = gson.fromJson(dadosJSON, PessoaFisica.class);
	     
	     
	     PessoaFisicaDAO pessoaFisicaDAO = new PessoaFisicaDAO();
	     Session session = HibernateUtil.abrirSessao();
	     pessoaFisicaDAO.salvarOuAlterar(pessoaFisica, session);
		 session.close();
	     return pessoaFisica.getId();
	 }
	 
	@DELETE
    @Produces(MediaType.APPLICATION_JSON)
	@Path("{id}")
    public Boolean deletar(@PathParam("id") Long id){
	     PessoaFisicaDAO pessoaFisicaDAO = new PessoaFisicaDAO();
	     PessoaFisica p = new PessoaFisica();
	     p.setId(id);
	     Session session = HibernateUtil.abrirSessao();
	     pessoaFisicaDAO.excluir(p, session);
		 session.close();
	     return true;
	 }
}
