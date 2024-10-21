/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package progettoswe;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Giada
 */
public class ProgettoSWE {
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        Admin admin = new Admin("marta", "rossi", "marta.rossi@email.com", "password", "GNVE");
        Map<String, Integer> serviziNaveGrande = new HashMap<>();
        serviziNaveGrande.put("passeggeri", 200);
        serviziNaveGrande.put("cabina interna 2 posti", 20);
        serviziNaveGrande.put("cabina interna 4 posti",40);
        serviziNaveGrande.put("poltrona", 100);
        Ferry splendid = admin.createFerry("Splendid", serviziNaveGrande);
        
        Map<String, Integer> serviziNavePiccola = new HashMap<>();
        serviziNavePiccola.put("passeggeri", 100);
        serviziNavePiccola.put("cabina interna 2 posti", 10);
        serviziNavePiccola.put("cabina interna 4 posti",5);
        Ferry mini = admin.createFerry("Mini", serviziNavePiccola);
        
        Ferry magnific = admin.createFerry("Magnific", serviziNaveGrande);
        
        admin.printFerries();
        
        Map<String, Double> serviziNaveGrandeCosti = new HashMap<>();
        serviziNaveGrandeCosti.put("passeggeri", 10.80);
        serviziNaveGrandeCosti.put("cabina interna 2 posti", 50.0);
        serviziNaveGrandeCosti.put("cabina interna 4 posti", 100.0);
        serviziNaveGrandeCosti.put("poltrona", 15.50);
        
        Map<String, Double> serviziNavePiccolaCosti = new HashMap<>();
        serviziNavePiccolaCosti.put("passeggeri", 10.0);
        serviziNavePiccolaCosti.put("cabina interna 2 posti", 40.0);
        serviziNavePiccolaCosti.put("cabina interna 4 posti", 80.0);
        
        Route cvnp = admin.createRoute(splendid, serviziNaveGrandeCosti, "Civitavecchia", "Napoli", LocalDateTime.now(), LocalDateTime.now());
        Route npms = admin.createRoute(mini, serviziNavePiccolaCosti, "Napoli", "Messina", LocalDateTime.now(), LocalDateTime.now());
        Route nppa = admin.createRoute(magnific, serviziNaveGrandeCosti, "Napoli", "Palermo", LocalDateTime.now(), LocalDateTime.now());
        
        System.out.println(".........");
        
        Customer user = new Customer("mario", "bianchi", "mario.bianchi@email.com", "password");
        Map<String, Integer> servizimario = new HashMap<>();
        servizimario.put("passeggeri",8);
        servizimario.put("cabina interna 2 posti", 2);
        servizimario.put("cabina interna 4 posti", 1);
        
        user.makeReservation(cvnp, servizimario);
        user.makeReservation(npms, servizimario);
        user.makeReservation(nppa, servizimario);
        user.printReservations();
        
        System.out.println(".........");
        
        admin.getRoute("R0").updateServicePrice("cabina interna 2 posti", 55.50);
        admin.printRoutes();
        
        System.out.println(".........");
        
        user.makeReservation(cvnp, servizimario);
        user.printReservations();
        
    }
    
}
