/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

import java.io.FileInputStream;
import org.apache.poi.ss.usermodel.Cell;
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

    public void Buscar(String cliente, String sheetName) {

        Object data = "";
        int i = 0;
        while (!data.equals(cliente)) {

            try {
                FileInputStream fis = new FileInputStream("C:\\Java\\Booking_hotel.xlsx");
                Workbook wb = WorkbookFactory.create(fis);
                Sheet s = wb.getSheet(sheetName);
                Row r = s.getRow(i + 1);
                Cell c = r.getCell(2);
                 data = c.getStringCellValue();

            } catch (Exception e) {
                System.out.println("BookingHotel.Read()");
                e.printStackTrace();
            }

            i++;
            
        System.out.println(data);    

        }
        
        

        

    }

    public void insertarArbol() {

    }

}
