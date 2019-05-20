import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

public class DiffieHellman
{

	String alf = "aábcdeéfghiíjklmnñoópqrstuúvwxyzAÁBCDEÉFGHIÍJKLMNÑOÓPQRSTUÚVWXYZ0123456789 ,.:-()";
	String A = "bú32a4Í2lDíhUeÉB";
	String B = "áuÁTJKWz7É I.Ñ2É";
	BigInteger b = new BigInteger("1717171717171717");
	BigInteger p = new BigInteger("428765575697899393132131414307");
	BigInteger g = BigInteger.valueOf(2);
	
	public DiffieHellman()
	{
		
		// TODO Auto-generated constructor stub
	}

	public void desencriptar()
	{
		CodificacionTextoNumero cod = new CodificacionTextoNumero();
		
		BigInteger aNumero = cod.decodificacionTexto(A);
		
		aNumero = aNumero.modPow(b, p);
		
		String resultado = cod.decodificacionNumero(aNumero);
		
		System.out.println(resultado);
	}
}
