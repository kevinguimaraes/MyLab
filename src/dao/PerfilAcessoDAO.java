package dao;

import java.io.Serializable;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;

import dao.helper.BaseDao;
import model.PerfilAcesso;

public class PerfilAcessoDAO extends BaseDao<PerfilAcesso, Long> implements Serializable {
	@Override
    public PerfilAcesso pesquisarPorId(Long id, Session session) throws HibernateException {
        PerfilAcesso perfilacesso = (PerfilAcesso) session.get(PerfilAcesso.class, id);
        return perfilacesso;
    }

	@Override
	public List<PerfilAcesso> listarTodos(Session session) throws HibernateException {
		Query consulta = session.createQuery("from PerfilAcesso");
        return consulta.list();
	}

}