package EDD;

import ClasesAux.ClienteHistorico;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 * Esta clase representa una lista simplemente enlazada.
 * @author Daniel Fariña
 * @version 17/03/2024
 */
public class ListaSimple {
    NodoListaSimple pFirst;
    NodoListaSimple pLast;
    int size;

    /**
     * Constructor que crea una lista vacía.
     */
    public ListaSimple() {
        this.pFirst = null;
        this.pLast = null;
        this.size = 0;
    }

    /**
     * Obtiene el primer nodo de la lista.
     * @return El primer nodo de la lista.
     */
    public NodoListaSimple getpFirst() {
        return pFirst;
    }

    /**
     * Obtiene el último nodo de la lista.
     * @return El último nodo de la lista.
     */
    public NodoListaSimple getpLast() {
        return pLast;
    }

    /**
     * Obtiene el tamaño actual de la lista.
     * @return El tamaño actual de la lista.
     */
    public int getSize() {
        return size;
    }

    /**
     * Establece el primer nodo de la lista.
     * @param pFirst El nuevo primer nodo de la lista.
     */
    public void setpFirst(NodoListaSimple pFirst) {
        this.pFirst = pFirst;
    }

    /**
     * Establece el último nodo de la lista.
     * @param pLast El nuevo último nodo de la lista.
     */
    public void setpLast(NodoListaSimple pLast) {
        this.pLast = pLast;
    }

    /**
     * Establece el tamaño actual de la lista.
     * @param size El nuevo tamaño actual de la lista.
     */
    public void setSize(int size) {
        this.size = size;
    }
    
    /**
     * Inserta un nuevo nodo al final de la lista con el dato especificado.
     * @param data El dato a almacenar en el nuevo nodo.
     */
    public void insertarFinal(Object data){
        NodoListaSimple nuevoNodo = new NodoListaSimple(data);
        if(this.esVacio()){
            pFirst = pLast = nuevoNodo;
        }else{
            pLast.setpNext(nuevoNodo);
            pLast = nuevoNodo;
        }
        size++;
    }
    
    /**
     * Verifica si la lista está vacía.
     * @return true si la lista está vacía, false de lo contrario.
     */
    public boolean esVacio(){
        return getpFirst()==null;
    }
    
    /**
     * Vacía la lista, eliminando todos sus nodos.
     */
    public void vaciar(){
        this.pFirst = null;
        this.pLast = null;
        this.size = 0;
    }
    
    /**
     * Elimina el nodo que contiene el valor especificado de la lista.
     * Si hay varios nodos con el mismo valor, elimina el primero que encuentra.
     * @param valor El valor a eliminar de la lista.
     */
    public void eliminar(Object valor) {
        if (pFirst == null) {
            // La lista está vacía, no hay nada que eliminar
            return;
        }

        if (pFirst.getData().equals(valor)) {
            // El valor a eliminar está en el primer nodo
            pFirst = pFirst.getpNext();
            size--;
            if (pFirst == null) {
                // Si la lista queda vacía después de eliminar el nodo,
                // también actualizamos el puntero al último nodo
                pLast = null;
            }
            return;
        }

        NodoListaSimple current = pFirst;
        while (current.getpNext() != null && !current.getpNext().getData().equals(valor)) {
            current = current.getpNext();
        }

        if (current.getpNext() != null) {
            // Encontramos el nodo que contiene el valor a eliminar
            current.setpNext(current.getpNext().getpNext());
            size--;
            if (current.getpNext() == null) {
                // Si el nodo eliminado era el último nodo,
                // actualizamos el puntero al último nodo
                pLast = current;
            }
        }
    }
    
    /**
     * Genera una representación en forma de cadena de texto de los clientes históricos almacenados en la lista.
     * @return Una cadena de texto que contiene la información de los clientes históricos.
     */
    public String toStringClientesHistoricos() {
        StringBuilder sb = new StringBuilder();
        sb.append("""
                  Lista de Clientes que alguna vez se
                  hospedaron en la habitación:
                   
                  """);
        NodoListaSimple current = pFirst;
        while (current != null) {
            sb.append(((ClienteHistorico) current.getData()).toString()).append("\n");
            current = current.getpNext();
        }
        return sb.toString();
    }
    

}