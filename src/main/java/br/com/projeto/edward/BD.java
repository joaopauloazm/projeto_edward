package br.com.projeto.edward;

import java.util.ArrayList;
import java.util.List;

import lombok.Getter;

public class BD {

	private static final List<Cliente> clientes = new ArrayList<>();
	private static final List<Produto> produtos = new ArrayList<>();
	private static final List<Venda> vendas = new ArrayList<>();

	public void addCliente(Cliente cliente) {
		clientes.add(cliente);
	}

	public void removeCliente(Cliente cliente) {
		clientes.remove(cliente);
	}

	public static List<Cliente> getClientes() {
		return clientes;
	}

	public void addProduto(Produto produto) {
		produtos.add(produto);
	}

	public void removeProduto(Produto produto) {
		produtos.remove(produto);
	}

	public static List<Produto> getProdutos() {
		return produtos;
	}

	public void addVenda(Venda venda) {
		vendas.add(venda);
	}

	public void removeVenda(Venda venda) {
		vendas.remove(venda);
	}

	public void removeaddItemVenda(Venda venda) {
		vendas.remove(venda);
	}

	public static List<Venda> getVendas() {
		return vendas;
	}

}
