package EDD;

import ClasesAux.ClienteHistorico;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author 58412
 */
public class ListaSimple {
    NodoListaSimple pFirst;
    NodoListaSimple pLast;
    int size;

    public ListaSimple() {
        this.pFirst = null;
        this.pLast = null;
        this.size = 0;
    }

    public ListaSimple(NodoListaSimple pFirst, NodoListaSimple pLast, int size) {
        this.pFirst = pFirst;
        this.pLast = pLast;
        this.size = size;
    }

    public NodoListaSimple getpFirst() {
        return pFirst;
    }

    public NodoListaSimple getpLast() {
        return pLast;
    }

    public int getSize() {
        return size;
    }

    public void setpFirst(NodoListaSimple pFirst) {
        this.pFirst = pFirst;
    }

    public void setpLast(NodoListaSimple pLast) {
        this.pLast = pLast;
    }

    public void setSize(int size) {
        this.size = size;
    }
    
    public void insertarInicio(Object data){
        NodoListaSimple nuevoNodo = new NodoListaSimple(data);
        if(this.esVacio()){
            pFirst = pLast = nuevoNodo;
        }else{
            nuevoNodo.setpNext(pFirst);
            pFirst = nuevoNodo;
        }
        size++;
    }
    
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
    
    public boolean esVacio(){
        return getpFirst()==null;
    }
    
    public void vaciar(){
        this.pFirst = null;
        this.pLast = null;
        this.size = 0;
    }
            
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

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("ListaSimple: [");
        NodoListaSimple current = pFirst;
        while (current != null) {
            sb.append(current.getData());
            if (current.getpNext() != null) {
                sb.append(", ");
            }
            current = current.getpNext();
        }
        sb.append("]");
        return sb.toString();
    }
    
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