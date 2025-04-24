package tp3.ejercicio1;

import java.util.LinkedList;
import java.util.List;

public class RecorridosAG {
	
	public List<Integer> numerosImparesMayoresQuePreOrden(GeneralTree<Integer>a,Integer n){
		List<Integer> resultado = new LinkedList<Integer>();
		if( (a != null) && (!a.isEmpty()) ) {
			resultado = numImpMayQuePreOrden(a,n);
		}		
		return resultado;
	}
	
	private List<Integer> numImpMayQuePreOrden(GeneralTree<Integer> a,Integer n) {
		List <Integer> resultado = new LinkedList<Integer>();
		Integer valor = a.getData();
		if((valor %2 != 0) && (valor > n)) {
			resultado.add(valor);			
		}
		for (GeneralTree<Integer> hijo : a.getChildren()) {
			resultado.addAll(numImpMayQuePreOrden(hijo,n));
		}
		return resultado;		
	}
	
	public List<Integer> numerosImparesMayoresQueInOrden(GeneralTree<Integer> a,Integer n){
		List<Integer> resultado = new LinkedList<Integer>();
		if( (a != null) && (!a.isEmpty()) ) {
			resultado = numImpMayQueInOrden(a,n);
		}		
		return resultado;
	}
	
	private List<Integer> numImpMayQueInOrden(GeneralTree<Integer> a ,Integer n){
		List<Integer> resultado = new LinkedList();
		
		
		
		
		return resultado;
	}

}
