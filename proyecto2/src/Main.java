
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
/**
 *
 * @author jesus
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

      

        

        BookingHotel obj = new BookingHotel();
        String ci = obj.Read("reservas", 2, 0);

        System.out.println(ci);

    }

}
