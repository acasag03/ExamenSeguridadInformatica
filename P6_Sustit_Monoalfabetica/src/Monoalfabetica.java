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
		
		alf ="a�bcde�fghi�jklmn�o�pqrstu�vwxyzA�BCDE�FGHI�JKLMN�O�PQRSTU�VWXYZ0123456789 ,.:-()";
		texto = "NBHQ��HBHQ��ahYBWQ(B�AhQHt�Aaya�QaAQ�tB:�tyAhQ�9hBQQwBWAhBQrdQHyWQAw�BhM�dQHt�AayAh�WQBHYDQPBWyA:dQA:QQ)��(tA:�dQaAHaAQA:Qm�Wa�QaAQHtHQ�W�AQB��HdQ:BwAW9B�BQQA:Q�thH�QaAQ:�HQB��W9A�ywyAW9�HdQBtW�tAQ:�QB�B9BhBQQ��w�QtWBQhAB:yaBaQyWAfy9B�:AQrQmB9B:D";
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
