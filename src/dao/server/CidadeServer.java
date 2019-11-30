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

import dao.CidadeDAO;
import dao.helper.HibernateUtil;
import model.Cidade;

@Path("/cidade")
public class CidadeServer {

	
	@GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Cidade> getCidade(){
		 CidadeDAO cidadeDAO = new CidadeDAO();
		 Session session = HibernateUtil.abrirSessao();
		 List<Cidade> tmp  = cidadeDAO.listarTodos(session);
		 session.close();
		 return tmp;
    }
	 
	@GET
    @Produces(MediaType.APPLICATION_JSON)
	@Path("{id}")
    public Cidade getCidade(@PathParam("id") Long id){
		 CidadeDAO cidadeDAO = new CidadeDAO();
		 Session session = HibernateUtil.abrirSessao();
		 Cidade cidade = cidadeDAO.pesquisarPorId(id, session);
		 session.close();
		 return cidade;
    }
	 
	 @POST
	 @Produces(MediaType.APPLICATION_JSON)
	 @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	 public Long cadastrar(@FormParam("dado") String dadosJSON ) {
		 Gson gson = new Gson();
	     Cidade cidade = gson.fromJson(dadosJSON, Cidade.class);
	     CidadeDAO cidadeDAO = new CidadeDAO();
	     Session session = HibernateUtil.abrirSessao();
	     cidadeDAO.salvarOuAlterar(cidade, session);
		 session.close();
	     return cidade.getId();
	 }
	 
	 @PUT
	 @Produces(MediaType.APPLICATION_JSON)
	 @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	 public Long alterar(@FormParam("dado") String dadosJSON ) {
		 Gson gson = new Gson();
	     Cidade cidade = gson.fromJson(dadosJSON, Cidade.class);
	     
	     
	     CidadeDAO cidadeDAO = new CidadeDAO();
	     Session session = HibernateUtil.abrirSessao();
	     cidadeDAO.salvarOuAlterar(cidade, session);
		 session.close();
	     return cidade.getId();
	 }
	 
	@DELETE
    @Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    public Boolean deletar(@FormParam("dado") String dadosJSON){
	     CidadeDAO cidadeDAO = new CidadeDAO();
	     
	     Gson gson = new Gson();
	     Cidade cidade = gson.fromJson(dadosJSON, Cidade.class);
	     
	     Session session = HibernateUtil.abrirSessao();
	     cidadeDAO.excluir(cidade, session);
		 session.close();
	     return true;
	 }
}
