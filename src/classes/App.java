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
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Scanner;
import java.util.List;
import keeper.FileKeeper;

/**
 *
 * @author pupil
 */
public class App {
    
    Scanner scanner = new Scanner(System.in);
    List<Product> products = new ArrayList<>();
    List<Buyer> buyers = new ArrayList<>();
    List<History> histories = new ArrayList<>();
    FileKeeper fileKeeper = new FileKeeper();
    
    public App() {
        products = fileKeeper.loadProducts();
        buyers = fileKeeper.loadBuyers();
        histories = fileKeeper.loadHistories();
    }
    
    public void run() {
        String repeat = "y";
        do{
            System.out.println("Выберите задачу: ");
            System.out.println("0: Закончить программу");
            System.out.println("1: Добавить продукт");
            System.out.println("2: Список продуктов");
            System.out.println("3: Добавить покупателя");
            System.out.println("4: Список покупателей");
            System.out.println("5: Продать товар");
            System.out.println("6: Список проданных товаров");
            int task = scanner.nextInt();
            scanner.nextLine();
            switch (task){
                case 0: 
                    repeat="q";
                    System.out.println("Программа закончена");
                    break;
                case 1:
                    System.out.println("Добавление продукта");
                    products.add(addProduct());
                    fileKeeper.saveProducts(products);
                    break;
                case 2:
                    System.out.println("Список товаров:");
                    for (int i = 0; i < products.size(); i++) {
                        if(products.get(i) != null){
                            System.out.println(products.get(i).toString());
                        }
                        
                    }
                    break;
                case 3:
                    System.out.println("Добавление пользователя");
                    buyers.add(addBuyer());
                    fileKeeper.saveBuyers(buyers);
                    break;
                case 4:
                    System.out.println("Список пользователей");
                    for (int i = 0; i < buyers.size(); i++) {
                        if(buyers.get(i) != null){
                            System.out.println(buyers.get(i).toString());
                        }
                        
                    }
                    break;
                case 5:
                    System.out.println("Продажа товара");
                    histories.add(addHistory());
                    fileKeeper.saveHistories(histories);
                    break;
                case 6:
                    printSoldProducts();
                    break;
            }
        }while("y".equals(repeat));
    }
    
    private Product addProduct(){
        Product product = new Product();
        System.out.print("Введите название продукта: ");
        product.setName(scanner.nextLine());
        System.out.print("Введите год срока годности: ");
        product.setExperation_year(scanner.nextInt());
        scanner.nextLine();
        System.out.print("Введите месяц срока годности: ");
        product.setExperation_month(scanner.nextInt());
        scanner.nextLine();
        System.out.print("Введите день срока годности: ");
        product.setExperation_day(scanner.nextInt());
        scanner.nextLine();
        System.out.print("Сколько производителей у данного продукта: ");
        int countManufactors=scanner.nextInt();
        scanner.nextLine();
        List<Manufactor> manufactors = new ArrayList<>();
        for (int i = 0; i < countManufactors; i++) {
            System.out.println("Добавление производителя "+(i+1));
            Manufactor manufactor = new Manufactor();
            System.out.print("Имя производителя: ");
            manufactor.setName(scanner.nextLine());
            System.out.print("Страна производителя: ");
            manufactor.setCountry(scanner.nextLine());
            System.out.print("Город производителя: ");
            manufactor.setCity(scanner.nextLine());
            manufactors.add(manufactor);
            
        }
        product.setManufactor(manufactors);
        
        return product;
    }
    
    private Buyer addBuyer(){
        Buyer buyer = new Buyer();
        System.out.print("Введите имя покупателя: ");
        buyer.setFirstname(scanner.nextLine());
        System.out.print("Введите фамилию покупателя: ");
        buyer.setLastname(scanner.nextLine());
        System.out.print("Введите телеофон покупателя: ");
        buyer.setPhone(scanner.nextLine());
        
        return buyer;
    }
    
    private void printSoldProducts(){
        System.out.println("Список проданных товаров");
            for (int i = 0; i < histories.size(); i++){
                if(histories.get(i) != null){
                    System.out.printf("%d. Товар: %s купил %s %s%n",
                            i+1,
                            histories.get(i).getProduct().getName(),
                            histories.get(i).getBuyer().getFirstname(),
                            histories.get(i).getBuyer().getLastname()
                    );
                }
            }
    }
    
    private History addHistory(){
        History history = new History();
        /**
         * Вывести нумерованный список товаров
         * получить от пользователя номер товара
         * вывести список клиентов покупателей
         * в history инициировать поле product объектом, который лежит
         *                          в массиве products[productNuber-1]
         * в history инициировать поле buyer объектом, который лежит
         *                          в массиве products[buyerNuber-1]
         * получить текущую дату и положить ее в поле history.givenDate
         */
        System.out.println("Список товаров");
        for (int i = 0; i < products.size(); i++){
            if(products.get(i) != null){
                System.out.printf("%d. %s%n",i+1,products.get(i).toString());
            }
        }
        System.out.print("Введите номер товара: ");
        int productNumber = scanner.nextInt(); scanner.nextLine();
        history.setProduct(products.get(productNumber-1));
        System.out.println();
        System.out.println("Список клиентов покупателей");
        for (int i = 0; i < buyers.size(); i++){
            if(buyers.get(i) != null){
                System.out.printf("%d. %s%n", i+1,buyers.get(i).toString());
            }
        }
        System.out.print("Введите номер покупателя: ");
        int buyerNumber = scanner.nextInt(); scanner.nextLine();
        history.setBuyer(buyers.get(buyerNumber-1));
        Calendar c = new GregorianCalendar();
        history.setSellingDate(c.getTime());
        
        return history;
    }
    
}
