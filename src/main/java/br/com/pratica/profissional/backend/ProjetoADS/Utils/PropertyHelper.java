package br.com.pratica.profissional.backend.ProjetoADS.Utils;

import java.io.InputStream;
import java.util.Properties;

import java.io.IOException;

public class PropertyHelper {

	/**
	 * Busca no arquivo project.properties env passado como parametro
	 *  
	 * @param env
	 * 
	 * @return String setada no project.properties
	 * 
	 * @author danielrocha
	 */
	public static String getStringProperty(String env) {
		
		try {

			InputStream input = PropertyHelper.class.getClassLoader().getResourceAsStream("project.properties");
					
            Properties prop = new Properties();

            if (input == null) {
                System.out.println("Desculpe, não foi possível encontrar o arquivo project.properties");
            }
            
             prop.load(input);
             
             return prop.getProperty(env);

		} catch (IOException ex) {
            ex.printStackTrace();
        }
		return null;
	}
}
