package ClasesAux;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 * Esta clase representa una reservación en el hotel.
 * @author Daniel Fariña
 * @version 16/03/2024
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

    /**
     * Constructor de la clase `Reservacion`.
     * @param cedula La cédula del cliente.
     * @param primerNombre El primer nombre del cliente.
     * @param segundoNombre El segundo nombre del cliente.
     * @param email El correo electrónico del cliente.
     * @param genero El género del cliente.
     * @param habitacion El tipo de habitación reservada.
     * @param celular El número de celular del cliente.
     * @param llegada La fecha de llegada al hotel.
     * @param salida La fecha de salida del hotel.
     */
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

    /**
     * Devuelve la cédula del cliente.
     * @return La cédula del cliente.
     */
    public int getCedula() {
        return cedula;
    }
    
    /**
     * Establece la cédula del cliente.
     * @param cedula La nueva cédula del cliente.
     */
    public void setCedula(int cedula) {
        this.cedula = cedula;
    }

    /**
     * Devuelve el primer nombre del cliente.
     * @return El primer nombre del cliente.
     */
    public String getPrimerNombre() {
        return primerNombre;
    }

    /**
     * Establece el primer nombre del cliente.
     * @param primerNombre El nuevo primer nombre del cliente.
     */
    public void setPrimerNombre(String primerNombre) {
        this.primerNombre = primerNombre;
    }

    /**
     * Devuelve el segundo nombre del cliente.
     * @return El segundo nombre del cliente.
     */
    public String getSegundoNombre() {
        return segundoNombre;
    }

    /**
     * Establece el segundo nombre del cliente.
     * @param segundoNombre El nuevo segundo nombre del cliente.
     */
    public void setSegundoNombre(String segundoNombre) {
        this.segundoNombre = segundoNombre;
    }

    /**
     * Devuelve el correo electrónico del cliente.
     * @return El correo electrónico del cliente.
     */
    public String getEmail() {
        return email;
    }

    /**
     * Establece el correo electrónico del cliente.
     * @param email El nuevo correo electrónico del cliente.
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
     * Devuelve el tipo de habitación reservada por el cliente.
     * @return El tipo de habitación reservada.
     */
    public String getTipoHabitacion() {
        return tipoHabitacion;
    }

    /**
     * Establece el tipo de habitación reservada por el cliente.
     * @param habitacion El nuevo tipo de habitación reservada.
     */
    public void setTipoHabitacion(String habitacion) {
        this.tipoHabitacion = habitacion;
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
     * Devuelve la fecha de llegada del cliente al hotel.
     * @return La fecha de llegada del cliente.
     */
    public String getLlegada() {
        return llegada;
    }

    /**
     * Establece la fecha de llegada del cliente al hotel.
     * @param llegada La nueva fecha de llegada del cliente.
     */
    public void setLlegada(String llegada) {
        this.llegada = llegada;
    }

    /**
     * Devuelve la fecha de salida del cliente del hotel.
     * @return La fecha de salida del cliente.
     */
    public String getSalida() {
        return salida;
    }

    /**
     * Establece la fecha de salida del cliente del hotel.
     * @param salida La nueva fecha de salida del cliente.
     */
    public void setSalida(String salida) {
        this.salida = salida;
    }
    
    @Override
    /**
     * Devuelve una representación en formato de cadena de la reservación.
     * @return Una cadena que contiene los detalles de la reservación.
     */
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