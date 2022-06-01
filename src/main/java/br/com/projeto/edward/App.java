package br.com.projeto.edward;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.Scanner;

public class App {

	static Scanner sc;

	public static void main(String[] args) {

		sc = new Scanner(System.in);

		boolean condicao = true;

		do {
			// trycatch
			System.out.println("MENU PRINCIPAL");
			System.out.println("1 - CADASTRAR/EXCLUIR CLIENTES");
			System.out.println("2 - CADASTRAR/EXCLUIR VENDAS");
			System.out.println("3 - CONTROLE DE ESTOQUES");
			System.out.println("4 - EMITIR NOTA FISCAL");
			System.out.println("0 - SAIR");
			System.out.print("DIGITE A OPÇÃO DESEJADA: ");
			int opcao = sc.nextInt();
			System.out.println();

			if (opcao == 1) {
				cadastrarClientes();
			} else if (opcao == 2) {
				
			} else if (opcao == 3) {
			} else if (opcao == 4) {
			} else if (opcao == 0) {
			} else {
			}

		} while (condicao == true);

		sc.close();
	}

	private static void cadastrarClientes() {
		// trycatch
		BD bd = new BD();
		sc = new Scanner(System.in);

		System.out.println("CLIENTES");
		System.out.println("1 - CADASTRAR CLIENTES");
		System.out.println("2 - EXCLUIR CLIENTES");
		System.out.println("0 - SAIR");
		System.out.print("DIGITE A OPÇÃO DESEJADA: ");
		int opcao = sc.nextInt();
		System.out.println();

		if (opcao == 1) {

			System.out.println();
			System.out.print("Nome: ");
			String nome = sc.nextLine();
			System.out.print("CNPJ: ");
			String cnpj = sc.nextLine();
			System.out.print("Endereco: "); // Regex
			String endereco = sc.nextLine();
			System.out.print("CEP: "); // Regex
			String cep = sc.nextLine();
			System.out.print("Telefone: "); // Regex
			String telefone = sc.nextLine();
			System.out.print("Email: "); // Regex
			String email = sc.nextLine();
			System.out.println();

			Cliente cliente = new Cliente(nome, cnpj, endereco, cep, telefone, email);
			bd.addCliente(cliente);
		}

		else if (opcao == 2) {
			 //bd.getClientes().forEach(System.out::println);
		}

		else if (opcao == 0) {
			// break;
		} else {
			// System.out.println();
		}

	}

	public static LocalDate dataAniversario(String data) {
		// throws
		DateTimeFormatter format = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		LocalDate dataAniversario = LocalDate.parse(data, format);
		return dataAniversario;

	}

}
