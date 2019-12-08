package dao;

import java.io.Serializable;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;

import dao.helper.BaseDao;
import model.Medicao;
import model.Usuario;

public class UsuarioDAO extends BaseDao<Usuario, Long> implements Serializable {
	@Override
    public Usuario pesquisarPorId(Long id, Session session) throws HibernateException {
        Usuario usuario = (Usuario) session.get(Usuario.class, id);
        return usuario;
    }

	@Override
	public List<Usuario> listarTodos(Session session) throws HibernateException {
		Query consulta = session.createQuery("from Usuario");
        return consulta.list();
	}
	
	public Usuario listarPorNomeUsuario(Session session, String login) throws HibernateException{
		Query consulta = session.createQuery("from Usuario where login = :login");
		consulta.setParameter("login", login);
		return (Usuario) consulta.getSingleResult();
	}

}