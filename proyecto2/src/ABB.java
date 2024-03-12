/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author jesus
 */
public class ABB {

    private Nodo_ABB raiz;

    private int cantidad; //Cantidad de Nodos
    private int altura; //Altura del arbol

    public ABB() {
        raiz = null;
        cantidad = 0;
        altura = 0;

    }
    
    public boolean esvacio(){
        return raiz == null;
    }
    
    // Método para insertar un nodo en el árbol
    public void insertar(int dato) {
        raiz = insertarRecursivo(raiz, dato);
    }
    
    // Método recursivo para insertar un nodo en el árbol
    private Nodo_ABB insertarRecursivo(Nodo_ABB nodo, int dato) {
        if (nodo == null) {
            cantidad++;
            return new Nodo_ABB( dato);
        }
        
        if (dato < nodo.getDato()) {
            nodo.setHijo_izq(insertarRecursivo(nodo.getHijo_izq(), dato));
        } else if (dato > nodo.getDato()) {
            nodo.setHijo_der(insertarRecursivo(nodo.getHijo_der(), dato));
        }
        
        return nodo;
    }
    
    // Método para buscar un nodo en el árbol
    public boolean buscar(int dato) {
        return buscarRecursivo(raiz, dato);
    }
    
    // Método recursivo para buscar un nodo en el árbol
    private boolean buscarRecursivo(Nodo_ABB nodo, int dato) {
        if (nodo == null) {
            return false;
        }
        
        if (dato == nodo.getDato()) {
            return true;
        } else if (dato < nodo.getDato()) {
            return buscarRecursivo(nodo.getHijo_izq(), dato);
        } else {
            return buscarRecursivo(nodo.getHijo_der(), dato);
        }
    }
    
    // Otros métodos como eliminar, calcular altura, etc.
    
    public Nodo_ABB getRaiz() {
        return raiz;
    }

    public void setRaiz(Nodo_ABB raiz) {
        this.raiz = raiz;
    }

}
