package br.com.projeto.edward;

import lombok.Getter;

@Getter
public class ItemVenda {

	
	public Integer getQuantidade() {
		return quantidade;
	}

	private Produto produto;
	private Integer quantidade;

	public ItemVenda(Produto produto) {
		this.produto = produto;
	}

	public Produto getProduto() {
		return produto;
	}
	
}
