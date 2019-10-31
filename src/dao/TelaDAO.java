package dao;

import java.io.Serializable;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;

import dao.helper.BaseDao;
import model.Tela;

public class TelaDAO extends BaseDao<Tela, Long> implements Serializable {
	@Override
    public Tela pesquisarPorId(Long id, Session session) throws HibernateException {
        Tela tela = (Tela) session.get(Tela.class, id);
        return tela;
    }

	@Override
	public List<Tela> listarTodos(Session session) throws HibernateException {
		Query consulta = session.createQuery("from Tela");
        return consulta.list();
	}

}