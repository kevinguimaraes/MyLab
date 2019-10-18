package dao;

import java.io.Serializable;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;

import model.PessoaFisica;

public class PessoaFisicaDAOImpl extends BaseDaoImpl<PessoaFisica, Long> implements PessoaFisicaDAO, Serializable{

    @Override
    public PessoaFisica pesquisarPorId(Long id, Session session) throws HibernateException {
        return (PessoaFisica) session.get(PessoaFisica.class, id);
    }

	@Override
	public List<PessoaFisica> listarTodos(Session session) throws HibernateException {
		Query consulta = session.createQuery("from PessoaFisica");
        return consulta.list();
	}
    
}
