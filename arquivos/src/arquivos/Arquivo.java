package arquivos;

import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;


public class Arquivo {
	
	/*
	 * Objetivo: 
	 * Escrever dados de um objeto em um arquivo txt
	 */

	public static void main(String[] args) throws IOException {
		
		
		
		// Três objetos Pessoa com nome, email e idade 
		Pessoa pessoa1 = new Pessoa("Matheus", "matheus-email.com" , 17 );
		Pessoa pessoa2 = new Pessoa("Paulo", "paulo-gmailgames.com", 22);
		Pessoa pessoa3 = new Pessoa("Carlos", "carluxo17.com", 35 );
		
		
		
		/*Pode vir de um banco de dados ou qualquer lugar */ 
		List<Pessoa> pessoas = new ArrayList<Pessoa>();
		
		/*
		 * Adciona os objetos a uma Lista 
		 */
		pessoas.add(pessoa1); 
		pessoas.add(pessoa2);
		pessoas.add(pessoa3);  
		
		
		
		
		//busca um arquivo
		File arquivo = new 
	File("C:\\Users\\mathe\\git\\arquivos\\arquivos\\src\\arquivos\\arquivo.csv"); 
		
		
		
		//verificar se o arquivo exite ou não
		if(!arquivo.exists()) {
			arquivo.createNewFile(); //se arquivo não existir, cria-se um.
		}
		
		
		//Classe para escrever em um arquivo
		OutputStreamWriter escrever = new OutputStreamWriter(new FileOutputStream(arquivo));
		
		
		/*
		 * For each escrevendo o nome e a idade das pessoas que estão na lista
		 * e suas respectivas idades 
		 */
		for (Pessoa pessoa : pessoas) {
			
			//escrever.write(" email: " + pessoa.getEmail() + " \n");
			escrever.write(pessoa.getNome() + ";" + pessoa.getEmail()+";"+ pessoa.getIdade()+ "\n" );
			
			
		}
		

		
		escrever.flush();
		escrever.close();

		
	}
	

}
