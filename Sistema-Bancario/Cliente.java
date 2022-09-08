import java.util.*;

public class Cliente {
	private String nome; 
	private String email;
	private String telefone;
	List<Conta> contas;
	
	public Cliente(String nome, String email, String telefone) {
		contas = new LinkedList<>();
		this.nome = nome;
		this.email = email;
		this.telefone = telefone;
		
	}
	
	public String getNome() {
		return nome;
	}
	
	public void incluirConta(Conta c){
		this.contas.add(c);
	} 
	
	public double getSaldoGeral(){
		double saldoGeral = 0;
		
		for (Conta conta: contas){
			saldoGeral+= conta.getSaldo();
		}
		
		return saldoGeral;
	
	}


}
