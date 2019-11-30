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

import dao.EnderecoDAO;
import dao.helper.HibernateUtil;
import model.Endereco;

@Path("/endereco")
public class EnderecoServer {

	
	@GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Endereco> getEndereco(){
		 EnderecoDAO enderecoDAO = new EnderecoDAO();
		 Session session = HibernateUtil.abrirSessao();
		 List<Endereco> tmp  = enderecoDAO.listarTodos(session);
		 session.close();
		 return tmp;
    }
	 
	@GET
    @Produces(MediaType.APPLICATION_JSON)
	@Path("{id}")
    public Endereco getEndereco(@PathParam("id") Long id){
		 EnderecoDAO enderecoDAO = new EnderecoDAO();
		 Session session = HibernateUtil.abrirSessao();
		 Endereco endereco = enderecoDAO.pesquisarPorId(id, session);
		 session.close();
		 return endereco;
    }
	 
	 @POST
	 @Produces(MediaType.APPLICATION_JSON)
	 @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	 public Long cadastrar(@FormParam("dado") String dadosJSON ) {
		 Gson gson = new Gson();
	     Endereco endereco = gson.fromJson(dadosJSON, Endereco.class);
	     EnderecoDAO enderecoDAO = new EnderecoDAO();
	     Session session = HibernateUtil.abrirSessao();
	     enderecoDAO.salvarOuAlterar(endereco, session);
		 session.close();
	     return endereco.getId();
	 }
	 
	 @PUT
	 @Produces(MediaType.APPLICATION_JSON)
	 @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	 public Long alterar(@FormParam("dado") String dadosJSON ) {
		 Gson gson = new Gson();
	     Endereco endereco = gson.fromJson(dadosJSON, Endereco.class);
	     
	     
	     EnderecoDAO enderecoDAO = new EnderecoDAO();
	     Session session = HibernateUtil.abrirSessao();
	     enderecoDAO.salvarOuAlterar(endereco, session);
		 session.close();
	     return endereco.getId();
	 }
	 
	@DELETE
    @Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    public Boolean deletar(@FormParam("dado") String dadosJSON){
	     EnderecoDAO enderecoDAO = new EnderecoDAO();
	     
	     Gson gson = new Gson();
	     Endereco endereco = gson.fromJson(dadosJSON, Endereco.class);
	     
	     Session session = HibernateUtil.abrirSessao();
	     enderecoDAO.excluir(endereco, session);
		 session.close();
	     return true;
	 }
}
