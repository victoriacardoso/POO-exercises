package arquivos;

import java.io.*;
import java.util.*;
import arquivos.GenericFilter;

public class Arquivo {
	private String caminhoArquivo;
	
	public Arquivo (String caminhoArquivo) {
		this.caminhoArquivo = caminhoArquivo;
	
	}
	
	public int buscarPalavras(String palavraInformada) throws Exception {
		FileInputStream file = new FileInputStream(caminhoArquivo);
		InputStreamReader isr = new InputStreamReader(file);
		BufferedReader br = new BufferedReader(isr);
		
		int ocorrencia = 0;
		String linha = br.readLine();
		String [] palavras;
		String palavraLowerCase;
						
		while(linha!= null) {
			palavras = linha.split(" "); 
		
			for (int i=0; i<palavras.length; i++) {
				palavraLowerCase = palavras[i].toLowerCase();
								
				if(palavraLowerCase.contains(palavraInformada.toLowerCase())) {
					ocorrencia++;
				}
			}
							
			linha = br.readLine();
		}
		return ocorrencia;
	
	}


	public void substituirPalavras(String palavra1, String palavra2) throws Exception {
		FileInputStream file = new FileInputStream(caminhoArquivo);
		InputStreamReader isr = new InputStreamReader(file);
		BufferedReader br = new BufferedReader(isr);
		
		
		String arquivoN = caminhoArquivo.replace(".txt", "_novo.txt");
		FileOutputStream arquivoNovo = new FileOutputStream(arquivoN);
		PrintStream outNovo = new PrintStream(arquivoNovo);
		
		String linha = br.readLine();
		while(linha!= null) {
			String linhaLowerCase = linha.toLowerCase();
						
			if(linhaLowerCase.contains(palavra1.toLowerCase())) {
				String novaPalavra = linhaLowerCase.replace(palavra1.toLowerCase(), palavra2);
				outNovo.println(novaPalavra);
			}
			else {
				outNovo.println(linha);
			}
							
			linha = br.readLine();
		}
						
	}
	public void listarArquivos() throws Exception {
		GenericFilter filtro = new GenericFilter();
		String [] list;
		filtro.add("txt");
		
		File path = new File(caminhoArquivo);
		
		if(path.getParent() == null) {
			path = new File(".");
			list = path.list(filtro);
		}
		else{
			list = path.getParentFile().list(filtro);
		}
		
		for (int i=0; i<list.length; ++i) {
			System.out.println( list[i] );
		}			
	}
}
