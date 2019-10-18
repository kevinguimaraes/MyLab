package model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@PrimaryKeyJoinColumn(name="idpessoa")
@Table(name = "pessoafisica")
public class PessoaFisica extends Pessoa implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private String cpf;
	
	private String genero;

	public PessoaFisica() {
		super();
	}

	public PessoaFisica(Long id, String cpf, String genero) {
		super();
		this.cpf = cpf;
		this.genero = genero;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getGenero() {
		return genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	@Override
    public int hashCode() {
        int hash = 0;
        hash += (this.getId() != null ? this.getId().hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Pessoa)) {
            return false;
        }
        PessoaFisica other = (PessoaFisica) object;
        if ((this.getId() == null && other.getId() != null) || (this.getId() != null && !this.getId().equals(other.getId()))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.hibernate.entidade.Pessoa[ id=" + this.getId() + " ]";
    }
	
	
	

}
