package Proyecto2;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author 58412
 */
public class HashTable {
    private Cliente[] table;
    private int size;
    private final int capacity;

    public HashTable() {
        this.capacity = 450;
        table = new Cliente[capacity];
        size = 0;
    }

    public void insertar(Cliente cliente) {
        if (size == capacity) {
            System.out.println("Tabla hash llena, no se puede agregar más elementos.");
            return;
        }
        int hash = hash(cliente.getApellido() + cliente.getNombre());
        int index = hash;
        while (table[index] != null) {
            index = (index + 1) % capacity; // Sondaje lineal
        }
        table[index] = cliente;
        size++;
    }

    public Cliente buscar(String apellido, String nombre) {
        int hash = hash(apellido + nombre);
        int index = hash;
        while (table[index] != null) {
            if (table[index].getApellido().equals(apellido) && table[index].getNombre().equals(nombre)) {
                return table[index];
            }
            index = (index + 1) % capacity; // Sondaje lineal
        }
        return null;
    }
    
    public void eliminar(String apellido, String nombre) {
        int hash = hash(apellido + nombre);
        int index = hash;
        while (table[index] != null) {
            if (table[index].getApellido().equals(apellido) && table[index].getNombre().equals(nombre)) {
                table[index] = null; // Eliminamos el elemento de la tabla
                size--;
                return;
            }
            index = (index + 1) % capacity; // Sondaje lineal
        }
    }

    private int hash(String key) {
        int hash = 0;
        for (int i = 0; i < key.length(); i++) {
            hash = (31 * hash + key.charAt(i)) % capacity;
        }
        return Math.abs(hash);
    }
    
}

