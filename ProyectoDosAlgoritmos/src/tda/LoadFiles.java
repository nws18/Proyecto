
package tda;

import LinkedBinaryTree.TreeException;
import administratorFiles.AdministratorFiles;
import domain.Batch;
import domain.Category;
import domain.Cellar;
import domain.DistributionOrder;
import domain.Product;
import domain.TransportUnit;
import domain.User;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import lab_grafos_algoritmos.GraphException;
import static tda.LoadTda.batchMap;
import static tda.LoadTda.categoryMap;
import static tda.LoadTda.cellarGraph;
import static tda.LoadTda.distributionOrderList;
import static tda.LoadTda.productsBinaryTree;
import static tda.LoadTda.transportUnitMap;
import static tda.LoadTda.userList;

/**
 * Clase para cargar la información de las estructuras de datos a los archivos.
 * @author Nicole Fonseca, Wilmer Mata, Sergio Siles
 */
public class LoadFiles {
    
    AdministratorFiles administratorFiles = new AdministratorFiles();
    
    /**
     * Carga la información de productos desde las estructuras de datos hasta los archivos.
     * @throws IOException
     * @throws TreeException 
     */
    public void fileProduct() throws IOException, TreeException {
        ArrayList<Product> arrayList = new ArrayList<>();
        for (int i = 0; i < productsBinaryTree.getSize() ; i++) {
            arrayList.add((Product)productsBinaryTree.recorreArbol().get(i));
        }
        administratorFiles.writeProductFile(arrayList);
    }
    
    /**
     * Carga la información de categorías desde las estructuras de datos hasta los archivos.
     * @throws IOException 
     */
    public void fileCategory() throws IOException {
        ArrayList<Category> arrayList = new ArrayList<>();
        Iterator iterator = categoryMap.keySet().iterator();
        while (iterator.hasNext()) {
            String key = (String) iterator.next();
            arrayList.add(categoryMap.get(key));
        }
        administratorFiles.writeCategoryFile(arrayList);
    }
    
    /**
     * Carga la información de código de lote desde las estructuras de datos hasta los archivos.
     * @throws IOException 
     */
    public void fileBatch() throws IOException {
        ArrayList<Batch> arrayList = new ArrayList<>();
        Iterator iterator = batchMap.keySet().iterator();
        while (iterator.hasNext()) {
            Integer key = (Integer) iterator.next();
            arrayList.add(batchMap.get(key));
        }
        administratorFiles.writeBatchFile(arrayList);
    }
    
    /**
     * Carga la información de unidad de transporte desde las estructuras de datos hasta los archivos.
     * @throws IOException 
     */
    public void fileTransportUnit() throws IOException {
        ArrayList<TransportUnit> arrayList = new ArrayList<>();
        Iterator iterator = transportUnitMap.keySet().iterator();
        while (iterator.hasNext()) {
            Integer key = (Integer) iterator.next();
            arrayList.add(transportUnitMap.get(key));
        }
        administratorFiles.writeTransportUnitFile(arrayList);
    }
    
    /**
     * Carga la información de Bodegas desde las estructuras de datos hasta los archivos.
     * @throws GraphException
     * @throws IOException 
     */
    public void fileCellar() throws GraphException, IOException {
        ArrayList<Cellar> arrayList = new ArrayList<>();
        for (int i = 0; i < cellarGraph.list().size(); i++) {
            arrayList.add((Cellar) cellarGraph.list().get(i));
        }
        administratorFiles.writeCellarFile(arrayList);
    }
    
    /**
     * Carga la información de orden de distribución desde las estructuras de datos hasta los archivos.
     * @throws IOException 
     */
      public void fileDistributionOrder() throws IOException {
          ArrayList<DistributionOrder> arrayList = new ArrayList<>();
          for (int i = 0; i < distributionOrderList.size(); i++) {
              DistributionOrder distributionOrder = distributionOrderList.get(i);
              arrayList.add(distributionOrder);
          }
          administratorFiles.writeDistributionOrderFile(arrayList);
      }
      
      /**
       * Carga la información de usuarios desde las estructuras de datos hasta los archivos.
       * @throws IOException 
       */
      public void fileUser() throws IOException {
          ArrayList<User> arrayList = new ArrayList<>();
          for (int i = 0; i < userList.size(); i++) {
              User user = userList.get(i);
              arrayList.add(user);
          }
          administratorFiles.writeUserFile(arrayList);
      }
   
}
