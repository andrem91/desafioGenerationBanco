package contas;

import java.util.HashMap;
import java.util.Map;

public class Conta {
	
	private double saldo;
	private int numeroConta;
	private String nomeCliente;
	
	/*Quando aprendermos collections, armazenar as opera��es em uma cole��o para exibir no metodo*/
	
	
	public Conta(int numeroConta, String nomeCliente) {
		super();
		this.numeroConta = numeroConta;
		this.nomeCliente = nomeCliente;
	}

	public double getSaldo() {
		return saldo;
	}

	public int getNumeroConta() {
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
		}
	}
	
	public void debito (double valor) {
		if (valor <= 0) {
			System.out.println("Valor inv�lido");
		} else if (valor <= saldo) {
			saldo -= valor;
		} else {
			System.out.println("Saldo Insulficiente");
		}
	}
	
	public void mostrarSaldo () {
		System.out.println("Saldo atual: R$" + this.getSaldo());
	}
	
	/*A fazer quando entendermos direito collections, ira armazenar as opera��es para exibir*/
	public void imprimirExtrato() {
		
	}
}