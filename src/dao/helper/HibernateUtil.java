/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.helper;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

import model.Amostra;
import model.Calibracao;
import model.Cidade;
import model.Cliente;
import model.Endereco;
import model.Equipamento;
import model.Estado;
import model.Medicao;
import model.Pais;
import model.Perfil;
import model.PerfilAcesso;
import model.Pessoa;
import model.PessoaJuridica;
import model.Tela;
import model.Usuario;
import model.PessoaFisica;

import org.hibernate.Session;


public class HibernateUtil {

    private static final SessionFactory sessionFactory;
    
    static {
        try {
            Configuration cfg = new Configuration();
            cfg.addAnnotatedClass(Pais.class);
            cfg.addAnnotatedClass(Estado.class);
            cfg.addAnnotatedClass(Cidade.class);
            cfg.addAnnotatedClass(Endereco.class);
            cfg.addAnnotatedClass(Pessoa.class);
            cfg.addAnnotatedClass(PessoaFisica.class);
            cfg.addAnnotatedClass(PessoaJuridica.class);
            cfg.addAnnotatedClass(Cliente.class);
            cfg.addAnnotatedClass(Usuario.class);
            cfg.addAnnotatedClass(Tela.class);
            cfg.addAnnotatedClass(Perfil.class);
            cfg.addAnnotatedClass(PerfilAcesso.class);
            cfg.addAnnotatedClass(Equipamento.class);
            cfg.addAnnotatedClass(Calibracao.class);
            cfg.addAnnotatedClass(Amostra.class);
            cfg.addAnnotatedClass(Medicao.class);
            
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

