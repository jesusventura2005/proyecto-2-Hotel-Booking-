/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */



/**
 *
 * @author jesus
 */
public class NodoCola {
    private Nodo_ABB dato;
    private NodoCola sig;

    public NodoCola(Nodo_ABB dato) {
        this.dato = dato;
        this.sig = null;
    }

    public Nodo_ABB getDato() {
        return dato;
    }

    public void setDato(Nodo_ABB dato) {
        this.dato = dato;
    }

    public NodoCola getSig() {
        return sig;
    }

    public void setSig(NodoCola sig) {
        this.sig = sig;
    }
    
    
    
    
    
    
    
    
    
    
}
