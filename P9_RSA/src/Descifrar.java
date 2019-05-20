import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

public class Descifrar 
{

	public Descifrar() 
	{
		// TODO Auto-generated constructor stub
	}

	public void descifra() 
	{
		// TODO Auto-generated method stub
		BloquesRSA bRSA = new BloquesRSA();
		List<String> listaBloques = new ArrayList<String>();
		List<BigInteger> listaM = new ArrayList<BigInteger>();
		List<BigInteger> listaC = new ArrayList<BigInteger>();
		String resultado = "";
		char charAnterior = 'a';
		
		String alf = "abcdefghijklmnñopqrstuvwxyzABCDEFGHIJKLMNÑOPQRSTUVWXYZáéíóúÁÉÍÓÚ0123456789 ,.:!-¿?()";
		String mensaje = "BUL mzaR3Qx-OíQDM6EagkWFbb¿V7loJHpÓécaxLLBuú28V¿ÍÍETáÁKqEcFóÑUV1vu5rRxIchMiSikUpyAqXuÍvjWccDbUV3-S9VMÚDóéÑKKHdeWfphL2AoHKíBpcuOKO-kúYhúMNo95uc20sw1BeMñj(v-ñz:óMwáPVjqK66Vonegcy1zvUgAÍ5eM5YSQG3e)Eúrmkj";
	
		BigInteger d = bRSA.euclidesExtendido();
		
		BigInteger k = bRSA.buscaK(alf);
		
		BigInteger cont = BigInteger.valueOf(0);
		String bloque = "";
		
		for(int i = 0; i < mensaje.length(); i++)
		{
			if(cont.compareTo(k)==-1)
			{
				bloque = bloque + mensaje.charAt(i);
				cont=cont.add(BigInteger.valueOf(1));
			}
			else if(cont.compareTo(k)==0)
			{
				bloque = bloque + mensaje.charAt(i);
				cont = BigInteger.valueOf(0);
				listaBloques.add(bloque);
				bloque = "";
			}
		}
		
		for(String minecraft : listaBloques)
		{
			listaM.add(bRSA.calculaM(minecraft));
		}
		
		for(BigInteger m : listaM)
		{
			listaC.add(bRSA.calculaC(d, m));
		}
		
		for(BigInteger c : listaC)
		{
			resultado = resultado + bRSA.decodificacionNumero(c);
		}
		
		for(int i = 0; i < resultado.length(); i++)
		{
			if(resultado.charAt(i) == ' ')
			{
				if(charAnterior == ' ')
				{
					System.out.println();
				}
				else
				{
					System.out.print(resultado.charAt(i));
				}
			}
			else
			{
				System.out.print(resultado.charAt(i));
			}
			
			charAnterior = resultado.charAt(i);
		}
	}

}
