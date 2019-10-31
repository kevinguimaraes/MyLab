package dao;

import java.io.Serializable;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;

import dao.helper.BaseDao;
import model.Equipamento;

public class EquipamentoDAO extends BaseDao<Equipamento, Long> implements Serializable {
	@Override
    public Equipamento pesquisarPorId(Long id, Session session) throws HibernateException {
        Equipamento equipamento = (Equipamento) session.get(Equipamento.class, id);
        return equipamento;
    }

	@Override
	public List<Equipamento> listarTodos(Session session) throws HibernateException {
		Query consulta = session.createQuery("from Equipamento");
        return consulta.list();
	}

}