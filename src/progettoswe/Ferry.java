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
public class Ferry {
    private final String name; //unique
    private final String firm;
    private Map<String, Integer> availableServices; //service name and quantity (availability)
    
    public Ferry(String name, String firm, Map<String, Integer> services){
        this.name = name;
        this.firm = firm;
        Map<String, Integer> copy = new HashMap<>();
        for (Map.Entry<String, Integer> entry : services.entrySet()){
            copy.put(entry.getKey(), entry.getValue());
        }
        this.availableServices = copy; //deep copy
    }
    
    public Ferry(Ferry ferry){ //copy constructor
        this.firm = ferry.firm;
        this.name = ferry.name;
        Map<String, Integer> copy = new HashMap<>();
        for (Map.Entry<String, Integer> entry : ferry.availableServices.entrySet()){
            copy.put(entry.getKey(), entry.getValue());
        }
        this.availableServices = copy; //deep copy
    }
    
    public Map<String, Integer> getAvailableServices(){
        return availableServices;
    }
    
    public boolean bookServices(Map<String, Integer> requestedServices){
        for (String rs : requestedServices.keySet()){
            if (availableServices.get(rs) >= requestedServices.get(rs)){
                availableServices.replace(rs, availableServices.get(rs) - requestedServices.get(rs));
            } else {
                //TODO: exception
                System.out.println(requestedServices.get(rs)+" "+rs+" NOT available!");
                return false;
            }
        }
        return true;
    }
    
    public void printAllDetails(){ //print ferry name, firm, number of each available service and its name
        System.out.println("Ferry "+name+" - ditta: "+firm);
        for (String service : availableServices.keySet()){
            System.out.println(service+" availability: "+availableServices.get(service));
        }
    }
   
    public void printDetails(){
        System.out.println("Ferry "+name+" - ditta: "+firm);
    }
}
