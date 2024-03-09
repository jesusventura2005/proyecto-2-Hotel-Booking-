/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author 58412
 */
public class Reservacion {

    private String cedula;
    private String nombreCliente;
    private String fechaLlegada;
    private String fechaSalida;
    private int numeroHabitacion;

    public Reservacion(String cedula, String nombreCliente, String fechaLlegada, String fechaSalida, int numeroHabitacion) {
        this.cedula = cedula;
        this.nombreCliente = nombreCliente;
        this.fechaLlegada = fechaLlegada;
        this.fechaSalida = fechaSalida;
        this.numeroHabitacion = numeroHabitacion;
    }

    // Getters y setters
    
    // Método de comparación personalizado para comparar las cédulas
    public boolean cedulaMenorQue(String otraCedula) {
        // Eliminar los puntos de la cédula para comparar solo los números
        String cedulaSinPuntos = this.cedula.replace(".", "");
        otraCedula = otraCedula.replace(".", "");

        // Comparar las cédulas como enteros
        return Long.parseLong(cedulaSinPuntos) < Long.parseLong(otraCedula);
    }

}