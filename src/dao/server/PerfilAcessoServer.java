package dao.server;

import java.util.List;

import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import org.hibernate.Session;

import com.google.gson.Gson;

import dao.PerfilAcessoDAO;
import dao.helper.HibernateUtil;
import model.PerfilAcesso;

@Path("/perfilacesso")
public class PerfilAcessoServer {

	
	@GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<PerfilAcesso> getPerfilAcesso(){
		 PerfilAcessoDAO perfilAcessoDAO = new PerfilAcessoDAO();
		 Session session = HibernateUtil.abrirSessao();
		 List<PerfilAcesso> tmp  = perfilAcessoDAO.listarTodos(session);
		 session.close();
		 return tmp;
    }
	 
	@GET
    @Produces(MediaType.APPLICATION_JSON)
	@Path("{id}")
    public PerfilAcesso getPerfilAcesso(@PathParam("id") Long id){
		 PerfilAcessoDAO perfilAcessoDAO = new PerfilAcessoDAO();
		 Session session = HibernateUtil.abrirSessao();
		 PerfilAcesso perfilAcesso = perfilAcessoDAO.pesquisarPorId(id, session);
		 session.close();
		 return perfilAcesso;
    }
	 
	//@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	 @POST
	 @Produces(MediaType.APPLICATION_JSON)
	 public Long cadastrar(@QueryParam("dado") String dadosJSON ) {
		 Gson gson = new Gson();
	     PerfilAcesso perfilAcesso = gson.fromJson(dadosJSON, PerfilAcesso.class);
	     PerfilAcessoDAO perfilAcessoDAO = new PerfilAcessoDAO();
	     Session session = HibernateUtil.abrirSessao();
	     perfilAcessoDAO.salvarOuAlterar(perfilAcesso, session);
		 session.close();
	     return perfilAcesso.getId();
	 }
	 
	 //@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	 @PUT
	 @Produces(MediaType.APPLICATION_JSON)
	 public Long alterar(@QueryParam("dado") String dadosJSON ) {
		 Gson gson = new Gson();
	     PerfilAcesso perfilAcesso = gson.fromJson(dadosJSON, PerfilAcesso.class);
	     
	     
	     PerfilAcessoDAO perfilAcessoDAO = new PerfilAcessoDAO();
	     Session session = HibernateUtil.abrirSessao();
	     perfilAcessoDAO.salvarOuAlterar(perfilAcesso, session);
		 session.close();
	     return perfilAcesso.getId();
	 }
	 
	@DELETE
    @Produces(MediaType.APPLICATION_JSON)
    public Boolean deletar(@QueryParam("dado") String dadosJSON){
	     PerfilAcessoDAO perfilAcessoDAO = new PerfilAcessoDAO();
	     
	     Gson gson = new Gson();
	     PerfilAcesso perfilAcesso = gson.fromJson(dadosJSON, PerfilAcesso.class);
	     
	     Session session = HibernateUtil.abrirSessao();
	     perfilAcessoDAO.excluir(perfilAcesso, session);
		 session.close();
	     return true;
	 }
}
