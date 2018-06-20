
package tda;

import Exception.TreeException;
import administratorFiles.AdministratorFiles;
import binarytree.LinkedBinaryTree;
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
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.TreeMap;
import lab_grafos_algoritmos.AdjacencyMatrixGraph;
import lab_grafos_algoritmos.GraphException;

/**
 * Clase para cargar la información de los archivos a las estructuras de datos.
 * @author Nicole Fonseca, Wilmer Mata, Sergio Siles
 */

public class LoadTda {
    
    public static LinkedBinaryTree productsBinaryTree = new LinkedBinaryTree();
    public static Map<String, Category> categoryMap = new HashMap<>();
    public static Map<Integer, Batch> batchMap = new TreeMap<>();
    public static Map<Integer, TransportUnit> transportUnitMap = new LinkedHashMap<>();
    public static AdjacencyMatrixGraph cellarGraph = new AdjacencyMatrixGraph(50);
    public static LinkedList<DistributionOrder> distributionOrderList = new LinkedList<>();
    public static LinkedList<User> userList = new LinkedList<>();
    
    AdministratorFiles administratorFiles = new AdministratorFiles();
    
    public void tdaProduct() throws IOException, FileNotFoundException, ClassNotFoundException, TreeException {
        ArrayList<Product> arrayList = administratorFiles.readProductFile();
        for (int i = 0; i < arrayList.size(); i++) {
            Product product = arrayList.get(i);
            productsBinaryTree.insert(product);            
        }
        System.out.println(productsBinaryTree.recorreArbol().toString());
    }
    
    public void tdaCategory() throws IOException, FileNotFoundException, ClassNotFoundException {
        ArrayList<Category> arrayList = administratorFiles.readCategoryFile();
        for (int i = 0; i < arrayList.size(); i++) {
            Category category = arrayList.get(i);
            categoryMap.put(category.getName(), category);
        }
        System.out.println(categoryMap.toString());
    }
    
    public void tdaBatch() throws IOException, FileNotFoundException, ClassNotFoundException {
        ArrayList<Batch> arrayList = administratorFiles.readBatchFile();
        for (int i = 0; i < arrayList.size(); i++) {
            Batch batch = arrayList.get(i);
            batchMap.put(batch.getIdBatch(), batch);
        }
        System.out.println(batchMap.toString());
    }
    
    public void tdaTransportUnit() throws IOException, FileNotFoundException, ClassNotFoundException {
        ArrayList<TransportUnit> arrayList = administratorFiles.readTransportUnitFile();
        for (int i = 0; i < arrayList.size(); i++) {
            TransportUnit transportUnit = arrayList.get(i);
            transportUnitMap.put(transportUnit.getIdTransportUnit(), transportUnit);
        }
        System.out.println(transportUnitMap.toString());
    }
    
    public void tdaCellar() throws IOException, FileNotFoundException, ClassNotFoundException, GraphException {
        ArrayList<Cellar> arrayList = administratorFiles.readCellarFile();
        for (int i = 0; i < arrayList.size(); i++) {
            Cellar cellar = arrayList.get(i);
            cellarGraph.insertVertx(cellar);
        }
        System.out.println(cellarGraph.toString());
    }
    
    public void tdaDistributionOrder() throws IOException, FileNotFoundException, ClassNotFoundException {
        ArrayList<DistributionOrder> arrayList = administratorFiles.readFile();
        for (int i = 0; i < arrayList.size(); i++) {
            DistributionOrder distributionOrder = arrayList.get(i);
            distributionOrderList.add(distributionOrder);
        }
        System.out.println(distributionOrderList.toString());
    }
    
    public void tdaUser() throws IOException, FileNotFoundException, ClassNotFoundException {
        ArrayList<User> arrayList = administratorFiles.readUserFile();
        for (int i = 0; i < arrayList.size(); i++) {
            User user = arrayList.get(i);
            userList.add(user);
        }
        System.out.println(userList.toString());
    }
}
