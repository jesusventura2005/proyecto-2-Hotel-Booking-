package ClasesAux;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 * Clase que representa a un cliente de un hotel.
 * @author Jesús Ventura
 * @version 16/03/2024
 */
public class Cliente {
    
    private String nombre;
    private String apellido;
    private String email;
    private String genero;
    private String celular;
    private String llegada;
    private int numeroHabitacion;

    /**
     * Constructor de la clase Cliente.
     * @param nombre El nombre del cliente.
     * @param apellido El apellido del cliente.
     * @param email El email del cliente.
     * @param genero El género del cliente.
     * @param celular El número de celular del cliente.
     * @param llegada La fecha de llegada del cliente.
     * @param numeroHabitacion El número de habitación en la que se aloja el cliente.
     */
    public Cliente(String nombre, String apellido, String email, String genero, String celular, String llegada, int numeroHabitacion) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.email = email;
        this.genero = genero;
        this.celular = celular;
        this.llegada = llegada;
        this.numeroHabitacion = numeroHabitacion;
    }

    /**
     * Devuelve el nombre del cliente.
     * @return El nombre del cliente.
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Establece el nombre del cliente.
     * @param nombre El nuevo nombre del cliente.
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Devuelve el apellido del cliente.
     * @return El apellido del cliente.
     */
    public String getApellido() {
        return apellido;
    }

    /**
     * Establece el apellido del cliente.
     * @param apellido El nuevo apellido del cliente.
     */
    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    /**
     * Devuelve el número de habitación en la que se aloja el cliente.
     * @return El número de habitación del cliente.
     */
    public int getNumeroHabitacion() {
        return numeroHabitacion;
    }

    /**
     * Establece el número de habitación en la que se aloja el cliente.
     * @param numeroHabitacion El nuevo número de habitación del cliente.
     */
    public void setNumeroHabitacion(int numeroHabitacion) {
        this.numeroHabitacion = numeroHabitacion;
    }

    /**
     * Devuelve el email del cliente.
     * @return El email del cliente.
     */
    public String getEmail() {
        return email;
    }

    /**
     * Establece el email del cliente.
     * @param email El nuevo email del cliente.
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Devuelve el género del cliente.
     * @return El género del cliente.
     */
    public String getGenero() {
        return genero;
    }

    /**
     * Establece el género del cliente.
     * @param genero El nuevo género del cliente.
     */
    public void setGenero(String genero) {
        this.genero = genero;
    }

    /**
     * Devuelve el número de celular del cliente.
     * @return El número de celular del cliente.
     */
    public String getCelular() {
        return celular;
    }

    /**
     * Establece el número de celular del cliente.
     * @param celular El nuevo número de celular del cliente.
     */
    public void setCelular(String celular) {
        this.celular = celular;
    }

    /**
     * Devuelve la fecha de llegada del cliente.
     * @return La fecha de llegada del cliente.
     */
    public String getLlegada() {
        return llegada;
    }

    /**
     * Establece la fecha de llegada del cliente.
     * @param llegada La nueva fecha de llegada del cliente.
     */
    public void setLlegada(String llegada) {
        this.llegada = llegada;
    }
    
    @Override
    /**
     * Devuelve una representación en cadena del objeto Cliente.
     * @return Una cadena que representa al cliente.
     */
    public String toString() {
        return """
            Datos del Cliente:
            Nombre: %s
            Apellido: %s
            Email: %s
            Genero: %s
            Celular: %s
            Llegada: %s

            Este cliente se encuentra alojado
            en la habitación %s.
            """.formatted(nombre, apellido, email, genero, celular, llegada, numeroHabitacion);
    }



}