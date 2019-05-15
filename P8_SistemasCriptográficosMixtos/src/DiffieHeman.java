import java.math.BigInteger;
import java.util.ArrayList;

public class DiffieHeman {


	public static String alf = "aábcdeéfghiíjklmnñoópqrstuúvwxyzAÁBCDEÉFGHIÍJKLMNÑOÓPQRSTUÚVWXYZ0123456789 ,.:-()";

	public static void main(String[] args) 
	{
		BigInteger num = new BigInteger("14");
		BigInteger base = new BigInteger("2");
		//BigInteger  prueba = calculaBase(num,base);
		//System.out.print(prueba);
		String _num = "123456789123456789";
		String _base = "81";
		//numeroTexto(_num,_base);
		String[] hola = alfabetoEnteros("24 de Abril");
		System.out.println(hola);
		
	}
	
	
	//Calcula el modulo de una potencia
	public static BigInteger potenciacionModular(String base, String exp, String mod)
	{
		
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
	
	//Calcula un numero segun la base-------------Usar BigInteger
	public static String  calculaBase(String _numero, String _base) 
	{
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
	public static String reverse(String cadena)
	{
		String cadenaInvertida = "";
		for (int x=cadena.length()-1;x>=0;x--)
			cadenaInvertida = cadenaInvertida + cadena.charAt(x);
		return cadenaInvertida;
	}
	//	
	public static String numeroTexto(String numero, String base)
	{
		//CAMBIAR EL METODO CALCULABASE PARA QUE DEVUELVA 2 CIFRAS y tiene que devolver un string
		String cadenaResuelta = calculaBase(numero , base);
		
		for(int i = 0;i < cadenaResuelta.length(); i++)
		{
			int cadenaInt = Character.getNumericValue(cadenaResuelta.charAt(i));
			char variable = alf.charAt(cadenaInt);
			System.out.println(cadenaInt + "  " +variable);
		}
		return null;

	
	}
	
	public static void textoNumero(int[] args, BigInteger base)
	{
		BigInteger suma = new BigInteger("0");
		
		for(int i = 0; i < args.length; i++)
		{
			String num = String.valueOf(args[i]);
			BigInteger n = new BigInteger(num);
			//n = n.multiply(potenciacionModular(base , args.length - i));
			suma = suma.add(n);
		}
	}
	
	public static String[] alfabetoEnteros(String arg)
	{
		String[] cadenaNumeros = new String[arg.length()];
		
		for(int i=0; i < arg.length();i++)
		{
			for(int j=0; j < alf.length();j++)
			{
				if(arg.charAt(i) == (alf.charAt(j)))
				{
					cadenaNumeros[i] = String.valueOf(j);
					
				}
			}
		}
		
		return cadenaNumeros;
	}
	
	public static BigInteger Diffie(String A, String b, String p)
	{
		//Pasamos las cadenas de texto a numero
		//Para crear ñla clave publica debemos hacer g elevado a a*b modulo p
		//Donde a es el numeor de Alicia y b es el numeor de Benito , p y g son datos que nos dan
		//Para sacer el numero Alicia, g elevado a a modulo de p
		//Para sacer el numeor Benito, g elevado a b modulo de p
		
		String n = numeroTexto(A, p);
		BigInteger resultado = potenciacionModular(p,b,n);
		System.out.println(resultado);
		
		return resultado;
	}
}