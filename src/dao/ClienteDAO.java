package dao;

import java.io.Serializable;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;

import dao.helper.BaseDao;
import model.Cliente;

public class ClienteDAO extends BaseDao<Cliente, Long> implements Serializable {
	@Override
    public Cliente pesquisarPorId(Long id, Session session) throws HibernateException {
        Cliente cliente = (Cliente) session.get(Cliente.class, id);
        return cliente;
    }

	@Override
	public List<Cliente> listarTodos(Session session) throws HibernateException {
		Query consulta = session.createQuery("from Cliente");
        return consulta.list();
	}

}