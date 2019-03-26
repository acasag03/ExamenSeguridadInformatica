import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Fuente
{
	String cadena;
	char[] cadenaVector;
	ArrayList<Integer> frecuencia = new ArrayList<Integer>();
	ArrayList<Character> simbolos = new ArrayList<Character>();
	ArrayList<Double> probabilidad = new ArrayList<Double>();
	boolean repetido = false;

	//Parte Dos
	ArrayList<String> binario = new ArrayList<String>();
	ArrayList<String> posicion = new ArrayList<String>();
	ArrayList<Double> copiaProb = new ArrayList<Double>();
	ArrayList<String> pos = new ArrayList<String>();
	
	//parte Tres
	String[] stringFre;
	ArrayList<Double> pi = new ArrayList<Double>();




	
	public Fuente()
	{
	 //Contructor
		cadena ="La noche cae, brumosa ya y morada. Vagas claridades malvas y verdes perduran tras la torre de la iglesia. El camino sube, lleno de sombras, de campanillas, de fragancia de hierba, de canciones, de cansancio y de anhelo.\r\n";

		
	}
	
	public void frecuencia()
	{
		cadenaVector = cadena.toCharArray();
		
		for(int i=0; i<cadenaVector.length; i++)
		{
			repetido = false;
			if(i == 0)
			{
				 simbolos.add(cadenaVector[i]);
				 frecuencia.add(1);
			}
			else
			{
		        for (int j =0; j<simbolos.size(); j++)
		        {
		        	if(cadenaVector[i] == simbolos.get(j))
		        	{

		        		frecuencia.set(j,frecuencia.get(j) + 1);
		        		repetido = true;
		        	}
		        	
		        }

		        
		        if(repetido == false)
		        {
		        	simbolos.add(cadenaVector[i]);
		        	frecuencia.add(1);
		        }
		        

			}

	    }
		
		
		Comparator<Integer> comparador = Collections.reverseOrder();
		Collections.sort(frecuencia, comparador);
		
		System.out.println(frecuencia);	
		

	}

	public void probabilidad()
	{

		double resultado;
		
		for(int i = 0;i<simbolos.size();i++)
		{
			resultado = Math.round(frecuencia.get(i)/(double)cadena.length() * 1000d) / 1000d;
			probabilidad.add(resultado);
		}
		
		System.out.println(probabilidad);
	}

	
	public int sumaFrecuencia()
	{

		int t = 0;
		
		for(int i = 0;i < stringFre.length;i++)
		{
			t = t + Integer.parseInt(stringFre[i]);
		}
		
		return t;
	}
	
	public double sumaFrecLog()
	{
		double sumaResultado = 0.0;
		
		for(int i = 0;i < stringFre.length;i++)
		{
			sumaResultado = sumaResultado + (Double.parseDouble(stringFre[i]) * log(Double.parseDouble(stringFre[i]),2));
		
		}
		
		return sumaResultado;
		
	}
	
	public void entropia()
	{
		double resultadoFinal;
		String stringFrecuencia = "83,69,67,82,69,84,79,32,68,69,32,85,78,79,32,83,69,67,82,69,84,79,32,83,69,71,85,82,79";
		
		stringFre = stringFrecuencia.split(",");
		
		int t = sumaFrecuencia();
		double logaritmo = log(t,2);
		double division = 1.0/Double.valueOf(t);
		resultadoFinal = logaritmo - (division * sumaFrecLog());
		
		System.out.println(resultadoFinal);
		
		
	}
	
	private void eficacia()
	{
		int t = sumaFrecuencia();
		for(int i = 0;i < stringFre.length;i++)
		{
			 pi.add(Double.parseDouble(stringFre[i])/t);
			 
		}
	}
	
	private static Double log(double num, int base) 
	{
	     return (Math.log10(num) / Math.log10(base));
	}
	

	

	
}
