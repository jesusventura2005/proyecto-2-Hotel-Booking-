package ClasesAux;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

import EDD.NodoListaSimple;
import EDD.ABB;
import EDD.ListaSimple;
import EDD.HashTable;
import java.io.FileInputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.ss.util.NumberToTextConverter;

/**
 * Clase que representa un sistema de reservas de hotel.
 * Permite cargar datos desde archivos Excel, buscar clientes y gestionar las reservas y habitaciones.
 * @author Daniel Fariña
 * @version 16/03/2024
 */
public class BookingHotel {
    private ABB arbolReservaciones;
    private HashTable hashEstado;
    private ABB arbolHabitaciones;
    private ListaSimple habitacionesDisponibles;
    private boolean error;

    /**
     * Constructor de la clase BookingHotel.
     * Inicializa las estructuras de datos necesarias para el sistema.
     */
    public BookingHotel() {
        arbolReservaciones = new ABB();
        hashEstado = new HashTable();
        arbolHabitaciones = new ABB();
        habitacionesDisponibles = new ListaSimple();
        error = false;
    }

    /**
     * Obtiene el árbol de reservaciones del hotel.
     * @return el árbol de reservaciones
     */
    public ABB getArbolReservaciones() {
        return arbolReservaciones;
    }

    /**
     * Establece el árbol de reservaciones del hotel.
     * @param arbolReservaciones el árbol de reservaciones a establecer
     */
    public void setArbolReservaciones(ABB arbolReservaciones) {
        this.arbolReservaciones = arbolReservaciones;
    }

    /**
     * Obtiene la tabla hash que almacena el estado de los clientes en el hotel.
     * @return la tabla hash del estado de los clientes
     */
    public HashTable getHashEstado() {
        return hashEstado;
    }

    /**
     * Establece la tabla hash que almacena el estado de los clientes en el hotel.
     * @param hashEstado la tabla hash del estado de los clientes a establecer
     */
    public void setHashEstado(HashTable hashEstado) {
        this.hashEstado = hashEstado;
    }

    /**
     * Obtiene el árbol de habitaciones del hotel.
     * @return el árbol de habitaciones
     */
    public ABB getArbolHabitaciones() {
        return arbolHabitaciones;
    }

    /**
     * Establece el árbol de habitaciones del hotel.
     * @param arbolHabitaciones el árbol de habitaciones a establecer
     */
    public void setArbolHabitaciones(ABB arbolHabitaciones) {
        this.arbolHabitaciones = arbolHabitaciones;
    }

    /**
     * Obtiene la lista de habitaciones disponibles en el hotel.
     * @return la lista de habitaciones disponibles
     */
    public ListaSimple getHabitacionesDisponibles() {
        return habitacionesDisponibles;
    }

    /**
     * Establece la lista de habitaciones disponibles en el hotel.
     * @param habitacionesDisponibles la lista de habitaciones disponibles a establecer
     */
    public void setHabitacionesDisponibles(ListaSimple habitacionesDisponibles) {
        this.habitacionesDisponibles = habitacionesDisponibles;
    }

    /**
     * Indica si se ha producido algún error en el sistema.
     * @return true si hay un error, false en caso contrario
     */
    public boolean isError() {
        return error;
    }

    /**
     * Establece el estado de error del sistema.
     * @param error true para indicar que hay un error, false en caso contrario
     */
    public void setError(boolean error) {
        this.error = error;
    }
    
    // Método para cargar reservaciones desde un archivo Excel
    /**
     * Carga las reservaciones desde un archivo Excel.
     * @param rutaExcel la ruta del archivo Excel que contiene las reservaciones
     */
    public void cargarReservaciones(String rutaExcel) {
        Workbook wb = null;
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        try {
            FileInputStream fis = new FileInputStream(rutaExcel);
            wb = WorkbookFactory.create(fis);
            Sheet s = wb.getSheet("reservas");
            int rowNum = 0;
            for (Row row : s) {
                if (rowNum > 0) { // Verificar que no sea la primera fila
                    Cell ciCell = row.getCell(0); // Celda con la cédula
                    double ci = ciCell.getNumericCellValue(); // Obtener la cédula
                    int cedula = (int)ci; // Convertir la cédula a entero
                    String primerNombre = row.getCell(1).getStringCellValue(); // Obtener el primer nombre
                    String segundoNombre = row.getCell(2).getStringCellValue(); // Obtener el segundo nombre
                    String email = row.getCell(3).getStringCellValue(); // Obtener el email
                    String genero = row.getCell(4).getStringCellValue(); // Obtener el género
                    String habitacion = row.getCell(5).getStringCellValue(); // Obtener el tipo de habitación
                    String celular = row.getCell(6).getStringCellValue(); // Obtener el celular
                    Date llegadaDate = row.getCell(7).getDateCellValue();
                    String llegada = dateFormat.format(llegadaDate); // Obtener la fecha de llegada
                    Date salidaDate = row.getCell(8).getDateCellValue();
                    String salida = dateFormat.format(salidaDate); // Obtener la fecha de salida
                    Reservacion reserva = new Reservacion(cedula, primerNombre, segundoNombre, email, genero, habitacion, celular, llegada, salida); // Crear la reserva
                    arbolReservaciones.insertarReservacion(reserva); // Insertar la reserva en el árbol
                    
                }
                rowNum++;
            }
        } catch (Exception e) {
            System.out.println("Error al cargar las reservaciones");
        } finally {
            try {
                if (wb != null) {
                    wb.close();
                }
            } catch (Exception ex) {
                System.out.println("Error al cerrar el Workbook");
            }
        }
    }
    
    // Método para cargar clientes desde un archivo Excel
    /**
     * Carga los clientes desde un archivo Excel.
     * @param rutaExcel la ruta del archivo Excel que contiene los clientes
     */
    public void cargarClientes(String rutaExcel) {
        Workbook wb = null;
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        try {
            FileInputStream fis = new FileInputStream(rutaExcel);
            wb = WorkbookFactory.create(fis);
            Sheet s = wb.getSheet("estado"); // Hoja con los datos de los clientes
            int rowNum = 0;
            int habitacionAnterior = -1; // Para manejar los casos donde no se proporciona el número de habitación
            ListaSimple habitacionesOcupadas = new ListaSimple();
            for (Row row : s) {
                if (rowNum > 0) { // Verificar que no sea la primera fila
                    Cell habitacionCell = row.getCell(0); // Celda con el número de habitación
                    int habitacion;
                    if (habitacionCell == null) {
                        habitacion = habitacionAnterior;
                    } else {
                        habitacion = (int) habitacionCell.getNumericCellValue(); // Obtener el número de habitación
                        habitacionAnterior = habitacion;
                    }
                    String primerNombre = row.getCell(1).getStringCellValue(); // Obtener el primer nombre
                    String segundoNombre = row.getCell(2).getStringCellValue(); // Obtener el segundo nombre
                    String email = row.getCell(3).getStringCellValue(); // Obtener el email
                    String genero = row.getCell(4).getStringCellValue(); // Obtener el género
                    String celular = row.getCell(5).getStringCellValue(); // Obtener el celular
                    Date llegadaDate = row.getCell(6).getDateCellValue();
                    String llegada = dateFormat.format(llegadaDate); // Obtener la fecha de llegada
                    habitacionesOcupadas.insertarFinal(habitacion);
                    Cliente cliente = new Cliente(primerNombre, segundoNombre, email, genero, celular, llegada, habitacion); // Crear el cliente
                    hashEstado.insertar(cliente); // Insertar el cliente en la tabla hash
                }
                rowNum++;
            }
            encontrarHabitacionesDisponibles(habitacionesOcupadas);
            
        } catch (Exception e) {
            error = true;
        } finally {
            try {
                if (wb != null) {
                    wb.close();
                }
            } catch (Exception ex) {
                System.out.println("Error al cerrar el Workbook");
            }
        }
    }
    
    /**
     * Encuentra las habitaciones disponibles en el hotel, a partir de las habitaciones ocupadas.
     * @param habitacionesOcupadas la lista de habitaciones ocupadas
     */
    public void encontrarHabitacionesDisponibles(ListaSimple habitacionesOcupadas) {
        int totalHabitaciones = 300; // Total de habitaciones en el hotel
        // Recorremos desde la habitación 1 hasta el total de habitaciones en el hotel
        for (int i = 1; i <= totalHabitaciones; i++) {
            // Verificamos si la habitación está ocupada
            if (!estaOcupada(habitacionesOcupadas, i)) {
                // Si la habitación no está ocupada, la agregamos a la lista de habitaciones disponibles
                habitacionesDisponibles.insertarFinal(i);
            }
        }
    }

    // Método privado para verificar si una habitación está ocupada
    /**
     * Verifica si una habitación está ocupada.
     * @param habitacionesOcupadas la lista de habitaciones ocupadas
     * @param numeroHabitacion el número de habitación a verificar
     * @return true si la habitación está ocupada, false en caso contrario
     */
    private boolean estaOcupada(ListaSimple habitacionesOcupadas, int numeroHabitacion) {
        NodoListaSimple current = habitacionesOcupadas.getpFirst();
        // Recorremos la lista de habitaciones ocupadas para verificar si la habitación está en ella
        while (current != null) {
            int habitacionOcupada = (int) current.getData();
            if (habitacionOcupada == numeroHabitacion) {
                // La habitación está ocupada
                return true;
            }
            current = current.getpNext();
        }
        // La habitación no está ocupada
        return false;
    }

    // Método para cargar habitaciones desde un archivo Excel
    /**
     * Carga las habitaciones desde un archivo Excel.
     * @param rutaExcel la ruta del archivo Excel que contiene las habitaciones
     */
    public void cargarHabitaciones(String rutaExcel) {
        Workbook wb = null;
        try {
            FileInputStream fis = new FileInputStream(rutaExcel);
            wb = WorkbookFactory.create(fis);
            Sheet historicoSheet = wb.getSheet("Histórico");
            Sheet habitacionesSheet = wb.getSheet("habitaciones");

            // Crear listas de clientes históricos por habitación
            ListaSimple[] clientesPorHabitacion = new ListaSimple[301]; // Numero de habitaciones
            for (Row row : historicoSheet) {
                if (row.getRowNum() > 0) { // Omitir encabezados
                    int numeroHabitacion = (int) row.getCell(6).getNumericCellValue();
                    ClienteHistorico clienteHistorico = crearClienteHistoricoDesdeFila(row);
                    // Verificar si ya se creó la lista para esta habitación
                    if (clientesPorHabitacion[numeroHabitacion] == null) {
                        clientesPorHabitacion[numeroHabitacion] = new ListaSimple();
                    }
                    clientesPorHabitacion[numeroHabitacion].insertarFinal(clienteHistorico);
                }
            }

            // Crear habitaciones y asignarles la lista de clientes
            for (Row row : habitacionesSheet) {
                if (row.getRowNum() > 0) { // Omitir encabezados
                    int numeroHabitacion = (int) row.getCell(0).getNumericCellValue();
                    String tipoHabitacion = row.getCell(1).getStringCellValue();
                    int piso = (int) row.getCell(2).getNumericCellValue();
                    ListaSimple clientesHistoricos = (numeroHabitacion < clientesPorHabitacion.length)
                            ? clientesPorHabitacion[numeroHabitacion] : new ListaSimple();
                    Habitacion habitacion = new Habitacion(numeroHabitacion, tipoHabitacion, piso, clientesHistoricos);
                    arbolHabitaciones.insertarHabitacion(habitacion);
                }
            }

        } catch (Exception e) {
            System.out.println("Error al cargar el histórico y las habitaciones");
        } finally {
            try {
                if (wb != null) {
                    wb.close();
                }
            } catch (Exception ex) {
                System.out.println("Error al cerrar el Workbook");
            }
        }
    }

    // Método privado para crear un ClienteHistorico desde una fila de datos de Excel
    /**
     * Crea un objeto ClienteHistorico a partir de una fila de datos de un archivo Excel.
     * @param row la fila de datos de Excel
     * @return el objeto ClienteHistorico creado
     */
    private ClienteHistorico crearClienteHistoricoDesdeFila(Row row) {
        int cedula = (int) row.getCell(0).getNumericCellValue();
        String primerNombre = row.getCell(1).getStringCellValue();
        String apellido = row.getCell(2).getStringCellValue();
        String email = row.getCell(3).getStringCellValue();
        String genero = row.getCell(4).getStringCellValue();
        String llegada = new SimpleDateFormat("dd/MM/yyyy").format(row.getCell(5).getDateCellValue());
        int numeroHabitacion = (int) row.getCell(6).getNumericCellValue();
        return new ClienteHistorico(cedula, primerNombre, apellido, email, genero, llegada, numeroHabitacion);
    }

    // Método para buscar un cliente en un archivo Excel
    /**
     * Busca un cliente en un archivo Excel.
     * @param cliente el nombre del cliente a buscar
     * @param sheetName el nombre de la hoja de cálculo en la que buscar
     */
    public void Buscar(String cliente, String sheetName) {
        Workbook wb = null;
        try {
            FileInputStream fis = new FileInputStream("C:\\Users\\58412\\Desktop\\Booking_hotel.xlsx");
            wb = WorkbookFactory.create(fis);
            Sheet s = wb.getSheet(sheetName);
            for (Row row : s) {
                Cell cell = row.getCell(2);
                if (cell != null) {
                    if (cell.getCellType() == CellType.NUMERIC) {
                        System.out.println("Celda " + (row.getRowNum() + 1) + ": " + NumberToTextConverter.toText(cell.getNumericCellValue()));
                    } else {
                        System.out.println("Celda " + (row.getRowNum() + 1) + ": " + cell.getStringCellValue());
                    }
                }
            }
        } catch (Exception e) {
            System.out.println("Error al buscar el cliente");
        } finally {
            try {
                if (wb != null) {
                    wb.close();
                }
            } catch (Exception ex) {
                System.out.println("Error al cerrar el Workbook");
            }
        }
    }
    

}
