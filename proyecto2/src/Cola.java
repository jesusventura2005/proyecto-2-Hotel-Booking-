/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author jesus
 */
public class Cola {

    private NodoCola primero, ultimo;

    public Cola() {
        primero = null;
        ultimo = null;
    }

    public boolean esvacio() {
        return primero == null;
    }

    public void encolar(Nodo_ABB dato) {
        NodoCola nuevo = new NodoCola(dato);
        if (esvacio()) {
            primero = nuevo;

        } else {
            ultimo.setSig(nuevo);
            ultimo = nuevo;

        }

    }

    public Nodo_ABB desencolar() {
        Nodo_ABB aux = null;
        if (!esvacio()) {
            aux = primero.getDato();
            primero = primero.getSig();
            if (primero == null) {
                ultimo = null;
            }

        }
        return aux;
    }

}
