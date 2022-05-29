package ApachePOI;

import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import arquivos.Pessoa;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;

public class LerArquivo {
	
	/*
	 * Objetivo:
	 * Ler arquivo xls 
	 */

	public static void main(String[] args) throws Exception {
		
		File file = 
		new File("C:\\Users\\mathe\\git\\arquivos\\arquivos\\src\\ApachePOI\\Excel ApachePOI.xls");
		
		FileInputStream entrada = new FileInputStream(file);
		
		
		HSSFWorkbook hssfWorkbook = new HSSFWorkbook(entrada);
		HSSFSheet planilha = hssfWorkbook.getSheetAt(0);
		
		
		Iterator<Row> linhaInterator = planilha.iterator();
		
		List<Pessoa> pessoas = new ArrayList<Pessoa>();
		
		while(linhaInterator.hasNext()){
			
			Row linha = linhaInterator.next();
			
			Iterator<Cell> celulas = linha.iterator();
			  
			  Pessoa pessoa = new Pessoa();
			  
			  while (celulas.hasNext()) { /*Percorrer as celulas*/
				   Cell cell = celulas.next();
				   
				   switch (cell.getColumnIndex()) {
				   case 0:
					   pessoa.setNome(cell.getStringCellValue());
					   break;
				   case 1:
					   pessoa.setEmail(cell.getStringCellValue());
					   break;
				   case 2:
					   pessoa.setIdade(Double.valueOf(cell.getNumericCellValue()).intValue());
					   break;
				   }
				   
			  }/*Fim das celular da linha*/
			  
			  pessoas.add(pessoa);
			
		}
		
	    entrada.close();/*Terminou de ler o arquivo excel*/
		
		for (Pessoa pessoa : pessoas) { /*Poderia gravar no banco de dados*/
			System.out.println(pessoa);
		}
		
		
	}
}
