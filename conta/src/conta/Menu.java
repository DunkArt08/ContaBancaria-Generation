package conta;
import conta.util.Cores;

import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

import conta.controller.ContaController;
import conta.model.Conta;
import conta.model.ContaCorrente;
import conta.model.ContaPoupanca;

public class Menu {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		ContaController contas = new ContaController();
		
		int opcao, numero, agencia, tipo, aniversario, numeroDestino;
		String titular;
		float saldo, limite, valor;
		Scanner leia = new Scanner(System.in);
		
		System.out.println("Criar contas \n");
		
		ContaCorrente cc1 = new ContaCorrente(contas.gerarNumero(), 123, 1, "Son Goku", 8001, 200.0f);
		contas.cadastrar(cc1);
		ContaCorrente cc2 = new ContaCorrente(contas.gerarNumero(), 456, 1, "Vegetta", 8000, 200.0f);
		contas.cadastrar(cc2);
		
		ContaPoupanca cp1 = new ContaPoupanca(contas.gerarNumero(), 789, 2, "Lebron James", 2300, 10);
		contas.cadastrar(cp1);
		ContaPoupanca cp2 = new ContaPoupanca(contas.gerarNumero(), 101, 2, "Max Verstappen", 2000, 11);
		contas.cadastrar(cp2);
		
		while(true) {
			System.out.println(Cores.TEXT_YELLOW_BOLD + Cores.ANSI_BLACK_BACKGROUND
								+"**************************************************************************************");
			System.out.println("                                                                                      ");
			System.out.println("                        Banco do Brasiu com U                                         ");
			System.out.println("                                                                                      ");
			System.out.println("**************************************************************************************");
			System.out.println("                        1 - Criar Conta                                               ");
			System.out.println("                        2 - Listar todas as Contas                                    ");
			System.out.println("                        3 - Buscar conta por numero                                   ");
			System.out.println("                        4 - Atualizar dados da conta                                  ");
			System.out.println("                        5 - Apagar Conta                                              ");
			System.out.println("                        6 - Sacar                                                     ");
			System.out.println("                        7 - Depositar                                                 ");
			System.out.println("                        8 - Tranferir valores entre conta                             ");
			System.out.println("                        9 - Sair                                                      ");
			System.out.println("                                                                                      ");
			System.out.println("**************************************************************************************");
			System.out.println("Entre com a opção desejada:                                                           ");
			System.out.println("                                                                                      "+ Cores.TEXT_RESET);
			
			try {
			opcao = leia.nextInt();
			} catch (InputMismatchException e) {
				System.out.println("\nDigite valores inteiros!");
				leia.nextLine();
				opcao = 0;
			}
			
			if(opcao == 9) {
				System.out.println(Cores.TEXT_WHITE_BOLD+"Banco do Brasiu com U - O seu futuro começa aqui");
				sobre();
				leia.close();
				System.exit(0);
			}
			
			switch (opcao) {
			case 1:
				System.out.println(Cores.TEXT_WHITE_BOLD+"Criar conta\n\n");
				
				System.out.println("Digite o numero da agência: ");
				agencia = leia.nextInt();
				System.out.println("Digite o nome do titular: ");
				leia.skip("\\R?");
				titular = leia.nextLine();
				
				do {
					System.out.println("Digite o tipo  da conta (1-CC ou 2-CP): ");
					tipo = leia.nextInt();
				}while(tipo < 1 && tipo > 2);
				
				System.out.println("Digite o saldo da conta: ");
				saldo = leia.nextFloat();
				
				switch (tipo) {
				case 1 -> {
					System.out.println("Digite o limite de crédito (R$): ");
					limite = leia.nextFloat();
					contas.cadastrar(new ContaCorrente(contas.gerarNumero(), agencia, tipo, titular, saldo, limite));
					}
				case 2 -> {
					System.out.println("Digite a data de aniversário: ");
					aniversario = leia.nextInt();
					contas.cadastrar(new ContaPoupanca(contas.gerarNumero(), agencia, tipo, titular, saldo, aniversario));
					}
				}
				
				keyPress();
				break;
			case 2:
				System.out.println(Cores.TEXT_WHITE_BOLD+"\nListar todas as contas");
				contas.ListarTodas();
				keyPress();
				break;
			case 3:
				System.out.println(Cores.TEXT_WHITE_BOLD+"Consultar dados da conta - por numero\n\n");
				System.out.println("Digite o numero da conta: ");
				numero = leia.nextInt();	
				
				contas.procurarPorNumero(numero);
				
				keyPress();
				break;
			case 4:
				System.out.println(Cores.TEXT_WHITE_BOLD+"Atualizar dados da conta\n\n");
				
				System.out.println("Digite o número da conta: ");
				numero = leia.nextInt();
				
				var buscaConta = contas.buscarNaCollection(numero);
				
				if(buscaConta != null) {
					
					tipo = buscaConta.getTipo();
					
					System.out.println("Digite o numero da agencia: ");
					agencia = leia.nextInt();
					System.out.println("Digite o titular da conta: ");
					leia.skip("\\R?");
					titular = leia.nextLine();
					
					System.out.println("Digite o saldo da conta (R$) : ");
					saldo = leia.nextFloat();
					
					switch (tipo) {
						case 1 -> { System.out.println("Digite o limite de credito: ");
								limite = leia.nextFloat();
								
								contas.atualizar(new ContaCorrente(numero, agencia, tipo, titular, saldo, limite));
						}
						case 2 -> { System.out.println("Digite a data de aniversário: ");
								aniversario = leia.nextInt();
								
								contas.atualizar(new ContaPoupanca(numero, agencia, tipo, titular, saldo, aniversario));
						}
						default -> { 
						System.out.println("Tipo de conta inválido!");
						}
					}
					
				}else {
					System.out.println("Conta não foi encontrada!");
				}
				
				keyPress();
				break;
			case 5:
				System.out.println(Cores.TEXT_WHITE_BOLD+"Apagar conta\n\n");
				
				System.out.println("Digite o número da conta: ");
				numero = leia.nextInt();
				
				contas.deletar(numero);
				
				keyPress();
				break;
			case 6:
				System.out.println(Cores.TEXT_WHITE_BOLD+"Saque\n\n");
				
				System.out.println("Digite o numero da conta:");
				numero = leia.nextInt();
				
				do {
					System.out.println("Digite o valor do saque (R$): ");
					valor = leia.nextFloat();
				}while(valor <= 0);
				
				contas.sacar(numero, valor);
					
				keyPress();
				break;
			case 7:
				System.out.println(Cores.TEXT_WHITE_BOLD+"Depósito\n\n");
				
				System.out.println("Digite o numero da conta: ");
				numero = leia.nextInt();
				
				do {
					System.out.println("Digite o valor do depósito (R$) : ");
					valor = leia.nextFloat();
				}while(valor <=0);
				
				contas.depositar(numero, valor);
				
				keyPress();
				break;
			case 8:
				System.out.println(Cores.TEXT_WHITE_BOLD+"Transferência entre contas\n\n");
				
				System.out.println("Digite o numero da conta origem: ");
				numero = leia.nextInt();
				System.out.println("Digite o numero da conta Destino: ");
				numeroDestino = leia.nextInt();
				
				do {
					System.out.println("Digite o valor da transferencia: ");
					valor = leia.nextFloat();
				}while(valor <=0);
				
				contas.transferir(numero, numeroDestino, valor);
				
				keyPress();
				break;

			default:
				System.out.println(Cores.TEXT_RED_BOLD+"\nOpção inválida!\n");
				keyPress();
				break;
			}
		}
		}
	
		public static void keyPress() {
			try {
				System.out.println(Cores.TEXT_RESET + "\n\nPressione Enter para continuar....;");
				System.in.read();
			} catch (IOException e) {
				System.out.println("Você pressionou uma tecla diferente de Enter!");
			}
		}
	
	
			
		public static void sobre() {
				System.out.println("\n************************************************************************************\n");
				System.out.println("Projeto desenvolvido por: Daniel Lopes");
				System.out.println("email para contato: daniellucaspc@hotmail.com");
				System.out.println("https://github.com/DunkArt08");
				System.out.println("\n************************************************************************************\n");
	}
	}


