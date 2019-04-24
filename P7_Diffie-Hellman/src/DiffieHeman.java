import java.math.BigInteger;

public class DiffieHeman {



	public static void main(String[] args) {
		BigInteger num = new BigInteger("14");
		BigInteger base = new BigInteger("2");
		BigInteger  prueba = calculaBase(num,base);
		System.out.print(prueba);
	}
	
	
	//Calcula el modulo de una potencia
	public static int potenciacionModular(int base, int exp, int bas) {
		
		return 0;
	}
	
	//Calcula un numero segun la base-------------Usar BigInteger
	public static BigInteger  calculaBase(BigInteger numero, BigInteger base) {
		String resto;
		BigInteger cociente;
		BigInteger uno = new BigInteger("1");
		BigInteger result;
		
		cociente = numero.divide(base);
		resto = (numero.mod(base)).toString();
		
		//while(cociente!=uno) {
		while(!cociente.equals(uno)) {
			resto = resto + (cociente.mod(base)).toString();
			cociente = cociente.divide(base);
		}
		resto = resto + "1";
		resto = reverse(resto);
		result = new BigInteger(resto);
		return result;
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