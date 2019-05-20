import java.math.BigInteger;
import java.util.Scanner;

public class main {

	public static void main(String[] args)
	{
		DiffieHellman dif = new DiffieHellman();
		PotenciacionModular pm = new PotenciacionModular();
		/*
		System.out.println("############### POTENCIACIÓN MODULAR ###############");
		Scanner sc = new Scanner(System.in);
		System.out.println("Introduzca la base: ");
		BigInteger a = sc.nextBigInteger();
		System.out.println("Introduzca el exponente: ");
		BigInteger b = sc.nextBigInteger();
		System.out.println("Introduzca el módulo: ");
		BigInteger n = sc.nextBigInteger();
		System.out.println(pm.calculaPotenciacion(a, b, n));
		
		*/
		
		/*System.out.println("############### CODIFICACIÓN TEXTO/NÚMERO ###############");*/
		CodificacionTextoNumero ctn = new CodificacionTextoNumero();
		/*
		Scanner sc = new Scanner(System.in);
		System.out.println("Introduzca el numero: ");
		BigInteger num = sc.nextBigInteger();
		System.out.println(ctn.decodificacionNumero(num));
		*/
		/*Scanner sc = new Scanner(System.in);
		System.out.println("Introduzca el texto: ");
		String texto = sc.nextLine();
		System.out.println(ctn.decodificacionTexto(texto);*/
		
		dif.desencriptar();
	}
}
