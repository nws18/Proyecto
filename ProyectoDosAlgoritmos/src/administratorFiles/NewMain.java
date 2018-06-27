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
        ArrayList<Category> categoryList = new ArrayList();
        ArrayList<Cellar> cellarList = new ArrayList();
        ArrayList<DistributionOrder> distributionOrderList = new ArrayList();
        ArrayList<Product> productList = new ArrayList();
        ArrayList<TransportUnit> transportUnitList = new ArrayList();
        ArrayList<User> UserList = new ArrayList();

        Batch batch0 = new Batch(0, "IDRHFU45T45", "01-01-2018 12:30", "13-03-2018");
        Batch batch1 = new Batch(1, "KJBFH45G54G", "08-02-2018 10:25", "01-04-2018");
        Batch batch2 = new Batch(2, "EARGE56YHRT", "05-03-2018 11:45", "23-05-2018");
        Batch batch3 = new Batch(3, "ERGRTERHRHT", "22-04-2018 9:10", "15-06-2018");
        Batch batch4 = new Batch(4, "DFVKNSKJVNJ", "28-05-2018 8:01", "18-10-2018");
        Batch batch5 = new Batch(5, "AHIR65HEN5N", "23-06-2018 10:01", "25-12-2018");
        Batch batch6 = new Batch(6, "QJWEHBD76JN", "10-01-2018 11:25", "25-09-2018");
        Batch batch7 = new Batch(7, "ASCVBRU456R", "22-02-2018 10:04", "11-10-2018");
        Batch batch8 = new Batch(8, "CVIRH3O0J3N", "01-06-2018 9:01", "01-12-2018");
        Batch batch9 = new Batch(9, "YWEMD7402JD", "01-05-2018 7:25", "03-08-2018");
        Batch batch10 = new Batch(10, "CVIRH3O0J3N", "01-03-2018 9:01", "01-12-2018");
        Batch batch11 = new Batch(11, "HYEBEERDW45", "01-06-2018 10:01", "20-12-2019");
        Batch batch12 = new Batch(12, "AH63HHWUB55", "02-07-2018 11:13", "20-11-2019");
        Batch batch13 = new Batch(13, "P3956GEV5NW", "03-08-2018 12:01", "20-10-2019");
        Batch batch14 = new Batch(14, "SGTEBJ47444", "04-09-2018 6:25", "20-09-2019");
        Batch batch15 = new Batch(15, "BUWKUEWJ535", "05-10-2018 7:02", "20-08-2019");
        Batch batch16 = new Batch(16, "SUHEUWHSHSS", "06-11-2018 8:01", "20-07-2019");
        Batch batch17 = new Batch(17, "HWHWE56BU34", "07-12-2018 11:07", "25-04-2019");
        Batch batch18 = new Batch(18, "UEHEYEBB532", "06-05-2018 9:11", "20-07-2019");
        Batch batch19 = new Batch(19, "UW7402BRHWK", "05-06-2018 10:12", "21-07-2019");
        Batch batch20 = new Batch(20, "XBY26455553", "04-07-2018 11:15", "22-08-2019");
        Batch batch21 = new Batch(21, "NJU35FO383Q", "03-08-2018 1:20", "23-09-2019");
        Batch batch22 = new Batch(22, "P03HVCFRAWE", "02-09-2018 3:02", "24-10-2019");
        Batch batch23 = new Batch(23, "23EW47TNJS7", "01-10-2018 4:25", "25-11-2019");
        batchList.add(batch0);
        batchList.add(batch1);
        batchList.add(batch2);
        batchList.add(batch3);
        batchList.add(batch4);
        batchList.add(batch5);
        batchList.add(batch6);
        batchList.add(batch7);
        batchList.add(batch8);
        batchList.add(batch9);
        batchList.add(batch10);
        batchList.add(batch11);
        batchList.add(batch12);
        batchList.add(batch13);
        batchList.add(batch14);
        batchList.add(batch15);
        batchList.add(batch16);
        batchList.add(batch17);
        batchList.add(batch18);
        batchList.add(batch19);
        batchList.add(batch20);
        batchList.add(batch21);
        batchList.add(batch22);
//
        Category category0 = new Category(0, "Higiene", "Productos para el higiene y ciudado personal");
        Category category1 = new Category(1, "Hogar", "Productos de limpieza para el hogar");
        Category category2 = new Category(2, "Larga duración", "Productos enlatados de larga duración");
        Category category3 = new Category(3, "Bebidas", "Refrescos gaseosos, naturales y bebidas alcoholicas");
        Category category4 = new Category(4, "Abarrotes", "Arroz, pastas y legumbres");
        Category category5 = new Category(5, "Snacks", "Frituras y dulces");
        categoryList.add(category0);
        categoryList.add(category1);
        categoryList.add(category2);
        categoryList.add(category3);
        categoryList.add(category4);
        categoryList.add(category5);
//
        Cellar cellar0 = new Cellar(0, "Caballo Blanco", "9.8465059", "-83.8453388", 6, "images/grocery/paraiso.jpg");
        Cellar cellar1 = new Cellar(1, "Curridabat", "9.9104054", "-84.0261615", 7, "images/grocery/san jose.jpg");
        Cellar cellar2 = new Cellar(2, "Desamaparados", "9.8962853", "-84.0929378", 8, "images/grocery/desamparados.jpg");
        Cellar cellar3 = new Cellar(3, "Lima", "9.8733467", "-83.9445108", 9, "images/grocery/lima.jpg");
        Cellar cellar4 = new Cellar(4, "San Sebastian", "9.8962853", "-84.0929378", 10, "images/grocery/liberia.jpg");
        cellarList.add(cellar0);
        cellarList.add(cellar1);
        cellarList.add(cellar2);
        cellarList.add(cellar3);
        cellarList.add(cellar4);

        Product product0 = new Product(0, "Aceite", "Unidades", 1, 2, "Aceite de cocina", 0, 4, 2000.0, "images/products/aceite.png");
        Product product1 = new Product(1, "Arroz", "Paquetes", 8, 16, "Arroz, 2kg", 1, 4, 12500.0, "images/products/arroz.png");
        Product product2 = new Product(2, "Cereal", "Cajas", 10, 5, "Cereal", 2, 2, 10500.0, "images/products/cereal.png");
        Product product3 = new Product(3, "Chocolate", "Paquetes", 15, 5, "Chocolate relleno", 3, 5, 15500.0, "images/products/chocolate.png");
        Product product4 = new Product(4, "Coca cola", "Tarimas", 30, 20, "Bebida gaseosa", 4, 3, 40500, "images/products/cocacola.png");
        Product product5 = new Product(5, "Cono Kit-Kat", "Paquetes", 15, 10, "Helado de chocolate", 5, 5, 20500.0, "images/products/cono-kitkat.png");
        Product product6 = new Product(6, "Galletas", "Paquetes", 10, 3, "Galletas de crema", 6, 5, 10500.0, "images/products/galletas.png");
        Product product7 = new Product(7, "Salsa de tomate", "Cajas", 10, 9, "Salsa de tomate", 7, 2, 8500, "images/products/ketchup.png");
        Product product8 = new Product(8, "Limpiador", "Cajas", 7, 10, "Limpiador de superficies del hogar", 8, 1, 8000.0, "images/products/limpiador.png");
        Product product9 = new Product(9, "Enjuague bucal", "Paquetes", 20, 7, "Enjuague bucal", 9, 0, 14300.0, "images/products/listerine.png");
        Product product10 = new Product(10, "Mayonesa", "Cajas", 10, 6, "Aderezo mayonesa", 10, 2, 6000.0, "images/products/mayonesa.png");
        Product product11 = new Product(11, "Chocolate en polvo", "Paquetes", 6, 6, "Chocolate en polvo Nesquik", 11, 2, 6500.0, "images/products/nesquik.png");
        Product product12 = new Product(12, "Nuggets", "Paquetes", 5, 6, "Nuggets congelados para freír", 12, 5, 11500.0, "images/products/nuggets.png");
        Product product13 = new Product(13, "Palomitas", "Paquetes", 20, 3, "Palomitas de maíz, sabor mantequilla", 13, 5, 5000.0, "images/products/palomitas.png");
        Product product14 = new Product(14, "Pan", "Cajas", 10, 5, "Pan cuadrado para sandwiches", 14, 5, 5000.0, "images/products/pan.png");
        Product product15 = new Product(15, "Papas tostadas", "Cajas", 25, 15, "Papas tostadas en lata", 15, 5, 15200.0, "images/products/papasfritas.png");
        Product product16 = new Product(16, "Papel higienico", "Tarimas", 20, 10, "Papel higienico doble hoja", 16, 0, 17800.0, "images/products/papel.png");
        Product product17 = new Product(17, "Pasta dental", "Cajas", 20, 8, "Pasta dental", 17, 0, 9700.0, "images/products/pasta.png");
        Product product18 = new Product(18, "Shampoo", "Cajas", 15, 17, "Shampoo", 18, 0, 26300.0, "images/products/shampoo.png");
        Product product19 = new Product(19, "Spaghetti", "Paquetes", 10, 3, "Spaghetti", 19, 4, 10100.0, "images/products/spaghetti.png");
        Product product20 = new Product(20, "Té frío", "Tarimas", 25, 20, "Refresco natural", 20, 3, 32500.0, "images/products/te.png");
        Product product21 = new Product(21, "Limpiador Vanish", "Cajas", 14, 11, "Limpiador de ropa", 21, 1, 8000.0, "images/products/vanish.png");
        Product product22 = new Product(22, "Vino", "Cajas", 10, 11, "Bebida alcoholica", 22, 3, 35400.0, "images/products/vino.png");
        productList.add(product0);
        productList.add(product1);
        productList.add(product2);
        productList.add(product3);
        productList.add(product4);
        productList.add(product5);
        productList.add(product6);
        productList.add(product7);
        productList.add(product8);
        productList.add(product9);
        productList.add(product10);
        productList.add(product11);
        productList.add(product12);
        productList.add(product13);
        productList.add(product14);
        productList.add(product15);
        productList.add(product16);
        productList.add(product17);
        productList.add(product18);
        productList.add(product19);
        productList.add(product20);
        productList.add(product21);
        productList.add(product22);
        
        ArrayList<Product> arrayList = new ArrayList<>();
        arrayList.add(product0);
        arrayList.add(product1);
        arrayList.add(product2);
        arrayList.add(product3);
        
        ArrayList<Product> arrayList1 = new ArrayList<>();
        arrayList1.add(product4);
        arrayList1.add(product5);
        arrayList1.add(product6);
        arrayList1.add(product7);
        
        ArrayList<Product> arrayList2 = new ArrayList<>();
        arrayList2.add(product8);
        arrayList2.add(product9);
        arrayList2.add(product10);
        arrayList2.add(product11);
        
        ArrayList<Product> arrayList3 = new ArrayList<>();
        arrayList3.add(product12);
        arrayList3.add(product13);
        arrayList3.add(product14);
        arrayList3.add(product15);
        
        ArrayList<Product> arrayList4 = new ArrayList<>();
        arrayList4.add(product16);
        arrayList4.add(product17);
        arrayList4.add(product18);
        arrayList4.add(product19);

        DistributionOrder distributionOrder0 = new DistributionOrder(0, 0, 1, 40500, 38, arrayList, 0, "12-04-2018");
        DistributionOrder distributionOrder1 = new DistributionOrder(1, 0, 2, 80000, 48, arrayList1, 1, "05-04-2018");
        DistributionOrder distributionOrder2 = new DistributionOrder(2, 0, 3, 34800, 29, arrayList2, 2,  "11-04-2018");
        DistributionOrder distributionOrder3 = new DistributionOrder(3, 0, 4, 36700, 29, arrayList3, 3,  "22-05-2018");
        DistributionOrder distributionOrder4 = new DistributionOrder(4, 0, 4, 63900, 38, arrayList4, 1, "26-05-2018");
        DistributionOrder distributionOrder5 = new DistributionOrder(5, 0, 4, 34800, 38, arrayList, 2, "26-05-2018");
        DistributionOrder distributionOrder6 = new DistributionOrder(6, 0, 1, 80000, 48, arrayList1, 3, "26-06-2018");
        DistributionOrder distributionOrder7 = new DistributionOrder(7, 0, 0, 34800, 29, arrayList2, 1, "26-06-2018");
        DistributionOrder distributionOrder8 = new DistributionOrder(8, 0, 3, 36700, 29, arrayList3, 0, "26-06-2018");
        distributionOrderList.add(distributionOrder0);
        distributionOrderList.add(distributionOrder1);
        distributionOrderList.add(distributionOrder2);
        distributionOrderList.add(distributionOrder3);
        distributionOrderList.add(distributionOrder4);
        distributionOrderList.add(distributionOrder5);
        distributionOrderList.add(distributionOrder6);
        distributionOrderList.add(distributionOrder7);
        distributionOrderList.add(distributionOrder8);

        TransportUnit transportUnit0 = new TransportUnit(0, "646644", 10, 20, "images/transport/camion1.png");
        TransportUnit transportUnit1 = new TransportUnit(1, "754532", 20, 30, "images/transport/camion2.png");
        TransportUnit transportUnit2 = new TransportUnit(2, "768923", 5, 10, "images/transport/camion3.png");
        TransportUnit transportUnit3 = new TransportUnit(3, "856326", 10, 15, "images/transport/camion4.png");
        transportUnitList.add(transportUnit0);
        transportUnitList.add(transportUnit1);
        transportUnitList.add(transportUnit2);
        transportUnitList.add(transportUnit3);
//
        String password = DigestUtils.md5Hex("1234");

        User user0 = new User(0, "Nicole Fonseca", "Administrador", "nicole98", password);
        User user1 = new User(1, "Wilmer Mata", "Operador", "wilmata24", password);
        User user2 = new User(2, "Sergio Siles", "Operador", "sfss1997", password);
        User user3 = new User(3, "Allan Brito", "Operador", "Nalla", password);
        UserList.add(user0);
        UserList.add(user1);
        UserList.add(user2);
        UserList.add(user3);

        administratorFiles.writeBatchFile(batchList);
        administratorFiles.writeCategoryFile(categoryList);
        administratorFiles.writeCellarFile(cellarList);
        administratorFiles.writeDistributionOrderFile(distributionOrderList);
        administratorFiles.writeProductFile(productList);
        administratorFiles.writeTransportUnitFile(transportUnitList);
        administratorFiles.writeUserFile(UserList);

        LinkedBinaryTree linkedBinaryTree = new LinkedBinaryTree();
//        linkedBinaryTree.insert(product0);
//        linkedBinaryTree.insert(product1);
//        linkedBinaryTree.insert(product2);
//        linkedBinaryTree.insert(product3);
//        linkedBinaryTree.insert(product4);
////        
//        ArrayList<Product> tempArray = linkedBinaryTree.recorreArbol();
//        
//        for (int i = 0; i < tempArray.size(); i++) {
//            Product tempProduct = tempArray.get(i);
//            System.out.println(tempProduct.toString());
//            
//        }
        
        
        
        
    }

}
