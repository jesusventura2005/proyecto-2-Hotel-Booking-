package EDD;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 * La clase Nodo_ABB representa un nodo de un árbol binario de búsqueda (ABB). Cada nodo tiene un dato, un hijo izquierdo, un hijo derecho y una altura.
 * @author Jesús Ventura
 * @version 13/03/2024
 */
public class Nodo_ABB {
    
    private Nodo_ABB hijo_der;
    private Nodo_ABB hijo_izq;
    private Object dato;
    private int altura; 

    /**
     * Constructor de la clase Nodo_ABB.
     * @param dato El dato que se almacenará en el nodo.
     */
    public Nodo_ABB(Object dato) {
        this.dato = dato;
        this.hijo_der = null;
        this.hijo_izq = null;
        this.altura = 1; 
    }
    
    /**
     * Obtiene el hijo derecho del nodo.
     * @return El hijo derecho del nodo.
     */
    public Nodo_ABB getHijo_der() {
        return hijo_der;
    }

    /**
     * Establece el hijo derecho del nodo.
     * @param hijo_der El nodo que se establecerá como hijo derecho.
     */
    public void setHijo_der(Nodo_ABB hijo_der) {
        this.hijo_der = hijo_der;
    }

    /**
     * Obtiene el hijo izquierdo del nodo.
     * @return El hijo izquierdo del nodo.
     */
    public Nodo_ABB getHijo_izq() {
        return hijo_izq;
    }

    /**
     * Establece el hijo izquierdo del nodo.
     * @param hijo_izq El nodo que se establecerá como hijo izquierdo.
     */
    public void setHijo_izq(Nodo_ABB hijo_izq) {
        this.hijo_izq = hijo_izq;
    }

    /**
     * Obtiene el dato almacenado en el nodo.
     * @return El dato almacenado en el nodo.
     */
    public Object getDato() {
        return dato;
    }

    /**
     * Establece el dato almacenado en el nodo.
     * @param dato El dato que se establecerá en el nodo.
     */
    public void setDato(Object dato) {
        this.dato = dato;
    }

    /**
     * Obtiene la altura del nodo en el árbol.
     * @return La altura del nodo.
     */
    public int getAltura() {
        return altura;
    }

    /**
     * Establece la altura del nodo en el árbol.
     * @param altura La altura que se establecerá para el nodo.
     */
    public void setAltura(int altura) {
        this.altura = altura;
    }
    
}
