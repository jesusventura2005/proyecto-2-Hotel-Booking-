package Proyecto2;


/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
/**
 *
 * @author jesus
 */
public class Main {

    
     
    public static void main(String[] args) {

        BookingHotel bookingHotel = new BookingHotel();
        bookingHotel.cargarClientes("C:\\Users\\58412\\Desktop\\Booking_hotel.xlsx");
        bookingHotel.cargarReservaciones("C:\\Users\\58412\\Desktop\\Booking_hotel.xlsx");
        bookingHotel.cargarHabitaciones("C:\\Users\\58412\\Desktop\\Booking_hotel.xlsx");
        Ventana1 ventana = new Ventana1(bookingHotel);
        ventana.setVisible(true);

        
        
        
        
      

    }

}