package model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@PrimaryKeyJoinColumn(name = "idpessoa")
@Table(name = "cliente")
public class Cliente extends Pessoa implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private String codigo;

	public Cliente() {
		super();
	}

	public Cliente(String codigo) {
		super();
		this.codigo = codigo;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
}
