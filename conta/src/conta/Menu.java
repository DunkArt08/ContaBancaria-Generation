package conta;
import conta.util.Cores;
import java.util.Scanner;

public class Menu {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int opcao;
		
		Scanner leia = new Scanner(System.in);
		
		
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
			
			opcao = leia.nextInt();
			
			if(opcao == 9) {
				System.out.println(Cores.TEXT_WHITE_BOLD+"Banco do Brasiu com U - O seu futuro começa aqui");
				sobre();
				leia.close();
				System.exit(0);
			}
			
			switch (opcao) {
			case 1:
				System.out.println(Cores.TEXT_WHITE_BOLD+"Criar conta\n\n");
				
				break;
			case 2:
				System.out.println(Cores.TEXT_WHITE_BOLD+"Listar todas as contas\n\n");
				
				break;
			case 3:
				System.out.println(Cores.TEXT_WHITE_BOLD+"Consultar dados da conta - por numero\n\n");
				
				break;
			case 4:
				System.out.println(Cores.TEXT_WHITE_BOLD+"Atualizar dados da conta\n\n");
				
				break;
			case 5:
				System.out.println(Cores.TEXT_WHITE_BOLD+"Apagar conta\n\n");
				
				break;
			case 6:
				System.out.println(Cores.TEXT_WHITE_BOLD+"Saque\n\n");
				
				break;
			case 7:
				System.out.println(Cores.TEXT_WHITE_BOLD+"Depósito\n\n");
				
				break;
			case 8:
				System.out.println(Cores.TEXT_WHITE_BOLD+"Transferência entre contas\n\n");
				
				break;

			default:
				System.out.println(Cores.TEXT_RED_BOLD+"\nOpção inválida!\n");
				break;
			}
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

