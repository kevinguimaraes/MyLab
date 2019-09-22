/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;


public interface BaseDao<T, ID> {
    
    void salvarOuAlterar(T entidade, Session session) throws HibernateException;
    
    void excluir(T entidade, Session session) throws HibernateException;
    
    T pesquisarPorId(ID id, Session session) throws HibernateException;
    
    List<T> listarTodos(Session session) throws HibernateException;
}
