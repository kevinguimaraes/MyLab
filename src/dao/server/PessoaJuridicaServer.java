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

import dao.PessoaJuridicaDAO;
import dao.helper.HibernateUtil;
import model.PessoaJuridica;

@Path("/pessoajuridica")
public class PessoaJuridicaServer {

	
	@GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<PessoaJuridica> getPessoaJuridica(){
		 PessoaJuridicaDAO pessoaJuridicaDAO = new PessoaJuridicaDAO();
		 Session session = HibernateUtil.abrirSessao();
		 List<PessoaJuridica> tmp  = pessoaJuridicaDAO.listarTodos(session);
		 session.close();
		 for (int i = 0; i < tmp.size(); i++) {
			 System.out.println(tmp.get(i).getCnpj() + tmp.get(i).getNome());
		 }
		 return tmp;
    }
	 
	@GET
    @Produces(MediaType.APPLICATION_JSON)
	@Path("{id}")
    public PessoaJuridica getPessoaJuridica(@PathParam("id") Long id){
		 PessoaJuridicaDAO pessoaJuridicaDAO = new PessoaJuridicaDAO();
		 Session session = HibernateUtil.abrirSessao();
		 PessoaJuridica pessoaJuridica = pessoaJuridicaDAO.pesquisarPorId(id, session);
		 session.close();
		 return pessoaJuridica;
    }
	 
	//@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	 @POST
	 @Produces(MediaType.APPLICATION_JSON)
	 public Long cadastrar(@QueryParam("dado") String dadosJSON ) {
		 Gson gson = new Gson();
	     PessoaJuridica pessoaJuridica = gson.fromJson(dadosJSON, PessoaJuridica.class);
	     PessoaJuridicaDAO pessoaJuridicaDAO = new PessoaJuridicaDAO();
	     Session session = HibernateUtil.abrirSessao();
	     pessoaJuridicaDAO.salvarOuAlterar(pessoaJuridica, session);
		 session.close();
	     return pessoaJuridica.getId();
	 }
	 
	 //@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	 @PUT
	 @Produces(MediaType.APPLICATION_JSON)
	 public Long alterar(@QueryParam("dado") String dadosJSON ) {
		 Gson gson = new Gson();
	     PessoaJuridica pessoaJuridica = gson.fromJson(dadosJSON, PessoaJuridica.class);
	     
	     
	     PessoaJuridicaDAO pessoaJuridicaDAO = new PessoaJuridicaDAO();
	     Session session = HibernateUtil.abrirSessao();
	     pessoaJuridicaDAO.salvarOuAlterar(pessoaJuridica, session);
		 session.close();
	     return pessoaJuridica.getId();
	 }
	 
	@DELETE
    @Produces(MediaType.APPLICATION_JSON)
    public Boolean deletar(@QueryParam("dado") String dadosJSON){
	     PessoaJuridicaDAO pessoaJuridicaDAO = new PessoaJuridicaDAO();
	     
	     Gson gson = new Gson();
	     PessoaJuridica pessoaJuridica = gson.fromJson(dadosJSON, PessoaJuridica.class);
	     
	     Session session = HibernateUtil.abrirSessao();
	     pessoaJuridicaDAO.excluir(pessoaJuridica, session);
		 session.close();
	     return true;
	 }
}
