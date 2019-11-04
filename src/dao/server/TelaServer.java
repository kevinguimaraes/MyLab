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

import dao.TelaDAO;
import dao.helper.HibernateUtil;
import model.Tela;

@Path("/tela")
public class TelaServer {

	
	@GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Tela> getTela(){
		 TelaDAO telaDAO = new TelaDAO();
		 Session session = HibernateUtil.abrirSessao();
		 List<Tela> tmp  = telaDAO.listarTodos(session);
		 session.close();
		 return tmp;
    }
	 
	@GET
    @Produces(MediaType.APPLICATION_JSON)
	@Path("{id}")
    public Tela getTela(@PathParam("id") Long id){
		 TelaDAO telaDAO = new TelaDAO();
		 Session session = HibernateUtil.abrirSessao();
		 Tela tela = telaDAO.pesquisarPorId(id, session);
		 session.close();
		 return tela;
    }
	 
	//@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	 @POST
	 @Produces(MediaType.APPLICATION_JSON)
	 public Long cadastrar(@QueryParam("dado") String dadosJSON ) {
		 Gson gson = new Gson();
	     Tela tela = gson.fromJson(dadosJSON, Tela.class);
	     TelaDAO telaDAO = new TelaDAO();
	     Session session = HibernateUtil.abrirSessao();
	     telaDAO.salvarOuAlterar(tela, session);
		 session.close();
	     return tela.getId();
	 }
	 
	 //@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	 @PUT
	 @Produces(MediaType.APPLICATION_JSON)
	 public Long alterar(@QueryParam("dado") String dadosJSON ) {
		 Gson gson = new Gson();
	     Tela tela = gson.fromJson(dadosJSON, Tela.class);
	     
	     
	     TelaDAO telaDAO = new TelaDAO();
	     Session session = HibernateUtil.abrirSessao();
	     telaDAO.salvarOuAlterar(tela, session);
		 session.close();
	     return tela.getId();
	 }
	 
	@DELETE
    @Produces(MediaType.APPLICATION_JSON)
    public Boolean deletar(@QueryParam("dado") String dadosJSON){
	     TelaDAO telaDAO = new TelaDAO();
	     
	     Gson gson = new Gson();
	     Tela tela = gson.fromJson(dadosJSON, Tela.class);
	     
	     Session session = HibernateUtil.abrirSessao();
	     telaDAO.excluir(tela, session);
		 session.close();
	     return true;
	 }
}
