package dao;

import java.io.Serializable;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;

import dao.helper.BaseDao;
import model.Estado;

public class EstadoDAO extends BaseDao<Estado, Long> implements Serializable {
	@Override
    public Estado pesquisarPorId(Long id, Session session) throws HibernateException {
        Estado estado = (Estado) session.get(Estado.class, id);
        return estado;
    }

	@Override
	public List<Estado> listarTodos(Session session) throws HibernateException {
		Query consulta = session.createQuery("from Estado");
        return consulta.list();
	}

}