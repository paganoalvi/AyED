package Practica2;

import java.util.LinkedList;
import java.util.Queue;

import tp3.ejercicio1.GeneralTree;

public class ParcialArboles {
	BinaryTree<Integer> arbol;
	
	public ParcialArboles(BinaryTree<Integer> unArbol) {
		this.arbol = unArbol;
	}
	
	public boolean isLeftTree(int num) {
		boolean aux = false;
		
		if(this.arbol == null) {
			return aux;
		}else {
			BinaryTree<Integer> ab = buscarNum(this.arbol,num);
			if(ab != null) {
				aux = verifica(ab);
			}
			
		}
		return aux;		
	}
	
	public BinaryTree<Integer> buscarNum(BinaryTree<Integer> arbol, int num){				
		if(arbol.getData() == num) {
			return arbol;
		}
		BinaryTree<Integer> encontrado = null; 
		if(arbol.hasLeftChild()) {
			encontrado = buscarNum(arbol.getLeftChild(),num);
		}
		if(arbol.hasRightChild()) {
			encontrado = buscarNum(arbol.getRightChild(),num);
		}
		return encontrado;
	}
		
	
	
	public boolean verifica(BinaryTree<Integer> ab) {
		int izq,der = 0;
		
		if (ab.hasLeftChild()) {
			izq = contarHijoUnico(ab.getLeftChild());			
		}else {
			izq = -1;
		}
		
		if(ab.hasRightChild()) {
			der = contarHijoUnico(ab.getRightChild());			
		}else {
			der = -1;
		}
	    	    	    							
		return izq > der;
	}
	
	public int contarHijoUnico(BinaryTree<Integer> ab) {
		int cuenta = 0;
		
		boolean tieneIzq = ab.hasLeftChild();
		boolean tieneDer = ab.hasRightChild();
		
		if((tieneIzq && !tieneDer) || (tieneDer && !tieneIzq)) {
			cuenta = 1;
		}
		
		if(tieneIzq) {
			cuenta += contarHijoUnico(ab.getLeftChild());
		}
		if(tieneDer) {
			cuenta += contarHijoUnico(ab.getRightChild());
		}
		
		return cuenta;
	}
	
	
	
	public boolean isLeftTree2(int num){
		boolean es = false;
		if(!this.arbol.isEmpty()) {
			es = isLeftTreeHelper(this.arbol,num);
		}				
		return es;
	}
	
	private boolean isLeftTreeHelper(BinaryTree<Integer> a,int num){
		boolean es = false;
		BinaryTree<Integer> subArbolNum = buscarSubArbolNum(this.arbol,num);
		if(subArbolNum != null) {
			es = cumple(subArbolNum);			
		}		
		return es;		
	}
	
	private BinaryTree<Integer> buscarSubArbolNum(BinaryTree<Integer> a,int num){
		Queue <BinaryTree<Integer>> cola = new LinkedList<>();
		cola.add(a);
		while(!cola.isEmpty()) {
			BinaryTree<Integer> nodo = cola.poll();
			Integer valor = nodo.getData();
			if(valor == num) {
				return nodo;					
			}		
			if(nodo.hasLeftChild()) {
				cola.add(nodo.getLeftChild());
			}
			if(nodo.hasRightChild()) {
				cola.add(nodo.getRightChild());
			}
		}
		return null;
	}
	
	
	private boolean cumple(BinaryTree<Integer> a) {
		int cantHijosUnicosRI = 0;
		int cantHijosUnicosRD = 0;
		if(a.hasLeftChild()) {
			cantHijosUnicosRI = contarHijosUnicosNum(a.getLeftChild());
		}else {cantHijosUnicosRI = -1;}
		if(a.hasRightChild()) {
			cantHijosUnicosRD = contarHijosUnicosNum(a.getRightChild());			
		}else {cantHijosUnicosRD = -1;}
		
		return cantHijosUnicosRI > cantHijosUnicosRD;
		
	}
	private int contarHijosUnicosNum(BinaryTree<Integer> a) {
		int cant = 0;
		
		boolean tieneHI = a.hasLeftChild();
		boolean tieneHD = a.hasRightChild();
		
		if( (tieneHI && !tieneHD) || (!tieneHI && tieneHD)) {
			cant ++;
		}
		if(tieneHI) {
			cant += contarHijosUnicosNum(a.getLeftChild());
		}
		if(tieneHD) {
			cant += contarHijosUnicosNum(a.getRightChild());
		}
		
		return cant;
	}
	
	public static boolean resolver (GeneralTree<Integer> arbol) {
		boolean creciente = false;
		
		if( (arbol != null) && (!arbol.isEmpty()) ) {
			creciente = resolverHelper(arbol);
		}
		return creciente;
	}
	
	private static boolean resolverHelper (GeneralTree<Integer> a) {
		boolean esCreciente = true;
		Queue <GeneralTree<Integer>> cola = new LinkedList<>();
		cola.add(a);
		cola.add(null);
		int nodosNivelAct =0;
		int nodosNivelAnt = 0;
		while(!cola.isEmpty() && (esCreciente)) {
			GeneralTree<Integer> nodo = cola.poll();
			if(nodo != null) {
				nodosNivelAct ++;
				
				for(GeneralTree<Integer> hijos : nodo.getChildren()) {					
					cola.add(hijos);
				}		
				
			}else {
				esCreciente = (nodosNivelAct == nodosNivelAnt + 1);
				nodosNivelAnt = nodosNivelAct;
				nodosNivelAct = 0;
				if(!cola.isEmpty()) {
					cola.add(null);
				}			
			}		
			
		}
		return esCreciente;
	}
}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

