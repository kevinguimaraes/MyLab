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

import model.Pessoa;

/**
 *
 * @author Aluno
 */
public class PessoaDAOImpl extends BaseDaoImpl<Pessoa, Long> implements PessoaDAO, Serializable{

    @Override
    public Pessoa pesquisarPorId(Long id, Session session) throws HibernateException {
        Pessoa pessoa = (Pessoa) session.get(Pessoa.class, id);
        return pessoa;
    }

	@Override
	public List<Pessoa> listarTodos(Session session) throws HibernateException {
		Query consulta = session.createQuery("from Pessoa");
        return consulta.list();
	}
    
    
}
