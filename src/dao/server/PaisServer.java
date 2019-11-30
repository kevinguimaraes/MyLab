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

import dao.PaisDAO;
import dao.helper.HibernateUtil;
import model.Pais;

@Path("/pais")
public class PaisServer {

	
	@GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Pais> getPais(){
		 PaisDAO paisDAO = new PaisDAO();
		 Session session = HibernateUtil.abrirSessao();
		 List<Pais> tmp  = paisDAO.listarTodos(session);
		 session.close();
		 return tmp;
    }
	 
	@GET
    @Produces(MediaType.APPLICATION_JSON)
	@Path("{id}")
    public Pais getPais(@PathParam("id") Long id){
		 PaisDAO paisDAO = new PaisDAO();
		 Session session = HibernateUtil.abrirSessao();
		 Pais pais = paisDAO.pesquisarPorId(id, session);
		 session.close();
		 return pais;
    }
	 
	 @POST
	 @Produces(MediaType.APPLICATION_JSON)
	 @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	 public Long cadastrar(@FormParam("dado") String dadosJSON ) {
		 Gson gson = new Gson();
	     Pais pais = gson.fromJson(dadosJSON, Pais.class);
	     PaisDAO paisDAO = new PaisDAO();
	     Session session = HibernateUtil.abrirSessao();
	     paisDAO.salvarOuAlterar(pais, session);
		 session.close();
	     return pais.getId();
	 }
	 
	 @PUT
	 @Produces(MediaType.APPLICATION_JSON)
	 @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	 public Long alterar(@FormParam("dado") String dadosJSON ) {
		 Gson gson = new Gson();
	     Pais pais = gson.fromJson(dadosJSON, Pais.class);
	     
	     
	     PaisDAO paisDAO = new PaisDAO();
	     Session session = HibernateUtil.abrirSessao();
	     paisDAO.salvarOuAlterar(pais, session);
		 session.close();
	     return pais.getId();
	 }
	 
	@DELETE
    @Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    public Boolean deletar(@FormParam("dado") String dadosJSON){
	     PaisDAO paisDAO = new PaisDAO();
	     
	     Gson gson = new Gson();
	     Pais pais = gson.fromJson(dadosJSON, Pais.class);
	     
	     Session session = HibernateUtil.abrirSessao();
	     paisDAO.excluir(pais, session);
		 session.close();
	     return true;
	 }
}
