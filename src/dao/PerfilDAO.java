package dao;

import java.io.Serializable;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;

import dao.helper.BaseDao;
import model.Perfil;

public class PerfilDAO extends BaseDao<Perfil, Long> implements Serializable {
	@Override
    public Perfil pesquisarPorId(Long id, Session session) throws HibernateException {
        Perfil perfil = (Perfil) session.get(Perfil.class, id);
        return perfil;
    }

	@Override
	public List<Perfil> listarTodos(Session session) throws HibernateException {
		Query consulta = session.createQuery("from Perfil");
        return consulta.list();
	}

}