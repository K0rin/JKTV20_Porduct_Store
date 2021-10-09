/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classes;

import Entity.Buyer;
import Entity.History;
import Entity.Manufactor;
import Entity.Product;
import java.util.Calendar;
import java.util.GregorianCalendar;

/**
 *
 * @author pupil
 */
public class App {

    public App() {
    
    }
    
    public void run() {
        System.out.println("Hello director");
        Product product1 = new Product();
        product1.setName("Red Cheese");
        Manufactor manufactor1 = new Manufactor();
        manufactor1.setName("Tere");
        manufactor1.setCountry("Estonia");
        manufactor1.setCity("Tallinn");
        Manufactor[] manufactors = new Manufactor[1];
        manufactors[0]=manufactor1;
        product1.setManufactor(manufactors);
        product1.setExperation_year(2022);
        product1.setExperation_month(2);
        product1.setExperation_day(18);
        
        Product product2 = new Product();
        product2.setName("Chocolate");
        Manufactor manufactor2 = new Manufactor();
        manufactor2.setName("Farmy");
        manufactor2.setCountry("Estonia");
        manufactor2.setCity("Tallinn");
        Manufactor[] manufactors2 = new Manufactor[1];
        manufactors2[0]=manufactor2;
        product2.setManufactor(manufactors2);
        product2.setExperation_year(2025);
        product2.setExperation_month(12);
        product2.setExperation_day(31);
        
        Buyer buyer1 = new Buyer();
        buyer1.setFirstname("Ivan");
        buyer1.setLastname("Ivanov");
        buyer1.setPhone("465879333");
        
        History history1 = new History();
        history1.setBuyer(buyer1);
        history1.setProduct(product1);
        Calendar c = new GregorianCalendar();
        
        history1.setSellingDate(c.getTime());
        
        System.out.println("History = "+history1.toString());
        
        
    }
    
}
