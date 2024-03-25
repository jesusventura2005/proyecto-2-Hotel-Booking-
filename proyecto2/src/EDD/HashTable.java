package EDD;

import ClasesAux.Cliente;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 * Esta clase implementa una tabla hash para almacenar objetos de tipo Cliente.
 * @author Daniel Fariña
 * @version 17/03/2024
 */
public class HashTable {
    private final Cliente[] table;
    private int size;
    private final int capacity;

    /**
     * Constructor que crea una tabla hash con una capacidad predeterminada de 500.
     */
    public HashTable() {
        this.capacity = 500;
        table = new Cliente[capacity];
        size = 0;
    }

    /**
     * Inserta un cliente en la tabla hash.
     * @param cliente El cliente a insertar.
     */
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

    /**
     * Busca un cliente en la tabla hash por su apellido y nombre, utilizando Sondaje lineal.
     * @param apellido El apellido del cliente a buscar.
     * @param nombre El nombre del cliente a buscar.
     * @return El cliente encontrado, o null si no se encuentra.
     */
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
    
    /**
     * Elimina un cliente de la tabla hash por su apellido y nombre, utilizando Sondaje lineal.
     * @param apellido El apellido del cliente a eliminar.
     * @param nombre El nombre del cliente a eliminar.
     */
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

    /**
     * Función de hash que calcula el índice de la tabla hash para una clave dada.
     * @param key La clave para la cual se calculará el hash.
     * @return El índice de la tabla hash calculado para la clave dada.
     */
    private int hash(String key) {
        int hash = 0;
        for (int i = 0; i < key.length(); i++) {
            hash = (31 * hash + key.charAt(i)) % capacity;
        }
        return Math.abs(hash);
    }
    
}

