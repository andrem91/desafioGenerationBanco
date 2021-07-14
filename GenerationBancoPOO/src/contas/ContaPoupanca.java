package contas;

import java.text.DecimalFormat;

public class ContaPoupanca extends Conta{
	
	private int diaAniversarioPoupanca = 7;

	public ContaPoupanca(String numeroConta, String nomeCliente) {
		super(numeroConta, nomeCliente);
	}

	public int getDiaAniversarioPoupanca() {
		return diaAniversarioPoupanca;
	}
	
<<<<<<< HEAD
	public void ajustarSaldo(int dataDigitada) {
		if(dataDigitada <= 0 || dataDigitada > 31){
			System.out.println("Dia inválido!");
		}else if(dataDigitada == this.diaAniversarioPoupanca){
			double ajuste;
			ajuste = 0.05*super.getSaldo();
			super.credito(ajuste);
			System.out.println("Hoje é o aniversário da sua conta. Saldo corrigido para R$" + this.getSaldo());
			System.out.println("Saldo Atual: " + this.getSaldo());
			super.credito(ajuste);
		}else{
			System.out.println("Saldo Atual: " + super.getSaldo());
		}
					
	}
=======
	public void ajustarSaldo() {
            double saldo, ajuste;
            ajuste =  0.05*super.getSaldo();
            saldo = super.getSaldo() + ajuste;
            System.out.println("Hoje é o aniversário da sua conta. Saldo corrigido para R$" + new DecimalFormat("0.00").format(saldo));
            super.credito(ajuste);
    }
>>>>>>> master
	
}
