package EDD;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 * Esta clase representa un nodo de una lista enlazada simple.
 * @author Daniel Fariña
 * @version 16/03/2024
 */
public class NodoListaSimple {
    Object data;
    NodoListaSimple pNext;

    /**
     * Constructor para crear un nuevo nodo con el dato especificado.
     * @param data El dato a almacenar en el nodo.
     */
    public NodoListaSimple(Object data) {
        this.data = data;
        this.pNext = null;   
    }

    /**
     * Obtiene el dato almacenado en el nodo.
     * @return El dato almacenado en el nodo.
     */
    public Object getData() {
        return data;
    }

    /**
     * Obtiene la referencia al siguiente nodo en la lista.
     * @return La referencia al siguiente nodo en la lista.
     */
    public NodoListaSimple getpNext() {
        return pNext;
    }

    /**
     * Establece el dato almacenado en el nodo.
     * @param data El nuevo dato a almacenar en el nodo.
     */
    public void setData(Object data) {
        this.data = data;
    }

    /**
     * Establece la referencia al siguiente nodo en la lista.
     * @param pNext El siguiente nodo en la lista.
     */
    public void setpNext(NodoListaSimple pNext) {
        this.pNext = pNext;
    }
}
