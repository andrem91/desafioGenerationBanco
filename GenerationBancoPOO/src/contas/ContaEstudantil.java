package contas;

import java.util.Scanner;

public class ContaEstudantil extends Conta {
	
	Scanner read=new Scanner (System.in);

	private double valorMaximoEstudantil = 5000.00;
	private char usarEmprestimo;

	public ContaEstudantil(String numeroConta, String nomeCliente, double valorMaximoEstudantil, double valorSolicitado,
			char usarEmprestimo) {
		super(numeroConta, nomeCliente);
		this.usarEmprestimo = usarEmprestimo;

	}

	public double getValorMaximoEstudantil() {
		return valorMaximoEstudantil;
	}

			
	public char getUsarEmprestimo() {
		return usarEmprestimo;
	}

	
	public void menuEmprestimo() {
		double valorSolicitado=0;
		char usarEmprestimo;
		System.out.println("Caro estudante, você tem R$" + valorMaximoEstudantil + "liberados para emprestimo.");
		System.out.println("Deseja utilizar(S/N)?: ");
		usarEmprestimo=read.next().toUpperCase().charAt(0);

		if (usarEmprestimo == 'S') {
			System.out.println("Valor do emprestimo: R$");
		}
		if (valorSolicitado <= valorMaximoEstudantil) {
			credito(valorSolicitado);
			if (valorSolicitado > 0) {
				valorMaximoEstudantil -= valorSolicitado;
			} else {
				System.out.println("Valor invalido. Emprestimo não concluido.\n");
				System.out.println("Caro estudante, o valor solicitado é maior que o disponivel.\n");
			}
		
		}
		super.mostrarSaldo();

	}

}
