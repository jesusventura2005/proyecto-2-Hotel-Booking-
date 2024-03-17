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
 *
 * @author jesus
 */
public class BookingHotel {
    private ABB arbolReservaciones;
    private HashTable hashEstado;
    private ABB arbolHabitaciones;
    private ListaSimple habitacionesDisponibles;
    private boolean error;

    public BookingHotel() {
        arbolReservaciones = new ABB();
        hashEstado = new HashTable();
        arbolHabitaciones = new ABB();
        habitacionesDisponibles = new ListaSimple();
        error = false;
    }

    public ABB getArbolReservaciones() {
        return arbolReservaciones;
    }

    public void setArbolReservaciones(ABB arbolReservaciones) {
        this.arbolReservaciones = arbolReservaciones;
    }

    public HashTable getHashEstado() {
        return hashEstado;
    }

    public void setHashEstado(HashTable hashEstado) {
        this.hashEstado = hashEstado;
    }

    public ABB getArbolHabitaciones() {
        return arbolHabitaciones;
    }

    public void setArbolHabitaciones(ABB arbolHabitaciones) {
        this.arbolHabitaciones = arbolHabitaciones;
    }

    public ListaSimple getHabitacionesDisponibles() {
        return habitacionesDisponibles;
    }

    public void setHabitacionesDisponibles(ListaSimple habitacionesDisponibles) {
        this.habitacionesDisponibles = habitacionesDisponibles;
    }

    public boolean isError() {
        return error;
    }

    public void setError(boolean error) {
        this.error = error;
    }
    
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

    // Método para verificar si una habitación está ocupada
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
    
    public void insertarArbol() {

    }

}
