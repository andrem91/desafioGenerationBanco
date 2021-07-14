package contas;

import java.util.LinkedList;
import java.util.List;

public abstract class Conta {
	
	protected double saldo;
	private String numeroConta;
	private String nomeCliente;
	private int contadorDeOperacoes;
	private List<String> extrato = new LinkedList<>();
	/*Quando aprendermos collections, armazenar as opera��es em uma cole��o para exibir no metodo*/
	
	
	public Conta(String numeroConta, String nomeCliente) {
		super();
		this.numeroConta = numeroConta;
		this.nomeCliente = nomeCliente;
	}

	public double getSaldo() {
		return saldo;
	}

	public String getNumeroConta() {
		return numeroConta;
	}

	public String getNomeCliente() {
		return nomeCliente;
	}

	public void credito (double valor) {
		if (valor <= 0) {
			System.out.println("Valor inv�lido");
		}
		else {
			saldo += valor;
			extrato.add("Cr�dito:\tR$ " + valor);
		}
		realizarOperacao();
	}
	
	public int getContadorDeOperacoes() {
		return contadorDeOperacoes;
	}


	public void debito (double valor) {
		if (valor <= 0) {
			System.out.println("Valor inv�lido");
		} else if (valor <= saldo) {
			saldo -= valor;
			extrato.add("D�bito:\tR$ -" + valor);
		} else {
			System.out.println("Saldo Insulficiente");
		}
		realizarOperacao();
	}
	
	public void mostrarSaldo () {
		System.out.println("Saldo atual: R$ " + this.getSaldo());
	}
	
	/*A fazer quando entendermos direito collections, ira armazenar as opera��es para exibir*/
	public void imprimirExtrato() {
		int i = 0;
		for (String operacoes : extrato) {
			i++;
			System.out.println(i +": " + operacoes);
		}
		mostrarSaldo();
	}
	
	public void realizarOperacao() {
		this.contadorDeOperacoes++;
		mostrarSaldo();
	}
	
}