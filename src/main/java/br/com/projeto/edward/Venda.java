package br.com.projeto.edward;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Venda {

	private Cliente cliente;
	private LocalDate emissao;
	
	List<ItemVenda> vendas = new ArrayList<>();

	public Venda(Cliente cliente, LocalDate emissao, List<ItemVenda> lista) {
		this.cliente = cliente;
		this.emissao = emissao;
		this.vendas = lista;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public LocalDate getEmissao() {
		return emissao;
	}
	
	public void addVenda(ItemVenda venda) {
		vendas.add(venda);
	}

	public void removeVenda(ItemVenda venda) {
		vendas.remove(venda);
	}
	

}
