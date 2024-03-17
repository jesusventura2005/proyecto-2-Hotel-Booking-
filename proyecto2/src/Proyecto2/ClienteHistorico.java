package Proyecto2;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author 58412
 */
public class ClienteHistorico {
    int cedula;
    String nombre;
    String apellido;
    String email;
    String genero;
    String llegada;
    int numeroHabitacion;

    public ClienteHistorico(int cedula, String nombre, String apellido, String email, String genero, String llegada, int numeroHabitacion) {
        this.cedula = cedula;
        this.nombre = nombre;
        this.apellido = apellido;
        this.email = email;
        this.genero = genero;
        this.llegada = llegada;
        this.numeroHabitacion = numeroHabitacion;
    }

    public int getCedula() {
        return cedula;
    }

    public void setCedula(int cedula) {
        this.cedula = cedula;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getLlegada() {
        return llegada;
    }

    public void setLlegada(String llegada) {
        this.llegada = llegada;
    }

    public int getNumeroHabitacion() {
        return numeroHabitacion;
    }

    public void setNumeroHabitacion(int numeroHabitacion) {
        this.numeroHabitacion = numeroHabitacion;
    }
    
    @Override
    public String toString() {
        return """
            Datos del Cliente:
            Cédula: %s
            Nombre: %s
            Apellido: %s
            Email: %s
            Genero: %s
            Llegada: %s
            """.formatted(cedula, nombre, apellido, email, genero, llegada, numeroHabitacion);
    }
    
}
