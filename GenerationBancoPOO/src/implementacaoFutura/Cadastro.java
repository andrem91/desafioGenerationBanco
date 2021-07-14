/*Classe para e acessar as contas*/

package implementacaoFutura;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

import contas.*;

public class Cadastro {
	/*Lista onde fica todos os cadastros, sua busca é por numero da conta, acessado pelos metodos da classe*/
	private static List<Cadastro> todosOsCadastros = new LinkedList<>();
	
	/*Lista em cada cadastro onde fica armazenado as 5 tipos de contas*/
	private List<Conta> cadastroDeContas = new ArrayList<>();
	private String numeroConta;
	
	public Cadastro() {
		
	}
	
	public Cadastro(String numeroConta) {
		this.numeroConta = numeroConta;
	}
	
	public String getNumeroConta() {
		return this.numeroConta;
	}
	
	private Cadastro cadastrarContas(String numeroConta, String nome) {
		
		cadastroDeContas.add(new ContaPoupanca(numeroConta, nome));
		cadastroDeContas.add(new ContaCorrente(numeroConta, nome));
		cadastroDeContas.add(new ContaEspecial(numeroConta, nome));
		cadastroDeContas.add(new ContaEmpresarial(numeroConta, nome));
		cadastroDeContas.add(new ContaEstudantil(numeroConta, nome));
		
		return this;
	}
	
	public static boolean temConta(String numeroConta) {
		boolean encontrado = false;
		for (Cadastro cad : todosOsCadastros) {
			if (cad.getNumeroConta().equals(numeroConta)) {
				encontrado = true;
			}
		}
		return encontrado;
	}
	
	public String cadastrarUsuario() {

			Random gerador = new Random();
			System.out.println("Cadastro de conta do banco G1 GENERATION BRASIL");
			System.out.println("Digite o seu nome: ");
			String nome = new Scanner(System.in).next();

			int primeirosNumeros = 0;
			while (primeirosNumeros < 10000) {
				primeirosNumeros = gerador.nextInt(100000);
			}
			
			String numeroConta = primeirosNumeros + "-" + gerador.nextInt(10);
			
			
			System.out.println("Cadastro realizado com sucesso\nBem vindo ao banco G1 GENERATION BRASIL\n" + nome +", o número da sua conta é " + numeroConta);
			todosOsCadastros.add(new Cadastro (numeroConta).cadastrarContas(numeroConta, nome));
			return numeroConta;
	}

	public void cancelarCadastro() {
		System.out.println(this.cadastroDeContas.get(0).getNomeCliente() + ", deseja realmente cancelar sua conta de número " + this.cadastroDeContas.get(0).getNumeroConta() + "? (S/N)");
		char op = new Scanner(System.in).next().toUpperCase().charAt(0);

		if (op == 'S') {
			todosOsCadastros.remove(this);
			System.out.println("Conta cancelada");
		}
	}
	
	public static Cadastro acessarCadastro(String numeroConta) {
		for(int i = 0; i < todosOsCadastros.size(); i++) {
			if (todosOsCadastros.get(i).getNumeroConta().equals(numeroConta))
				return todosOsCadastros.get(i);
		}
		return null;
	}
	
	
	public static Conta acessarConta(String numeroConta, int index) {
		
		return acessarCadastro(numeroConta).cadastroDeContas.get(index);
	}
	
	
	public static ContaPoupanca acessarContaPoupanca(String numeroConta) {
		return (ContaPoupanca) acessarCadastro(numeroConta).cadastroDeContas.get(0);
	}
	
	public static ContaCorrente acessarContaCorrente(String numeroConta) {
		return (ContaCorrente) acessarCadastro(numeroConta).cadastroDeContas.get(1);
	}
	
	
	public static ContaEspecial acessarContaEspecial(String numeroConta) {
		return (ContaEspecial) acessarCadastro(numeroConta).cadastroDeContas.get(2);
	}
	
	public static ContaEmpresarial acessarContaEmpresa(String numeroConta) {
		return (ContaEmpresarial) acessarCadastro(numeroConta).cadastroDeContas.get(3);
	}
	
	public static ContaEstudantil acessarContaEstudantil(String numeroConta) {
		return (ContaEstudantil) acessarCadastro(numeroConta).cadastroDeContas.get(4);
	}
	
	
}