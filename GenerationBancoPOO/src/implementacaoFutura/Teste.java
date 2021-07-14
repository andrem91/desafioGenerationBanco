package implementacaoFutura;

import java.util.Locale;
import java.util.Scanner;

import menu.Banco;

public class Teste {
	public static void main(String[] args) {

		Cadastro cadastrador = new Cadastro();
		Scanner leitor = new Scanner(System.in);
		Locale.setDefault(Locale.US);

		char op;
		double valor = 0;
		int escolha;
		String nome = "", numeroConta = "";

		// programa
		do {
			// cadastramento de conta
			Banco.mostrarLogo();
			
			System.out.println("Digite a op��o desejada\n1 - Acessar conta existente\n2 - Cadastrar nova conta\n3 - Sair");
			escolha = leitor.nextInt();
			
			//validar escolha
			while (escolha < 1 || escolha > 3) {
				System.out.println("Op��o inv�lida");
				System.out.println("Digite a op��o desejada\n1 - Acessar conta existente\n2 - Cadastrar nova conta\n3 - Sair");
				escolha = leitor.nextInt();
			} 
			
			
			if (escolha == 1) {
				System.out.println("Por favor, digite o n�mero e o d�gito da sua conta: ");
				numeroConta = leitor.next();

				if (!Cadastro.temConta(numeroConta)) {
					System.out.println("N�o foi encontrado uma conta com o n�mero " + numeroConta
							+ "\nDeseja cadastrar uma nova conta?(S/N)");
					op = leitor.next().toUpperCase().charAt(0);

					if (op == 'S') {
						numeroConta = cadastrador.cadastrarUsuario();

					} else {
						continue;
					}
				}

			} else if (escolha == 2) {
				numeroConta = cadastrador.cadastrarUsuario();

			} else if (escolha == 3) {
				break;
			}
			// fim do cadastramento de conta

			// dentro de uma conta
			do {

				// validar escolha do menu
				do {
					Banco.mostrarLogo();
					System.out.println("Bem vindo " + Cadastro.acessarConta(numeroConta, 0).getNomeCliente()
							+ "\nConta " + numeroConta + "\nSelecione a op��o desejada:");
					System.out.println("1 - CONTA POUPAN�A");
					System.out.println("2 - CONTA CORRENTE");
					System.out.println("3 - CONTA ESPECIAL");
					System.out.println("4 - CONTA EMPRESA");
					System.out.println("5 - CONTA ESTUDANTIL\n");
					System.out.println("6 - Cancelar conta\n");
					System.out.println("7 - Sair\n");
					System.out.println("DIGITE O CODIGO DA OP��O SELECIONADA: ");
					escolha = leitor.nextInt();
					if (escolha < 1 || escolha > 7) {
						System.out.println("Op��o invalida");
					}
					if (escolha == 7) {
						break;
					}
				} while (escolha < 1 || escolha > 6);

				// tem que ver isso aqui
				if (escolha == 6) {
					Cadastro.acessarCadastro(numeroConta).cancelarCadastro();
					break;
				}

				if (escolha == 7) {
					break;
				}
				escolha--;

				// opera��es dentro da conta

				do {
					System.out.println("MOVIMENTO \nD-debito \nC-Cr�dito \nE-Extrato ");
					op = leitor.next().toUpperCase().charAt(0);

					if (op == 'D') {
						System.out.println("Debitar: R$");
						valor = leitor.nextDouble();
						Cadastro.acessarConta(numeroConta, escolha).debito(valor);
					} else if (op == 'C') {
						System.out.println("Creditar: R$");
						valor = leitor.nextDouble();
						Cadastro.acessarConta(numeroConta, escolha).credito(valor);

					} else if (op == 'E') {
						System.out.println("Extrato:");
						Cadastro.acessarConta(numeroConta, escolha).imprimirExtrato();
					} else {
						System.out.println("Op��o invalida");
					}

					// ==== Conta Poupan�a ====

					if (escolha == 0) {
						while (true) {
							if (valor > 0 && op != 'E'
									&& Cadastro.acessarContaPoupanca(numeroConta).getSaldo() >= valor) {
								int dataDigitada;
								System.out.print("Informe o dia: ");
								dataDigitada = leitor.nextInt();

								if (dataDigitada <= 0 || dataDigitada > 31) {
									System.out.println("Dia inv�lido!");
								} else if (dataDigitada == Cadastro.acessarContaPoupanca(numeroConta)
										.getDiaAniversarioPoupanca()) {
									Cadastro.acessarContaPoupanca(numeroConta).ajustarSaldo();
									break;
								} else {
									Cadastro.acessarContaPoupanca(numeroConta).mostrarSaldo();
									break;
								}
							} else {
								break;
							}
						}
					}
					// ==== Fim Poupan�a ====

					// ===== Inicio Conta Empresa =====
					if (escolha == 3) {
						Cadastro.acessarContaEmpresa(numeroConta).realizarEmpresitmo();
					}
					// ===== Fim Conta Empresa =====

					// ===== Inicio conta Estudantil ====
					if (escolha == 4) {
						Cadastro.acessarContaEstudantil(numeroConta).menuEmprestimo();
					}
					// ===== Fim conta Estudantil ====

					System.out.println("Continuar? (S/N)");
					op = leitor.next().toUpperCase().charAt(0);
					while (op != 'N' && op != 'S') {
						System.out.println("Op��o inv�lida");
						System.out.println("Continuar? (S/N)");
						op = leitor.next().toUpperCase().charAt(0);
					}
				} while (op == 'S' && Cadastro.acessarConta(numeroConta, escolha).getContadorDeOperacoes() < 10);

				// ==== Conta Corrente ====
				if (escolha == 1 && Cadastro.acessarContaCorrente(numeroConta).podePedirTalao()) {
					char pedirTalao = 'S';
					while (pedirTalao == 'S' && Cadastro.acessarContaCorrente(numeroConta).podePedirTalao()) {
						pedirTalao = 'N';
						System.out.println("\nTAL�ES DE CHEQUE\n");
						System.out.println("\nTal�es pedidos: " + Cadastro.acessarContaCorrente(numeroConta).getTaloes()
								+ "\nlimites de tal�o no m�s: "
								+ Cadastro.acessarContaCorrente(numeroConta).getMAXIMO_TALOES());
						System.out.println("\nCusto: R$" + Cadastro.acessarContaCorrente(numeroConta).getPRECO_TALAO());
						System.out.println("Gostaria de comprar um tal�o de cheque?");
						pedirTalao = leitor.next().toUpperCase().charAt(0);
						Cadastro.acessarContaCorrente(numeroConta).pedirTalao(pedirTalao);
					}
					// ==== Fim Corrente ====
				}

			} while (escolha != 7);
			System.out.println("Saindo da conta " + numeroConta);
		} while (true);
		Banco.despedida();

		// vers�o com cadastro, decidir se vai ficar
		/*
		 * Cadastro cadastrador = new Cadastro(); loopTotal: while (true) { int escolha
		 * = 0; String numeroConta = ""; char op = 'S';
		 * 
		 * //Come�o do bloco de entrar na conta System.out.
		 * println("Digite a op��o desejada\n1 - Acessar conta existente\n2 - Cadastrar nova conta\n3 - Sair"
		 * ); escolha = leitor.nextInt();
		 * 
		 * if (escolha == 1) {
		 * System.out.println("Por favor, digite o n�mero e o d�gito da sua conta: ");
		 * numeroConta = leitor.next();
		 * 
		 * if (!Cadastro.temConta(numeroConta)) {
		 * System.out.println("N�o foi encontrado uma conta com o n�mero " + numeroConta
		 * + "\nDeseja cadastrar uma nova conta?(S/N)"); op =
		 * leitor.next().toUpperCase().charAt(0);
		 * 
		 * if (op == 'S') { numeroConta = cadastrador.cadastrarUsuario();
		 * 
		 * } else { continue; } }
		 * 
		 * } else if (escolha == 2) { numeroConta = cadastrador.cadastrarUsuario();
		 * 
		 * } else if (escolha == 3) { break; } //Fim do bloco de entrar na conta
		 * 
		 * 
		 * //Menu de contas System.out.println("Bem vindo " +
		 * Cadastro.acessarConta(numeroConta, 0).getNomeCliente() +"\nConta "+
		 * numeroConta +"\nSelecione a op��o desejada:");
		 * System.out.println("1 - CONTA POUPAN�A");
		 * System.out.println("2 - CONTA CORRENTE");
		 * System.out.println("3 - CONTA ESPECIAL");
		 * System.out.println("4 - CONTA EMPRESA");
		 * System.out.println("5 - CONTA ESTUDANTIL\n");
		 * System.out.println("6 - Cancelar conta\n"); System.out.println("7 - Sair\n");
		 * 
		 * }
		 */

	}
}
