package contas;

public class ContaCorrente extends Conta {

	private final int MAXIMO_TALOES = 3;
	private int taloes;
	private final double PRECO_TALAO = 30.0;
	
	public ContaCorrente(String numeroConta, String nomeCliente) {
		super(numeroConta, nomeCliente);
		// TODO Auto-generated constructor stub
	}
	
	
	public int getMAXIMO_TALOES() {
		return MAXIMO_TALOES;
	}
	public int getTaloes() {
		return taloes;
	}
	public double getPRECO_TALAO() {
		return PRECO_TALAO;
	}
	public void setTaloes(int taloes) {
		this.taloes = taloes;
	}
	
	
	public void pedirTalao(char escolha) {
		
		if (escolha == 'S' && podePedirTalao()){

				taloes++;
				super.debito(getPRECO_TALAO());
				System.out.println ("Debitando em conta...");
				System.out.println ("Compra finalizada");
				
		}
	}
	
	public boolean podePedirTalao() {
		return getPRECO_TALAO() <= super.getSaldo() && getTaloes() < getMAXIMO_TALOES();
	}
	
	
	
}
