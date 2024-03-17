package ClasesAux;

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
    private String tipoHabitacion;
    private String celular;
    private String llegada;
    private String salida;

    public Reservacion(int cedula, String primerNombre, String segundoNombre, String email, String genero, String habitacion, String celular, String llegada, String salida) {
        this.cedula = cedula;
        this.primerNombre = primerNombre;
        this.segundoNombre = segundoNombre;
        this.email = email;
        this.genero = genero;
        this.tipoHabitacion = habitacion;
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

    public String getTipoHabitacion() {
        return tipoHabitacion;
    }

    public void setHabitacion(String habitacion) {
        this.tipoHabitacion = habitacion;
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
    
    public String toString() {
        return """
            Datos de la Reservación:
            Cedula: %s
            Primer Nombre: %s
            Segundo Nombre: %s
            Email: %s
            Genero: %s
            Habitacion: %s
            Celular: %s
            Llegada: %s
            Salida: %s
            """.formatted(cedula, primerNombre, segundoNombre, email, genero, tipoHabitacion, celular, llegada, salida);
    }

}