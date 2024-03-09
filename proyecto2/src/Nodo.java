/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author 58412
 */
public class Nodo {
    Object data;
    Nodo pNext;

    public Nodo(Object data) {
        this.data = data;
        this.pNext = null;   
    }

    public Object getData() {
        return data;
    }

    public Nodo getpNext() {
        return pNext;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public void setpNext(Nodo pNext) {
        this.pNext = pNext;
    }
}
