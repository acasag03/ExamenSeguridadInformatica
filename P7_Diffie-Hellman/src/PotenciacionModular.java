import java.math.BigInteger;

public class PotenciacionModular {

	public PotenciacionModular()
	{
		// TODO Auto-generated constructor stub
	}
	
	public BigInteger calculaPotenciacion(BigInteger a, BigInteger b, BigInteger n)
	{
		BigInteger resultado = BigInteger.valueOf(0);
		BigInteger m = BigInteger.valueOf(1);
		String bBinario=calculaBinario(b);
		String bBinarioInv="";
		for (int x=bBinario.length()-1;x>=0;x--)
		{
			bBinarioInv = bBinarioInv + bBinario.charAt(x);
		}
		
		for(int i=0; i<bBinarioInv.length();i++)
		{
			if(bBinarioInv.charAt(i)=='0')
			{
				//El m será igual al m anterior
			}
			else
			{
				m=m.multiply(a);
				m=m.remainder(n);
			}
			a = a.multiply(a);
			a = a.remainder(n);
		}
		resultado=m;
		
		return resultado;
	}
	
	public String calculaBinario(BigInteger numeroDecimal)
	{
		BigInteger temp = numeroDecimal;
		BigInteger zero= BigInteger.valueOf(0);
		BigInteger two=BigInteger.valueOf(2);
		  String resultado = "";
		  while (temp != zero){
		   if(temp.remainder(two) == zero){
		    resultado = "0" + resultado;
		   }else{
		    resultado = "1" + resultado;
		   }
		   temp = temp.divide(two);
		  }
		  return resultado;
	}

}
