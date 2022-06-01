package br.com.projeto.edward;

import java.util.List;

import lombok.Getter;

@Getter
public class BD {

	private static final List<Cliente> clientes = List.of();

	public void addCliente(Cliente cliente) {
		clientes.add(cliente);
	}

	public void removeCliente(Cliente cliente) {
		clientes.remove(cliente);
	}

	public static List<Cliente> getClientes() {
		return clientes;
	}
	
	

}
