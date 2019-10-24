/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.helper;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

import model.Endereco;
import model.Pessoa;
import model.PessoaJuridica;
import model.PessoaFisica;

import org.hibernate.Session;


public class HibernateUtil {

    private static final SessionFactory sessionFactory;
    
    static {
        try {
            Configuration cfg = new Configuration();
            cfg.addAnnotatedClass(Endereco.class);
            cfg.addAnnotatedClass(Pessoa.class);
            cfg.addAnnotatedClass(PessoaFisica.class);
            cfg.addAnnotatedClass(PessoaJuridica.class);
            
            cfg.configure("/dao/helper/hibernate.cfg.xml");
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
