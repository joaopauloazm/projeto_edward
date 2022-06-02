package br.com.projeto.edward;

import lombok.Getter;

public class ItemVenda {

	private Produto produto;
	private Integer quantidade;
	
	public ItemVenda(Produto produto, Integer quantidade) {
		this.produto = produto;
		this.quantidade = quantidade;
	}

	public Produto getProduto() {
		return produto;
	}

	public Integer getQuantidade() {
		return quantidade;
	}

}
