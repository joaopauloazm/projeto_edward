package br.com.projeto.edward;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import lombok.Getter;

@Getter
public class Venda {

	private Cliente cliente;
	private LocalDate emissao;

	List<ItemVenda> listaItensVenda = new ArrayList<>();

	public Venda(Cliente cliente, LocalDate emissao, List<ItemVenda> listaItensVenda) {
		this.cliente = cliente;
		this.emissao = emissao;
		this.listaItensVenda = listaItensVenda;
	}

}
