/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.io.Serializable;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;

import model.Produto;

/**
 *
 * @author Aluno
 */
public class ProdutoDAOImpl extends BaseDaoImpl<Produto, Long> implements ProdutoDAO, Serializable{

    @Override
    public Produto pesquisarPorId(Long id, Session session) throws HibernateException {
        Produto produto = (Produto) session.get(Produto.class, id);
        return produto;
    }

	@Override
	public List<Produto> listarTodos(Session session) throws HibernateException {
		Query consulta = session.createQuery("from Produto");
        return consulta.list();
	}
    
    
}
