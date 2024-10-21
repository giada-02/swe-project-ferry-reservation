/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package progettoswe;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Giada
 */
public class Customer extends User{
    
    private Map<String, Reservation> reservations;
    
    public Customer(String name, String surname, String email, String password){
        super(name, surname, email, password);
        reservations = new HashMap<>();
    }

    public Map<String, Reservation> getReservations() {
        return reservations;
    }
    
    public void makeReservation(Route route, Map<String, Integer> servicesRequest){
        if (route.bookServices(servicesRequest)){
            Reservation r = new Reservation(this, route, servicesRequest);
            reservations.put(r.getReservationId(), r);
            System.out.println(this.getEmail()+" made a reservation");
        }
    }
    
    public void cancelReservation(String reservationId){
        if (reservations.containsKey(reservationId)){
            reservations.remove(reservationId);
        } else { //TODO: exception
            System.out.println("reservation n."+reservationId+" not found");
        }
    }
    
    public void printReservations(){
        for (Reservation r : reservations.values()){
            r.printDetails();
        }
    }
    
}
