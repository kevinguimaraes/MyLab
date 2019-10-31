package dao;

import java.io.Serializable;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;

import dao.helper.BaseDao;
import model.Pais;
import model.Pais;

public class PaisDAO extends BaseDao<Pais, Long> implements Serializable {
	@Override
    public Pais pesquisarPorId(Long id, Session session) throws HibernateException {
        Pais pais = (Pais) session.get(Pais.class, id);
        return pais;
    }

	@Override
	public List<Pais> listarTodos(Session session) throws HibernateException {
		Query consulta = session.createQuery("from Pais");
        return consulta.list();
	}

}
