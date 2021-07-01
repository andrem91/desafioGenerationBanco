programa
{

	inclua biblioteca Matematica
	
	// ======== Conta ========
	inteiro numero = 0
	real saldo = 0.00

	funcao mostrarSaldo() {
		escreva("Saldo atual: R$" + saldo + "\n")
	}

	
	funcao debito(real valor) {
		se (valor <= saldo) {
			saldo -= valor
		} senao {
			escreva("Saldo insuficiente.\n")
		}
	}
	funcao credito(real valor) {
		saldo += valor
	}
	// ======== Fim Conta ========
	// ======== Conta Poupança ========
	

	
	// ======== Fim Conta Poupança ========
	// ======== Conta Especial ========

	
	
	// ======== Fim Conta Especial ========
	// ======== Conta Empresa ========
	
	real valorMaximo = 10000.00, valorEmprestimo = 0.0
	caracter aceitarEmprestimo = 'N'
	
	funcao contaEmpresa() {
		escreva("Você tem R$" + valorMaximo + " liberados para emprestimo.\n")
		escreva("Deseja utilizar(S/N)? ")
		leia(aceitarEmprestimo)
		se(aceitarEmprestimo == 'S' ou aceitarEmprestimo == 's') {
			escreva("Valor do emprestimo: R$")
			leia(valorEmprestimo)
			se (valorEmprestimo <= valorMaximo) {
				saldo += valorEmprestimo
				valorMaximo -= valorEmprestimo
			} senao {
				escreva("Valor invalido. Emprestimo não concluido.\n")
			}
			mostrarSaldo()
		}
	}
	// ======== Fim Conta Empresa ========
	// ======== Conta Estudantil ========



	// ======== Fim Conta Estudantil ========

	// ======== Inicio do programa ========
	funcao inicio() {

		inteiro codigo = 0
		caracter continuar = 'S'
		caracter operacao
		real valor = 0.0
		
		faca {

			escreva("1 - CONTA POUPANÇA\n")
			escreva("2 - CONTA CORRENTE\n")
			escreva("3 - CONTA ESPECIAL\n")
			escreva("4 - CONTA EMPRESA\n")
			escreva("5 - CONTA ESTUDANTIL\n")
			escreva("6 - SAIR\n")
	
			escreva("DIGITE O CODIGO DA OPÇÃO SELECIONADA: ")
			leia(codigo)
			se (codigo < 1 ou codigo > 6){
				limpa()
				escreva ("Opção invalida\n")
			}
		} enquanto (codigo < 1 ou codigo > 6)
		
		enquanto (continuar != 'N' e continuar != 'n' e codigo != 6) {
			limpa()
			mostrarSaldo()
			escreva("MOVIMENTO - D-debito ou C-Crédito: ")
			leia(operacao)
			se(operacao == 'D' ou operacao == 'd') {
				escreva("Debitar: R$")
				leia(valor)
				debito(valor)
			} senao se(operacao == 'C' ou operacao == 'c') {
				escreva("Creditar: R$")
				leia(valor)
				credito(valor)
			} senao {
				escreva("Opção invalida")
			}
			mostrarSaldo()

			// ===== Conta Empresa =====
			se(codigo == 4) {
				contaEmpresa()
			}
			// ===== Conta Empresa =====
			
			escreva("Continuar S/N: ")
			leia(continuar)
		}
	}
	// ======== Fim do programa ========
}
/* $$$ Portugol Studio $$$ 
 * 
 * Esta seção do arquivo guarda informações do Portugol Studio.
 * Você pode apagá-la se estiver utilizando outro editor.
 * 
 * @POSICAO-CURSOR = 1820; 
 * @PONTOS-DE-PARADA = ;
 * @SIMBOLOS-INSPECIONADOS = ;
 * @FILTRO-ARVORE-TIPOS-DE-DADO = inteiro, real, logico, cadeia, caracter, vazio;
 * @FILTRO-ARVORE-TIPOS-DE-SIMBOLO = variavel, vetor, matriz, funcao;
 */