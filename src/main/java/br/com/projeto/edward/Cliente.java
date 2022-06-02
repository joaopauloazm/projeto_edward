package br.com.projeto.edward;

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

	public String getNome() {
		return nome;
	}

	public String getCnpj() {
		return cnpj;
	}

	public String getEnderceco() {
		return enderceco;
	}

	public String getCep() {
		return cep;
	}

	public String getTelefone() {
		return telefone;
	}

	public String getEmail() {
		return email;
	}

}
