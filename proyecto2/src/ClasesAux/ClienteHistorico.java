package ClasesAux;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 * Clase que representa a un cliente histórico de un hotel, cliente que se guarda en el historial de habitación.
 * @author Daniel Fariña
 */
public class ClienteHistorico {
    int cedula;
    String nombre;
    String apellido;
    String email;
    String genero;
    String llegada;
    int numeroHabitacion;

    /**
     * Constructor de la clase ClienteHistorico.
     * @param cedula La cédula del cliente histórico.
     * @param nombre El nombre del cliente histórico.
     * @param apellido El apellido del cliente histórico.
     * @param email El email del cliente histórico.
     * @param genero El género del cliente histórico.
     * @param llegada La fecha de llegada del cliente histórico.
     * @param numeroHabitacion El número de habitación en la que se alojó el cliente histórico.
     */
    public ClienteHistorico(int cedula, String nombre, String apellido, String email, String genero, String llegada, int numeroHabitacion) {
        this.cedula = cedula;
        this.nombre = nombre;
        this.apellido = apellido;
        this.email = email;
        this.genero = genero;
        this.llegada = llegada;
        this.numeroHabitacion = numeroHabitacion;
    }

    /**
     * Devuelve la cédula del cliente histórico.
     * @return La cédula del cliente histórico.
     */
    public int getCedula() {
        return cedula;
    }

    /**
     * Establece la cédula del cliente histórico.
     * @param cedula La nueva cédula del cliente histórico.
     */
    public void setCedula(int cedula) {
        this.cedula = cedula;
    }

    /**
     * Devuelve el nombre del cliente histórico.
     * @return El nombre del cliente histórico.
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Establece el nombre del cliente histórico.
     * @param nombre El nuevo nombre del cliente histórico.
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Devuelve el apellido del cliente histórico.
     * @return El apellido del cliente histórico.
     */
    public String getApellido() {
        return apellido;
    }

    /**
     * Establece el apellido del cliente histórico.
     * @param apellido El nuevo apellido del cliente histórico.
     */
    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    /**
     * Devuelve el email del cliente histórico.
     * @return El email del cliente histórico.
     */
    public String getEmail() {
        return email;
    }

    /**
     * Establece el email del cliente histórico.
     * @param email El nuevo email del cliente histórico.
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Devuelve el género del cliente histórico.
     * @return El género del cliente histórico.
     */
    public String getGenero() {
        return genero;
    }

    /**
     * Establece el género del cliente histórico.
     * @param genero El nuevo género del cliente histórico.
     */
    public void setGenero(String genero) {
        this.genero = genero;
    }

    /**
     * Devuelve la fecha de llegada del cliente histórico.
     * @return La fecha de llegada del cliente histórico.
     */
    public String getLlegada() {
        return llegada;
    }

    /**
     * Establece la fecha de llegada del cliente histórico.
     * @param llegada La nueva fecha de llegada del cliente histórico.
     */
    public void setLlegada(String llegada) {
        this.llegada = llegada;
    }

    /**
     * Devuelve el número de habitación en la que se alojó el cliente histórico.
     * @return El número de habitación del cliente histórico.
     */
    public int getNumeroHabitacion() {
        return numeroHabitacion;
    }

    /**
     * Establece el número de habitación en la que se alojó el cliente histórico.
     * @param numeroHabitacion El nuevo número de habitación del cliente histórico.
     */
    public void setNumeroHabitacion(int numeroHabitacion) {
        this.numeroHabitacion = numeroHabitacion;
    }
    
    @Override
    /**
     * Devuelve una representación en cadena del objeto ClienteHistorico.
     * Si la cédula es -1, indica que no se encontró la cédula en el sistema.
     * @return Una cadena que representa al cliente histórico.
     */
    public String toString() {
        if (cedula == -1){
            return """
            Datos del Cliente:
            Cédula: Cédula no encontrada
            Nombre: %s
            Apellido: %s
            Email: %s
            Genero: %s
            Llegada: %s
            """.formatted(nombre, apellido, email, genero, llegada, numeroHabitacion);
        } else {
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
    
}
