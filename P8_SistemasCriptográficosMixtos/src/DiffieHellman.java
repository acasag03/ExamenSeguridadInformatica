import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

public class DiffieHellman
{

	String alf = "aábcdeéfghiíjklmnñoópqrstuúvwxyzAÁBCDEÉFGHIÍJKLMNÑOÓPQRSTUÚVWXYZ0123456789 ,.:-()";
	String A = "íyr5IR6ípDSAúY";//CLAVES QUE INTERCAMBIAN A
	String B = "eXPKeSítÍííDN,";//CLAVES QUE INTERCAMBIA B
	BigInteger a = new BigInteger("63332323232451757353");//CLAVE PRIVADA DE A(la b seria la de Benito)
	BigInteger p = new BigInteger("131414242343537725243372873");
	BigInteger g = BigInteger.valueOf(10);
	
	public DiffieHellman()
	{
		
		// TODO Auto-generated constructor stub
	}

	//DEVUELVE K(clave privada que acuerdan ambos)
	public String desencriptar()
	{
		CodificacionTextoNumero cod = new CodificacionTextoNumero();
		
		BigInteger aNumero = cod.decodificacionTexto(B);
		
		aNumero = aNumero.modPow(a, p);
		
		String resultado = cod.decodificacionNumero(aNumero);
		
		System.out.println(resultado);
		
		return resultado;
	}
}
