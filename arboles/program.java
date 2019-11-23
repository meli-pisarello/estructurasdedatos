package arboles;

import arboles.ArbolBinario;
import arboles.NodoABinario;

public class program {
    public static void main(String[] args) {
        ArbolBinario arbolito = new ArbolBinario();

        arbolito.agregar("+");
        arbolito.agregar("*");
        arbolito.agregar("-");
        arbolito.agregar("1");
        arbolito.agregar("3");
        arbolito.agregar("1");
        arbolito.agregar("6");
        // cuando se trata de nodos alfanuméricos, el método agregar no funciona bien
        arbolito.imprimirPreOrder();
     
        System.out.println("--------------------------------");
        NodoABinario mas = new NodoABinario("+");

        mas.izq = new NodoABinario("*");
        mas.der = new NodoABinario("-");

        mas.izq.izq = new NodoABinario("1");
        mas.izq.der = new NodoABinario("3");

        mas.der.izq = new NodoABinario("1");
        mas.der.der = new NodoABinario("6");

        ArbolBinario ar = new ArbolBinario();

        ar.construir(mas);

        ar.imprimirPreOrder();
        System.out.println("------------------------");
    }
}
