package dao;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;

import dao.helper.BaseDao;
import model.Medicao;

public class MedicaoDAO extends BaseDao<Medicao, Long> implements Serializable {
	@Override
    public Medicao pesquisarPorId(Long id, Session session) throws HibernateException {
        Medicao medicao = (Medicao) session.get(Medicao.class, id);
        return medicao;
    }

	@Override
	public List<Medicao> listarTodos(Session session) throws HibernateException {
		Query consulta = session.createQuery("from Medicao");
        return consulta.list();
	}
	
	public List<Medicao> listarPorAmostra(Session session, Long idamostra) throws HibernateException{
		Query consulta = session.createQuery("from Medicao where idamostra = :idamostra");
		consulta.setParameter("idamostra", idamostra);
		return consulta.list();
	}
	
	public List<Medicao> listarPorEquipamento(Session session, Long idequipamento) throws HibernateException{
		Query consulta = session.createQuery("from Medicao where idequipamento = :idequipamento");
		consulta.setParameter("idequipamento", idequipamento);
		return consulta.list();
	}
	
	public List<Medicao> listarPorCliente(Session session, Long idcliente) throws HibernateException{
		Query consulta = session.createQuery("select m from Medicao m join m.amostra a where a.cliente.id = :idcliente");
		consulta.setParameter("idcliente", idcliente);
		return consulta.list();
	}
	
	public List<Integer> listarWeekMedicoes(Session session) throws HibernateException{
		
		SQLQuery query = session.createSQLQuery("select * from vw_weekMed");
		List<Object[]> rows = query.list();
		List<Integer> tmp = new ArrayList<Integer>();
		for(Object[] row : rows) {
			tmp.add(Integer.parseInt(row[0].toString()));
			tmp.add(Integer.parseInt(row[1].toString()));
			tmp.add(Integer.parseInt(row[2].toString()));
			tmp.add(Integer.parseInt(row[3].toString()));
			tmp.add(Integer.parseInt(row[4].toString()));
			tmp.add(Integer.parseInt(row[5].toString()));
			tmp.add(Integer.parseInt(row[6].toString()));
		}
		return tmp;
	}
	
public List<Integer> listarMonthPerWeekMedicoes(Session session) throws HibernateException{
		
		SQLQuery query = session.createSQLQuery("select * from vw_monthMedicoes");
		List<Object[]> rows = query.list();
		List<Integer> tmp = new ArrayList<Integer>();
		for(Object[] row : rows) {
			tmp.add(Integer.parseInt(row[0].toString()));
			tmp.add(Integer.parseInt(row[1].toString()));
			tmp.add(Integer.parseInt(row[2].toString()));
			tmp.add(Integer.parseInt(row[3].toString()));
		}
		return tmp;
	}

}