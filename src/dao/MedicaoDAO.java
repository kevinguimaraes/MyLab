package dao;

import java.io.Serializable;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;

import dao.helper.BaseDao;
import model.Medicao;

public class MedicaoDAO extends BaseDao<Medicao, Long> implements Serializable {
	@Override
    public Medicao pesquisarPorId(Long id, Session session) throws HibernateException {
        Medicao medicao = (Medicao) session.get(Medicao.class, id);
        return medicao;
    }

	@Override
	public List<Medicao> listarTodos(Session session) throws HibernateException {
		Query consulta = session.createQuery("from Medicao");
        return consulta.list();
	}

}