package dao;

import java.io.Serializable;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;

import dao.helper.BaseDao;
import model.PessoaJuridica;

public class PessoaJuridicaDAO extends BaseDao<PessoaJuridica, Long> implements Serializable{

    @Override
    public PessoaJuridica pesquisarPorId(Long id, Session session) throws HibernateException {
        return (PessoaJuridica) session.get(PessoaJuridica.class, id);
    }

	@Override
	public List<PessoaJuridica> listarTodos(Session session) throws HibernateException {
		Query consulta = session.createQuery("from PessoaJuridica");
        return consulta.list();
	}
    
}
