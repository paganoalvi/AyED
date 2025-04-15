package Practica2;

import java.util.Queue;
import java.util.LinkedList;

public class ProfundidadDeArbolBinario {
    
    private BinaryTree<Integer> arbol;

    public ProfundidadDeArbolBinario(BinaryTree<Integer> arbol) {
        this.arbol = arbol;
    }

    public int sumaElementosProfundidad(int p) {
        if (arbol == null || arbol.isEmpty()) {
            return 0;
        }

        int suma = 0;
        Queue<NodoConNivel> cola = new LinkedList<>(); // creo cola,que contiene NodConNivel(regitro)
        cola.offer(new NodoConNivel(arbol, 0)); // Empiezo con nivel 0(raiz)
        // no necesito encolar marca de nivel porque voy llevando cuenta del nivel en el regitro nodocon nivel

        while (!cola.isEmpty()) {
            NodoConNivel actual = cola.poll(); //desencolo regitro completo y guardo en actual
            BinaryTree<Integer> nodo = actual.getNodo();//me quedo solo con el campo nodo (arbol)
            int nivel = actual.getNivel(); // guardo en nivel el campo nivel del registro
            
            if (nivel > p) { // si ya procese todo el nivel p quiero cortar, porque no quiero seguir recorriendo todo el arbol
            	break;
            }

            if (nivel == p) {
                suma += nodo.getData();
            }

            if (nodo.hasLeftChild()) {
                cola.offer(new NodoConNivel(nodo.getLeftChild(), nivel + 1));
            }
            if (nodo.hasRightChild()) {
                cola.offer(new NodoConNivel(nodo.getRightChild(), nivel + 1));
            }
        }

        return suma;
    }
}
