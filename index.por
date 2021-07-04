programa
{
	inclua biblioteca Util
	inclua biblioteca Matematica
	inclua biblioteca Tipos
	inclua biblioteca Texto 
	
	// ======== Conta ========
	
	inteiro numero = 0, contadorOperacoes = 0
	real saldo = 0.00
	inteiro codigo = 0
	const cadeia CONTAS[] = {"CONTA POUPANÇA", "CONTA CORRENTE", "CONTA ESPECIAL", "CONTA EMPRESA", "CONTA ESTUDANTIL"}

	funcao mostrarSaldo() {
		escreva("Saldo atual: R$" + saldo + "\n")

	}

	funcao logo(){
		escreva (">>>>>>>>>> G1 GENERATION BRASIL <<<<<<<<<<\n")
		escreva ("\tBuscando um futuro melhor\n\n\n")
		
	}
	
	funcao despedida(){
		limpa()
		logo()
		mostrarSaldo()
		Util.aguarde(2000)
		limpa()
		logo()
		escreva ("Finalizado\nAgradecemos a prefência\nVolte Sempre")
		Util.aguarde(1000)
		
	}
	
	funcao mostrarConta(inteiro codigoConta) {
		escreva(" ===== " + CONTAS[codigoConta - 1] + " =====")
		escreva("\nOperações realizadas: "+ contadorOperacoes + "\n")
		
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
	
	const inteiro DIAANIVERSARIOPOUPANCA = 37 //A data está no formato Dia/Mes

	funcao cadeia conversaoDiaMesAniversario (){ //Essa função é responsável por converter a data de aniversário para o tipo cadeia
		cadeia diaAniversarioPoupancaTexto 
		cadeia diaAniversarioTexto, mesAniversarioTexto
		
		diaAniversarioPoupancaTexto = Tipos.inteiro_para_cadeia(DIAANIVERSARIOPOUPANCA, 10)
		
		se(Texto.numero_caracteres(diaAniversarioPoupancaTexto) == 2){
			caracter diaAniversario = Texto.obter_caracter(diaAniversarioPoupancaTexto, 0)
			caracter mesAniversario = Texto.obter_caracter(diaAniversarioPoupancaTexto, 1)

			diaAniversarioTexto = "0" + Tipos.caracter_para_cadeia(diaAniversario)
			mesAniversarioTexto = "0" + Tipos.caracter_para_cadeia(mesAniversario)
			diaAniversarioPoupancaTexto = diaAniversarioTexto + "/" + mesAniversarioTexto

			retorne diaAniversarioPoupancaTexto
			
		}senao{
			caracter diaAniversario1 = Texto.obter_caracter(diaAniversarioPoupancaTexto, 0)
			caracter diaAniversario2 = Texto.obter_caracter(diaAniversarioPoupancaTexto, 1)
			caracter mesAniversario1 = Texto.obter_caracter(diaAniversarioPoupancaTexto, 2)
			caracter mesAniversario2 = Texto.obter_caracter(diaAniversarioPoupancaTexto, 3)

			diaAniversarioTexto = Tipos.caracter_para_cadeia(diaAniversario1) + Tipos.caracter_para_cadeia(diaAniversario2 )
			mesAniversarioTexto = Tipos.caracter_para_cadeia(mesAniversario1) + Tipos.caracter_para_cadeia(mesAniversario2)
			diaAniversarioPoupancaTexto = diaAniversarioTexto + "/" + mesAniversarioTexto

			retorne diaAniversarioPoupancaTexto
			
		}
		
	}
	
	funcao contaPoupanca(){
		cadeia dataDigita
		inteiro numeroCaracteres
		logico Verdade = verdadeiro

		enquanto(Verdade){
			escreva("Informe a data [DD/MM]: ")
			leia(dataDigita)
		
			numeroCaracteres = Texto.numero_caracteres(dataDigita)
		
			se(numeroCaracteres == 5 e Texto.obter_caracter(dataDigita, 2) == '/'){
				se(dataDigita == conversaoDiaMesAniversario()){
					saldo = saldo + 0.05*saldo
					
				}
				
				mostrarSaldo()
				pare
			
			}senao{
				escreva("\nEntrada inválida! Por favor, informe uma entrada válida.\n\n")
				Util.aguarde(1500)
				
			}
			
		}
				
	}
	
	// ======== Fim Conta Poupança ========
	
	// ======== Conta Corrente ========
	
	const inteiro LIMITE_TALAO = 3
	const real CUSTO_TALAO = 30.00
	inteiro talao = 0
	caracter pedirTalao = 'S'
	
	funcao contaCorrente(){
		enquanto (pedirTalao == 's' ou pedirTalao == 'S'){
			limpa()
			logo()
			mostrarSaldo()
			
			escreva("\nTALÕES DE CHEQUE\n")
			escreva("\nTalões pedidos: " + talao + "\nlimites de talão no mês: " + LIMITE_TALAO)
			escreva("\nCusto: R$" + CUSTO_TALAO)
			escreva("\nDeseja pedir um talão de cheque?S/N: ")
			leia(pedirTalao)
			
			limpa()
			logo()
			
			se (CUSTO_TALAO <= saldo){
				se ((pedirTalao == 's' ou pedirTalao == 'S')){
					talao++
					debito(CUSTO_TALAO)
					escreva ("Fazendo pedido de talão\n")
					escreva ("Debitando em conta...\n")
					Util.aguarde(2000)
					escreva ("Compra finalizada\n")
					Util.aguarde(1000)
					
					se (talao >= LIMITE_TALAO){
						escreva ("Limite de talões atingido\n")
						escreva ("Finalizando operação...\n")
						Util.aguarde(2000)
						pare
						
					}
					
				}
				
			} senao {
				escreva ("Não há saldo em conta para comprar talão de cheque\n")
				escreva ("Finalizando operação...\n")
				Util.aguarde(2000)
				pare
				
			}
			
		}
		
		limpa()
		logo()
		
		escreva ("Finalizando módulo de cheque...")
		Util.aguarde(2000)
		
	}
	
	// ======== Fim Conta Corrente ========
	
	// ======== Conta Especial ========
	
	real limiteEspecial = 1000.0
	
	funcao contaEspecial(real valor) {
		escreva("Saldo em conta insuficiente para realizar a operação.\n")
	
		se(valor <= saldo + limiteEspecial){
			escreva("Utilizando " + (valor - saldo) + " do limite especial.\n")
			limiteEspecial-=(valor - saldo)
			debito(saldo)
			
		}
		senao{
			escreva("Seu limite é insuficiente.")
			
		}
		escreva("Seu limite atual é R$ "+ limiteEspecial +".\n")
		
	}
	
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
			
	real valorMaximoEstudantil=5000.00, valorSolicitado=0.0
	caracter usarEmprestimo
				
	funcao contaEstudantil()
	{
		escreva("Caro estudante, você tem R$ " +valorMaximoEstudantil+ " liberados para empréstimo.\n")
		escreva("Deseja utilizar(S/N)?: ") 
		leia(usarEmprestimo)

		se(usarEmprestimo == 'S' ou usarEmprestimo == 's') {
		escreva("Valor do emprestimo: R$")
		leia(valorSolicitado)
		
		se (valorSolicitado <= valorMaximoEstudantil) {
			saldo += valorSolicitado
			valorMaximoEstudantil -= valorSolicitado
			
		} senao {
			escreva("Valor invalido. Emprestimo não concluido.\n")
			escreva("Caro estudante, o valor solicitado é maior que o disponivel.\n")
			
		}
		mostrarSaldo()
		
		}
		
	}
		
	// ======== Fim Conta Estudantil ========

	// ======== Inicio do programa ========
	funcao inicio() {
		caracter continuar = 'S'
		caracter operacao
		real valor = 0.0
		
		faca {
			pedirTalao = 'S'
			limiteEspecial = 1000.0
			talao = 0
			saldo = 0.00
			contadorOperacoes = 0
			continuar = 'S'
			limpa()
			logo()
			escreva("1 - CONTA POUPANÇA\n")
			escreva("2 - CONTA CORRENTE\n")
			escreva("3 - CONTA ESPECIAL\n")
			escreva("4 - CONTA EMPRESA\n")
			escreva("5 - CONTA ESTUDANTIL\n")
			escreva("6 - SAIR\n\n")
	
			escreva("DIGITE O CODIGO DA OPÇÃO SELECIONADA: ")
			leia(codigo)
			
			se (codigo < 1 ou codigo > 6){
				limpa()
				logo()
				escreva ("Opção invalida\n")
				
			}
		
			enquanto (continuar != 'N' e continuar != 'n' e codigo != 6 e contadorOperacoes < 10) {
				limpa()
				logo()
				mostrarConta(codigo)
				mostrarSaldo()
				escreva("MOVIMENTO - D-debito ou C-Crédito: ")
				leia(operacao)
				
				se(operacao == 'D' ou operacao == 'd') {
					escreva("Debitar: R$")
					leia(valor)
					
					se (codigo ==3 e valor > saldo){
						contaEspecial(valor)
						
					}senao{
						debito(valor)	
						
					}
					
				} senao se(operacao == 'C' ou operacao == 'c') {
					escreva("Creditar: R$")
					leia(valor)
					credito(valor)
					
				} senao {
					escreva("Opção invalida\n")
					
				}
				
				contadorOperacoes++
				mostrarSaldo()
				
				// ==== Conta Poupança ====
				
				se(codigo == 1) {
					contaPoupanca()
					
				}
	
				// ==== Fim Poupança ====
	
				// ===== Inicio Conta Empresa =====
				
				se(codigo == 4) {
					contaEmpresa()
					
				}
	
				// ===== Fim Conta Empresa =====
				
				// ===== Inicio conta Estudantil ====
				
				se(codigo == 5){
					contaEstudantil()
				
				}
				
				//===== Fim conta Estudantil ====	
				
				se (contadorOperacoes >= 10){
					limpa()
					logo()
					mostrarSaldo()
					escreva ("limite de operações atingido\n")
					Util.aguarde(2000)
					pare
					
				}
				
				escreva("Continuar S/N: ")
				leia(continuar)
	
			}
			
			// ==== Conta Corrente ====
			
			se (codigo == 2){
				contaCorrente()
				
			}
			
			// ==== Fim Corrente ====
			
			limpa()
			escreva ("Saindo da Conta...\n")
			Util.aguarde(2000)
			
		} enquanto (codigo != 6)
		
		despedida()
	
	}
		
	// ======== Fim do programa ========
}
/* $$$ Portugol Studio $$$ 
 * 
 * Esta seção do arquivo guarda informações do Portugol Studio.
 * Você pode apagá-la se estiver utilizando outro editor.
 * 
 * @POSICAO-CURSOR = 7380; 
 * @PONTOS-DE-PARADA = ;
 * @SIMBOLOS-INSPECIONADOS = ;
 * @FILTRO-ARVORE-TIPOS-DE-DADO = inteiro, real, logico, cadeia, caracter, vazio;
 * @FILTRO-ARVORE-TIPOS-DE-SIMBOLO = variavel, vetor, matriz, funcao;
 */