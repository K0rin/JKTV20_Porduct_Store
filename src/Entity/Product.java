/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entity;

import java.io.Serializable;
import java.util.Arrays;
import java.util.List;

/**
 *
 * @author pupil
 */
public class Product implements Serializable {
    private String name;
    private List<Manufactor> manufactor;
    private int experation_year;
    private int experation_month;
    private int experation_day;

    public Product() {
    
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Manufactor> getManufactor() {
        return manufactor;
    }

    public void setManufactor(List<Manufactor> manufactor) {
        this.manufactor = manufactor;
    }

    public int getExperation_year() {
        return experation_year;
    }

    public void setExperation_year(int experation_year) {
        this.experation_year = experation_year;
    }

    public int getExperation_month() {
        return experation_month;
    }

    public void setExperation_month(int experation_month) {
        this.experation_month = experation_month;
    }

    public int getExperation_day() {
        return experation_day;
    }

    public void setExperation_day(int experation_day) {
        this.experation_day = experation_day;
    }

    

    @Override
    public String toString() {
        return "Product{" + "name=" + name
                + ", manufactor=" + Arrays.toString(manufactor.toArray()) 
                + ", experation_date= " + experation_day
                + "." + experation_month + "."
                + experation_year + '}';
    }
    
    
}
