package model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Medicao")
public class Medicao implements Serializable{
	private static final long serialVersionUID = 1L;
    
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    private double valor;
    
    private String unidade;
    
    private Date dt_Medicao;

	public Medicao(Long id, double valor, String unidade, Date dt_Medicao) {
		super();
		this.id = id;
		this.valor = valor;
		this.unidade = unidade;
		this.dt_Medicao = dt_Medicao;
	}

	public Medicao() {
		super();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public double getValor() {
		return valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}

	public String getUnidade() {
		return unidade;
	}

	public void setUnidade(String unidade) {
		this.unidade = unidade;
	}

	public Date getDt_Medicao() {
		return dt_Medicao;
	}

	public void setDt_Medicao(Date dt_Medicao) {
		this.dt_Medicao = dt_Medicao;
	}
    
	@Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof Medicao)) {
            return false;
        }
        Medicao other = (Medicao) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.hibernate.entidade.Produto[ id=" + id + " ]";
    }

}
