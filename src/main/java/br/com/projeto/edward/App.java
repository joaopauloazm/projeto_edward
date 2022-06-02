package br.com.projeto.edward;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
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
				cadastrarVendas();
			} else if (opcao == 3) {
				controleEstoque();
			} else if (opcao == 4) {
				emissaoNotaFiscal();
			} else if (opcao == 0) {
				condicao = false;
				break;
			} else {
				System.out.println("Essa opcão não existe, favor digite novamente!");
			}

		} while (condicao == true);

		sc.close();
	}

	private static void cadastrarClientes() {
		// trycatch
		BD bd = new BD();
		sc = new Scanner(System.in);
		boolean condicao = true;

		do {
			System.out.println("CLIENTES");
			System.out.println("1 - CADASTRAR CLIENTE");
			System.out.println("2 - EXCLUIR CLIENTE");
			System.out.println("0 - MENU PRINCIPAL");
			System.out.print("DIGITE A OPÇÃO DESEJADA: ");
			int opcao = sc.nextInt();
			System.out.println();

			if (opcao == 1) {

				System.out.print("Nome: ");
				sc.nextLine();
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
				for (int i = 0; i < bd.getClientes().size(); i++) {
					System.out.println(i + " - " + bd.getClientes().get(i).getNome());
				}

				System.out.println();
				System.out.print("Qual cliente deseja remover: ");
				int n = sc.nextInt();

				bd.removeCliente(bd.getClientes().get(n));
				System.out.println();
			}

			else if (opcao == 0) {
				condicao = false;
				break;

			} else {
				System.out.println("Essa opcão não existe, favor digite novamente!");
			}
		} while (condicao == true);

	}

	private static void cadastrarVendas() {

		BD bd = new BD();
		sc = new Scanner(System.in);
		boolean condicao = true;

		do {

			System.out.println("VENDAS");
			System.out.println("1 - ADICIONAR VENDA");
			System.out.println("2 - REMOVER VENDA");
			System.out.println("0 - MENU PRINCIPAL");
			System.out.print("DIGITE A OPÇÃO DESEJADA: ");
			int opcao = sc.nextInt();
			System.out.println();

			if (opcao == 1) {

				for (int i = 0; i < bd.getClientes().size(); i++) {
					System.out.println(i + " - " + bd.getClientes().get(i).getNome());
				}

				System.out.println();
				System.out.print("Qual cliente deseja comprar: ");
				int n = sc.nextInt();

				for (int i = 0; i < bd.getProdutos().size(); i++) {
					System.out.println(i + " - " + bd.getProdutos().get(i).getNome() + ", "
							+ bd.getProdutos().get(i).getEstoque() + ", R$: " + bd.getProdutos().get(i).getPreco());
				}
				System.out.println();
				System.out.print("Qual produto deseja adicionar: ");
				n = sc.nextInt();
				System.out.println(n + " - " + bd.getProdutos().get(n).getNome() + ", "
						+ bd.getProdutos().get(n).getEstoque() + ", R$: " + bd.getProdutos().get(n).getPreco());
				System.out.println("Adicione a quantidade desejada: ");
				int quantidade = sc.nextInt();
				System.out.println("Adicione de emissao: ");
				String dataEmissaoVenda = sc.nextLine();
				;

				// Produto produto = new Produto(bd.getProdutos().get(n).getNome(), bd.getProdutos().get(n).diminuiEstoque(quantidade), bd.getProdutos().get(n).getPreco(), bd.getProdutos().get(n).getValidade());

			} else if (opcao == 2) {

			} else if (opcao == 0) {

			} else {

			}

		} while (condicao == true);

	}

	private static void controleEstoque() {

		BD bd = new BD();
		sc = new Scanner(System.in);

		System.out.println("VENDAS");
		System.out.println("1 - ADICIONAR PRODUTO");
		System.out.println("2 - REMOVER PRODUTO");
		System.out.println("0 - MENU PRINCIPAL");
		System.out.print("DIGITE A OPÇÃO DESEJADA: ");
		int opcao = sc.nextInt();
		System.out.println();

		if (opcao == 1) {
		} else if (opcao == 2) {
		} else if (opcao == 0) {
		} else {
		}

	}

	private static void emissaoNotaFiscal() {
	}

	public static LocalDate dataAniversario(String data) {
		// throws
		DateTimeFormatter format = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		LocalDate dataAniversario = LocalDate.parse(data, format);
		return dataAniversario;

	}
}
