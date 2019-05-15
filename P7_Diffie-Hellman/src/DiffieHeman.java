import java.math.BigInteger;
import java.util.ArrayList;

public class DiffieHeman {



	public static void main(String[] args) {
		
		//String  prueba = calculaBase("14","2");
		//System.out.print(prueba);
		BigInteger a = potenciacionModular("3","14","11");
		System.out.println(a);
		BigInteger Ejercicio1 = potenciacionModular("2424242424","4444444444","201920192019");
		System.out.println(Ejercicio1);
	}
	
	
	//Calcula el modulo de una potencia
	public static BigInteger potenciacionModular(String base, String exp, String mod) {
		
		ArrayList<BigInteger> a = new ArrayList<BigInteger>();
		ArrayList<BigInteger> b = new ArrayList<BigInteger>();
		ArrayList<BigInteger> m = new ArrayList<BigInteger>();
		
		
		//RELLENAR B//
		String binario = calculaBase(exp,"2");
		binario = reverse(binario);
		for(int i=0; i<binario.length(); i++) {
			b.add(new BigInteger(String.valueOf (binario.charAt(i))));
		}
		//RELLENAR A//
		a.add(new BigInteger(base));
		
		for(int j=1; j<binario.length();j++) {
			//bInt.add(j,new BigInteger(base).multiply(bInt.get(j-1)));
			a.add(j,(new BigInteger(base).multiply(a.get(j-1))).mod(new BigInteger(mod)));
		}
		
		
		//RELLENAR M//
		m.add(new BigInteger("1"));
		for(int i=1; i<=a.size(); i++) {
			if(b.get(i-1).equals(BigInteger.ZERO)) { // si la anterior pos de b es CERO
				m.add(m.get(i-1));
			}else {
				m.add((m.get(i-1).multiply(a.get(i-1))).mod(new BigInteger(mod)));
			}
		}
		return m.get(m.size()-1);
	}

	
	//Calcula un numero segun la base
	public static String  calculaBase(String _numero, String _base) {
		String resto;
		BigInteger numero = new BigInteger(_numero);
		BigInteger base = new BigInteger(_base);
		
		BigInteger cociente;
		BigInteger uno = new BigInteger("1");
		
		cociente = numero.divide(base);
		resto = (numero.mod(base)).toString();
		
		//while(cociente!=uno) {
		while(!cociente.equals(uno)) {
			resto = resto + (cociente.mod(base)).toString();
			cociente = cociente.divide(base);
		}
		resto = resto + "1";
		resto = reverse(resto);
		
		return resto;
	}
	//Da la vuelta al string que recibe, Original=0111 Result=1110
	public static String reverse(String cadena) {
		String cadenaInvertida = "";
		for (int x=cadena.length()-1;x>=0;x--)
			cadenaInvertida = cadenaInvertida + cadena.charAt(x);
		return cadenaInvertida;
	}
	//
	public static void codTexto() {
		
	}
	public static void codViceversa() {
		
	}
}