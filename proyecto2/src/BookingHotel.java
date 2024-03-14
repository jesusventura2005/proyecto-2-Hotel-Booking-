/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

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

    public BookingHotel() {
        arbolReservaciones = new ABB();
    }

    public ABB getArbolReservaciones() {
        return arbolReservaciones;
    }

    public void setArbolReservaciones(ABB arbolReservaciones) {
        this.arbolReservaciones = arbolReservaciones;
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
                    arbolReservaciones.insertar(reserva); // Insertar la reserva en el árbol
                    
                }
                rowNum++;
            }
        } catch (Exception e) {
            System.out.println("Error al cargar las reservaciones");
            e.printStackTrace();
        } finally {
            try {
                if (wb != null) {
                    wb.close();
                }
            } catch (Exception ex) {
                System.out.println("Error al cerrar el Workbook");
                ex.printStackTrace();
            }
        }
    }
    

//    public void Buscar(String cliente, String sheetName) {
//        Object data = null;
//        Workbook wb = null;
//        try {
//            FileInputStream fis = new FileInputStream("C:\\Users\\58412\\Desktop\\Booking_hotel.xlsx");
//            wb = WorkbookFactory.create(fis);
//            Sheet s = wb.getSheet(sheetName);
//            for (Row row : s) {
//                Cell cell = row.getCell(2);
//                if (cell != null) {
//                    if (cell.getCellType() == CellType.NUMERIC) {
//                        data = NumberToTextConverter.toText(cell.getNumericCellValue());
//                    } else {
//                        data = cell.getStringCellValue();
//                    }
//                    if (cliente.equals(data)) {
//                        System.out.println("Cliente encontrado en la fila: " + (row.getRowNum() + 1));
//                        break;
//                    }
//                }
//            }
//        } catch (Exception e) {
//            System.out.println("Error al buscar el cliente");
//            e.printStackTrace();
//        } finally {
//            try {
//                if (wb != null) {
//                    wb.close();
//                }
//            } catch (Exception ex) {
//                System.out.println("Error al cerrar el Workbook");
//                ex.printStackTrace();
//            }
//        }
//    }

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
            e.printStackTrace();
        } finally {
            try {
                if (wb != null) {
                    wb.close();
                }
            } catch (Exception ex) {
                System.out.println("Error al cerrar el Workbook");
                ex.printStackTrace();
            }
        }
    }
    
    public void insertarArbol() {

    }

}
