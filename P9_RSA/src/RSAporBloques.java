import java.util.ArrayList;

public class RSAporBloques
{
	public static String alf = "abcdefghijklmnÒopqrstuvwxyzABCDEFGHIJKLMN—OPQRSTUVWXYZ·ÈÌÛ˙¡…Õ”⁄0123456789 ,.:!-ø?()";
	
	public static void main(String[] args) 
	{
		String pepa_n = "62439738695706104201747";
		String pepa_e = "356812573";
		String pepa_factorizacion_n = "249879448303";
		String pepa_factorizacion_dot = "249879448349";
		
		String Benito_n = "743330222539755158153";
		String Benito = "80263681";
		String Benito_factorizacion_n = "27264083009";
		String Benito_factorizacion_dot = "27264083017";
		
		cifrarMensaje(pepa_n);
	}
	
	public static void cifrarMensaje(String pepa_n)
	{
		ArrayList<Integer> nuevaCadena = new ArrayList<Integer>();
		ArrayList<Character> nuevaCadenaprueba = new ArrayList<Character>();
		char num;
		
		for(int i = 0; i < pepa_n.length();i++)
		{
			num = pepa_n.charAt(i);
			
			for(int j = 0; j < alf.length();j++)
			{
				
				if(alf.charAt(j) == num)
				{
					nuevaCadena.add(j - 1);
					nuevaCadenaprueba.add(alf.charAt(j-1));
					System.out.println(nuevaCadena.get(i) + " " + nuevaCadenaprueba.get(i));
					
				}
			}
			
		}
	}
}
