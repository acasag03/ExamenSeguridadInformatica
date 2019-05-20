import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

public class CodificacionTextoNumero
{
	
	String alf = "aábcdeéfghiíjklmnñoópqrstuúvwxyzAÁBCDEÉFGHIÍJKLMNÑOÓPQRSTUÚVWXYZ0123456789 ,.:-()";

	List<BigInteger> listaPosiciones = new ArrayList<BigInteger>();
	List<BigInteger> listaRestos = new ArrayList<BigInteger>();
	
	public CodificacionTextoNumero()
	{
		
	}

	//DE TEXTO A NUMERO
	public BigInteger decodificacionTexto(String texto)
	{
		BigInteger numero=BigInteger.valueOf(0);
		guardaPosiciones(texto, alf);
		int j=0;
		for(int i=texto.length()-1; i>=0; i--)
		{
			
			numero = numero.add(listaPosiciones.get(i).multiply(BigInteger.valueOf(alf.length()).pow(j)));
			j = j+1;
			
		}
		
		return numero;
	}
	
	//GUARDA LAS POSICIONES DE LA LETRAS, ESTA RELACIONADO CON TEXTO NUMERO 
	public void guardaPosiciones(String texto, String alf)
	{
		BigInteger pos = BigInteger.valueOf(0);
		
		for(int i = 0; i < texto.length(); i++)
		{
			pos = BigInteger.valueOf(alf.indexOf(texto.charAt(i)));
			
			listaPosiciones.add(pos);
		}
		
	}
	
	//DE NUMERO A TEXTO
	public String decodificacionNumero(BigInteger numero)
	{
		String text="";
		String textInv="";
		BigInteger resto=BigInteger.valueOf(0);
		
		while(numero.divide(BigInteger.valueOf(alf.length())) != BigInteger.valueOf(0))
		{
			resto=numero.remainder(BigInteger.valueOf(alf.length()));
			numero=numero.divide(BigInteger.valueOf(alf.length()));
			listaRestos.add(resto);
		}
		listaRestos.add(numero);
		
		for(BigInteger bi : listaRestos)
		{
			text=text+alf.charAt(bi.intValue());
		}
		for (int x=text.length()-1;x>=0;x--)
		{
			textInv = textInv + text.charAt(x);
		}
		
		return textInv;
	}
}