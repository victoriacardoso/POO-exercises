import java.util.*;

public class Principal {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		List<Cliente> clientes = new LinkedList<>();
		Conta c = null;
		String opcao= "";

		
		try{
			do {				
				System.out.println("Informe o nome");
				String nome = sc.next();
				System.out.println("Informe o e-mail");
				String email = sc.next();
				System.out.println("Informe o telefone");
				String telefone = sc.next();
				
				Cliente cliente = new Cliente(nome, email, telefone);
				
				do {
					System.out.println("1- Conta corrente");
					System.out.println("2- Conta poupanca");
					int tipoConta = sc.nextInt();
					
					switch(tipoConta) {
						case 1: 
							c = new ContaCorrente(100);
							break;
						case 2: 
							c = new ContaPoupanca();
							break;
					
					}
					System.out.println("Valor do depósito:");
					c.depositar(sc.nextDouble());
					cliente.incluirConta(c);
					
					System.out.println("Conta criada com sucesso");
					System.out.println("Deseja criar outra conta para o mesmo cliente? (s/n)");
					opcao = sc.next();
				} while(opcao.equalsIgnoreCase("s"));
				
				clientes.add(cliente);
				
				System.out.println("\nDeseja criar outra cadastro? (s/n)");
				opcao = sc.next();
			
			} while (opcao.equalsIgnoreCase("s"));
			
			System.out.println("\n------RELATÓRIO------");
			Iterator<Cliente> it = clientes.iterator();
			
			while(it.hasNext()){
				Cliente cliente = (Cliente) it.next();
				System.out.println(cliente.getNome());
				System.out.println(cliente.getSaldoGeral());
			
			}
		
		sc.close();
		} catch (Exception e) {
		
		
		}
	
	
	}



}
