package Practica2;

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
}
