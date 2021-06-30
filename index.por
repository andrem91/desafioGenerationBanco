programa
{
	inclua biblioteca Matematica

	inteiro numero
	real saldo = 0.00

	funcao mostrarSaldo() {
		escreva(saldo)
	}
	funcao debito(real valor) {
			saldo -= valor
	}
	funcao credito(real valor) {
		saldo += valor
	}
	funcao inicio() {
		caracter continuar = 'S'
		caracter operacao
		real valor = 0.0

		enquanto (continuar != 'N') {
			escreva("Saldo atual: R$")
			mostrarSaldo()
			escreva("\n")
			escreva("MOVIMENTO - D-debito ou C-Crédito: ")
			leia(operacao)
			se(operacao == 'D') {
				escreva("Debitar: R$")
				leia(valor)
				debito(valor)
			} senao se(operacao == 'C') {
				escreva("Creditar: R$")
				leia(valor)
				credito(valor)
			} senao {
				escreva("Opção invalida")
			}
			escreva("Saldo Atual: ")
			mostrarSaldo()
			escreva("\n")
			escreva("Continuar S/N: ")
			leia(continuar)
		}
	}

}
/* $$$ Portugol Studio $$$ 
 * 
 * Esta seção do arquivo guarda informações do Portugol Studio.
 * Você pode apagá-la se estiver utilizando outro editor.
 * 
 * @POSICAO-CURSOR = 823; 
 * @PONTOS-DE-PARADA = ;
 * @SIMBOLOS-INSPECIONADOS = ;
 * @FILTRO-ARVORE-TIPOS-DE-DADO = inteiro, real, logico, cadeia, caracter, vazio;
 * @FILTRO-ARVORE-TIPOS-DE-SIMBOLO = variavel, vetor, matriz, funcao;
 */