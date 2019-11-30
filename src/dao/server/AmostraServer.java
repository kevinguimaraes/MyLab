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

import dao.AmostraDAO;
import dao.helper.HibernateUtil;
import model.Amostra;

@Path("/amostra")
public class AmostraServer {

	
	@GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Amostra> getAmostra(){
		 AmostraDAO amostraDAO = new AmostraDAO();
		 Session session = HibernateUtil.abrirSessao();
		 List<Amostra> tmp  = amostraDAO.listarTodos(session);
		 session.close();
		 return tmp;
    }
	 
	@GET
    @Produces(MediaType.APPLICATION_JSON)
	@Path("{id}")
    public Amostra getAmostra(@PathParam("id") Long id){
		 AmostraDAO amostraDAO = new AmostraDAO();
		 Session session = HibernateUtil.abrirSessao();
		 Amostra amostra = amostraDAO.pesquisarPorId(id, session);
		 session.close();
		 return amostra;
    }
	 
	//@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	 @POST
	 @Produces(MediaType.APPLICATION_JSON)
	 @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	 public Long cadastrar(@FormParam("dado") String dadosJSON ) {
		 Gson gson = new Gson();
	     Amostra amostra = gson.fromJson(dadosJSON, Amostra.class);
	     AmostraDAO amostraDAO = new AmostraDAO();
	     Session session = HibernateUtil.abrirSessao();
	     amostraDAO.salvarOuAlterar(amostra, session);
		 session.close();
	     return amostra.getId();
	 }
	 
	 @PUT
	 @Produces(MediaType.APPLICATION_JSON)
	 @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	 public Long alterar(@FormParam("dado") String dadosJSON ) {
		 Gson gson = new Gson();
	     Amostra amostra = gson.fromJson(dadosJSON, Amostra.class);
	     
	     
	     AmostraDAO amostraDAO = new AmostraDAO();
	     Session session = HibernateUtil.abrirSessao();
	     amostraDAO.salvarOuAlterar(amostra, session);
		 session.close();
	     return amostra.getId();
	 }
	 
	@DELETE
    @Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    public Boolean deletar(@FormParam("dado") String dadosJSON){
	     AmostraDAO amostraDAO = new AmostraDAO();
	     
	     Gson gson = new Gson();
	     Amostra amostra = gson.fromJson(dadosJSON, Amostra.class);
	     
	     Session session = HibernateUtil.abrirSessao();
	     amostraDAO.excluir(amostra, session);
		 session.close();
	     return true;
	 }
}
