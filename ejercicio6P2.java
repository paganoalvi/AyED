package Practica2;
import java.util.BinaryTree;

public class Transformacion(){
    private BinaryTree<Integer> arbol;

    public Transformacion(BinaryTree<Integer> unArbol){
        this.arbol = unArbol;
    }

    public static BinaryTree<Integer> Suma (BinaryTree<Integer> arbol){
        Transformacion(arbol);
        return arbol;
    }

    private int Transformacion(BinaryTree<Integer> ab){
        if ( ( ab == null ) || ( ab.isEmpty() ) ){
            return 0;
        }
        int valorActual = ab.getData;

        if(ab.isLeaf()){
            ab.setDato(0);
            return valorActual;
        }else{
            int sumaHI = Transformacion(ab.getLeftChild());
            int sumaHD = Transformacion(ab.getRightChild());
            int suma = sumaHI + sumaHD;
            ab.setDato(suma);
        }
        return suma + valorActual;
    }
}