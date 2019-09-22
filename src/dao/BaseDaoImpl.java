/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.io.Serializable;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

public abstract class BaseDaoImpl<T, ID> implements BaseDao<T, ID>, Serializable{

    private Transaction transacao;
    
    @Override
    public void salvarOuAlterar(T entidade, Session session) throws HibernateException {
        transacao = session.beginTransaction();
        session.saveOrUpdate(entidade);
        transacao.commit();
    }

    @Override
    public void excluir(T entidade, Session session) throws HibernateException {
        transacao = session.beginTransaction();
        session.delete(entidade);
        transacao.commit();
    }
}
