package Proyecto2;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author 58412
 */
public class NodoListaSimple {
    Object data;
    NodoListaSimple pNext;

    public NodoListaSimple(Object data) {
        this.data = data;
        this.pNext = null;   
    }

    public Object getData() {
        return data;
    }

    public NodoListaSimple getpNext() {
        return pNext;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public void setpNext(NodoListaSimple pNext) {
        this.pNext = pNext;
    }
}
