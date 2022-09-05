import java.util.*;

import arquivos.Arquivo;

public class Principal {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int opcao;
		
		try {
			System.out.println("Informe o caminho de um arquivo de texto.");
			String caminhoArquivo = sc.nextLine();
			
			Arquivo arquivo = new Arquivo(caminhoArquivo);
			
			do {
				System.out.println("O que deseja fazer?");
				System.out.println("1- Buscar palavra.");
				System.out.println("2- Substituir palavra.");
				System.out.println("3- Listar os arquivos");	
				System.out.println("0- Terminar");	
				opcao = sc.nextInt();
				
				switch(opcao) {
					case 1: 
						System.out.println("Informe a palavra.");
						String palavraInformada = sc.next();
						
						int ocorrencia = arquivo.buscarPalavras(palavraInformada);
						
						System.out.println("Número de ocorrências: " + ocorrencia);
						break;		
						
					case 2:
				
						System.out.println("Informe a palavra que deseja substituir.");
						String palavra1 = sc.next();	
						System.out.println("Informe a palavra nova.");
						String palavra2 = sc.next();	
						
						arquivo.substituirPalavras(palavra1, palavra2);
						
						System.out.println("Feito.");	
						break;
						

					
					case 3: 
						arquivo.listarArquivos();
						
						break;	 	
				}

			} while(opcao != 0);
			
			sc.close();
		} catch(Exception e) {
			System.out.println(e);
		}
	}





}
