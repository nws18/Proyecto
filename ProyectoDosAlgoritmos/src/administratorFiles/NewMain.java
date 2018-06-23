/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package administratorFiles;



import LinkedBinaryTree.LinkedBinaryTree;
import LinkedBinaryTree.TreeException;
import domain.Batch;
import domain.Category;
import domain.Cellar;
import domain.DistributionOrder;
import domain.Product;
import domain.TransportUnit;
import domain.User;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import org.apache.commons.codec.digest.DigestUtils;

/**
 *
 * @author fabian
 */
public class NewMain {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException, FileNotFoundException, ClassNotFoundException, TreeException {
//
        AdministratorFiles administratorFiles = new AdministratorFiles();
//
        ArrayList<Batch> batchList = new ArrayList();
//        ArrayList<Category> categoryList = new ArrayList();
//        ArrayList<Cellar> cellarList = new ArrayList();
        ArrayList<DistributionOrder> distributionOrderList = new ArrayList();
        ArrayList<Product> productList = new ArrayList();
//        ArrayList<TransportUnit> transportUnitList = new ArrayList();
//        ArrayList<User> UserList = new ArrayList();
//
        Date date = new Date();
        Date date2 = new Date(2019, 2, 23, 0, 0, 0);

        Batch batch0 = new Batch(0, "IDRHFU45T45", date, date2);
        Batch batch1 = new Batch(1, "KJBFH45G54G", date, date2);
        Batch batch2 = new Batch(2, "EARGE56YHRT", date, date2);
        Batch batch3 = new Batch(3, "ERGRTERHRHT", date, date2);
        Batch batch4 = new Batch(4, "DFVKNSKJVNJ", date, date2);
        batchList.add(batch0);
        batchList.add(batch1);
        batchList.add(batch2);
        batchList.add(batch3);
        batchList.add(batch4);
//
//        Category category0 = new Category(0, "Higiene", "Productos para el higiene y ciudado personal");
//        Category category1 = new Category(1, "Hogar", "Productos de limpieza para el hogar");
//        Category category2 = new Category(2, "Larga duración", "Productos enlatados de larga duración");
//        Category category3 = new Category(3, "Bebidas", "Refrescos gaseosos, naturales y bebidas alcoholicas");
//        Category category4 = new Category(4, "Abarrotes", "Arroz, pastas y legumbres");
//        categoryList.add(category0);
//        categoryList.add(category1);
//        categoryList.add(category2);
//        categoryList.add(category3);
//        categoryList.add(category4);
//
//        Cellar cellar0 = new Cellar(0, "Caballo Blanco", "9.8465059", "-83.8453388", 6, "images/grocery/paraiso.jpg");
//        Cellar cellar1 = new Cellar(1, "Curridabat", "9.9104054", "-84.0261615", 7, "images/grocery/san jose.jpg");
//        Cellar cellar2 = new Cellar(2, "Desamaparados", "9.8962853", "-84.0929378", 8, "images/grocery/desamparados.jpg");
//        Cellar cellar3 = new Cellar(3, "Lima", "9.8733467", "-83.9445108", 9, "images/grocery/lima.jpg");
//        Cellar cellar4 = new Cellar(4, "San Sebastian", "9.8962853", "-84.0929378", 10, "images/grocery/liberia.jpg");
//        cellarList.add(cellar0);
//        cellarList.add(cellar1);
//        cellarList.add(cellar2);
//        cellarList.add(cellar3);
//        cellarList.add(cellar4);

        Product product0 = new Product(0, "Aceite", "Unidades", 20, 1, "Aceite de cocina", 0, 4, 2000, "images/products/aceite.png");
        Product product1 = new Product(1, "Arroz", "Paquetes", 100, 2, "Arroz, 2kg", 1, 1, 12500, "images/products/arroz.png");
        Product product2 = new Product(2, "Cereal", "Cajas", 10, 1, "Cereal", 2, 2, 10500, "images/products/cereal.png");
        Product product3 = new Product(3, "Gaseosas", "Tarimas", 15, 20, "Refresco gaseoso", 3, 3, 25500, "images/products/");
        Product product4 = new Product(4, "Cervezas", "Tarimas", 10, 30, "Bebida alcoholica", 4, 4, 40500, "images/products/");
        productList.add(product0);
        productList.add(product1);
        productList.add(product2);
        productList.add(product3);
        productList.add(product4);
//
        DistributionOrder distributionOrder0 = new DistributionOrder(0, 0, 1, 100000, 5000, productList, 0);
        DistributionOrder distributionOrder1 = new DistributionOrder(1, 1, 2, 200000, 10000, productList, 1);
        DistributionOrder distributionOrder2 = new DistributionOrder(2, 2, 3, 300000, 60000, productList, 2);
        DistributionOrder distributionOrder3 = new DistributionOrder(3, 3, 4, 400000, 70000, productList, 3);
        DistributionOrder distributionOrder4 = new DistributionOrder(4, 4, 0, 500000, 90000, productList, 4);
        distributionOrderList.add(distributionOrder0);
        distributionOrderList.add(distributionOrder1);
        distributionOrderList.add(distributionOrder2);
        distributionOrderList.add(distributionOrder3);
        distributionOrderList.add(distributionOrder4);
//
//        TransportUnit transportUnit0 = new TransportUnit(0, "646644", 10, 20, "images/transport/camion1.png");
//        TransportUnit transportUnit1 = new TransportUnit(1, "754532", 20, 30, "images/transport/camion2.png");
//        TransportUnit transportUnit2 = new TransportUnit(2, "768923", 5, 10, "images/transport/camion3.png");
//        TransportUnit transportUnit3 = new TransportUnit(3, "856326", 10, 15, "images/transport/camion4.png");
//        transportUnitList.add(transportUnit0);
//        transportUnitList.add(transportUnit1);
//        transportUnitList.add(transportUnit2);
//        transportUnitList.add(transportUnit3);
//
//        String password = DigestUtils.md5Hex("1234");
//
//        User user0 = new User(0, "Nicole Fonseca", "Administrador", "nicole98", password);
//        User user1 = new User(1, "Wilmer Mata", "Operador", "wilmata24", password);
//        User user2 = new User(2, "Sergio Siles", "Operador", "sfss1997", password);
//        User user3 = new User(3, "Elva Surita", "Operador", "EV", password);
//        User user4 = new User(4, "Allan Brito", "Operador", "Nalla", password);
//        UserList.add(user0);
//        UserList.add(user1);
//        UserList.add(user2);
//        UserList.add(user3);
//        UserList.add(user4);
//
        administratorFiles.writeBatchFile(batchList);
//        administratorFiles.writeCategoryFile(categoryList);
//        administratorFiles.writeCellarFile(cellarList);
        administratorFiles.writeDistributionOrderFile(distributionOrderList);
//        administratorFiles.writeProductFile(productList);
//        administratorFiles.writeTransportUnitFile(transportUnitList);
//        administratorFiles.writeUserFile(UserList);

        LinkedBinaryTree linkedBinaryTree = new LinkedBinaryTree();
        linkedBinaryTree.insert(product0);
        linkedBinaryTree.insert(product1);
        linkedBinaryTree.insert(product2);
        linkedBinaryTree.insert(product3);
        linkedBinaryTree.insert(product4);
        
//        ArrayList<Product> tempArray = linkedBinaryTree.recorreArbol();
//        
//        for (int i = 0; i < tempArray.size(); i++) {
//            Product tempProduct = tempArray.get(i);
//            System.out.println(tempProduct.toString());
//            
//        }
        
        
    }

}
