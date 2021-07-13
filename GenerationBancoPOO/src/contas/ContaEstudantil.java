package contas;

public class ContaEstudantil extends Conta{
		
	private double limiteEspecial = 1000.0;
	
	
	public ContaEstudantil(String numeroConta, String nomeCliente) {
		super(numeroConta, nomeCliente);
		// TODO Auto-generated constructor stub
	}

	public ContaEstudantil(String numeroConta, String nomeCliente, double limiteEspecial) {
		super(numeroConta, nomeCliente);
		this.limiteEspecial = limiteEspecial;
	}



	public double getlimiteEspecial() {
		return limiteEspecial;
	}	
	
		public void saldoInsuficiente (double valor) {
			System.out.println("Saldo em conta insuficiente para realizar a operação.");
			valor = 0.0;
		
			if(valor <= getSaldo() + getlimiteEspecial()) {
				System.out.println("Utilizando " + (valor - getSaldo()) + " do limite especial.");
			
				if(valor > 0) {
					limiteEspecial -=(valor - getSaldo());
				}
				super.debito(getSaldo());
		}
			else {
				System.out.println("Seu limite é insuficiente");
			}
			System.out.println("Seu limite atual é R$: " + getlimiteEspecial());
	}

	
	
	
}
