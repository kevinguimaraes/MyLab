package model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "medicao")
public class Medicao implements Serializable{
	private static final long serialVersionUID = 1L;
    
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    private double valor;
    
    private String unidade;
    
    @Temporal(TemporalType.DATE)
    private Date dt_medicao;
    
    @ManyToOne
    @JoinColumn(name = "idequipamento")
    private Equipamento equipamento;
    
    @ManyToOne
    @JoinColumn(name = "idamostra")
    private Amostra amostra;

	public Medicao(Long id, double valor, String unidade, Date dt_medicao, Equipamento equipamento, Amostra amostra) {
		super();
		this.id = id;
		this.valor = valor;
		this.unidade = unidade;
		this.dt_medicao = dt_medicao;
		this.equipamento = equipamento;
		this.amostra = amostra;
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
		return dt_medicao;
	}

	public void setDt_Medicao(Date dt_medicao) {
		this.dt_medicao = dt_medicao;
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
