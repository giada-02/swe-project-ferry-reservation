/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package progettoswe;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Giada
 */
public class Route {
    private String routeId;
    private Ferry ferry;
    private Map<String, Double> servicesPrices;
    private String departure;
    private String arrival;
    private LocalDateTime departureDateTime;
    private LocalDateTime arrivalDateTime;
    
    private static int count = 0;

    //Getters & Setters
    public String getRouteId() {
        return routeId;
    }

    public Ferry getFerry() {
        return ferry;
    }

    public Map<String, Double> getServicesPrices() {
        return servicesPrices;
    }

    public String getDeparture() {
        return departure;
    }

    public void setDeparture(String departure) {
        this.departure = departure;
    }

    public String getArrival() {
        return arrival;
    }

    public void setArrival(String arrival) {
        this.arrival = arrival;
    }

    public LocalDateTime getDepartureDateTime() {
        return departureDateTime;
    }

    public void setDepartureDateTime(LocalDateTime departureDateTime) {
        this.departureDateTime = departureDateTime;
    }

    public LocalDateTime getArrivalDateTime() {
        return arrivalDateTime;
    }

    public void setArrivalDateTime(LocalDateTime arrivalDateTime) {
        this.arrivalDateTime = arrivalDateTime;
    }
    
    //Constructor
    public Route(Ferry ferry, Map<String, Double> servicesPrices, String departure, String arrival, LocalDateTime departureDateTime, LocalDateTime arrivalDateTime){
        this.ferry = new Ferry(ferry); //ferry copy constructor
        
        Map<String, Double> copy = new HashMap<>();
        for (Map.Entry<String, Double> entry :servicesPrices.entrySet()){
            copy.put(entry.getKey(), entry.getValue());
        }
        this.servicesPrices = copy; //deep copy
        
        this.routeId = "R"+count++;
        this.departure = departure;
        this.arrival = arrival;
        this.departureDateTime = departureDateTime;
        this.arrivalDateTime = arrivalDateTime;
    }
    
    public void updateServicePrice(String service, double newPrice){
        if (servicesPrices.containsKey(service)){
            servicesPrices.put(service, newPrice); //replace price
        } else { //TODO: exception
            System.out.println("ricerca senza successo "+service+" non appartiene ai servizi di questa rotta n."+routeId);
        }
    }
    
    public boolean bookServices(Map<String, Integer> servicesRequest){ //handles the availability of the services for this route throught ferry
        return ferry.bookServices(servicesRequest);
    }
    
    public void printAllDetails(){
        System.out.println("Rotta n."+routeId);
        System.out.println("From "+departure+" to "+arrival);
        ferry.printDetails();
        for (Map.Entry<String, Integer> entry : ferry.getAvailableServices().entrySet()){
            if (servicesPrices.containsKey(entry.getKey())){
                System.out.println("service: "+entry.getKey()+" availability: "+entry.getValue()+" price: "+servicesPrices.get(entry.getKey())+" euro");
            }
        }
        System.out.println();
    }
    
    public void printDetails(){
        System.out.println("Rotta n."+routeId);
        System.out.println("From "+departure+" ("+departureDateTime+")"+" to "+arrival+" ("+arrivalDateTime+")");
        ferry.printDetails();
        System.out.println();
    }
    
}
