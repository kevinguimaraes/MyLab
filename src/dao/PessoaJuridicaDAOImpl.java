package dao;

import java.io.Serializable;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;

import model.PessoaJuridica;

public class PessoaJuridicaDAOImpl extends BaseDaoImpl<PessoaJuridica, Long> implements PessoaJuridicaDAO, Serializable{

    @Override
    public PessoaJuridica pesquisarPorId(Long id, Session session) throws HibernateException {
        return (PessoaJuridica) session.get(PessoaJuridica.class, id);
    }

	@Override
	public List<PessoaJuridica> listarTodos(Session session) throws HibernateException {
		Query consulta = session.createQuery("from PessoaFisica");
        return consulta.list();
	}
    
}
