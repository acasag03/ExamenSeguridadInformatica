import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class CodificacionBinariaP5
{
	static String alf;
	static int base;
	static int lonCodF1;
	static int lonCodF2;
	static int filasId;
	static char charAnterior;
	private static Scanner scanner;
	static int[][] matrizATranpuesta;
	static int[][] unidadH;
	static ArrayList<String> codigoDividido15 = new ArrayList<String>();
	static int[][] codigoDiv;

	public static void main(String[] args) 
	{
		
		//COGEMOS LOS DATOS PARA MIRAR SI DE QUE BASE ES, LAS COLUMNAS Y LAS FILAS
		System.out.print("Base: ");
		scanner = new Scanner(System.in);
		
		base = scanner.nextInt();
		
		System.out.print("ColumnasG: ");
		lonCodF2 = scanner.nextInt();
		
		System.out.print("FilasI: ");
		filasId = scanner.nextInt();
		
		String alf ="A�BCDE�FGHI�JKLMN�O�PQRSTU�VWXYZ .,;:()�?�!-0123456789a�bcde�fghi�jklmn�o�pqrstu�vwxyz";
		
		
		rellenarAlfabeto(alf);
		
		//HALLAMOS LA LONGITUD CON LA FORMULA min long = dlog2(60)e = 6

		lonCodF1 = (int) (Math.log(alf.length())/ Math.log(base) + 1);

		//ANIADIMOS LA COFIDICACION
		String codificacion ="1,1,0,1,0,0,0,1,0,1,0,0,1,1,0,0,0,1,1,1,1,0,1,1,1,0,1,1,1,0,1,1,0,1,1,1,0,1,0,1,0,1,0,0,0,0,0,1,0,1,0,1,1,0,0,1,0,0,1,1,1,1,1,0,0,0,0,0,1,0,0,0,1,1,0,1,1,1,1,1,1,0,0,1,1,0,1,1,0,0,1,0,1,1,1,0,0,0,1,0,1,1,0,0,1,1,1,0,0,1,0,1,0,1,0,1,0,1,1,1,0,0,1,0,1,0,0,0,0,1,1,1,0,1,1,0,0,0,1,0,0,1,0,1,1,0,1,1,0,0,0,1,1,1,0,0,0,1,0,0,1,1,1,0,1,0,1,1,0,0,1,1,1,1,1,0,0,0,0,0,1,0,0,1,0,1,1,1,1,1,0,0,0,0,0,1,0,1,0,0,1,0,0,0,1,0,1,0,1,0,0,0,0,1,0,1,1,0,1,1,1,0,0,1,1,0,0,0,1,1,0,0,1,1,1,0,1,1,1,0,0,1,1,0,1,0,1,1,1,0,1,0,1,0,1,1,0,0,1,0,1,0,1,1,0,0,0,1,0,0,0,0,0,1,1,0,0,1,1,1,0,1,1,1,0,0,1,1,0,1,1,1,0,1,1,1,0,0,1,1,0,0,0,0,1,0,1,0,1,1,0,1,1,0,0,1,1,0,1,0,1,0,1,0,1,1,1,0,0,1,0,1,1,1,0,0,1,0,1,1,0,1,1,0,0,0,0,1,1,1,1,0,1,0,0,0,1,1,0,0,0,1,1,0,0,1,0,1,0,0,1,0,0,1,1,1,1,1,0,1,1,0,0,0,1,0,0,1,0,0,0,0,0,1,1,0,0,1,1,0,1,1,0,1,1,0,0,1,0,0,0,1,0,1,0,1,0,1,1,1,0,1,0,0,1,1,0,1,1,0,0,0,1,0,0,1,1,0,1,1,0,1,0,0,1,0,1,0,1,0,0,0,0,0,0,1,0,1,0,1,0,0,1,1,0,0,0,0,0,1,0,0,1,0,1,0,0,1,1,0,0,0,1,1,1,0,0,0,1,0,0,1,0,0,0,0,0,1,1,1,1,0,1,1,1,0,0,0,0" +
				",0,0,1,1,0,1,0,0,1,1,1,1,0,0,0,1,1,0,1,1,0,1,1,0,1,1,1,0,0,1,1,0,1,0,1,1,0,1,1,0,1,1,1,0,0,1,1,0,0,1,0,1,0,1,0,1,0,1,0,0,0,0,0,0,1,1,1,0,1,0,1,0,0,1,1,0,0,1,0,1,0,0,1,0,1,0,0,1,0,0,0,0,1,0,0,1,1,1,0,0,1,1,1,0,1,1,0,0,1,0,0,1,1,1,1,0,0,1,0,1,0,0,1,0,0,1,1,1,0,1,0,1,1,0,0,1,0,1,0,1,0,0,0,1,0,1,1,1,0,0,1,0,1,1,0,1,0,1,1,0,0,0,1,1,0,0,1,1,0,1,0,1,1,1,1,0,0,0,1,0,0,1,0,1,1,0,1,1,0,1,0,0,1,0,0,0,1,1,0,0,0,1,1,1,1,1,0,0,0,0,0,0,0,1,0,0,0,0,0,0,1,0,1,0,1,0,1,0,1,1,0,0,1,0,1,0,1,0,1,1,1,0,1,0,1,0,0,0,1,0,1,1,1,0,0,1,1,1,1,1,0,1,1,1,1,0,1,0,1,0,1,0,0,0,0,0,0,1,1,1,1,1,1,1,1,1,1,1,0,0,0,0,0,1,0,1,1,1,0,0,1,1,1,1,1,0,0,0,1,1,0,1,1,0,1,1,1,1,1,1,0,0,1,1,1,1,1,0,0,0,1,1,0,0,0,0,0,1,0,1,0,1,1,0,0,1,0,1,1,1,0,0,1,0,1,1,0,1,1,0,0,0,0,1,1,1,1,0,1,0,0,0,1,1,0,0,0,0,1,1,1,0,0,1,0,0,1,1,1,0,1,1,0,1,0,1,0,1,1,0,0,0,0,0,1,0,0,0,1,1,1,1,0,1,0,0,0,1,1,0,0,1,0,1,0,0,1,1,0,1,1,0,1,1,0,0,1,1,0,0,1,0,1,0,1,0,1,1,0,0,1,1,0,1,1,1,1,1,1,0,1,1,1,0,0,1,1,1,1,0,0,0,1,1,1,0,1,0,1,0,1,1,1,0,1,0,0,0,1,0,1,0,0,1,1,0,1,1,1,1,0,1,1,1,1,0,1,0,1,0,1,1" +
				",0,0,0,0,1,0,0,0,0,0,0,0,0,0,1,1,1,0,0,0,0,1,1,1,1,0,0,0,1,1,1,0,0,1,1,1,0,0,1,0,0,1,0,0,1,1,1,0,0,0,1,0,1,1,0,1,1,0,0,0,1,1,1,1,1,1,0,0,1,1,0,1,0,1,1,1,1,1,0,0,1,1,1,0,0,1,0,1,0,0,0,0,1,1,0,1,0,0,1,0,0,1,0,0,0,0,1,0,0,1,0,0,0,1,1,0,1,0,1,1,1,0,0,1,1,0,1,1,0,1,1,0,1,1,1,1,1,0,0,0,0,0,1,0,0,1,0,0,0,0,1,0,1,1,0,0,0,1,1,1,1,1,0,1,0,0,0,0,0,0,0,0,0,1,1,0,1,0,1,0,1,0,0,0,0,0,0,1,1,1,1,1,0,1,0,0,1,1,1,0,0,0,1,1,1,0,0,1,1,0,1,0,0,1,1,0,0,1,0,0,0,1,1,0,1,1,1,1,0,1,0,1,1,1,1,0,0,0,1,1,0,0,0,0,0,1,0,1,0,1,1,0,0,1,0,0,0,1,1,0,1,0,0,1,0,1,0,1,0,1,0,1,1,0,0,1,1,1,0,1,1,0,1,1,0,1,1,1,1,1,0,1,1,1,1,0,0,0,1,0,1,1,1,0,1,1,0,1,1,1,1,1,0,1,1,0,0,0,0,0,0,1,0,1,0,1,0,0,0,1,0,1,0,1,0,0,1,1,1,1,0,0,0,1,0,0,1,0,0,0,1,0,1,0,1,1,0,0,1,0,1,0,0,0,1,1,1,1,1,1,1,1,1,1,0,0,0,1,0,1,0,0,1,1,0,1,1,0,0,1,1,1,1,1,0,0,1,0,0,1,0,0,1,1,1,1,1,0,0,0,1,1,1,1,0,1,1,1,0,1,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,1,0,1,0,1,0,1,1,0,0,0,1,0,1,1,0,0,1,0,1,0,1,0,1,0,1,1,1,0,1,1,1,1,1,1,1,0,1,1,1,0,0,1,1,1,0,0,0,1,1,0,1,1,0,0,0,1,0,1,0,0,0,1,1,0,0,1,1,1,1,1,0,1,0,1,1" +
				",1,1,1,0,0,0,1,0,1,0,1,0,0,0,0,1,0,1,0,0,0,0,0,0,0,0,0,1,1,0,0,1,0,1,0,1,0,1,0,1,1,1,1,1,0,0,0,0,1,0,0,1,0,0,1,0,0,1,1,0,0,1,1,1,0,0,1,0,1,0,1,0,0,0,0,0,1,0,0,1,0,1,0,0,1,1,0,0,0,1,1,1,1,1,1,0,0,1,0,0,1,1,0,0,0,1,1,0,0,1,1,1,0,1,1,1,0,0,0,1,0,0,0,0,0,1,0,0,0,1,1,0,1,1,0,0,0,1,0,1,1,1,1,0,0,0,1,1,1,1,0,1,1,0,1,1,0,0,0,1,0,0,1,0,0,1,1,0,1,1,0,1,1,1,0,0,1,0,0,0,0,0,0,0,0,0,1,1,0,1,0,1,0,1,0,0,0,1,1,1,0,0,1,0,0,1,1,1,1,1,0,1,1,0,0,1,0,0,0,1,1,0,1,0,1,0,1,0,1,0,1,1,0,1,1,0,0,1,1,0,0,1,0,1,0,1,0,1,0,1,1,1,0,1,1,0,1,1,1,0,1,1,1,0,0,1,1,1,0,0,1,1,1,1,1,0,0,1,1,1,0,1,0,0,0,0,0,0,1,1,1,1,1,1,1,1,1,0,1,0,0,0,0,0,1,0,1,0,0,1,1,0,1,0,1,0,1,0,0,0,1,1,1,0,0,1,1,0,0,1,0,1,1,0,0,0,1,0,1,0,1,0,0,1,0,0,1,0,0,1,0,1,1,1,0,0,1,1,0,1,0,0,1,1,0,1,0,1,0,1,1,1,0,0,0,0,0,1,0,1,1,0,0,1,0,1,0,1,0,1,0,0,0,0,0,0,1,1,0,1,0,1,1,0,0,0,1,0,1,1,0,0,1,0,0,1,1,1,1,1,0,1,0,1,0,0,1,0,0,1,0,0,1,0,1,0,0,1,1,0,1,1,0,1,1,0,0,1,1,1,0,0,0,0,1,1,1,1,0,0,0,1,0,1,1,1,0,0,1,0,1,0,1,1,0,0,1,0,0,1,0,1,0,1,0,0,1,0,1,0,1,0,0,1,0,1,1,0,1,1,0,0,0,0,0,1,0,1,1,1,1,1" +
				",0,0,1,0,1,0,1,0,0,0,0,1,0,0,0,0,1,1,1,1,0,1,1,1,0,1,0,1,1,1,1,0,1,0,0,1,1,1,0,1,1,1,0,1,0,0,1,0,1,0,1,0,1,1,1,0,0,0,0,0,0,1,0,0,1,0,0,1,0,0,0,1,1,1,1,0,1,0,0,1,0,1,0,1,0,1,0,1,0,1,1,0,1,0,0,0,1,1,0,0,0,1,1,0,1,0,0,0,1,0,0,1,0,0,0,0,0,0,1,0,0,0,0,1,1,1,0,0,1,1,0,1,0,1,1,1,0,1,0,1,1,1,0,0,1,1,0,0,1,1,0,0,0,1,1,1,0,0,1,1,0,0,0,1,0,1,1,1,1,1,1,0,0,0,1,0,1,1,0,0,1,0,1,1,0,0,1,0,1,0,0,1,0,1,1,1,1,1,1,1,1,1,1,1,1,0,0,1,1,0,0,1,0,0,0,1,1,1,1,1,0,1,1,0,0,1,1,1,1,1,0,0,0,0,0,0,1,1,0,0,0,0,0,0,0,0,0,0,0,0,1,0,1,1,0,1,1,0,1,0,0,0,1,1,0,1,1,0,1,1,1,1,0,0,1,1,0,1,0,1,0,0,1,1,0,1,1,0,1,1,0,1,1,0,0,0,0,0,0,0,1,0,0,1,1,1,0,0,1,1,1,0,0,1,1,1,0,1,0,1,1,0,1,1,1,1,1,1,0,0,1,0,0,0,1,1,0,1,0,1,0,1,1,1,1,0,1,1,1,1,1,1,1,1,1,0,1,0,1,0,1,1,0,1,0,1,1,0,0,1,1,1,0,0,0,1,1,1,1,1,0,0,0,0,0,0,0,1,0,1,0,1,0,0,1,0,0,1,0,0,1,0,1,0,1,1,1,0,0,1,0,0,1,0,0,1,1,1,0,0,0,1,0,1,0,1,0,1,1,1,1,0,1,1,0,1,0,0,0,1,1,1,0,1,1,0,1,0,0,0,1,0,0,0,0,0,1,1,1,0,0,0,0,0,1,1,1,0,0,1,0,1,0,1,0,1,1,0,0,1,0,1,0,1,0,1,1,0,0,1,0,0,0,1,0,0,1,0,1,1,0,1,1,0,0,0,1,0,0,1,0,0,0,0,0,0,0,0,0,0,0,0,0,1,1,1,0,1,0,1,0,0,1,1,0,1,1,0,0,1,0,0,0,1,0,0,0,1,1,0,0,1,0,0,0,1,1,0,1,1,1,0,0,1,1,0,1,1,1,0,0,1,0,1,1,0,1,1,0,0,0,0,0,0,0,1,1,0,1,0,1,0,1,1,1,1,1,0,0,0,0,0,1,0,1,1,1,0,0,1,0,0,0,1,0,1,0,0,1,1,0,0,0,1,0,0,1,0,1,1,0,0,0,1,0,0,0,1,1,0,0,0,1,0,0,0,1,1,1,1,0,0,0,0,0,1,0,0,0,0,0,0,1,0,1,0,1,0,0,0,1,1,0,0,0,1,0,1,1,1,1,0,0,0,1,0,1,0,0,1,1,1,0,1,0,1,1,0,0,1,0,0,0,0,1,1,1,0,1,0,0,0,1,1,0,1,1,1,1,0,0,0,1,1,0,1,1,0,1,1,1,1,0,0,0,1,0,1,0,1,0,1,0,0,0,0,0,1,0,0,0,0,0,1,1,1,0,0,1,1,0,0,1,1,1,0,0,0,0,1,0,1,0,1,0,0,0,1,0,0,0,1,1,0,1,1,1,0,0,1,1,1,0,1,1,1,0,0,0,0,1,1,1,1,1,1,0,1,0,1,1,0,1,0,1,1,0,1,1,1,1,0,1,0,1,0,0,0,1,0,0,0,1,1,0,1,1,1,1,0,1,0,1,0,0,1,0,0,1,1,1,0,1,1,0,0,1,1,0,1,1,0,1,1,1,1,1,0,1,1,0,1,1,1,1,1,1,1,1,1,0,0,1,1,0,0,1,1,1,0,0,0,1,0,0,1,0,1,1,1,1,1,1,0,0,0,0,0,1,0,1,1,0,1,0,0,0,0,0,0,1,1,1,1,1,0,1,1,1,0,0,0,1,0,1,0,0,1,1,0,0,1,0,0,0,0,0,0,1,1,1,0,0,1,1,1,0,1,0,0,1,1,1,1,1,0,0,0,0,0,1,1,1,0,1,1,0,0,1,0,0,0,1,1,0,0,0,0,1,0,1,1,0,1,0,0,1,0,0,0,0,0,1,1,1,0,1,1,0,0,0,1,1,0,0,0,0,1,1,0,1,0,1,1,1,1,1,1,1,1,0,1,1,1,0,1,1,0,1,0,0,0,1,1,0,0,1,1,1,0,0,0,0,1,0,0,0,1,1,0,0,0,0,1,0,1,1,0,1,0,0,1,0,0,0,1,0,0,1,1,0,0,0,1,0,0,1,0,0,0,1,1,1,1,0,0,0,0,0,0,0,1,1,1,0,0,1,0,0,1,0,0,0,0,1,1,0,1,0,1,0";
		
		
		codificacion = codificacion.replace(",", "");
		codificacion = codificacion.replace("\r\n", "");
		
		int[][] matrizA = {{1,0,1,0,1,0,1,1,1},{1,0,1,0,1,1,0,0,1},{1,0,1,1,0,1,1,0,0},{0,1,0,1,0,0,1,1,0},{0,0,1,1,1,0,0,1,1},{1,1,1,1,0,0,0,0,0}};
		//Matriz yt es el codigo, tranpuesto y dividido de 15 en 15(primeor se divide)
		transpuesta(matrizA);
		uniMatriz();
		dividir(codificacion);
		int[][] c = productoMatrices(unidadH,matrizATranpuesta);
		//decodifica(codificacion);
		
	}

	//MULTIPLICAR H POR Yt
	public static int[][] productoMatrices(int[][] a, int[][] b) {
	    int[][] c = new int[a.length][b[0].length];
	    
	    // se comprueba si las matrices se pueden multiplicar
	    
	    if (a[0].length == b.length)
	    {
	        for (int i = 0; i < a.length; i++) 
	        {
	            for (int j = 0; j < b[0].length; j++)
	            {
	                for (int k = 0; k < a[0].length; k++) 
	                {
	                    // aquí se multiplica la matriz
	                    c[i][j] += a[i][k] * b[k][j];
	                }
	            }
	        }
	    }
	    /**
	     * si no se cumple la condición se retorna una matriz vacía
	     */
	    return c;
	}
	
	//DIVIDE EL CODIGO DE 15 EN 15
	public static void dividir(String codificacion)
	{
		int cola = codificacion.length() % 15;
		String cod = codificacion.substring(0 , codificacion.length() - cola);
		String temp = "";

		for(int i = 0; i < cod.length();i= i +15)
		{
			for(int j = 0; j <= 15 + i;j++)
			{
				if(j == (15 + i))
				{
					temp = cod.substring(i, j);
					codigoDividido15.add(temp);
				}
			}
			
		}
		codigoDiv = new int[codigoDividido15.size()][15];
		
		//METER A UNA MATRIZ LA CODIFICACION DIVIDIDA
		for(int z = 0;z < codigoDividido15.size() ;z++)
		{
			for(int c = 0;c < 15;c++)
			{
				codigoDiv[z][c] = Character.getNumericValue(codigoDividido15.get(z).charAt(c));
			}
			
		}
		
		System.out.println();
		transpuesta(codigoDiv);
	
	}

	//UNE LA MATRIZ At + I(H)
	public static void uniMatriz()
	{
		
		int[][] iden = {{1,0,0,0,0,0,0,0,0},{0,1,0,0,0,0,0,0,0},{0,0,1,0,0,0,0,0,0},{0,0,0,1,0,0,0,0,0},{0,0,0,0,1,0,0,0,0},{0,0,0,0,0,1,0,0,0},{0,0,0,0,0,0,1,0,0},{0,0,0,0,0,0,0,1,0},{0,0,0,0,0,0,0,0,1}};
		unidadH = new int[matrizATranpuesta.length][matrizATranpuesta[0].length + iden[0].length];
		int count1 = matrizATranpuesta[0].length;
		for(int i=0;i<matrizATranpuesta.length;i++)
		{
			for(int j=0;j<matrizATranpuesta[0].length;j++)	
			{
				unidadH[i][j] = matrizATranpuesta[i][j];		
			}
		}
		
		for(int z=0;z<iden.length;z++)
		{
			for(int k=0;k<iden[0].length;k++)	
			{
				unidadH[k][count1] = iden[z][k];
				
			}
			count1++;
		}
		
		/*for(int z= 0;z<unidadH.length;z++)
		{	
			System.out.print("\n");
			for(int j=0;j<unidadH[0].length;j++)			
			{	System.out.print(unidadH[z][j]);
			
			}
		}*/
		
	}
	
	//TRANSPONE A
	public static void transpuesta(int[][] matrizA)
	{
		int filas = matrizA.length;
		int columnas = matrizA[0].length;
		
		matrizATranpuesta = new int[columnas][filas];
		
		for(int i=0;i<filas;i++)
		{
			for(int j=0;j<columnas;j++)	
			{
				matrizATranpuesta[j][i] = matrizA[i][j];
	
			}
		}
		
		//IMPRIMIR MATRIZ
		/*for(int z= 0;z<matrizATranpuesta.length;z++)
		{	
			System.out.print("\n");
			for(int j=0;j<matrizATranpuesta[0].length;j++)			
			{	System.out.print(matrizATranpuesta[z][j]);
			
			}
		}*/
	
	}
	
	public static void rellenarAlfabeto(String alfabeto)
	{
		//RELLENAMOS EL ALFABETO
		alf = alfabeto;
	}
	
	public static void decodifica(String cadenaCodificada)
	{

		int cola;
		
		cola = cadenaCodificada.length() % lonCodF2;
		
		
		String listaDes = "";
		
		//REALIZAMOS UNA LISTA DESCODIFICADA
		for(int i = 0; i < cadenaCodificada.length() - cola; i += 15)
		{
			String value = "";
			
			for(int j = i; j < i + filasId; j++)
			{
				value = value + cadenaCodificada.charAt(j) + "";
			}
			
			listaDes = listaDes + value;
			//System.out.println(listaDes);
		}
		
		//LA COLA DE LA LISTA LA GUARDAMOS
		if(cola > 0)
		{
			String valueCola = cadenaCodificada.substring(cadenaCodificada.length() - cola,cadenaCodificada.length());
			
			listaDes = listaDes + valueCola;
		}
		
		List<String> listaDesFinal = new ArrayList<String>();
		
		//
		for(int i = 0; i < listaDes.length(); i += lonCodF1)
		{
	
			String stringValor = "";
			
			for(int j = i; j < (i + lonCodF1); j++)
			{
				stringValor = stringValor + listaDes.charAt(j);
			}
			
			//System.out.println(stringValor);
			listaDesFinal.add(stringValor);

		}
		
		for(String valorDecimal : listaDesFinal)
		{
			//CAMBIAMOS EL CODIGO BINARIO A LETRAS
			int decimal = 0;
			int exponente = lonCodF1;
			
			for(int i = 0; i < valorDecimal.length(); i++)
			{
				char c = valorDecimal.charAt(i);
				int num = Character.getNumericValue(c);
				decimal = (int) (decimal + num * Math.pow(base, exponente));
				
				
				exponente--;
			}
			
		
			if(alf.charAt(decimal) == ' ')
			{
				if(charAnterior == ' ')
				{
						System.out.println();
				}
				else
				{
						System.out.print(alf.charAt(decimal));
				}
			}
			else
			{
				System.out.print(alf.charAt(decimal));
			}
		
			charAnterior = alf.charAt(decimal);
			
	
		}
	}

}
