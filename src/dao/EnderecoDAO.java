package dao;

import java.io.Serializable;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;

import dao.helper.BaseDao;
import model.Endereco;

public class EnderecoDAO extends BaseDao<Endereco, Long> implements Serializable {
	@Override
    public Endereco pesquisarPorId(Long id, Session session) throws HibernateException {
        Endereco endereco = (Endereco) session.get(Endereco.class, id);
        return endereco;
    }

	@Override
	public List<Endereco> listarTodos(Session session) throws HibernateException {
		Query consulta = session.createQuery("from Endereco");
        return consulta.list();
	}

}
