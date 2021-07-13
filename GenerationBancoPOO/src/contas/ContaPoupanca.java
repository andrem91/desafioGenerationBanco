package contas;

public class ContaPoupanca extends Conta{
	
	private int diaAniversarioPoupanca = 7;

	public ContaPoupanca(String numeroConta, String nomeCliente, int diaAniversarioPoupanca) {
		super(numeroConta, nomeCliente);
		this.diaAniversarioPoupanca = diaAniversarioPoupanca;
	}

	public int getDiaAniversarioPoupanca() {
		return diaAniversarioPoupanca;
	}
	
	public void ajustarSaldo(int dataDigitada) {
		if(dataDigitada <= 0 || dataDigitada > 31){
			System.out.println("Dia inválido!");
		}else if(dataDigitada == this.diaAniversarioPoupanca){
			this.saldo = this.saldo + 0.05*this.saldo;
			System.out.println("Hoje é o aniversário da sua conta. Saldo corrigido para R$" + this.saldo);
			System.out.println("Saldo Atual: " + super.getSaldo());
		}else{
			System.out.println("Saldo Atual: " + super.getSaldo());
		}
					
	}
	
}
