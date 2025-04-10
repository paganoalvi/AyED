package practica2;

public class RedBinariaLlena {
	private BinaryTree<Integer> arbol;
	
	public RedBinariaLlena(BinaryTree<Integer> unArbol) {
		this.arbol = unArbol;
	}
	
	public int retardoReenvio() {
		return retardoReenvioHelper(arbol,0,new int [] {-9999});
	}
	
	public int retardoReenvioHelper(BinaryTree <Integer> nodo,int sumaActual,int []maximo) {
		
		if(nodo == null) {
			return maximo[0];
		}
		
		sumaActual += nodo.getData();  // acumulo valor del nodo actual con el valor del nodo padre
		
		if (nodo.isLeaf()) {
			if(sumaActual >= maximo[0]) {
				maximo[0] = sumaActual;
			}
			
		}else {
			retardoReenvioHelper(nodo.getLeftChild(),sumaActual,maximo);
			retardoReenvioHelper(nodo.getRightChild(),sumaActual,maximo);
		}		
		
		return maximo[0];
		
	}

}
