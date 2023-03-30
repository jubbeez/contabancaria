package conta;

import java.util.Scanner;
import java.io.IOException;
import java.util.InputMismatchException;

import conta.controller.ContaController;
import conta.model.Conta;
import conta.model.ContaCorrente;
import conta.model.ContaPoupanca;
import conta.util.Cores;

public class Menu {

	public static void main(String[] args) {
		
		ContaController contas = new ContaController();
		
				
		Scanner leia = new Scanner (System.in);
		
		int opcao,numero,agencia,tipo,aniversario;
		String titular;
		float saldo,limite;
		
		System.out.println("\nCriar Contas\n");
		
		ContaCorrente cc1 = new ContaCorrente(contas.gerarNumero(),123, 1, "Julia", 1000f, 100.0f);
		contas.cadastrar(cc1);
		
		ContaPoupanca cp1 = new ContaPoupanca(contas.gerarNumero(),125, 2, "Erick", 8000f);
		contas.cadastrar(cp1);
		
		contas.listarTodas();
		
		while(true) {
			
			System.out.println(Cores.TEXT_YELLOW + Cores.ANSI_BLACK_BACKGROUND + 
					"*************************************************");
			System.out.println("                                                 ");
			System.out.println("    BANCO DO BRAZIL COM Z                        ");
			System.out.println("                                                 ");
			System.out.println("*************************************************");
			System.out.println("                                                 ");
			System.out.println("    1 - Criar conta                              ");
			System.out.println("    2 - Listar todas as contas                   ");
			System.out.println("    3 - Buscar conta por número                  ");
			System.out.println("    4 - Atualizar dados da conta                 ");
			System.out.println("    5 - Apagar conta                             ");
			System.out.println("    6 - Sacar                                    ");
			System.out.println("    7 - Depositar                                ");
			System.out.println("    8 - Transferir valores entre contas          ");
			System.out.println("    9 - Sair                                     ");
			System.out.println("                                                 ");
			System.out.println("*************************************************");
			System.out.println("Entre com a opção desejada:                      ");
			System.out.println("                                                 ");
			opcao = leia.nextInt();
			
			if(opcao == 9) {
				System.out.println(Cores.TEXT_WHITE_BOLD + "\nBanco do Brazil com Z - O seu Futuro começa aqui!");				leia.close();
				leia.close();
				System.exit(0);
			}
			
			switch (opcao) {
			case 1:
				System.out.println(Cores.TEXT_WHITE +"Criar Conta\n\n");
				
				System.out.println("Digite o número da agência: ");
				agencia = leia.nextInt();
				
				System.out.println("Digite o nome do titular: ");
				leia.skip("\\R?");
				titular = leia.nextLine();
				
				do {
					System.out.println("Digite o tipo da conta (1-CC ou 2-CP): ");
					tipo = leia.nextInt();
				}while(tipo <1 && tipo >2);
				
				System.out.println("Digite o saldo da conta: ");
				saldo = leia.nextFloat();
				
				switch(tipo) {
					case 1 -> {
						System.out.println("Digite o limite de crédito (R$): ");
						limite = leia.nextFloat();
						contas.cadastrar(new ContaCorrente(contas.gerarNumero(),agencia,tipo,titular,saldo,limite));
					}
					case 2 -> {
						System.out.println("Digite o dia do aniversario da conta: ");
						aniversario = leia.nextInt();
						contas.cadastrar(new ContaPoupanca(contas.gerarNumero(),agencia,tipo,titular,saldo));
					}
				}
				
				keyPress();
				break;
			case 2:
				System.out.println(Cores.TEXT_WHITE +"Listar todas as Contas\n\n");
				contas.listarTodas();
				keyPress();
				break;
			case 3:
				System.out.println(Cores.TEXT_WHITE +"Consultar dados da Conta - por número\n\n");
				keyPress();
				break;
			case 4:
				System.out.println(Cores.TEXT_WHITE +"Atualizar dados da Conta\n\n");

				break;
			case 5:
				System.out.println(Cores.TEXT_WHITE +"Apagar a Conta\n\n");
				keyPress();
				break;
			case 6:
				System.out.println(Cores.TEXT_WHITE +"Saque\n\n");
				keyPress();
				break;
			case 7:
				System.out.println(Cores.TEXT_WHITE +"Depósito\n\n");
				keyPress();
				break;
			case 8:
				System.out.println(Cores.TEXT_WHITE +"Transferência entre Contas\n\n");
				keyPress();
				break;
			default:
				System.out.println(Cores.TEXT_WHITE +"\nOpção Inválida!\n");
				break;
		}
	}

}
	public static void keyPress() {

		try {

			System.out.println(Cores.TEXT_RESET + "\n\nPressione Enter para Continuar...");
			System.in.read();

		} catch (IOException e) {

			System.out.println("Você pressionou uma tecla diferente de enter!");
		}
	}
}
