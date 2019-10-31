package model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
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
@Table(name = "calibracao")
public class Calibracao  implements Serializable{
	private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    @Column(nullable = false)
    private double valor;
    
    @Column(nullable = false)
    @Temporal(TemporalType.DATE)
    private Date dt_calibracao;
    
    @ManyToOne
    @JoinColumn(name = "idequipamento")
    private Equipamento equipamento;

	public Calibracao(Long id, double valor, Date dt_calibracao, Equipamento equipamento) {
		super();
		this.id = id;
		this.valor = valor;
		this.dt_calibracao = dt_calibracao;
		this.equipamento = equipamento;
	}

	public Calibracao() {
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

	public Date getDt_calibracao() {
		return dt_calibracao;
	}

	public void setDt_calibracao(Date dt_calibracao) {
		this.dt_calibracao = dt_calibracao;
	}
	
	public Equipamento getEquipamento() {
		return equipamento;
	}

	public void setEquipamento(Equipamento equipamento) {
		this.equipamento = equipamento;
	}

	@Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof Calibracao)) {
            return false;
        }
        Calibracao other = (Calibracao) object;
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
