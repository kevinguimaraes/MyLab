package model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "equipamento")
public class Equipamento implements Serializable{
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    @Column(nullable = false)
    private String nome;
    
    @Column(nullable = false)
    private String serial;
    
    @Column(nullable = false)
    private String hw_version;
    
    @Column(nullable = false)
    private String fw_version;

	public Equipamento(Long id, String nome, String serial, String hw_version, String fw_version) {
		super();
		this.id = id;
		this.nome = nome;
		this.serial = serial;
		this.hw_version = hw_version;
		this.fw_version = fw_version;
	}

	public Equipamento() {
		super();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getSerial() {
		return serial;
	}

	public void setSerial(String serial) {
		this.serial = serial;
	}

	public String getHw_version() {
		return hw_version;
	}

	public void setHw_version(String hw_version) {
		this.hw_version = hw_version;
	}

	public String getFw_version() {
		return fw_version;
	}

	public void setFw_version(String fw_version) {
		this.fw_version = fw_version;
	}

	@Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof Equipamento)) {
            return false;
        }
        Equipamento other = (Equipamento) object;
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
