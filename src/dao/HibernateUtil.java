/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

import model.Produto;

import org.hibernate.Session;


public class HibernateUtil {

    private static final SessionFactory sessionFactory;
    
    static {
        try {
            Configuration cfg = new Configuration();
            cfg.addAnnotatedClass(Produto.class);
            
            cfg.configure("/dao/hibernate.cfg.xml");
            StandardServiceRegistryBuilder build = new StandardServiceRegistryBuilder().applySettings(cfg.getProperties());
            sessionFactory = cfg.buildSessionFactory(build.build());
        } catch (Throwable ex) {
            System.err.println("Erro ao criar fabrica de conexao." + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }
    
    public static Session abrirSessao() {
        return sessionFactory.openSession();
    }
}

