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

import dao.CalibracaoDAO;
import dao.helper.HibernateUtil;
import model.Calibracao;

@Path("/calibracao")
public class CalibracaoServer {

	
	@GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Calibracao> getCalibracao(){
		 CalibracaoDAO calibracaoDAO = new CalibracaoDAO();
		 Session session = HibernateUtil.abrirSessao();
		 List<Calibracao> tmp  = calibracaoDAO.listarTodos(session);
		 session.close();
		 return tmp;
    }
	 
	@GET
    @Produces(MediaType.APPLICATION_JSON)
	@Path("{id}")
    public Calibracao getCalibracao(@PathParam("id") Long id){
		 CalibracaoDAO calibracaoDAO = new CalibracaoDAO();
		 Session session = HibernateUtil.abrirSessao();
		 Calibracao calibracao = calibracaoDAO.pesquisarPorId(id, session);
		 session.close();
		 return calibracao;
    }
	 
	//@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	 @POST
	 @Produces(MediaType.APPLICATION_JSON)
	 public Long cadastrar(@QueryParam("dado") String dadosJSON ) {
		 Gson gson = new Gson();
	     Calibracao calibracao = gson.fromJson(dadosJSON, Calibracao.class);
	     CalibracaoDAO calibracaoDAO = new CalibracaoDAO();
	     Session session = HibernateUtil.abrirSessao();
	     calibracaoDAO.salvarOuAlterar(calibracao, session);
		 session.close();
	     return calibracao.getId();
	 }
	 
	 //@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	 @PUT
	 @Produces(MediaType.APPLICATION_JSON)
	 public Long alterar(@QueryParam("dado") String dadosJSON ) {
		 Gson gson = new Gson();
	     Calibracao calibracao = gson.fromJson(dadosJSON, Calibracao.class);
	     
	     
	     CalibracaoDAO calibracaoDAO = new CalibracaoDAO();
	     Session session = HibernateUtil.abrirSessao();
	     calibracaoDAO.salvarOuAlterar(calibracao, session);
		 session.close();
	     return calibracao.getId();
	 }
	 
	@DELETE
    @Produces(MediaType.APPLICATION_JSON)
    public Boolean deletar(@QueryParam("dado") String dadosJSON){
	     CalibracaoDAO calibracaoDAO = new CalibracaoDAO();
	     
	     Gson gson = new Gson();
	     Calibracao calibracao = gson.fromJson(dadosJSON, Calibracao.class);
	     
	     Session session = HibernateUtil.abrirSessao();
	     calibracaoDAO.excluir(calibracao, session);
		 session.close();
	     return true;
	 }
}
