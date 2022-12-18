package arquivos;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class EscreveJSON {

	public static void main(String[] args) {
		
		Usuario usuario = new Usuario(); 
		
		usuario.setCpf("897865465546");
		usuario.setLogin("joão");
		usuario.setSenha("852111");

		Usuario usuario2 = new Usuario(); 
		usuario2.setCpf("97846546546");
		usuario2.setLogin("paulo");
		usuario2.setSenha("123");
		
		List<Usuario> usuarios = new ArrayList<Usuario>();
		
		usuarios.add(usuario);
		usuarios.add(usuario2);
		
		String json = new GsonBuilder().setPrettyPrinting().create().toJson(usuarios);
		
		System.out.println(json);
		
		try {
			FileWriter escrevedor = new FileWriter(
					"//home//matheus//Documents//ProjectosProgramacao//Java//Eclipse//Arquivos//arquivos//src//arquivos//arquivo.json");
			
			escrevedor.write(json); 
			escrevedor.flush();
			escrevedor.close();
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
