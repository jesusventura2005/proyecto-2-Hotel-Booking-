package ClasesAux;

import EDD.ListaSimple;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 * Clase que representa una habitación en un hotel.
 * @author Daniel Fariña
 * @version 16/03/2024
 */
public class Habitacion {
    int numero;
    String tipo;
    int piso;
    ListaSimple clientes;

    /**
     * Constructor de la clase Habitacion.
     * @param numero El número de la habitación.
     * @param tipo El tipo de habitación.
     * @param piso El piso en el que se encuentra la habitación.
     * @param clientes La lista de clientes que han ocupado la habitación.
     */
    public Habitacion(int numero, String tipo, int piso, ListaSimple clientes) {
        this.numero = numero;
        this.tipo = tipo;
        this.piso = piso;
        this.clientes = clientes;
    }

    /**
     * Devuelve el número de la habitación.
     * @return El número de la habitación.
     */
    public int getNumero() {
        return numero;
    }

    /**
     * Establece el número de la habitación.
     * @param numero El nuevo número de la habitación.
     */
    public void setNumero(int numero) {
        this.numero = numero;
    }

    /**
     * Devuelve el tipo de la habitación.
     * @return El tipo de la habitación.
     */
    public String getTipo() {
        return tipo;
    }

    /**
     * Establece el tipo de la habitación.
     * @param tipo El nuevo tipo de la habitación.
     */
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    /**
     * Devuelve el piso en el que se encuentra la habitación.
     * @return El piso de la habitación.
     */
    public int getPiso() {
        return piso;
    }

    /**
     * Establece el piso en el que se encuentra la habitación.
     * @param piso El nuevo piso de la habitación.
     */
    public void setPiso(int piso) {
        this.piso = piso;
    }

    /**
     * Devuelve la lista de clientes que han ocupado la habitación.
     * @return La lista de clientes de la habitación.
     */
    public ListaSimple getClientes() {
        return clientes;
    }

    /**
     * Establece la lista de clientes que han ocupado la habitación.
     * @param clientes La nueva lista de clientes de la habitación.
     */
    public void setClientes(ListaSimple clientes) {
        this.clientes = clientes;
    }
    
    
    
}
