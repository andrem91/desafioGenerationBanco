package contas;

public class ContaEspecial extends Conta {
	private double limiteEspecial = 1000.0;

	public ContaEspecial(String numeroConta, String nomeCliente) {
		super(numeroConta, nomeCliente);
		// TODO Auto-generated constructor stub
	}

	public ContaEspecial(String numeroConta, String nomeCliente, double limiteEspecial) {
		super(numeroConta, nomeCliente);
		this.limiteEspecial = limiteEspecial;
	}

	public double getlimiteEspecial() {
		return limiteEspecial;
	}

	@Override
		public void debito (double valor) {
			if (valor <= 0) {
				System.out.println("Valor inválido");
			} else if (valor <= saldo) {
			 System.out.println("");
			
			 double saldo; 
			 saldo = super.getSaldo();
			 
			 	saldo -= valor;
			 	super.debito(valor);
				
				
			} 
			else if(valor <= getSaldo() + getlimiteEspecial()) {
				System.out.println("Saldo em conta insuficiente para realizar a operação.");
				System.out.println("Utilizando " + (valor - getSaldo()) + " do limite especial.");
				if(valor > 0)
				{
					limiteEspecial -=(valor - getSaldo());
					super.debito(getSaldo());	
			}
				else {
					System.out.println("Seu limite é insuficiente");
				}
			}
			System.out.println("Seu limite atual é R$: " + getlimiteEspecial());
			realizarOperacao();
			}
			
}
