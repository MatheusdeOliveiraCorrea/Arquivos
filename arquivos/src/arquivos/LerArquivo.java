package arquivos;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class LerArquivo {

	
	public static void main(String[] args) throws FileNotFoundException {
		
		File arquivo = 
				new File("C:\\Users\\mathe\\git\\arquivos\\arquivos\\src\\arquivos\\arquivo.txt"); 
		
		FileInputStream entrada = new FileInputStream(arquivo);
		
		Scanner lerArquivo = new Scanner(entrada, "UTF-8");
		
		
		List<Pessoa> listaPessoas = new ArrayList<Pessoa>();
		
		
		
		while(lerArquivo.hasNext()) {
			
			String linha = lerArquivo.nextLine(); 
			
			
			if(linha != null && !linha.isEmpty()) {
				
				String[] dados = linha.split(";");
				
				
				Pessoa pessoa = new Pessoa(); 
				
				pessoa.setNome(dados[0]);
				pessoa.setEmail(dados[1]);
				pessoa.setIdade(Integer.parseInt(dados[2]));
				
				listaPessoas.add(pessoa);

			}
			
		}
	
	
		for(Pessoa pessoa: listaPessoas) {
		
		System.out.println(pessoa);
		
		}
	
	}
	
	
	
	
}

