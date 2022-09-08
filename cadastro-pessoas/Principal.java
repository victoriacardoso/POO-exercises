import java.util.*;
import java.io.*;

public class Principal {
	public static void main(String[] args) {
		HashMap<Integer, Pessoa> pessoas = new HashMap<>();
		Scanner sc = new Scanner(System.in);
		int opcao;
		
		try {
			File arquivo = new File("pessoas.dat");
			
			if(arquivo.exists()) {
				FileInputStream file_l = new FileInputStream("pessoas.dat");
				ObjectInputStream in = new ObjectInputStream(file_l);
				
				pessoas = (HashMap) in.readObject();
			}
			
			do {
				System.out.println("Escolha uma opção: ");
				System.out.println("1- Cadastrar pessoa.");
				System.out.println("2- Consultar pessoa.");
				System.out.println("3- Finalizar.");
				opcao = sc.nextInt();
				
				switch(opcao) {
					case 1: 
						System.out.println("Informe o código de indexação");
						int codigo = sc.nextInt();
						
						System.out.println("Informe o nome");
						String nome = sc.next();
						
						System.out.println("Informe o telefone");
						String telefone = sc.next();
						
						pessoas.put(codigo, new Pessoa(nome, telefone));
						
						break;
					
					case 2:
						if(pessoas.size() == 0) {
							System.out.println("Não há pessoas cadastradas");
						}
						else{
							System.out.println("Lista de códigos");
							System.out.println(pessoas.keySet());
							

							
							System.out.println("Informe o código da pessoa que deseja buscar.");
							codigo = sc.nextInt();
							
							System.out.println("Nome: " + pessoas.get(codigo).getNome());
							System.out.println("Telefone: " + pessoas.get(codigo).getTelefone());
						}
						
						break;
						
					case 3:
						FileOutputStream file = new FileOutputStream("pessoas.dat");
						ObjectOutputStream out = new ObjectOutputStream(file);
						
						out.writeObject(pessoas);
						out.close(); 	
						
						break;
				}	
				
			
			} while(opcao != 3);
		
		} catch(Exception e) {
			System.out.println(e);
		}
		
	
	
		sc.close();
	}



}
