package ApachePOI;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;

import arquivos.Pessoa;

public class ApachePoi {
	/*
	 * Objetivo:
	 * Criar um documento xls ( excel ) separando os atributos do objeto
	 * Pessoa em colunas 
	 */

	public static void main(String[] args) throws IOException {
		
		File arquivo = 
		new File("C:\\Users\\mathe\\git\\arquivos\\arquivos\\src\\ApachePOI\\Excel ApachePOI.xls");
		
		if (!arquivo.exists()) {
			arquivo.createNewFile();	
			
		}
		
		Pessoa pessoa1 = new Pessoa("Matheus", "matheus-email.com" , 17 );
		Pessoa pessoa2 = new Pessoa("Paulo", "paulo-gmailgames.com", 22);
		Pessoa pessoa3 = new Pessoa("Carlos", "carluxo17.com", 35 );
		Pessoa pessoa4 = new Pessoa("Maurício", "mauriio@mark.org" , 29);
		Pessoa pessoa5 = new Pessoa("Pedro ", "pedrohenrique@gmail.com" , 41);
		
		List<Pessoa> pessoas = new ArrayList<Pessoa>();
		
		pessoas.add(pessoa1); 
		pessoas.add(pessoa2); 
		pessoas.add(pessoa3);  
		pessoas.add(pessoa4);
		pessoas.add(pessoa5);

		/*****  Apache POI  ******/

		HSSFWorkbook hssfWorkbook = new HSSFWorkbook(); 
		HSSFSheet linhasPessoa = hssfWorkbook.createSheet("Planilha"); 
		

		int numeroLinha = 0;

		for(Pessoa p : pessoas) {
			
			Row linha = linhasPessoa.createRow(numeroLinha++);
			
			int celula = 0;
			
			Cell celNome = linha.createCell(celula ++);			
			celNome.setCellValue(p.getNome());
			
			Cell celEmail = linha.createCell(celula ++);			
			celEmail.setCellValue(p.getEmail());
			
			Cell celIdade = linha.createCell(celula ++);			
			celIdade.setCellValue(p.getIdade());
	
		}
		
		FileOutputStream saida = new FileOutputStream(arquivo);
		
		hssfWorkbook.write(saida);
		saida.flush();
		saida.close();
		
		System.out.println("criado");
		
	}

}
