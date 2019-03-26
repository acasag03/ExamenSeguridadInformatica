import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Huffman{

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
		
		System.out.println("Longitud - " + longitud);
	}
	
	public static double longitudMedia(List<HuffmanNode> listaCalculada){
		listaCalculada.sort(Comparator.comparing(HuffmanNode::getContador));
		
		double valor = 0.0;
		
		for(HuffmanNode n : listaCalculada){
			valor = valor + (n.contador * n.frecuencia);
		}
		
		return valor;
	}
	
    public static void main(String[] args){
    	List<HuffmanNode> listaNodos = new ArrayList<HuffmanNode>();
    	
    	listaNodos.add(new HuffmanNode(0.3, 1, null, 0));
    	listaNodos.add(new HuffmanNode(0.2, 2, null, 0));
    	listaNodos.add(new HuffmanNode(0.1, 3, null, 0));
    	listaNodos.add(new HuffmanNode(0.1, 4, null, 0));
    	listaNodos.add(new HuffmanNode(0.05, 5, null, 0));
    	listaNodos.add(new HuffmanNode(0.05, 6, null, 0));
    	listaNodos.add(new HuffmanNode(0.05, 7, null, 0));
    	listaNodos.add(new HuffmanNode(0.05, 8, null, 0));
    	listaNodos.add(new HuffmanNode(0.05, 9, null, 0));
    	listaNodos.add(new HuffmanNode(0.05, 10, null, 0));
    	
    	
    	calcularLongitudes(listaNodos);
    }
}
