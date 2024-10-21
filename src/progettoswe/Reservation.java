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
public class Reservation {
    private String reservationId;
    private final Customer customer;
    private final Route route;
    private Map<String, Integer> bookedServices; //requested service name and booked quantity
    private Map<String, Double> bookedServicesCost; //cost for the customer
    
    private static int count = 0;
    
    public Reservation(Customer customer, Route route, Map<String, Integer> services){
        this.reservationId = "P"+count++;
        this.customer = customer;
        this.route = route;
        
        Map<String, Integer> copy = new HashMap<>();
        for (Map.Entry<String, Integer> entry : services.entrySet()){
            copy.put(entry.getKey(), entry.getValue());
        }
        this.bookedServices = copy; //deep copy
        
        this.bookedServicesCost = new HashMap<>();
        for (Map.Entry<String, Double> entry : this.route.getServicesPrices().entrySet()){
            if (bookedServices.containsKey(entry.getKey())){
                this.bookedServicesCost.put(entry.getKey(), entry.getValue());    
            }
        }
    }
    
    //Getter
    public String getReservationId(){
        return reservationId;
    }
    
    public void printDetails(){
        System.out.println("Prenotazione n."+reservationId);
        for (String service : bookedServices.keySet()){
            System.out.println(service+" quantity: "+bookedServices.get(service)+" cost: "+bookedServicesCost.get(service)+" euro");
        }
        route.printDetails();
    }
}
