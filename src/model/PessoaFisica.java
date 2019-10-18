package model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@PrimaryKeyJoinColumn(name = "idpessoa")
@Table(name = "pessoafisica")
public class PessoaFisica extends Pessoa implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private String cpf;
	
	private String genero;

	public PessoaFisica() {
	}

	public PessoaFisica(String cpf, String genero) {
		super();
		this.cpf = cpf;
		this.genero = genero;
	}
	
	public PessoaFisica(Long id, String nome, Date dt_nascimento, String telefone, String email, String cpf, String genero) {
		super(id, nome, dt_nascimento, telefone, email);
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

}
