package br.com.projeto.edward;

import java.math.BigDecimal;

import lombok.Getter;

@Getter
public class Produto {

	private String nome;
	private BigDecimal preco;
	private Integer quantidade;

	public Produto(String nome, BigDecimal preco, Integer quantidade) {
		this.nome = nome;
		this.preco = preco;
		this.quantidade = quantidade;
	}

	//Criar uma lista de produtos

}
