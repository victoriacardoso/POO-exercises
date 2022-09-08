import java.io.*;

public class Pessoa implements Serializable {
	private String nome;
	private String telefone;

	public Pessoa (String nome, String telefone) {
		this.nome = nome;
		this.telefone = telefone;
	}
	
	public String getNome() {
		return nome;
	}
	
	public String getTelefone() {
		return telefone;
	}

}
