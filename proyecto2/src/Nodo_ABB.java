/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author jesus
 */
public class Nodo_ABB {
    
    private Nodo_ABB hijo_der;
    private Nodo_ABB hijo_izq;
    private Object dato;

    public Nodo_ABB(Object dato) {
        this.dato = dato;
        this.hijo_der = null;
        this.hijo_izq = null;
    }

    public Nodo_ABB getHijo_der() {
        return hijo_der;
    }

    public void setHijo_der(Nodo_ABB hijo_der) {
        this.hijo_der = hijo_der;
    }

    public Nodo_ABB getHijo_izq() {
        return hijo_izq;
    }

    public void setHijo_izq(Nodo_ABB hijo_izq) {
        this.hijo_izq = hijo_izq;
    }

    public Object getDato() {
        return dato;
    }

    public void setDato(Object dato) {
        this.dato = dato;
    }
    
}
