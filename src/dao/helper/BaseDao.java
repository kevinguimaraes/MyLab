package dao.helper;

import java.io.Serializable;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

public abstract class BaseDao<T, ID> implements Serializable{
	private static final long serialVersionUID = 1L;
	private Transaction transacao;
	
	public void salvarOuAlterar(T entidade, Session session) throws HibernateException {
        transacao = session.beginTransaction();
        session.saveOrUpdate(entidade);
        transacao.commit();
    }
	
	public void excluir(T entidade, Session session) throws HibernateException {
        transacao = session.beginTransaction();
        session.delete(entidade);
        transacao.commit();
    }
    
    public T pesquisarPorId(ID id, Session session) throws HibernateException {
		return null;
	}
    
    public List<T> listarTodos(Session session) throws HibernateException {
		return null;
	}

}
