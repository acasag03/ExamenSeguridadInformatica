import java.math.BigInteger;
import java.util.ArrayList;

public class CrictograficosMixtos
{
	public static void main(String[] args)
	{
		DiffieHeman df = new DiffieHeman();
		Monoalfabetica mA = new Monoalfabetica();
		String a = "ıyr5IR6´ıpDSA´uY";
		String b = "eXPKeS´ıt´I´ı´ıDN";
		String p = "10";

		BigInteger res = df.Diffie(a,b,p);
		String clave = res.toString();
		
		ArrayList<Integer> resultado = new ArrayList<Integer>(mA.vigenere(clave));		
	}
}
