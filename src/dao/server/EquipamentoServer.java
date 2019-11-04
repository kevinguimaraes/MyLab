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

import dao.EquipamentoDAO;
import dao.helper.HibernateUtil;
import model.Equipamento;

@Path("/equipamento")
public class EquipamentoServer {

	
	@GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Equipamento> getEquipamento(){
		 EquipamentoDAO equipamentoDAO = new EquipamentoDAO();
		 Session session = HibernateUtil.abrirSessao();
		 List<Equipamento> tmp  = equipamentoDAO.listarTodos(session);
		 session.close();
		 return tmp;
    }
	 
	@GET
    @Produces(MediaType.APPLICATION_JSON)
	@Path("{id}")
    public Equipamento getEquipamento(@PathParam("id") Long id){
		 EquipamentoDAO equipamentoDAO = new EquipamentoDAO();
		 Session session = HibernateUtil.abrirSessao();
		 Equipamento equipamento = equipamentoDAO.pesquisarPorId(id, session);
		 session.close();
		 return equipamento;
    }
	 
	//@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	 @POST
	 @Produces(MediaType.APPLICATION_JSON)
	 public Long cadastrar(@QueryParam("dado") String dadosJSON ) {
		 Gson gson = new Gson();
	     Equipamento equipamento = gson.fromJson(dadosJSON, Equipamento.class);
	     EquipamentoDAO equipamentoDAO = new EquipamentoDAO();
	     Session session = HibernateUtil.abrirSessao();
	     equipamentoDAO.salvarOuAlterar(equipamento, session);
		 session.close();
	     return equipamento.getId();
	 }
	 
	 //@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	 @PUT
	 @Produces(MediaType.APPLICATION_JSON)
	 public Long alterar(@QueryParam("dado") String dadosJSON ) {
		 Gson gson = new Gson();
	     Equipamento equipamento = gson.fromJson(dadosJSON, Equipamento.class);
	     
	     
	     EquipamentoDAO equipamentoDAO = new EquipamentoDAO();
	     Session session = HibernateUtil.abrirSessao();
	     equipamentoDAO.salvarOuAlterar(equipamento, session);
		 session.close();
	     return equipamento.getId();
	 }
	 
	@DELETE
    @Produces(MediaType.APPLICATION_JSON)
    public Boolean deletar(@QueryParam("dado") String dadosJSON){
	     EquipamentoDAO equipamentoDAO = new EquipamentoDAO();
	     
	     Gson gson = new Gson();
	     Equipamento equipamento = gson.fromJson(dadosJSON, Equipamento.class);
	     
	     Session session = HibernateUtil.abrirSessao();
	     equipamentoDAO.excluir(equipamento, session);
		 session.close();
	     return true;
	 }
}
