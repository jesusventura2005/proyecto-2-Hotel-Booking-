
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
        
        bookingHotel.cargarReservaciones("C:\\Users\\58412\\Desktop\\Booking_hotel.xlsx");
        System.out.println(bookingHotel.getArbolReservaciones().toString());
        bookingHotel.cargarClientes("C:\\Users\\58412\\Desktop\\Booking_hotel.xlsx");
        System.out.println(bookingHotel.getHashEstado().buscar("Vlasov", "Cosmo").toString());
      

    }

}
