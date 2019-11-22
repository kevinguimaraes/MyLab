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
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import org.hibernate.Session;

import com.google.gson.Gson;

import dao.MedicaoDAO;
import dao.helper.HibernateUtil;
import model.Medicao;

@Path("/medicao")
public class MedicaoServer {

	
	@GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Medicao> getMedicao(){
		 MedicaoDAO medicaoDAO = new MedicaoDAO();
		 Session session = HibernateUtil.abrirSessao();
		 List<Medicao> tmp  = medicaoDAO.listarTodos(session);
		 session.close();
		 return tmp;
    }
	 
	@GET
    @Produces(MediaType.APPLICATION_JSON)
	@Path("{id}")
    public Medicao getMedicao(@PathParam("id") Long id){
		 MedicaoDAO medicaoDAO = new MedicaoDAO();
		 Session session = HibernateUtil.abrirSessao();
		 Medicao medicao = medicaoDAO.pesquisarPorId(id, session);
		 session.close();
		 return medicao;
    }
	 
	 @POST
	 @Produces(MediaType.APPLICATION_JSON)
	 @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	 public Long cadastrar(@QueryParam("dado") String dadosJSON ) {
		 Gson gson = new Gson();
	     Medicao medicao = gson.fromJson(dadosJSON, Medicao.class);
	     MedicaoDAO medicaoDAO = new MedicaoDAO();
	     Session session = HibernateUtil.abrirSessao();
	     medicaoDAO.salvarOuAlterar(medicao, session);
		 session.close();
	     return medicao.getId();
	 }
	 
	 @PUT
	 @Produces(MediaType.APPLICATION_JSON)
	 @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	 public Long alterar(@QueryParam("dado") String dadosJSON ) {
		 Gson gson = new Gson();
	     Medicao medicao = gson.fromJson(dadosJSON, Medicao.class);
	     
	     
	     MedicaoDAO medicaoDAO = new MedicaoDAO();
	     Session session = HibernateUtil.abrirSessao();
	     medicaoDAO.salvarOuAlterar(medicao, session);
		 session.close();
	     return medicao.getId();
	 }
	 
	@DELETE
    @Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    public Boolean deletar(@QueryParam("dado") String dadosJSON){
	     MedicaoDAO medicaoDAO = new MedicaoDAO();
	     
	     Gson gson = new Gson();
	     Medicao medicao = gson.fromJson(dadosJSON, Medicao.class);
	     
	     Session session = HibernateUtil.abrirSessao();
	     medicaoDAO.excluir(medicao, session);
		 session.close();
	     return true;
	 }
}
