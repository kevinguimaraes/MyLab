package dao;

import java.io.Serializable;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;

import dao.helper.BaseDao;
import model.Calibracao;

public class CalibracaoDAO extends BaseDao<Calibracao, Long> implements Serializable {
	@Override
    public Calibracao pesquisarPorId(Long id, Session session) throws HibernateException {
        Calibracao calibracao = (Calibracao) session.get(Calibracao.class, id);
        return calibracao;
    }

	@Override
	public List<Calibracao> listarTodos(Session session) throws HibernateException {
		Query consulta = session.createQuery("from Calibracao");
        return consulta.list();
	}

}
