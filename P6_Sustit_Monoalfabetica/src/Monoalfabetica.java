import java.util.ArrayList;

public class Monoalfabetica {
	//Monoalfabetica
	static String alf;
	static String texto_01;
	static String texto_02;
	static ArrayList<Integer> textoNum;
	static ArrayList<Integer> descodificadoNUM;
	static ArrayList<Character> descodificadoString;
	
	//Vigenere
	static String clave;
	
	
	public static void main(String[] args) 
	{
		
		alf ="aábcdeéfghiíjklmnñoópqrstuúvwxyzAÁBCDEÉFGHIÍJKLMNÑOÓPQRSTUÚVWXYZ0123456789 ,.:-()";
		texto_01 = "NBHQÑÍHBHQúÍahYBWQ(BñAhQHtÑAayaÍQaAQÑtB:ÚtyAhQÍ9hBQQwBWAhBQrdQHyWQAwñBhMÍdQHtÑAayAhÍWQBHYDQPBWyA:dQA:QQ)ÍÑ(tA:ÍdQaAHaAQA:QmÍWaÍQaAQHtHQÍWÑAQBíÍHdQ:BwAW9BñBQQA:QÑthHÍQaAQ:ÍHQBÑÍW9AÑywyAW9ÍHdQBtWÚtAQ:ÍQBÑB9BhBQQÑÍwÍQtWBQhAB:yaBaQyWAfy9Bñ:AQrQmB9B:D";
		textoNum = new ArrayList<Integer>();
		descodificadoNUM = new ArrayList<Integer>();
		descodificadoString = new ArrayList<Character>();
		
		clave = "10 de abril";
		texto_02 = "p5nty)s.úmfgá-r)3qvvcEhU3te-rfmiEd mdv  bmól45m-h( gDcl(8í-p,s.ÍCóÚgh-úoeuvAAÚ5md(on.móó49í-úoe.zwyé0.d(  uMcB14mha3PfJwfdám-óí sMmf1U)o(3ahvkÉ12 )a5";

		
		monoalfabetica();
		
		//vigenere();
		
		/*
		//Imprimir array list
		for (int l = 0; l < codClave.size(); l++) {
			System.out.println(codClave.get(l));

		}
		 */
		
		
	}
	
	public static void monoalfabetica() {
		//Obtener los numeros en el alfabeto
		/*for(int i=0; i<texto.length(); i++) {
			for(int j=0; j<alf.length();j++) {
				if(texto.charAt(i) == alf.charAt(j)) {
					textoNum.add(j);
					
				}
				
			}		
		}*/
		textoNum = posiciones(texto_01);
		//Descodificamos
		for(int k=0; k<textoNum.size();k++) {
			descodificadoNUM.add(((textoNum.get(k) *38) +4)%81);
		}
		for(int l=0; l<descodificadoNUM.size(); l++) {
			descodificadoString.add(alf.charAt(descodificadoNUM.get(l)));
		}
	}
	public static void vigenere() {
		ArrayList<Integer> numericoClave = posiciones(clave);
		ArrayList<Integer> numericoCifrado = posiciones(texto_02);
		ArrayList<Integer> codClave = new ArrayList<Integer>();
		ArrayList<Integer> resta = new ArrayList<Integer>();
		ArrayList<Character> decodificacion;
		//codClave es el array list que contiene tantas veces repetida la clave como longitud tenga el cifrado
		
		int index=0;
		for(int i=0; i<texto_02.length(); i++) {
			index = i % numericoClave.size();
			codClave.add(numericoClave.get(index));
			
		}
		
		//RESTAMOS EL NUMERICO DEL REXTO CIFRADO AL NUMERICO DE LA CLAVE
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
	
		/* Imprime la cadena*/
		for (int l = 0; l < decodificacion.size(); l++) {
			System.out.print(decodificacion.get(l));

		}
	
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
	public static ArrayList<Character> devuelveLetras(ArrayList<Integer> numerico) {
		ArrayList<Character> texto = new ArrayList<Character>();
		for(int l=0; l<numerico.size(); l++) {
			texto.add(alf.charAt(numerico.get(l)));
		}
		return texto;
	}
	
	
	
	
	
	
	
	
	
}
