package arquivos;

import java.io.*;
import java.util.*;

public class GenericFilter implements FilenameFilter {
	private Vector extensoes;
	
	public GenericFilter(){
		extensoes = new Vector();
	}
	public void add (String extensao) {
		extensoes.addElement(extensao);
	}
	public boolean accept (File dir, String name) {
		String f = (new File(name)).getName();
		int pos_ponto = f.indexOf(".");
		
		if( pos_ponto == -1 ) {
			return false;
		}
		else {
			for( int i=0; i<extensoes.size(); ++i) {
				String s = f.substring(pos_ponto+1,f.length());
				
				if( s.equalsIgnoreCase((String) extensoes.get(i))) {
					return true;
				}
			}
			return false;
		}
	}
}
