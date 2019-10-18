package model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@PrimaryKeyJoinColumn(name="idpessoa")
@Table(name = "pessoajuridica")
public class PessoaJuridica extends Pessoa implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private String cnpj;
	
	private String fantasia;

	public PessoaJuridica() {
		super();
	}

	public PessoaJuridica(Long id, String cnpj, String fantasia) {
		super();
		this.cnpj = cnpj;
		this.fantasia = fantasia;
	}

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	public String getFantasia() {
		return fantasia;
	}

	public void setFantasia(String fantasia) {
		this.fantasia = fantasia;
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
