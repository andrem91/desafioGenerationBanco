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
				System.out.println("1 - CONTA POUPANÇA");
				System.out.println("2 - CONTA CORRENTE");
				System.out.println("3 - CONTA ESPECIAL");
				System.out.println("4 - CONTA EMPRESA");
				System.out.println("5 - CONTA ESTUDANTIL\n");
				System.out.println("6 - Sair\n");
				System.out.println("DIGITE O CODIGO DA OPÇÃO SELECIONADA: ");
				escolha = leitor.nextInt();
				if (escolha < 1 || escolha > 6){
					System.out.println ("Opção invalida");
				}
			} while (escolha < 1 || escolha > 6);
			
			//operações dentro da conta
			do {
				System.out.println("MOVIMENTO - D-debito ou C-Crédito: ");
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
					System.out.println("Opção invalida");
				}
				
				//ContaX.contadorOperacoes++;
				//mostrarSaldo;
				
				/*
				// ==== Conta Poupança ====
				
				se(escola == 1) {
					contaPoupanca.metodo()
					
				}
	
				// ==== Fim Poupança ====
	
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
				
				System.out.println("Gostaria de comprar uma talão de cheque?");
				contaCorrente.pedirTalao(leitor.next().toUpperCase().charAt(0));
							
			}
						
			// ==== Fim Corrente ====
			*/
			
		} while(true);
		
		
		//versão com cadastro, decidir se vai ficar
		/*
		Cadastro cadastrador = new Cadastro();
		loopTotal:
		while (true) {
			int escolha = 0;
			String numeroConta = "";
			char op = 'S';
			
			//Começo do bloco de entrar na conta
			System.out.println("Digite a opção desejada\n1 - Acessar conta existente\n2 - Cadastrar nova conta\n3 - Sair");
			escolha = leitor.nextInt();

			if (escolha == 1) {
				System.out.println("Por favor, digite o número e o dígito da sua conta: ");
				numeroConta = leitor.next();
				
				if (!Cadastro.temConta(numeroConta)) {
					System.out.println("Não foi encontrado uma conta com o número " + numeroConta + "\nDeseja cadastrar uma nova conta?(S/N)");
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
			System.out.println("Bem vindo " + Cadastro.acessarConta(numeroConta, 0).getNomeCliente() +"\nConta "+ numeroConta +"\nSelecione a opção desejada:");
			System.out.println("1 - CONTA POUPANÇA");
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