package dao.server;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.FormParam;
import javax.ws.rs.core.MediaType;

import org.hibernate.Session;

import com.google.gson.Gson;

import dao.UsuarioDAO;
import dao.helper.HibernateUtil;
import model.Usuario;

@Path("/usuario")
public class UsuarioServer {

	
	@GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Usuario> getUsuario(){
		 UsuarioDAO usuarioDAO = new UsuarioDAO();
		 Session session = HibernateUtil.abrirSessao();
		 List<Usuario> tmp  = usuarioDAO.listarTodos(session);
		 session.close();
		 return tmp;
    }
	
	
	@GET
    @Produces(MediaType.APPLICATION_JSON)
	@Path("/login/{login}")
    public Usuario getUsuario(@PathParam("login") String login){
		 UsuarioDAO usuarioDAO = new UsuarioDAO();
		 Session session = HibernateUtil.abrirSessao();
		 Usuario usuario = usuarioDAO.listarPorNomeUsuario(session, login);
		 session.close();
		 return usuario;
    }
	 
	@GET
    @Produces(MediaType.APPLICATION_JSON)
	@Path("{id}")
    public Usuario getUsuario(@PathParam("id") Long id){
		 UsuarioDAO usuarioDAO = new UsuarioDAO();
		 Session session = HibernateUtil.abrirSessao();
		 Usuario usuario = usuarioDAO.pesquisarPorId(id, session);
		 session.close();
		 return usuario;
    }
	 
	 @POST
	 @Produces(MediaType.APPLICATION_JSON)
	 @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	 public Long cadastrar(@FormParam("dado") String dadosJSON ) {
		 Gson gson = new Gson();
	     Usuario usuario = gson.fromJson(dadosJSON, Usuario.class);
	     UsuarioDAO usuarioDAO = new UsuarioDAO();
	     Session session = HibernateUtil.abrirSessao();
	     usuarioDAO.salvarOuAlterar(usuario, session);
		 session.close();
	     return usuario.getId();
	 }
	 
	 @PUT
	 @Produces(MediaType.APPLICATION_JSON)
	 @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	 public Long alterar(@FormParam("dado") String dadosJSON ) {
		 Gson gson = new Gson();
	     Usuario usuario = gson.fromJson(dadosJSON, Usuario.class);
	     
	     
	     UsuarioDAO usuarioDAO = new UsuarioDAO();
	     Session session = HibernateUtil.abrirSessao();
	     usuarioDAO.salvarOuAlterar(usuario, session);
		 session.close();
	     return usuario.getId();
	 }
	 
	@DELETE
    @Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    public Boolean deletar(@FormParam("dado") String dadosJSON){
	     UsuarioDAO usuarioDAO = new UsuarioDAO();
	     
	     Gson gson = new Gson();
	     Usuario usuario = gson.fromJson(dadosJSON, Usuario.class);
	     
	     Session session = HibernateUtil.abrirSessao();
	     usuarioDAO.excluir(usuario, session);
		 session.close();
	     return true;
	 }
}
