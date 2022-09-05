import cadastro.Cliente;
import java.io.*;
import java.util.*;

public class Principal {
	public static void main(String[] args) {
		List<Cliente> clientes = new LinkedList<>();
		Scanner sc = new Scanner(System.in);
		String nome="", telefone=""; 
		
		do {		
			System.out.println("Informe o nome");
			nome = sc.nextLine();

			if(!nome.equalsIgnoreCase("fim")) {
				System.out.println("Informe o telefone");
				telefone = sc.nextLine();
				
			}
			if(!nome.equalsIgnoreCase("fim") && !telefone.equalsIgnoreCase("fim")) {
				clientes.add(new Cliente(nome, telefone));			

			}
			
		
		} while(!nome.equalsIgnoreCase("fim") && !telefone.equalsIgnoreCase("fim"));

		Iterator it = clientes.iterator();
		
		while(it.hasNext()) {
			Cliente cliente = (Cliente) it.next();
			System.out.println(cliente.getNome());
			System.out.println(cliente.getTelefone());
		}

		sc.close();
		
	
	} 




}
