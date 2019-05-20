import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Scanner;

public class main {

	public static void main(String[] args)
	{
		String alf = "aábcdeéfghiíjklmnñoópqrstuúvwxyzAÁBCDEÉFGHIÍJKLMNÑOÓPQRSTUÚVWXYZ0123456789 ,.:-()";
		String texto = ")bJ.WpfA)DJfHqsú1s:-FwódslkíxÁJnseóaDóíÉpaDúTF:-l7ÑñnnI:íNTny5A9ó9ÁEsqoú Hñ0D8óríouooMJsñ5róE),fzdBÉÓnf5fbÑóúxp7íETnñgK8ócéftáHÉ5o:UjBáDSYP69bñUUmg79hhFuií TKó1yázy.fd5bnNf.Ó):";
		DiffieHellman dif = new DiffieHellman();
		PotenciacionModular pm = new PotenciacionModular();
		Monoalfabetica ma = new Monoalfabetica();
		ArrayList<Character> resultado = new ArrayList<Character>();

		/*for(int i = 0; i < alf.length(); i++)
		{
			System.out.println(alf.charAt(i) + " - " + i);
		}*/
		
		CodificacionTextoNumero ctn = new CodificacionTextoNumero();

		String k  = dif.desencriptar();
		
		resultado = ma.vigenere(texto,k);
		char espacio = 'a';
		
		for( int i = 0; i < resultado.size(); i++)
		{
			
			if(i > 0 && espacio == ' ' && resultado.get(i) == espacio)
			{
				System.out.println();
			}
			else
			{
				System.out.print(resultado.get(i));
			}
			
			
			espacio = resultado.get(i);
		}
		
	}
}
