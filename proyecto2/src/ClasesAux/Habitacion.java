package ClasesAux;

import EDD.ListaSimple;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author 58412
 */
public class Habitacion {
    int numero;
    String tipo;
    int piso;
    ListaSimple clientes;

    public Habitacion(int numero, String tipo, int piso, ListaSimple clientes) {
        this.numero = numero;
        this.tipo = tipo;
        this.piso = piso;
        this.clientes = clientes;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public int getPiso() {
        return piso;
    }

    public void setPiso(int piso) {
        this.piso = piso;
    }

    public ListaSimple getClientes() {
        return clientes;
    }

    public void setClientes(ListaSimple clientes) {
        this.clientes = clientes;
    }
    
    
    
}
