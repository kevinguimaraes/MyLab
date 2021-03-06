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

import dao.ClienteDAO;
import dao.helper.HibernateUtil;
import model.Cliente;
import model.PessoaFisica;
import model.PessoaJuridica;

@Path("/cliente")
public class ClienteServer {

	
	@GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Cliente> getCliente(){
		 ClienteDAO clienteDAO = new ClienteDAO();
		 Session session = HibernateUtil.abrirSessao();
		 List<Cliente> tmp  = clienteDAO.listarTodos(session);
		 session.close();
		 return tmp;
    }
	 
	@GET
    @Produces(MediaType.APPLICATION_JSON)
	@Path("{id}")
    public Cliente getCliente(@PathParam("id") Long id){
		 ClienteDAO clienteDAO = new ClienteDAO();
		 Session session = HibernateUtil.abrirSessao();
		 Cliente cliente = clienteDAO.pesquisarPorId(id, session);
		 session.close();
		 return cliente;
    }
	 
	 @POST
	 @Produces(MediaType.APPLICATION_JSON)
	 @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	 public Long cadastrar(@FormParam("dado") String dadosJSON, @FormParam("pessoa") String pessoa, @FormParam("tipo") String tipo) {
		 Gson gson = new Gson();
	     Cliente cliente = gson.fromJson(dadosJSON, Cliente.class);
	     if(tipo.equals("fisica")) {
	    	 cliente.setPessoa(gson.fromJson(pessoa, PessoaFisica.class));
	     } else if (tipo.equals("juridica")) {
	    	 cliente.setPessoa(gson.fromJson(pessoa, PessoaJuridica.class));
	     }
	     ClienteDAO clienteDAO = new ClienteDAO();
	     Session session = HibernateUtil.abrirSessao();
	     clienteDAO.salvarOuAlterar(cliente, session);
		 session.close();
	     return cliente.getId();
	 }
	 
	 @PUT
	 @Produces(MediaType.APPLICATION_JSON)
	 @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	 public Long alterar(@FormParam("dado") String dadosJSON ) {
		 Gson gson = new Gson();
	     Cliente cliente = gson.fromJson(dadosJSON, Cliente.class);
	     
	     
	     ClienteDAO clienteDAO = new ClienteDAO();
	     Session session = HibernateUtil.abrirSessao();
	     clienteDAO.salvarOuAlterar(cliente, session);
		 session.close();
	     return cliente.getId();
	 }
	 
	@DELETE
    @Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    public Boolean deletar(@FormParam("dado") String dadosJSON){
	     ClienteDAO clienteDAO = new ClienteDAO();
	     
	     Gson gson = new Gson();
	     Cliente cliente = gson.fromJson(dadosJSON, Cliente.class);
	     
	     Session session = HibernateUtil.abrirSessao();
	     clienteDAO.excluir(cliente, session);
		 session.close();
	     return true;
	 }
}
