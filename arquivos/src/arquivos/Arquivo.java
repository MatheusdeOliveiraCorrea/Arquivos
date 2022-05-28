package arquivos;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class Arquivo {

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
	File("C:\\Users\\mathe\\Documents\\JavaWeb\\arquivos\\src\\arquivos\\arquivo.txt"); 
		
		if(!arquivo.exists()) {
			arquivo.createNewFile(); //se arquivo não existir, cria-se um.
		}
		
		
		//Classe para escrever em um arquivo
		FileWriter escrever = new FileWriter(arquivo);
		
		
		/*
		 * For each escrevendo o nome e a idade das pessoas que estão na lista
		 * e suas respectivas idades 
		 */
		for (Pessoa pessoa : pessoas) {
			
			//escrever.write(" email: " + pessoa.getEmail() + " \n");
			escrever.write("\n Nome: " + pessoa.getNome() + "; Idade: " + pessoa.getIdade()
			+ "; Email: " + pessoa.getEmail());
			
		}
		

		
		escrever.flush();
		escrever.close();

		
	}
	

}
