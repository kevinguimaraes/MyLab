package model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;

@Entity
@Table(name = "produto")
public class Produto implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    @Column(nullable = false, length = 100)
    private String nome;
    
    @Lob
    private String descricao;

    private double precoCompra;

    private double precoVenda;
    
    @Column(nullable = false)
    private int estoque;
    
    public Produto() {
    }

    public Produto(Long id, String nome, String descricao, double precoCompra, double precoVenda, int estoque) {
        this.id = id;
        this.nome = nome;
        this.descricao = descricao;
        this.precoCompra = precoCompra;
        this.precoVenda = precoVenda;
        this.estoque = estoque;
    }

    public Long getId() {
        return id;
    }
    
    public void setId(Long id) {
        this.id = id;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public String getNome() {
        return nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public double getPrecoCompra() {
        return precoCompra;
    }

    public double getPrecoVenda() {
        return precoVenda;
    }

    public int getEstoque() {
        return estoque;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public void setPrecoCompra(double precoCompra) {
        this.precoCompra = precoCompra;
    }

    public void setPrecoVenda(double precoVenda) {
        this.precoVenda = precoVenda;
    }

    public void setEstoque(int estoque) {
        this.estoque = estoque;
    }
    
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Produto)) {
            return false;
        }
        Produto other = (Produto) object;
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
