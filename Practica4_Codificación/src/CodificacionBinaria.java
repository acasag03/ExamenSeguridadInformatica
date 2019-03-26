import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CodificacionBinaria 
{
	static String alf;
	static int base;
	static int lonCodF1;
	static int lonCodF2;
	static int filasId;
	static char charAnterior;
	private static Scanner scanner;

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
		
		String alf = ".,;()¿?¡!-0123456789 aábcdeéfghiíjklmnñoópqrstuúvwxyzAÁBCDEÉFGHIÍJKLMNÑOÓPQRSTUÚVWXYZ";
		
		rellenarAlfabeto(alf);
		
		//HALLAMOS LA LONGITUD CON LA FORMULA min long = dlog2(60)e = 6

		lonCodF1 = (int) (Math.log(alf.length())/ Math.log(base) + 1);
		
		//A�ADIMOS LA COFIDICACI�N
		String codificacion ="2,0,3,0,4,4,0,4,1,4,2,0,1,2,0,1,4,3,4,2,3,4,2,4,0,4,0,0,0,1,0,1,3,1,2,0,0,4,2,3,2,2,0,1,1,1,3,3,1,4,3,1,1,3,3,0,4,1,2,4,1,2,4,0,2,1,0,4,0,1,0,0,0,4,0,1,0,0,1,0,1,0,2,2,1,2,1,2,4,0,1,2,1,3,2,1,2,3,4,1,1,1,0,4,2,3,2,1,1,1,0,1,4,3,1,4,3,1,0,3,4,1,1,1,0,0,3,3,3,2,2,2,0,4,1,0,4,4,0,4,3,0,4,0,1,1,0,1,3,2,3,2,2,3,0,1,0,4,0,0,0,1,0,4,0,1,4,0,1,0,1,1,0,1,2,0,1,1,2,2,1,2,1,0,0,1,1,1,1,1,0,0,3,3,3,2,2,2,1,2,4,0,4,1,2,1,2,4,0,0,1,2,1,1,0,4,4,3,4,0,4,1,1,2,0,3,3,1,2,2,4,1,4,0,1,1,2,1,1,2,3,1,1,1,4,0,1,2,1,2,3,1,1,4,1,1,0,0,1,1,1,0,0,2,0,4,0,1,0,0,0,4,0,1,0,0,1,0,1,0,2,2,1,2,1,2,4,0,0,4,4,2,3,3,2,2,3,1,2,4,1,2,0,3,4,1,3,4,2,1,4,0,0,2,2,2,3,1,0,4,1,0,4,4,3,4,4,3,2,4,1,4,0,1,2,3,1,2,3,4,2,4,1,3,4,0,2,2,3,4,1,3,4,0,0,4,4,2,3,3,2,2,3,1,2,4,1,2,0,3,4,1,3,4,2,0,4,0,1,2,1,2,3,2,0,2,1,1,4,1,4,3,0,3,3,2,1,2,0,1,4,3,4,2,3,1,2,0,1,1,1,1,4,3,3,3,3,4,4,0,1,4,1,0,4,1,4,0,1,1,0,0,0,4,0,1,0,0,0,4,0,1,0,0,1,2,1,2,2,1,2,0,1,0,4,0,0,0,1,0,4,0,1,0,4,1,0,1,1,0,2,1,0,1,1,2,2,1,2,1,0,0,1,1,4,0,1,0,1,1,0,1,0,1,2,0,4,0,1,3,3,0,2,3,4,3,4,1,0,1,1,2,1,1,2,1,3,3,3,1,1,1,4,3,3,3,1,1,0,4,1,0,0,0,0,0,4,1,0,0,0,4,0,3,2,4,2,3,2,2,1,0,1,1,1,4,3,3,3,4,3,1,4,3,1,1,0,4,4,2,1,4,2,0,4,0,0,1,1,1,2,1,4,4,0,1,2,1,3,2,1,2,3,4,1,4,1,0,4,0,1,0,4,1,4,4,1,1,0,1,2,1,2,1,1,3,2,4,0,4,0,0,0,1,0,1,3,0,4,4,1,2,1,4,0,2,2,1,4,1,2,2,0,4,4,2,2,3,0,4,0,1,3,1,4,3,1,3,4,0,1,0,1,1,3,1,3,0,0,1,0,3,1,3,4,1,2,1,3,4,1,4,2,4,1,2,2,1,4,4,0,2,4,0,4,1,1,3,4,1,3,3,0,4,4,0,4,0,1,4,3,4,0,4,0,2,1,0,4,1,3,2,4,3,2,1,2,0,1,1,2,1,4,0,0,1,4,4,1,3,3,1,2,1,4,4,1,3,0,1,1,3,4,4,0,1,3,3,4,0,4,0,2,0,1,1,4,1,2,1,1,0,4,0,1,1,0,1,2,1,0,2,0,0,4,1,2,1,3,2,2,0,1,3,4,0,4,2,3,2,3,4,1,0,1,1,0,1,3,2,3,2,2,3,0,1,0,4,0,0,0,1,0,4,0,0,4,4,1,2,1,4,0,2,2,1,4,1,2,2,1,0,4,3,3,4,1,2,4,0,4,4,4,0,0,4,0,2,1,1,1,1,0,4,4,3,3,3,3,0,1,2,4,0,2,2,3,0,1,2,4,0,1,2,1,3,2,1,2,3,4,1,4,1,2,0,3,3,1,2,4,2,1,0,4,0,1,1,0,1,2,1,0,0,0,1,0,1,2,1,2,1,2,2,0,4,0,0,4,3,4,3,3,4,3,4,1,0,1,1,2,1,1,2,1,3,3,3,0,4,4,4,0,0,4,1,1,0,4,1,0,0,0,0,0,4,1,0,2,0,4,0,1,2,1,2,3,2,0,3,1,1,0,1,1,0,1,0,0,3,1,3,3,1,2,0,3,4,2,2,4,4,0,4,0,1,4,3,4,0,4,0,0,1,1,3,4,4,0,1,3,3,4,1,4,0,1,2,3,1,2,3,4,2,4,0,4,0,1,4,3,4,0,4,0,2,2,1,2,4,1,2,4,0,4,4,0,4,0,1,1,1,0,0,1,2,1,0,0,4,1,0,0,0,4,1,0,0,4,0,1,2,1,3,2,1,2,3,4,1,0,1,1,1,4,3,3,3,4,3,3,1,2,4,1,1,0,2,4,0,3,3,3,0,4,1,1,0,2,1,3,3,1,0,0,1,2,4,2,3,4,4,3,4,0,4,0,1,4,3,4,0,4,0,2,1,1,1,1,1,0,0,0,0,4,0,4,0,0,4,3,4,3,3,4,3,0,1,2,4,1,3,2,4,1,2,3,3,1,1,1,1,2,1,1,1,1,4,1,2,2,1,1,2,1,1,0,0,1,1,1,3,0,1,1,0,1,3,0,0,2,2,0,4,0,3,3,4,3,1,1,1,3,4,1,2,1,4,0,2,3,0,4,0,4,3,1,2,1,4,3,2,3,3,3,1,0,1,3,2,3,2,0,0,0,4,0,1,0,0,0,4,0,1,0,1,1,2,0,1,0,4,0,3,4,4,2,0,0,4,1,2,1,3,2,2,0,1,3,4,0,0,3,3,3,4,0,2,0,0,4,0,0,4,4,4,0,4,4,4,0,0,0,3,2,4,2,2,2,3,2,1,3,2,3,1,3,4,3,0,4,2,0,4,0,2,3,1,3,4,3,1,4,3,3,0,0,0,0,0,2,2,1,2,2,3,2,3,2,4,0,4,0,0,4,2,1,1,2,0,3,4,4,3,1,2,3,2,4,3,4,1,0,2,1,2,2,2,3,3,0,0,0,2,2,3,3,2,2,4,1,0,4,4,3,0,2,2,0,1,0,4,0,0,0,1,0,4,0,2,0,3,1,2,3,1,2,0,3,1,2,1,4,0,1,3,2,3,4,2,1,2,4,1,1,1,4,3,3,3,0,2,1,2,2,1,0,1,1,0,4,4,0,1,0,4,0,1,1,0,1,2,1,0,0,0,1,0,1,2,1,2,1,2,2,0,4,0,3,0,2,2,4,2,3,2,1,0,4,1,1,2,1,1,3,2,1,1,1,1,2,2,2,0,0,1,1,1,1,4,0,0,1,1,0,1,1,2,0,4,2,1,3,2,2,0,4,1,0,3,0,0,1,4,1,1,0,2,0,1,1,1,3,1,1,0,1,1,0,0,3,0,2,1,3,3,2,1,4,3,3,0,4,0,1,0,0,1,2,1,2,2,1,2,0,4,0,0,2,1,4,1,1,2,1,1,0,3,4,0,3,3,4,0,3,2,2,0,0,2,0,4,4,2,4,4,2,0,1,4,0,2,2,0,2,3,1,2,1,0,3,4,0,3,3,4,0,3,2,2,4,0,2,4,2,3,0,2,3,0,0,0,4";
		
		codificacion = codificacion.replace(",", "");
		codificacion = codificacion.replace("\r\n", "");
		
		decodifica(codificacion);
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
		for(int i = 0; i < cadenaCodificada.length() - cola; i += lonCodF2)
		{
			String value = "";
			
			for(int j = i; j < i + filasId; j++)
			{
				value = value + cadenaCodificada.charAt(j) + "";
			}
			
			listaDes = listaDes + value;
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
			
			listaDesFinal.add(stringValor);

		}
		
		for(String valorDecimal : listaDesFinal)
		{
			//CAMBIAMOS EL CODIGO BINARIO A LETRAS
			int decimal = 0;
			int exponente = lonCodF1 - 1;
			
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
