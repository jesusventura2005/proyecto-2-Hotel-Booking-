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
    private int dato;
    private int altura; 

    public Nodo_ABB(int dato) {
        this.dato = dato;
        this.hijo_der = null;
        this.hijo_izq = null;
        this.altura = 1; 
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

    public int getDato() {
        return dato;
    }

    public void setDato(int dato) {
        this.dato = dato;
    }

    public int getAltura() {
        return altura;
    }

    public void setAltura(int altura) {
        this.altura = altura;
    }
    
}
