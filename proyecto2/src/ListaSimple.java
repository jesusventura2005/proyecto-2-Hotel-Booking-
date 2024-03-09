/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author 58412
 */
public class ListaSimple {
    Nodo pFirst;
    Nodo pLast;
    int size;

    public ListaSimple() {
        this.pFirst = null;
        this.pLast = null;
        this.size = 0;
    }

    public ListaSimple(Nodo pFirst, Nodo pLast, int size) {
        this.pFirst = pFirst;
        this.pLast = pLast;
        this.size = size;
    }

    public Nodo getpFirst() {
        return pFirst;
    }

    public Nodo getpLast() {
        return pLast;
    }

    public int getSize() {
        return size;
    }

    public void setpFirst(Nodo pFirst) {
        this.pFirst = pFirst;
    }

    public void setpLast(Nodo pLast) {
        this.pLast = pLast;
    }

    public void setSize(int size) {
        this.size = size;
    }
    
    public void insertarInicio(Object data){
        Nodo nuevoNodo = new Nodo(data);
        if(this.esVacio()){
            pFirst = pLast = nuevoNodo;
        }else{
            nuevoNodo.setpNext(pFirst);
            pFirst = nuevoNodo;
        }
        size++;
    }
    
    public void insertarFinal(Object data){
        Nodo nuevoNodo = new Nodo(data);
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
}
