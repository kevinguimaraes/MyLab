package model;

import java.io.Serializable;
import java.util.Date;

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
	}

	public PessoaJuridica(String cnpj, String fantasia) {
		this.cnpj = cnpj;
		this.fantasia = fantasia;
	}
	

	public PessoaJuridica(Long id, String nome, Date dt_nascimento, String telefone, String email, String cnpj, String fantasia) {
		super(id, nome, dt_nascimento, telefone, email);
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
}
