import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

public class BloquesRSA 
{
	String alf = "abcdefghijklmnñopqrstuvwxyzABCDEFGHIJKLMNÑOPQRSTUVWXYZáéíóúÁÉÍÓÚ0123456789 ,.:!-¿?()";

	List<BigInteger> listaPosiciones = new ArrayList<BigInteger>();
	List<BigInteger> listaRestos = new ArrayList<BigInteger>();
	
	BigInteger nMaria = new BigInteger("8849169404252643679");
	BigInteger eMaria = new BigInteger("196413997");
	BigInteger factor1Maria = new BigInteger("2974755337");
	BigInteger factor2Maria = new BigInteger("2974755367");
	BigInteger factor1Mariamenos1 = factor1Maria.subtract(BigInteger.valueOf(1));
	BigInteger factor2Mariamenos1 = factor2Maria.subtract(BigInteger.valueOf(1));
	
	BigInteger nJuan = new BigInteger("5244938048376303456108649");
	BigInteger eJuan = new BigInteger("114340249");
	BigInteger factor1Juan = new BigInteger("2290182972661");
	BigInteger factor2Juan = new BigInteger("2290182972709");
	
	public BloquesRSA() 
	{
		// TODO Auto-generated constructor stub
	}

	public BigInteger buscaK(String alf)
	{
		BigInteger tamAlf = BigInteger.valueOf(alf.length());
		BigInteger k = BigInteger.valueOf(0);
		BigInteger k2 = BigInteger.valueOf(9);
		BigInteger aux = BigInteger.valueOf(0);
		BigInteger aux2 = new BigInteger("9999999999999999999999999999999999999999999999999999999999999");
		
		while(aux.compareTo(nMaria) == -1)
		{
			aux = tamAlf.modPow(k, aux2);
			
			k = k.add(BigInteger.valueOf(1));
		}
		
		k = k.add(BigInteger.valueOf(-2));
		
		return k;
	}
	
	public BigInteger calculaM(String bloque)
	{
		BigInteger numero=BigInteger.valueOf(0);
		guardaPosiciones(bloque, alf);
		int j=0;
		for(int i=bloque.length()-1; i>=0; i--)
		{
			numero = numero.add(listaPosiciones.get(i).multiply(BigInteger.valueOf(alf.length()).pow(j)));
			j = j+1;
			
		}
		
		listaPosiciones = new ArrayList<BigInteger>();
		return numero;
	}
	
	public void guardaPosiciones(String texto, String alf)
	{
		BigInteger pos = BigInteger.valueOf(0);
		
		for(int i = 0; i < texto.length(); i++)
		{
			pos = BigInteger.valueOf(alf.indexOf(texto.charAt(i)));
			
			listaPosiciones.add(pos);
		}
		
	}
	
	public BigInteger calculaC(BigInteger d, BigInteger m)
	{
		BigInteger c = BigInteger.valueOf(0);
		
		c = m.modPow(d, nMaria);
		
		return c;
	}
	
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
		
		listaRestos = new ArrayList<BigInteger>();
		
		return textInv;
	}
	
	public BigInteger euclidesExtendido()	
    {
         BigInteger[] resp = new BigInteger[3];
         
         BigInteger a = factor1Mariamenos1.multiply(factor2Mariamenos1);
         BigInteger b = eMaria;
         BigInteger x = BigInteger.valueOf(0);
         BigInteger y = BigInteger.valueOf(0);
         BigInteger d = BigInteger.valueOf(0);
    		
         if(b.equals(0))
         {
        	 resp[0] = a;	resp[1] = BigInteger.valueOf(1);	resp[2] = BigInteger.valueOf(0);
         }		
         else
         {
	    	
	    	BigInteger x2 = BigInteger.valueOf(1);
	        BigInteger x1 = BigInteger.valueOf(0);
	        BigInteger y2 = BigInteger.valueOf(0);
	        BigInteger y1 = BigInteger.valueOf(1);
	        BigInteger q = BigInteger.valueOf(0);
	        BigInteger r = BigInteger.valueOf(0);
	    			
	    	while(b.compareTo(BigInteger.valueOf(0))==1)
	    	{
		    	q = a.divide(b);
		    	r = a.subtract(q.multiply(b));
		    	x = x2.subtract(q.multiply(x1));
		    	y = y2.subtract(q.multiply(y1));
		    	a = b;
		    	b = r;
		    	x2 = x1;
		    	x1 = x;
		    	y2 = y1;
		    	y1 = y;
		    	}
		    			
		    	resp[0] = a;
		    	resp[1] = x2;
		    	resp[2] = y2;
		        }
	     
	        return resp[2];		
    } 

}
