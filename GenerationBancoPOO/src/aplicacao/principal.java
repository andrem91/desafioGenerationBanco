package aplicacao;

import java.util.Scanner;
//import etc.Cadastro;

public class principal {

	public static void main(String[] args) {
		
		Scanner leitor = new Scanner(System.in);
		
		char op;
		double valor;
		int escolha;
		
		//programa
		do {
			
			//validar escolha do menu
			do {
				System.out.println("1 - CONTA POUPAN�A");
				System.out.println("2 - CONTA CORRENTE");
				System.out.println("3 - CONTA ESPECIAL");
				System.out.println("4 - CONTA EMPRESA");
				System.out.println("5 - CONTA ESTUDANTIL\n");
				System.out.println("6 - Sair\n");
				System.out.println("DIGITE O CODIGO DA OP��O SELECIONADA: ");
				escolha = leitor.nextInt();
				if (escolha < 1 || escolha > 6){
					System.out.println ("Op��o invalida");
				}
			} while (escolha < 1 || escolha > 6);
			
			//opera��es dentro da conta
			do {
				System.out.println("MOVIMENTO - D-debito ou C-Cr�dito: ");
				op = leitor.next().toUpperCase().charAt(0);
				
				if (op == 'D') {
					System.out.println("Debitar: R$");
					valor = leitor.nextDouble();
					//ContaX.debito(valor);
				} else if (op == 'C') {
					System.out.println("Creditar: R$");
					valor = leitor.nextDouble();
					//ContaX.credito(valor);

				}else {
					System.out.println("Op��o invalida");
				}
				
				//ContaX.contadorOperacoes++;
				//mostrarSaldo;
				
				/*
				// ==== Conta Poupan�a ====
				
				se(escola == 1) {
					contaPoupanca.metodo()
					
				}
	
				// ==== Fim Poupan�a ====
	
				// ===== Inicio Conta Empresa =====
				
				se(escolha == 4) {
					contaEmpresa().metodo()
					
				}
	
				// ===== Fim Conta Empresa =====
				
				// ===== Inicio conta Estudantil ====
				
				se(escolha == 5){
					contaEstudantil().metodo()
					
				}
				*/
				//===== Fim conta Estudantil ====	
				
				
				System.out.println("Continuar? (S/N)");
				op = leitor.next().toUpperCase().charAt(0);
			} while (op == 'S');
			/*
			// ==== Conta Corrente ====
			
			if (escolha == 2){
			
				//mostrarSaldo
				
				System.out.println("Gostaria de comprar uma tal�o de cheque?");
				contaCorrente.pedirTalao(leitor.next().toUpperCase().charAt(0));
							
			}
						
			// ==== Fim Corrente ====
			*/
			
		} while(true);
		
		
		//vers�o com cadastro, decidir se vai ficar
		/*
		Cadastro cadastrador = new Cadastro();
		loopTotal:
		while (true) {
			int escolha = 0;
			String numeroConta = "";
			char op = 'S';
			
			//Come�o do bloco de entrar na conta
			System.out.println("Digite a op��o desejada\n1 - Acessar conta existente\n2 - Cadastrar nova conta\n3 - Sair");
			escolha = leitor.nextInt();

			if (escolha == 1) {
				System.out.println("Por favor, digite o n�mero e o d�gito da sua conta: ");
				numeroConta = leitor.next();
				
				if (!Cadastro.temConta(numeroConta)) {
					System.out.println("N�o foi encontrado uma conta com o n�mero " + numeroConta + "\nDeseja cadastrar uma nova conta?(S/N)");
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
			//Fim do bloco de entrar na conta
			
			
			//Menu de contas
			System.out.println("Bem vindo " + Cadastro.acessarConta(numeroConta, 0).getNomeCliente() +"\nConta "+ numeroConta +"\nSelecione a op��o desejada:");
			System.out.println("1 - CONTA POUPAN�A");
			System.out.println("2 - CONTA CORRENTE");
			System.out.println("3 - CONTA ESPECIAL");
			System.out.println("4 - CONTA EMPRESA");
			System.out.println("5 - CONTA ESTUDANTIL\n");
			System.out.println("6 - Cancelar conta\n");
			System.out.println("7 - Sair\n");
			
		}
		*/
		
		
		
	}

}