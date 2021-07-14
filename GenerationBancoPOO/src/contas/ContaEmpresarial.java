package contas;

import java.util.Scanner;

public class ContaEmpresarial extends Conta {

	Scanner ler = new Scanner(System.in);

	double valorMaximo = 10000.00;
	private double valorEmprestimo;
	private char aceitarEmprestimo = 'N';

	public ContaEmpresarial(String numeroConta, String nomeCliente) {
		super(numeroConta, nomeCliente);
	}

	public double getValorEmprestimo() {
		return valorEmprestimo;
	}

	public void setValorEmprestimo(double valorEmprestimo) {
		this.valorEmprestimo = valorEmprestimo;
	}

	public char getAceitarEmprestimo() {
		return aceitarEmprestimo;
	}

	public void setAceitarEmprestimo(char aceitarEmprestimo) {
		this.aceitarEmprestimo = aceitarEmprestimo;
	}

	public void realizarEmpresitmo() {
		System.out.println("Você tem R$ " + valorMaximo + " liberados para emprestrimo.");
		System.out.print("Deseja utilizar(S/N)? ");
		aceitarEmprestimo = ler.next().charAt(0);

		if (aceitarEmprestimo == 'S' || aceitarEmprestimo == 's') {
			System.out.print("Valor do emprestimo: R$");
			valorEmprestimo = ler.nextDouble();

			if (valorEmprestimo <= valorMaximo) {
				super.credito(valorEmprestimo);
				if (valorEmprestimo > 0) {
					valorMaximo -= valorEmprestimo;
				}
			} else {
				System.out.println("Valor invalido. Emprestimo não concluido.");
			}
		}
	}
}
