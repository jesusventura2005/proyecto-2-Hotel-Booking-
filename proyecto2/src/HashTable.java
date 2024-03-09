/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author 58412
 */
public class HashTable {
    private ListaSimple[] table;
    private int size;

    public HashTable(int capacity) {
        table = new ListaSimple[capacity];
        size = 0;
    }

    public void put(Cliente huesped) {
        int index = hash(huesped.getApellido() + huesped.getNombre());
        if (table[index] == null) {
            table[index] = new ListaSimple();
        }
        table[index].insertarFinal(huesped);
        size++;
    }

    public Cliente get(String apellido, String nombre) {
        int index = hash(apellido + nombre);
        ListaSimple lista = table[index];
        if (lista != null) {
            Nodo current = lista.getpFirst();
            while (current != null) {
                Cliente huesped = (Cliente) current.getData();
                if (huesped.getApellido().equals(apellido) && huesped.getNombre().equals(nombre)) {
                    return huesped;
                }
                current = current.getpNext();
            }
        }
        return null;
    }

    private int hash(String key) {
        int hash = 0;
        // Suma de caracteres
        for (int i = 0; i < key.length(); i++) {
            hash += key.charAt(i);
        }
        // Multiplicación
        hash = 31 * hash;
        return Math.abs(hash) % table.length;
    }
}
