package aplicacao;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import contas.Conta;
import contas.ContaCorrente;
import contas.ContaEmpresarial;
import contas.ContaEspecial;
import contas.ContaEstudantil;
import contas.ContaPoupanca;
import etc.Banco;
//import etc.Cadastro;

public class principal {

	public static void main(String[] args) {

		Scanner leitor = new Scanner(System.in);
		Locale.setDefault(Locale.US);
		
		char op;
		double valor = 0;
		int escolha;
		String nome, numeroConta;
		
		Banco.mostrarLogo();
		
		System.out.println("Bem-vinde, me diga seu nome: ");
		nome = leitor.next().toUpperCase();
		System.out.println("Digite o n�mero da sua conta: ");
		numeroConta = leitor.next();
		ContaPoupanca contaPoupanca = new ContaPoupanca(numeroConta, nome);
		ContaCorrente contaCorrente = new ContaCorrente(numeroConta, nome);
		ContaEspecial contaEspecial = new ContaEspecial(numeroConta, nome);
		ContaEmpresarial contaEmpresa = new ContaEmpresarial(numeroConta, nome);
		ContaEstudantil contaEstudantil = new ContaEstudantil(numeroConta, nome);
		
		List<Conta> contas = new ArrayList<>();
		contas.add(contaPoupanca);
		contas.add(contaCorrente);
		contas.add(contaEspecial);
		contas.add(contaEmpresa);
		contas.add(contaEstudantil);
		
		List<String> nomeDasContas = new ArrayList<>();
		nomeDasContas.add("\nConta Poupan�a\n");
		nomeDasContas.add("\nConta Corrente\n");
		nomeDasContas.add("\nConta Especial\n");
		nomeDasContas.add("\nConta Empresarial\n");
		nomeDasContas.add("\nConta Estudantil\n");
		// programa
		do {

			// validar escolha do menu
			do {
				Banco.mostrarLogo();
				System.out.println("Ol�, " + nome + " seja bem vinde");
				System.out.println("1 - CONTA POUPAN�A");
				System.out.println("2 - CONTA CORRENTE");
				System.out.println("3 - CONTA ESPECIAL");
				System.out.println("4 - CONTA EMPRESA");
				System.out.println("5 - CONTA ESTUDANTIL\n");
				System.out.println("6 - Sair\n");
				System.out.println("DIGITE O CODIGO DA OP��O SELECIONADA: ");
				escolha = leitor.nextInt();
				if (escolha < 1 || escolha > 6) {
					System.out.println("Op��o invalida");
				}
				if (escolha == 6) {
					break;
				}
			} while (escolha < 1 || escolha > 6);
			if (escolha == 6) {
				break;
			}
			escolha--;

			// opera��es dentro da conta
			do {
				System.out.println( nomeDasContas.get(escolha));
				System.out.println("MOVIMENTO \nD-D�bito \nC-Cr�dito \nE-Extrato ");
				op = leitor.next().toUpperCase().charAt(0);

				if (op == 'D') {
					System.out.println("Debitar: R$");
					valor = leitor.nextDouble();
					contas.get(escolha).debito(valor);
				} else if (op == 'C') {
					System.out.println("Creditar: R$");
					valor = leitor.nextDouble();
					contas.get(escolha).credito(valor);

				} else if (op == 'E') {
					System.out.println("Extrato:");
					contas.get(escolha).imprimirExtrato();
				} else {
					System.out.println("Op��o invalida");
				}

				// ==== Conta Poupan�a ====
				
				if(escolha == 0) {
					while(true){
						if(valor > 0 && op != 'E' && contaPoupanca.getSaldo() >= valor ) {
							int dataDigitada;
							System.out.print("Informe o dia: ");
							dataDigitada = leitor.nextInt();
							
							if(dataDigitada <= 0 || dataDigitada > 31){
					            System.out.println("Dia inv�lido!");
					        }else if(dataDigitada == contaPoupanca.getDiaAniversarioPoupanca()){
					        	contaPoupanca.ajustarSaldo(); 
					        	break;
					        }else{
					            contaPoupanca.mostrarSaldo();
					            break;
					        }
						}else {
							break;
						}
					}
				}
				 // ==== Fim Poupan�a ====
				 
				 
				 // ===== Inicio Conta Empresa =====
				 
				 if (escolha == 3) {
					 contaEmpresa.realizarEmpresitmo();
				 }
				 
				 // ===== Fim Conta Empresa =====
				 
			    //===== Inicio conta Estudantil ====
				 	
			 	if (escolha == 4) { 
			 		contaEstudantil.menuEmprestimo();
			 	}
			
				// ===== Fim conta Estudantil ====

				System.out.println("Continuar? (S/N)");
				op = leitor.next().toUpperCase().charAt(0);
				while (op != 'N' && op != 'S') {
					System.out.println("Op��o inv�lida");
					System.out.println("Continuar? (S/N)");
					op = leitor.next().toUpperCase().charAt(0);
				}
			} while (op == 'S' && contas.get(escolha).getContadorDeOperacoes() < 10);
			
			  // ==== Conta Corrente ====
			 if (escolha == 1 && contaCorrente.podePedirTalao()){
				 char pedirTalao = 'S';
				 while (pedirTalao == 'S' && contaCorrente.podePedirTalao()) {
					 pedirTalao = 'N';
					 System.out.println("\nTAL�ES DE CHEQUE\n");
					 System.out.println("\nTal�es pedidos: " + contaCorrente.getTaloes() + "\nlimites de tal�o no m�s: " + contaCorrente.getMAXIMO_TALOES());
					 System.out.println("\nCusto: R$" + contaCorrente.getPRECO_TALAO());
					 System.out.println("Gostaria de comprar um tal�o de cheque?(S/N)");
					 pedirTalao = leitor.next().toUpperCase().charAt(0);
					 contaCorrente.pedirTalao(pedirTalao); 
				 }
			 // ==== Fim Corrente ==== 	 
			}
		} while (true);
		
		Banco.despedida();
		
	}
	
}