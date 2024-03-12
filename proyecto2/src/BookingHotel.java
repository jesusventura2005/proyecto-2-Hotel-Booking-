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


/**
 *
 * @author jesus
 */
public class BookingHotel {
    
   



    public String Read(String sheetName, int rNum , int cNum ) {
        String data = "";
        try {
            FileInputStream fis = new FileInputStream("C:\\Java\\Booking_hotel.xlsx");
            Workbook wb = WorkbookFactory.create(fis);
            Sheet s = wb.getSheet(sheetName);
            Row r = s.getRow(rNum);
            Cell c = r.getCell(cNum);
            data = c.getStringCellValue();
            
            
        } catch (Exception e) {
            System.out.println("error");
            e.printStackTrace();
        }
        
        return data;

    }
    
    


}
