package dao;

import java.io.Serializable;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;

import dao.helper.BaseDao;
import model.Cidade;

public class CidadeDAO extends BaseDao<Cidade, Long> implements Serializable {
	@Override
    public Cidade pesquisarPorId(Long id, Session session) throws HibernateException {
        Cidade cidade = (Cidade) session.get(Cidade.class, id);
        return cidade;
    }

	@Override
	public List<Cidade> listarTodos(Session session) throws HibernateException {
		Query consulta = session.createQuery("from Cidade");
        return consulta.list();
	}

}