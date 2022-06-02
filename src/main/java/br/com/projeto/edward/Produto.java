package br.com.projeto.edward;

import java.math.BigDecimal;
import java.time.LocalDate;

public class Produto {

	private String nome;
	private Integer estoque;
	private BigDecimal preco;

	public Produto(String nome, Integer estoque, BigDecimal preco) {
		this.nome = nome;
		this.estoque = estoque;
		this.preco = preco;

	}

	public String getNome() {
		return nome;
	}

	public Integer getEstoque() {
		return estoque;
	}

	public BigDecimal getPreco() {
		return preco;
	}

	public void diminuiEstoque(int quantidade) {
		this.estoque = this.estoque - quantidade;
	}

}
