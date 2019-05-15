
public class CriptacionQuickSort 
{
	public static char text[];
	
	public static void main(String[] args) 
	{
		String prueba = "azebac";
		String clave = "654321";
		
		cambioTexto(clave,prueba);
	}
	
	public static void cambioTexto(String clave, String prueba)
	{
		int a[] = new int[clave.length()];
		text = new char[prueba.length()];
		
		for(int i = 0; i < prueba.length();i++)
		{
			text[i] = prueba.charAt(i);
		}
		for(int i = 0; i < clave.length();i++)
		{
			a[i] = clave.charAt(i);
		}
		
		
		quicksort(a ,0 ,a.length-1);
		
		
	}
	public static void quicksort(int A[], int izq, int der)
	{
		  int pivote=A[izq]; // tomamos primer elemento como pivote
		  int i=izq; // i realiza la búsqueda de izquierda a derecha
		  int j=der; // j realiza la búsqueda de derecha a izquierda
		  int aux;
		  char aux_text;
		 
		  while(i<j)
		  {            // mientras no se crucen las búsquedas
		     while(A[i]<=pivote && i<j)
		     {
		    	 i++; // busca elemento mayor que pivote
		     }
		     while(A[j]>pivote)
		     {
		    	 j--;         // busca elemento menor que pivote
		     }
		     if (i<j)
		     {                      // si no se han cruzado                      
		         aux= A[i];			// los intercambia
		         aux_text = text[i];
		         System.out.println(aux + " " + aux_text);
		         A[i]=A[j];
		         text[i] = text[j];
		         System.out.println(A[i] + " " + text[i]);
		         A[j]=aux;
		         text[j] = aux_text;
		         System.out.println(A[j] + " " + text[j]);
		         
		     }
		   }
		   A[izq]=A[j]; // se coloca el pivote en su lugar de forma que tendremos
		   A[j]=pivote; // los menores a su izquierda y los mayores a su derecha
		   
		   if(izq<j-1)
		      quicksort(A,izq,j-1); // ordenamos subarray izquierdo
		   if(j+1 <der)
		      quicksort(A,j+1,der); // ordenamos subarray derecho
	}
	
}
