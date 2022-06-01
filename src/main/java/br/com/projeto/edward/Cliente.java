package br.com.projeto.edward;

import lombok.Getter;

@Getter
public class Cliente {

	private String nome;
	private String cnpj;
	private String enderceco;
	private String cep;
	private String telefone; // Regex
	private String email;

	public Cliente(String nome, String cnpj, String enderceco, String cep, String telefone, String email) {
		this.nome = nome;
		this.cnpj = cnpj;
		this.enderceco = enderceco;
		this.cep = cep;
		this.telefone = telefone;
		this.email = email;
	}

	public void adiconaListaCliente(Cliente cliente) {
		adiconaListaCliente(cliente);
	}

}
