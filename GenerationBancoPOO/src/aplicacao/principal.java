package aplicacao;

import java.util.Scanner;

import etc.Cadastro;

public class principal {

	public static void main(String[] args) {
		
		Scanner leitor = new Scanner(System.in);
		Cadastro cadastrador = new Cadastro();
		
		loopTotal:
		while (true) {
			int escolha = 0;
			String numeroConta = "";
			char op = 'S';
			
			/*Come�o do bloco de entrar na conta*/
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
			/*Fim do bloco de entrar na conta*/
			
			System.out.println("Bem vindo " + Cadastro.acessarConta(numeroConta, 0).getNomeCliente() +"\nConta "+ numeroConta +"\nSelecione a op��o desejada:");
			System.out.println("1 - CONTA POUPAN�A");
			System.out.println("2 - CONTA CORRENTE");
			System.out.println("3 - CONTA ESPECIAL");
			System.out.println("4 - CONTA EMPRESA");
			System.out.println("5 - CONTA ESTUDANTIL\n");
			System.out.println("6 - Cancelar conta\n");
			System.out.println("7 - Sair\n");
			
			
			
		}
	}

}