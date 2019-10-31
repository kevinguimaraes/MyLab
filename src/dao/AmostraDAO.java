package dao;

import java.io.Serializable;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;

import dao.helper.BaseDao;
import model.Amostra;

public class AmostraDAO extends BaseDao<Amostra, Long> implements Serializable {
	@Override
    public Amostra pesquisarPorId(Long id, Session session) throws HibernateException {
        Amostra amostra = (Amostra) session.get(Amostra.class, id);
        return amostra;
    }

	@Override
	public List<Amostra> listarTodos(Session session) throws HibernateException {
		Query consulta = session.createQuery("from Amostra");
        return consulta.list();
	}

}
