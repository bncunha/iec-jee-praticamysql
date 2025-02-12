package model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "produtos")
public class Produto {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;

	@Column(length = 100)
	private String nome;

	@Column()
	private Float preco;

	@ManyToOne(fetch=FetchType.EAGER)
  @JoinColumn(name="idCategoria")
	private Categoria categoria;

	public int getId() {
		return this.id;
	}

	public Float getPreco() {
		return this.preco;
	}

	public Categoria getCategoria() {
		return this.categoria;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setPreco(Float preco) {
		this.preco = preco;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

	public String getNome() {
		return this.nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	

}
