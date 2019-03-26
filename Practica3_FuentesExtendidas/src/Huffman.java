import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Huffman{

	private static Scanner scanner;
	static List<HuffmanNode> listaNodos = new ArrayList<HuffmanNode>();
	static List<HuffmanNode> listaNodosF2 = new ArrayList<HuffmanNode>();
	static List<HuffmanNode> listaEnviar = new ArrayList<HuffmanNode>();
	
	
	public Huffman(){
		// TODO Auto-generated constructor stub
	}
	
	private static class HuffmanNode{
        double frecuencia;
        int posicion;
        List<Integer> posiciones;
        int contador;

        HuffmanNode(double frequency, int posicion, List<Integer> posiciones, int contador){
            this.frecuencia = frequency;
            this.posicion = posicion;
            this.posiciones = posiciones;
            this.contador = contador;
        }
        
        public double getFrecuencia(){
        	return frecuencia;
        }
        
        public int getContador(){
        	return contador;
        }
    }
	
	private static void calcularLongitudes(List<HuffmanNode> listaInicial){
		List<HuffmanNode> listaEnMemoria = new ArrayList<HuffmanNode>();
		
		for(HuffmanNode n : listaInicial){
			listaEnMemoria.add(n);
		}
		
		List<HuffmanNode> listaSuma = listaInicial;
		
		listaSuma.sort(Comparator.comparing(HuffmanNode::getFrecuencia));
		
		while(listaSuma.size() > 1){
			HuffmanNode nodoPrimero = listaSuma.remove(0);
			HuffmanNode nodoSegundo = listaSuma.remove(0);
			
			double frecuencia = nodoPrimero.frecuencia + nodoSegundo.frecuencia;
			
			List<Integer> listaPosiciones = new ArrayList<Integer>();
			
			if(nodoPrimero.posiciones == null){
				listaPosiciones.add(nodoPrimero.posicion);
				listaEnMemoria.get(nodoPrimero.posicion - 1).contador = listaEnMemoria.get(nodoPrimero.posicion - 1).contador + 1;
			}
			else{
				for(int i : nodoPrimero.posiciones){
					listaPosiciones.add(i);
					listaEnMemoria.get(i - 1).contador = listaEnMemoria.get(i - 1).contador + 1;
				}
			}
			
			if(nodoSegundo.posiciones == null){
				listaPosiciones.add(nodoSegundo.posicion);
				listaEnMemoria.get(nodoSegundo.posicion - 1).contador = listaEnMemoria.get(nodoSegundo.posicion - 1).contador + 1;
			}
			else{
				for(int i : nodoSegundo.posiciones){
					listaPosiciones.add(i);
					listaEnMemoria.get(i - 1).contador = listaEnMemoria.get(i - 1).contador + 1;
				}
			}
			
			HuffmanNode nuevoNodo = new HuffmanNode(frecuencia, 0, listaPosiciones, 0);
			listaSuma.add(nuevoNodo);
			listaSuma.sort(Comparator.comparing(HuffmanNode::getFrecuencia));
		}
		
		
		double longitud = longitudMedia(listaEnMemoria);
		double entropia = entropia(listaEnMemoria);
		double eficacia = eficacia(longitud, entropia);
		
		System.out.println("Longitud - " + longitud);
		System.out.println("Entropia - " + entropia);
		System.out.println("Eficacia - " + eficacia);
	}
	
	public static double longitudMedia(List<HuffmanNode> listaCalculada){
		listaCalculada.sort(Comparator.comparing(HuffmanNode::getContador));
		
		double valor = 0.0;
		double sumaTotal = 0.0;
		
		for(HuffmanNode n : listaCalculada) {
			sumaTotal = sumaTotal + n.frecuencia;
		}
		
		for(HuffmanNode n : listaCalculada){
			valor = valor + (n.contador * (n.frecuencia / sumaTotal));
		}
		
		return valor;
	}
	
	public static double entropia(List<HuffmanNode> listaCalculada) {
		double valor = 0.0;
		double sumaTotal = 0.0;
		
		for(HuffmanNode n : listaCalculada) {
			sumaTotal = sumaTotal + n.frecuencia;
		}
		
		for(HuffmanNode n : listaCalculada) {
			valor = valor + ((n.frecuencia / sumaTotal) * (Math.log(sumaTotal / n.frecuencia) / Math.log(2)));
		}
		
		return valor;
	}
	
	public static double eficacia(double longitud, double entropia) {
		double eficacia = entropia / longitud;
		
		return eficacia;
	}
	
	public static List<HuffmanNode> f2(int n,List<HuffmanNode> listaMultiplicada)
	{
		if(n == 1)
		{
			return listaMultiplicada;
		}
		
		else
		{
			int cont = 1;
			for(HuffmanNode i: listaNodos)
	    	{
	    		for(HuffmanNode n2 : listaMultiplicada)
	    		{
	    			
	    			listaNodosF2.add(new HuffmanNode(i.frecuencia * n2.frecuencia, cont, null, 0));
	    			
	    			cont++;
	    		}
	    	}
			List<HuffmanNode> listaTemp = new ArrayList<HuffmanNode>(listaNodosF2);
			listaNodosF2.clear();
			return f2(n-1,listaTemp);
		}
		
	}
	
    public static void main(String[] args){
    	
    	
    	listaNodos.add(new HuffmanNode(1, 1, null, 0));
    	listaNodos.add(new HuffmanNode(9, 2, null, 0));
    	//listaNodos.add(new HuffmanNode(3, 3, null, 0));
    	//listaNodos.add(new HuffmanNode(9, 4, null, 0));
    	/*listaNodos.add(new HuffmanNode(69, 5, null, 0));
    	listaNodos.add(new HuffmanNode(84, 6, null, 0));
    	listaNodos.add(new HuffmanNode(79, 7, null, 0));
    	listaNodos.add(new HuffmanNode(32, 8, null, 0));
    	listaNodos.add(new HuffmanNode(68, 9, null, 0));
    	listaNodos.add(new HuffmanNode(69, 10, null, 0));
    	listaNodos.add(new HuffmanNode(32, 11, null, 0));
    	listaNodos.add(new HuffmanNode(85, 12, null, 0));
    	listaNodos.add(new HuffmanNode(78, 13, null, 0));
    	listaNodos.add(new HuffmanNode(79, 14, null, 0));
    	listaNodos.add(new HuffmanNode(32, 15, null, 0));
    	listaNodos.add(new HuffmanNode(83, 16, null, 0));
    	listaNodos.add(new HuffmanNode(69, 17, null, 0));
    	listaNodos.add(new HuffmanNode(67, 18, null, 0));
    	listaNodos.add(new HuffmanNode(82, 19, null, 0));
    	listaNodos.add(new HuffmanNode(69, 20, null, 0));
    	listaNodos.add(new HuffmanNode(84, 21, null, 0));
    	listaNodos.add(new HuffmanNode(79, 22, null, 0));
    	listaNodos.add(new HuffmanNode(32, 23, null, 0));
    	listaNodos.add(new HuffmanNode(83, 24, null, 0));
    	listaNodos.add(new HuffmanNode(69, 25, null, 0));
    	listaNodos.add(new HuffmanNode(71, 26, null, 0));
    	listaNodos.add(new HuffmanNode(85, 27, null, 0));
    	listaNodos.add(new HuffmanNode(82, 28, null, 0));
    	listaNodos.add(new HuffmanNode(79, 29, null, 0));*/
    	
    	
    	
    	
    	System.out.print("Escriba el numero: ");
    	scanner = new Scanner(System.in);
    	int n = scanner.nextInt();

    	if(n > 1)
    	{
    		listaEnviar = f2(n,listaNodos);
			//System.out.println(listaTemp.get(1).frecuencia);
    		calcularLongitudes(listaEnviar);

    	}
    	else
    	{
    		calcularLongitudes(listaNodos);
    	}
    	
    	
    }
}
