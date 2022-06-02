package br.com.projeto.edward;

import java.math.BigDecimal;
import java.time.LocalDate;

public class Produto {

	private String nome;
	private Integer estoque;
	private BigDecimal preco;
	private LocalDate validade;

	public Produto(String nome, Integer estoque, BigDecimal preco, LocalDate validade) {
		this.nome = nome;
		this.estoque = estoque;
		this.preco = preco;
		this.validade = validade;

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

	public LocalDate getValidade() {
		return validade;
	}

	public void diminuiEstoque(int valor) {
		this.estoque = this.estoque - valor;
	}

}
