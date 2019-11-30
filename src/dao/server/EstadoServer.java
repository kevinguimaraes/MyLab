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

import dao.EstadoDAO;
import dao.helper.HibernateUtil;
import model.Estado;

@Path("/estado")
public class EstadoServer {

	
	@GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Estado> getEstado(){
		 EstadoDAO estadoDAO = new EstadoDAO();
		 Session session = HibernateUtil.abrirSessao();
		 List<Estado> tmp  = estadoDAO.listarTodos(session);
		 session.close();
		 return tmp;
    }
	 
	@GET
    @Produces(MediaType.APPLICATION_JSON)
	@Path("{id}")
    public Estado getEstado(@PathParam("id") Long id){
		 EstadoDAO estadoDAO = new EstadoDAO();
		 Session session = HibernateUtil.abrirSessao();
		 Estado estado = estadoDAO.pesquisarPorId(id, session);
		 session.close();
		 return estado;
    }
	 
	 @POST
	 @Produces(MediaType.APPLICATION_JSON)
	 @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	 public Long cadastrar(@FormParam("dado") String dadosJSON ) {
		 Gson gson = new Gson();
	     Estado estado = gson.fromJson(dadosJSON, Estado.class);
	     EstadoDAO estadoDAO = new EstadoDAO();
	     Session session = HibernateUtil.abrirSessao();
	     estadoDAO.salvarOuAlterar(estado, session);
		 session.close();
	     return estado.getId();
	 }
	 
	 @PUT
	 @Produces(MediaType.APPLICATION_JSON)
	 @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	 public Long alterar(@FormParam("dado") String dadosJSON ) {
		 Gson gson = new Gson();
	     Estado estado = gson.fromJson(dadosJSON, Estado.class);
	     
	     
	     EstadoDAO estadoDAO = new EstadoDAO();
	     Session session = HibernateUtil.abrirSessao();
	     estadoDAO.salvarOuAlterar(estado, session);
		 session.close();
	     return estado.getId();
	 }
	 
	@DELETE
    @Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    public Boolean deletar(@FormParam("dado") String dadosJSON){
	     EstadoDAO estadoDAO = new EstadoDAO();
	     
	     Gson gson = new Gson();
	     Estado estado = gson.fromJson(dadosJSON, Estado.class);
	     
	     Session session = HibernateUtil.abrirSessao();
	     estadoDAO.excluir(estado, session);
		 session.close();
	     return true;
	 }
}
