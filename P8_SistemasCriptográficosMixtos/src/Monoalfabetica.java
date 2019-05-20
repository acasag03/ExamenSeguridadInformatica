import java.util.ArrayList;
import java.util.stream.Collectors;

public class Monoalfabetica {
	//Monoalfabetica
	static String alf = "aábcdeéfghiíjklmnñoópqrstuúvwxyzAÁBCDEÉFGHIÍJKLMNÑOÓPQRSTUÚVWXYZ0123456789 ,.:-()";


	
	public static ArrayList<Character> monoalfabetica(String texto) 
	{
		ArrayList<Integer> textoNum = new ArrayList<Integer>();
		ArrayList<Integer> descodificadoNUM = new ArrayList<Integer>();
		ArrayList<Character> descodificadoString =  new ArrayList<Character>();
		
		textoNum = posiciones(texto);
		
		//Descodificamos
		for(int k=0; k<textoNum.size();k++) {
			descodificadoNUM.add(((textoNum.get(k) *38) +4)%81);
		}
		for(int l=0; l<descodificadoNUM.size(); l++) {
			descodificadoString.add(alf.charAt(descodificadoNUM.get(l)));
		}
		for (int p = 0; p < descodificadoString.size(); p++) {
			System.out.print(descodificadoString.get(p));

		}
		return descodificadoString;
		
	}
	public static ArrayList<Character> vigenere(String texto,String clave)
	{
		
		ArrayList<Integer> numericoClave = posiciones(clave);
		ArrayList<Integer> numericoCifrado = posiciones(texto);
		ArrayList<Integer> codClave = new ArrayList<Integer>();
		ArrayList<Integer> resta = new ArrayList<Integer>();
		ArrayList<Character> decodificacion;
		//codClave es el array list que contiene tantas veces repetida la clave como longitud tenga el cifrado
		
		int index=0;
		for(int i=0; i<texto.length(); i++) {
			index = i % numericoClave.size();
			codClave.add(numericoClave.get(index));
			
		}
		
		//RESTAMOS EL NUMERICO DEL TEXTO CIFRADO AL NUMERICO DE LA CLAVE
		int restaVar = 0;
		for(int j=0; j<numericoCifrado.size(); j++) {
			restaVar = numericoCifrado.get(j) - codClave.get(j);
			if(restaVar<0) {
				restaVar = alf.length()+restaVar;
			}
			resta.add(restaVar);
		}
		
		
		//TRANSFORMAMOS LOS NUMEROS DE LAS LETRAS EN EL TEXTO DECODIFICADO
		decodificacion = devuelveLetras(resta);
	
		return decodificacion;
	
	}
	public static ArrayList<Integer> posiciones(String texto) {
		ArrayList<Integer> numericoTexto = new ArrayList<Integer>();
		for(int i=0; i<texto.length(); i++) {
			for(int j=0; j<alf.length();j++) {
				if(texto.charAt(i) == alf.charAt(j)) {
					numericoTexto.add(j);
				}
			}		
		}
		return numericoTexto;
	}
	//DEVUELVE LAS LETRAS DE UN NUMERICO
	public static ArrayList<Character> devuelveLetras(ArrayList<Integer> numerico) 
	{
		ArrayList<Character> texto = new ArrayList<Character>();
		for(int l=0; l<numerico.size(); l++) 
		{
			texto.add(alf.charAt(numerico.get(l)));
		}
		return texto;
	}
	
	
	
	
	
	
	
	
	
}
