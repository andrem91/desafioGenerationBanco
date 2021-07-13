package contas;

public class ContaPoupanca extends Conta{
	
	private int diaAniversarioPoupanca = 7;

	public ContaPoupanca(String numeroConta, String nomeCliente, int diaAniversarioPoupanca) {
		super(numeroConta, nomeCliente);
	}

	public int getDiaAniversarioPoupanca() {
		return diaAniversarioPoupanca;
	}
	
	public void ajustarSaldo(int dataDigitada) {
		if(dataDigitada <= 0 || dataDigitada > 31){
			System.out.println("Dia inválido!");
		}else if(dataDigitada == this.diaAniversarioPoupanca){
			double saldo, ajuste;
			saldo = super.getSaldo();
			ajuste = 0.05*super.getSaldo();
			System.out.println("Hoje é o aniversário da sua conta. Saldo corrigido para R$" + (saldo + ajuste));
			System.out.println("Saldo Atual: " + super.credito(ajuste));
		}else{
			System.out.println("Saldo Atual: " + super.getSaldo());
		}
					
	}
	
}
