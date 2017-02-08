package com.indra.cursojava.classes;
import java.util.Scanner;

public class A10_main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner entrada = new Scanner(System.in);
		
		ContaCorrente cc = new ContaCorrente();
		cc.setSenha(1234);
		cc.setAgencia(4322);
		cc.setNumero(3696);
		cc.setLimite(1000.0);
		
		Poupanca cp = new Poupanca();
		
		int senha=0;
		boolean verifica=false, sair=false, pass=true, sair_transacao=false;
		double dinheiro=0.0;
		
		System.out.println("Sistema do banco");
		System.out.print("Digite seu nome de usuário: ");
		String nome = entrada.next();
		
		System.out.println("\nOlá, @"+nome+"! \n");
		while(pass)
		{
			System.out.print("Digite sua senha para prosseguir: ");
			senha = entrada.nextInt();
			
			verifica = cc.autentica(senha);
			
			if(verifica)
			{
				System.out.println("Acesso permitido"); 
				pass = false;
			}
			else
			{
				System.out.println("Acesso negado!\n");
				pass = true;
			}
		}
		
		do
		{
			System.out.println("\n\nNome: "+nome+" - Agência: "+cc.getAgencia()+" - Conta: "+cc.getNumero());
			
			System.out.println("Qual conta você deseja acessar? ");
			System.out.println("1 - Conta Corrente");
			System.out.println("2 - Conta Poupança");
			System.out.println("3 - Sair");
			
			int opcao_conta = entrada.nextInt();
			
			switch (opcao_conta) 
			{
				case 1:
					do
					{
						sair_transacao = false;
						System.out.println("\nSelecione a transação desejada");
						System.out.println("1 - Depósito");
						System.out.println("2 - Saque");
						System.out.println("3 - Sair");
						
						int opcao_transacao = entrada.nextInt();
						
						switch (opcao_transacao) 
						{
							case 1:
								System.out.print("Digite o valor a ser depositado: ");
								dinheiro = entrada.nextDouble();
								cc.deposita(dinheiro);
								System.out.println("Saldo Atual: "+cc.getSaldo());
								break;
								
							case 2:
								System.out.print("Digite o valor a ser sacado: ");
								dinheiro = entrada.nextDouble();
								cc.saca(dinheiro);
								System.out.println("Saldo Atual: "+cc.getSaldo());
								break;
							
							case 3:
								System.out.print("Deseja realmente sair? <s/n> ");
								
								String s = entrada.next();
								char sel = s.charAt(0);
								
								if(sel=='s')
								{
									sair_transacao = true;
								}
								else
								{
									sair_transacao = false;
								}
								break;
								
							default:
								System.out.println("Opção inválida!");
								sair_transacao = false;
								break;
						}
					} while(!sair_transacao);
					break;
					
				case 2:
					do
					{
						sair_transacao = false;
						System.out.println("\nSelecione a transação desejada");
						System.out.println("1 - Depósito");
						System.out.println("2 - Saque");
						System.out.println("3 - Sair");
						
						int opcao_transacao = entrada.nextInt();
						
						switch (opcao_transacao) 
						{
							case 1:
								System.out.print("Digite o valor a ser depositado: ");
								dinheiro = entrada.nextDouble();
								System.out.println("Saldo Atual: "+cp.deposita(dinheiro));
								break;
								
							case 2:
								System.out.print("Digite o valor a ser sacado: ");
								dinheiro = entrada.nextDouble();
								System.out.println("Saldo Atual: "+cp.saca(dinheiro));
								break;
							
							case 3:
								System.out.print("Deseja realmente sair? <s/n> ");
								
								String s = entrada.next();
								char sel = s.charAt(0);
								
								if(sel=='s')
								{
									sair_transacao = true;
								}
								else
								{
									sair_transacao = false;
								}
								break;
								
							default:
								System.out.println("Opção inválida!");
								sair_transacao = false;
								break;
						}
					} while(!sair_transacao);
						
					break;

				case 3:
					System.out.print("Deseja realmente sair? <s/n> ");
					
					String s = entrada.next();
					char sel1 = s.charAt(0);
					
					if(sel1=='s')
					{
						sair = true;
					}
					else
					{
						sair = false;
					}
					break;
			
				default:
					System.out.println("Opção inválida!");
					break;
			}
			
		} while(!sair);
		
		entrada.close();
	}	
}
