package br.com.projeto.edward;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Venda {

	private Cliente cliente;
	private LocalDate emissao;

	private List<ItemVenda> itensVendas = new ArrayList<>();

	public Venda(Cliente cliente) {
		this.cliente = cliente;
		this.emissao = LocalDate.now();
	}

	public Cliente getCliente() {
		return cliente;
	}

	public LocalDate getEmissao() {
		return emissao;
	}

	public void addItemVenda(ItemVenda venda) {
		itensVendas.add(venda);
	}

	public void removeaddItemVenda(ItemVenda venda) {
		itensVendas.remove(venda);
	}

	public List<ItemVenda> getItensVendas() {
		return itensVendas;
	}

}
