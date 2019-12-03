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
	
	@GET
    @Produces(MediaType.APPLICATION_JSON)
	@Path("/amostra/{id}")
    public List<Medicao> getMedicaoPorAmostra(@PathParam("id") Long id){
		 MedicaoDAO medicaoDAO = new MedicaoDAO();
		 Session session = HibernateUtil.abrirSessao();
		 List<Medicao> tmp = medicaoDAO.listarPorAmostra(session, id);
		 session.close();
		 return tmp;
    }
	
	@GET
    @Produces(MediaType.APPLICATION_JSON)
	@Path("/equipamento/{id}")
    public List<Medicao> getMedicaoPorEquipamento(@PathParam("id") Long id){
		 MedicaoDAO medicaoDAO = new MedicaoDAO();
		 Session session = HibernateUtil.abrirSessao();
		 List<Medicao> tmp = medicaoDAO.listarPorEquipamento(session, id);
		 session.close();
		 return tmp;
    }
	
	@GET
    @Produces(MediaType.APPLICATION_JSON)
	@Path("/week")
    public List<Integer> getMedicaoWeek(){
		 MedicaoDAO medicaoDAO = new MedicaoDAO();
		 Session session = HibernateUtil.abrirSessao();
		 List<Integer> tmp = medicaoDAO.listarWeekMedicoes(session);
		 session.close();
		 return tmp;
    }
	
	@GET
    @Produces(MediaType.APPLICATION_JSON)
	@Path("/month")
    public List<Integer> getMedicaoMonth(){
		 MedicaoDAO medicaoDAO = new MedicaoDAO();
		 Session session = HibernateUtil.abrirSessao();
		 List<Integer> tmp = medicaoDAO.listarMonthPerWeekMedicoes(session);
		 session.close();
		 return tmp;
    }
	
	@GET
    @Produces(MediaType.APPLICATION_JSON)
	@Path("/cliente/{id}")
    public List<Medicao> getMedicaoPorCliente(@PathParam("id") Long id){
		 MedicaoDAO medicaoDAO = new MedicaoDAO();
		 Session session = HibernateUtil.abrirSessao();
		 List<Medicao> tmp = medicaoDAO.listarPorCliente(session, id);
		 session.close();
		 return tmp;
    }
	 
	 @POST
	 @Produces(MediaType.APPLICATION_JSON)
	 @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	 public Long cadastrar(@FormParam("dado") String dadosJSON ) {
		 Gson gson = new Gson();
		 System.out.println(dadosJSON);
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
	 public Long alterar(@FormParam("dado") String dadosJSON ) {
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
    public Boolean deletar(@FormParam("dado") String dadosJSON){
	     MedicaoDAO medicaoDAO = new MedicaoDAO();
	     
	     Gson gson = new Gson();
	     Medicao medicao = gson.fromJson(dadosJSON, Medicao.class);
	     
	     Session session = HibernateUtil.abrirSessao();
	     medicaoDAO.excluir(medicao, session);
		 session.close();
	     return true;
	 }
}
