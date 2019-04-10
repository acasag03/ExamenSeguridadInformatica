import java.util.ArrayList;

public class Monoalfabetica {
	//Monoalfabetica
	static String alf;
	static String texto;
	static ArrayList<Integer> textoNum;
	static ArrayList<Integer> descodificadoNUM;
	static ArrayList<Character> descodificadoString;
	
	//Vigenere
	static String clave;
	
	
	public static void main(String[] args) 
	{
		
		alf ="aábcdeéfghiíjklmnñoópqrstuúvwxyzAÁBCDEÉFGHIÍJKLMNÑOÓPQRSTUÚVWXYZ0123456789 ,.:-()";
		texto = "NBHQÑÍHBHQúÍahYBWQ(BñAhQHtÑAayaÍQaAQÑtB:ÚtyAhQÍ9hBQQwBWAhBQrdQHyWQAwñBhMÍdQHtÑAayAhÍWQBHYDQPBWyA:dQA:QQ)ÍÑ(tA:ÍdQaAHaAQA:QmÍWaÍQaAQHtHQÍWÑAQBíÍHdQ:BwAW9BñBQQA:QÑthHÍQaAQ:ÍHQBÑÍW9AÑywyAW9ÍHdQBtWÚtAQ:ÍQBÑB9BhBQQÑÍwÍQtWBQhAB:yaBaQyWAfy9Bñ:AQrQmB9B:D";
		textoNum = new ArrayList<Integer>();
		descodificadoNUM = new ArrayList<Integer>();
		descodificadoString = new ArrayList<Character>();
		
		clave = "10 de abril";
		
		monoalfabetica();
		
		
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
		textoNum = posiciones(texto);
		//Descodificamos
		for(int k=0; k<textoNum.size();k++) {
			descodificadoNUM.add(((textoNum.get(k) *38) +4)%81);
		}
		for(int l=0; l<descodificadoNUM.size(); l++) {
			descodificadoString.add(alf.charAt(descodificadoNUM.get(l)));
		}
	}
	public static void vigenere() {
		ArrayList<Integer> numericoClave = new ArrayList<Integer>();
		
		for(int i=0; i<clave.length(); i++) {
			for(int j=0; j<alf.length();j++) {
				if(texto.charAt(i) == alf.charAt(j)) {
					numericoClave.add(j);
				}
			}		
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
	
	
	
	
	
	
	
	
	
	
}
