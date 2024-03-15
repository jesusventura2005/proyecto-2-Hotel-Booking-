/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author 58412
 */
public class Reservacion {

    private int cedula;
    private String primerNombre;
    private String segundoNombre;
    private String email;
    private String genero;
    private String habitacion;
    private String celular;
    private String llegada;
    private String salida;

    public Reservacion(int cedula, String primerNombre, String segundoNombre, String email, String genero, String habitacion, String celular, String llegada, String salida) {
        this.cedula = cedula;
        this.primerNombre = primerNombre;
        this.segundoNombre = segundoNombre;
        this.email = email;
        this.genero = genero;
        this.habitacion = habitacion;
        this.celular = celular;
        this.llegada = llegada;
        this.salida = salida;
    }

    public int getCedula() {
        return cedula;
    }

    public void setCedula(int cedula) {
        this.cedula = cedula;
    }

    public String getPrimerNombre() {
        return primerNombre;
    }

    public void setPrimerNombre(String primerNombre) {
        this.primerNombre = primerNombre;
    }

    public String getSegundoNombre() {
        return segundoNombre;
    }

    public void setSegundoNombre(String segundoNombre) {
        this.segundoNombre = segundoNombre;
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

    public String getHabitacion() {
        return habitacion;
    }

    public void setHabitacion(String habitacion) {
        this.habitacion = habitacion;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public String getLlegada() {
        return llegada;
    }

    public void setLlegada(String llegada) {
        this.llegada = llegada;
    }

    public String getSalida() {
        return salida;
    }

    public void setSalida(String salida) {
        this.salida = salida;
    }
    
    public String toStringReservacion() {
        return """
            Datos de la Reservación:
            cedula: %s
            primerNombre: %s
            segundoNombre: %s
            email: %s
            genero: %s
            habitacion: %s
            celular: %s
            llegada: %s
            salida: %s
            """.formatted(cedula, primerNombre, segundoNombre, email, genero, habitacion, celular, llegada, salida);
    }

}