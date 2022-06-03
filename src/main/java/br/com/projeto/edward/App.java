package br.com.projeto.edward;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

import br.com.projeto.edward.exceptions.NegocioException;

public class App {

	static Scanner sc;

	public static void main(String[] args) {

		sc = new Scanner(System.in);

		boolean condicao = true;

		do {

			System.out.println("MENU PRINCIPAL");
			System.out.println("1 - CADASTRAR/EXCLUIR CLIENTES");
			System.out.println("2 - CADASTRAR/EXCLUIR PRODUTOS");
			System.out.println("3 - CADASTRAR VENDAS");
			System.out.println("4 - EMITIR NOTA FISCAL");
			System.out.println("0 - SAIR");
			System.out.print("DIGITE A OPÇÃO DESEJADA: ");
			try {
				int opcao = sc.nextInt();
				System.out.println();

				if (opcao == 1) {
					cadastrarClientes();
				} else if (opcao == 2) {
					cadastroProdutos();
				} else if (opcao == 3) {
					cadastrarVendas();
				} else if (opcao == 4) {
					emissaoNotaFiscal();
				} else if (opcao == 0) {
					condicao = false;
					break;
				} else {
					System.out.println("Essa opcão não existe, favor digite novamente!");
				}

			} catch (Exception e) {
				System.out.println("Something is wrong!");
			} finally {
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

	private static void cadastroProdutos() {

		BD bd = new BD();
		sc = new Scanner(System.in);
		boolean condicao1 = true;

		do {

			System.out.println("PRODUTOS");
			System.out.println("1 - ADICIONAR PRODUTO");
			System.out.println("2 - REMOVER PRODUTO");
			System.out.println("0 - MENU PRINCIPAL");
			System.out.print("DIGITE A OPÇÃO DESEJADA: ");
			int opcao = sc.nextInt();
			boolean condicao2 = true;
			System.out.println();

			if (opcao == 1) {
				do {
					sc.nextLine();
					System.out.print("Nome do produto: ");
					String nomeProduto = sc.nextLine();
					System.out.print("Quantidade do produto: ");
					int quantidadeProduto = sc.nextInt();
					System.out.print("Preço do produto: ");
					BigDecimal precoProduto = sc.nextBigDecimal();
					System.out.println();

					Produto produto = new Produto(nomeProduto, quantidadeProduto, precoProduto);
					bd.addProduto(produto);

					System.out.print("Para continuar digite qualquer número, para sair digite 0: ");
					int n = sc.nextInt();

					if (n == 0) {
						condicao2 = false;
						break;
					}

				} while (condicao2 == true);

			} else if (opcao == 2) {

				for (int i = 0; i < bd.getProdutos().size(); i++) {
					System.out.println(i + " - " + bd.getProdutos().get(i).getNome());
				}

				System.out.println();
				System.out.print("Qual produto deseja remover: ");
				int n = sc.nextInt();

				bd.removeProduto(bd.getProdutos().get(n));
				System.out.println();

			} else if (opcao == 0) {
				condicao1 = false;
				break;

			} else {
				System.out.println("Essa opcão não existe, favor digite novamente!");
			}

		} while (condicao1 = true);

	}

	private static void cadastrarVendas() {

		BD bd = new BD();
		sc = new Scanner(System.in);
		boolean condicao1 = true;

		do {

			System.out.println("VENDAS");
			System.out.println("1 - ADICIONAR VENDA");
			System.out.println("2 - EXCLUIR VENDA");
			System.out.println("0 - MENU PRINCIPAL");
			System.out.print("DIGITE A OPÇÃO DESEJADA: ");
			int opcao = sc.nextInt();
			System.out.println();
			boolean condicao2 = true;

			if (opcao == 1) {

				for (int i = 0; i < bd.getClientes().size(); i++) {
					System.out.println(i + " - " + bd.getClientes().get(i).getNome());
				}

				System.out.println();
				System.out.print("Qual cliente deseja comprar: ");
				int n = sc.nextInt();

				Venda venda = new Venda(bd.getClientes().get(n));
				bd.addVenda(venda);

				do {
					try {
						for (int i = 0; i < bd.getProdutos().size(); i++) {
							System.out.println(i + " - " + bd.getProdutos().get(i).getNome() + ", "
									+ bd.getProdutos().get(i).getEstoque() + ", R$: "
									+ bd.getProdutos().get(i).getPreco());
						}
						System.out.println();
						System.out.println();
						System.out.print("Qual produto deseja adicionar: ");
						n = sc.nextInt();
						System.out.println(n + " - Produto: " + bd.getProdutos().get(n).getNome() + "; Quantidade: "
								+ bd.getProdutos().get(n).getEstoque() + "; Valor R$: "
								+ bd.getProdutos().get(n).getPreco() + "; ");
						System.out.print("Adicione a quantidade desejada: ");
						int quantidade = sc.nextInt();
						System.out.println();
						if (quantidade > bd.getProdutos().get(n).getEstoque()) {
							throw new NegocioException("O estoque possui apenas" + bd.getProdutos().get(n).getEstoque()
									+ " produtos, repita!");
						}

						ItemVenda itemVenda = new ItemVenda(bd.getProdutos().get(n), quantidade);
						venda.addItemVenda(itemVenda);
						bd.getProdutos().get(n).diminuiEstoque(quantidade);

						System.out.print("Para continuar digite qualquer número, para sair digite 0: ");
						int i = sc.nextInt();

						if (i == 0) {
							condicao2 = false;
							break;
						}

					} catch (Exception e) {
						System.out.println(e.getMessage());
						System.out.println();
					}

				} while (condicao2 == true);

			} else if (opcao == 2) {

				for (int i = 0; i < bd.getVendas().size(); i++) {
					System.out.println(i + " - " + bd.getVendas().get(i).getCliente().getNome());
				}

				System.out.println();
				System.out.print("Qual venda deseja excluir: ");
				int n = sc.nextInt();

				bd.removeVenda(bd.getVendas().get(n));
				System.out.println();

			} else if (opcao == 0) {
				condicao1 = false;
				break;

			} else {
				System.out.println("Essa opcão não existe, favor digite novamente!");
			}

		} while (condicao1 == true);

	}

	private static void emissaoNotaFiscal() {

		BD bd = new BD();
		System.out.println();
		System.out.println("************ CUPOM ************");
		System.out.println();

		bd.getVendas().forEach(venda -> imprimeCupom(venda));
	}

	private static void imprimeCupom(Venda venda) {

		String linhaVenda = "Nome: " + venda.getCliente().getNome() + "\nCNPJ: " + venda.getCliente().getCnpj()
				+ "\nEndereco: " + venda.getCliente().getEnderceco() + "\nCEP: " + venda.getCliente().getCep()
				+ "\nTelefone: " + venda.getCliente().getTelefone() + "\nEmail: " + venda.getCliente().getEmail() + "\n";
	
		String linhasProdutos = "";
		
		for (ItemVenda item : venda.getItensVendas()) {
			linhasProdutos = linhasProdutos + geraLinha(item);
		}
		
		System.out.println(linhaVenda + linhasProdutos);
	}

	private static String geraLinha(ItemVenda item) {
		System.out.println();
		String linha1 = item.getProduto().getNome();

		BigDecimal valorTotal = item.getProduto().getPreco().multiply(BigDecimal.valueOf(item.getQuantidade()));

		int tQuantidade = String.valueOf(item.getQuantidade()).length();
		int tValorUnitario = String.valueOf(item.getProduto().getPreco()).length();
		int tValorTotalItem = String.valueOf(valorTotal).length();

		int pontos = (31 - 3 - tQuantidade - tValorUnitario - tValorTotalItem);

		String linha2 = item.getQuantidade() + "x " + item.getProduto().getPreco() + " " + geraPontos(pontos) + " "
				+ valorTotal + "\n";

		return linha1 + linha2;

	}

	private static String geraPontos(int pontos) {
		String pontosRetorno = "";
		int x = 1;

		while (x < pontos) {
			pontosRetorno = pontosRetorno + ".";
			x++;
		}

		return pontosRetorno;
	}

//	private static void ajusteDeEstoque() {
//	}

	public static LocalDate dataAniversario(String data) {
		// throws
		DateTimeFormatter format = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		LocalDate dataAniversario = LocalDate.parse(data, format);
		return dataAniversario;

	}
}
