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
public class Admin extends User {
    
    private String firm;
    private Map<String, Ferry> ferries;
    private Map<String, Route> routes;
    
    public Admin(String name, String surname, String email, String password, String firm){
        super(name, surname, email, password);
        this.firm = firm;
        ferries = new HashMap<>();
        routes = new HashMap<>();
    }
    
    public Ferry createFerry(String ferryName, Map<String, Integer> ferryServices){
        Ferry ferry = new Ferry(ferryName, firm, ferryServices);
        ferries.put(ferryName, ferry);
        return ferry;
    }
    
    public Route createRoute(Ferry ferry, Map<String, Double> servicesPrices, String partenza, String destinazione, LocalDateTime partenzaDateTime, LocalDateTime destinazioneDateTime){
        Route route = new Route(ferry, servicesPrices, partenza, destinazione, partenzaDateTime, destinazioneDateTime);
        routes.put(route.getRouteId(), route);
        return route;
    }
    
    public Route getRoute(String routeId){
        if(routes.containsKey(routeId)){
            return routes.get(routeId);
        } else { //TODO: exception
            System.out.println("route n."+routeId+" not found");
            return null;
        }
    }
    
    public Map<String, Route> getRoutes(){
        return routes;
    }
    
    public void printFerries(){ //prints ferry models
        for (String f : ferries.keySet()){
            ferries.get(f).printAllDetails();
            System.out.println();
        }
    }
    
    public void printRoutes(){
        for (String r : routes.keySet()){
            routes.get(r).printAllDetails();
            System.out.println();
        }
    }
}
