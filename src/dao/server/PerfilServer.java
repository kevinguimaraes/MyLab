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

import dao.PerfilDAO;
import dao.helper.HibernateUtil;
import model.Perfil;

@Path("/perfil")
public class PerfilServer {

	
	@GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Perfil> getPerfil(){
		 PerfilDAO perfilDAO = new PerfilDAO();
		 Session session = HibernateUtil.abrirSessao();
		 List<Perfil> tmp  = perfilDAO.listarTodos(session);
		 session.close();
		 return tmp;
    }
	 
	@GET
    @Produces(MediaType.APPLICATION_JSON)
	@Path("{id}")
    public Perfil getPerfil(@PathParam("id") Long id){
		 PerfilDAO perfilDAO = new PerfilDAO();
		 Session session = HibernateUtil.abrirSessao();
		 Perfil perfil = perfilDAO.pesquisarPorId(id, session);
		 session.close();
		 return perfil;
    }
	 
	//@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	 @POST
	 @Produces(MediaType.APPLICATION_JSON)
	 public Long cadastrar(@QueryParam("dado") String dadosJSON ) {
		 Gson gson = new Gson();
	     Perfil perfil = gson.fromJson(dadosJSON, Perfil.class);
	     PerfilDAO perfilDAO = new PerfilDAO();
	     Session session = HibernateUtil.abrirSessao();
	     perfilDAO.salvarOuAlterar(perfil, session);
		 session.close();
	     return perfil.getId();
	 }
	 
	 //@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	 @PUT
	 @Produces(MediaType.APPLICATION_JSON)
	 public Long alterar(@QueryParam("dado") String dadosJSON ) {
		 Gson gson = new Gson();
	     Perfil perfil = gson.fromJson(dadosJSON, Perfil.class);
	     
	     
	     PerfilDAO perfilDAO = new PerfilDAO();
	     Session session = HibernateUtil.abrirSessao();
	     perfilDAO.salvarOuAlterar(perfil, session);
		 session.close();
	     return perfil.getId();
	 }
	 
	@DELETE
    @Produces(MediaType.APPLICATION_JSON)
    public Boolean deletar(@QueryParam("dado") String dadosJSON){
	     PerfilDAO perfilDAO = new PerfilDAO();
	     
	     Gson gson = new Gson();
	     Perfil perfil = gson.fromJson(dadosJSON, Perfil.class);
	     
	     Session session = HibernateUtil.abrirSessao();
	     perfilDAO.excluir(perfil, session);
		 session.close();
	     return true;
	 }
}
