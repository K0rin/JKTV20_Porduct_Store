/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;

import Entity.Product;
import Entity.History;
import Entity.Buyer;
import java.util.List;

/**
 *
 * @author Владимир
 */
public interface Keeping {
    public void saveProducts(List<Product> products);
    public List<Product> loadProducts();
    public void saveBuyers(List<Buyer> buyers);
    public List<Buyer> loadBuyers();
    public void saveHistories(List<History> histories);
    public List<History> loadHistories();
}
