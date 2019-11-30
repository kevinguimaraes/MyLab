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
	 
	 @POST
	 @Produces(MediaType.APPLICATION_JSON)
	 @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	 public Long cadastrar(@FormParam("dado") String dadosJSON ) {
		 Gson gson = new Gson();
	     Equipamento equipamento = gson.fromJson(dadosJSON, Equipamento.class);
	     EquipamentoDAO equipamentoDAO = new EquipamentoDAO();
	     Session session = HibernateUtil.abrirSessao();
	     equipamentoDAO.salvarOuAlterar(equipamento, session);
		 session.close();
	     return equipamento.getId();
	 }
	 
	 @PUT
	 @Produces(MediaType.APPLICATION_JSON)
	 @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	 public Long alterar(@FormParam("dado") String dadosJSON ) {
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
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    public Boolean deletar(@FormParam("dado") String dadosJSON){
	     EquipamentoDAO equipamentoDAO = new EquipamentoDAO();
	     
	     Gson gson = new Gson();
	     Equipamento equipamento = gson.fromJson(dadosJSON, Equipamento.class);
	     
	     Session session = HibernateUtil.abrirSessao();
	     equipamentoDAO.excluir(equipamento, session);
		 session.close();
	     return true;
	 }
}
