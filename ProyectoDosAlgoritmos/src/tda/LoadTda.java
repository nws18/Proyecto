package tda;

import LinkedBinaryTree.LinkedBinaryTree;
import LinkedBinaryTree.TreeException;
import administratorFiles.AdministratorFiles;
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
 *
 * @author Nicole Fonseca, Wilmer Mata, Sergio Siles
 */
public class LoadTda {

    /**
     * Estructuras de datos para el manejo de toda la información durante la
     * ejecución del programa.
     */
    public static LinkedBinaryTree productsBinaryTree = new LinkedBinaryTree();
    public static Map<String, Category> categoryMap = new HashMap<>();
    public static Map<Integer, Batch> batchMap = new TreeMap<>();
    public static Map<Integer, TransportUnit> transportUnitMap = new LinkedHashMap<>();
    public static AdjacencyMatrixGraph cellarGraph = new AdjacencyMatrixGraph(50);
    public static ArrayList<DistributionOrder> distributionOrderList = new ArrayList<>();
    public static LinkedList<User> userList = new LinkedList<>();

    AdministratorFiles administratorFiles = new AdministratorFiles();

    /**
     * Carga la información de productos desde los archivos hasta las
     * estructuras de datos.
     *
     * @throws IOException
     * @throws FileNotFoundException
     * @throws ClassNotFoundException
     * @throws TreeException
     */
    public void tdaProduct() throws IOException, FileNotFoundException, ClassNotFoundException, TreeException {
        ArrayList<Product> arrayList = administratorFiles.readProductFile();
        for (int i = 0; i < arrayList.size(); i++) {
            Product product = arrayList.get(i);
            productsBinaryTree.insert(product);
        }
    }

    /**
     * Carga la información de categorías desde los archivos hasta las
     * estructuras de datos.
     *
     * @throws IOException
     * @throws FileNotFoundException
     * @throws ClassNotFoundException
     */
    public void tdaCategory() throws IOException, FileNotFoundException, ClassNotFoundException {
        ArrayList<Category> arrayList = administratorFiles.readCategoryFile();
        for (int i = 0; i < arrayList.size(); i++) {
            Category category = arrayList.get(i);
            categoryMap.put(category.getName(), category);
        }
    }

    /**
     * Carga la información de códigos de lote desde los archivos hasta las
     * estructuras de datos.
     *
     * @throws IOException
     * @throws FileNotFoundException
     * @throws ClassNotFoundException
     */
    public void tdaBatch() throws IOException, FileNotFoundException, ClassNotFoundException {
        ArrayList<Batch> arrayList = administratorFiles.readBatchFile();
        for (int i = 0; i < arrayList.size(); i++) {
            Batch batch = arrayList.get(i);
            batchMap.put(batch.getIdBatch(), batch);
        }
    }

    /**
     * Carga la información de unidades de transporte desde los archivos hasta
     * las estructuras de datos.
     *
     * @throws IOException
     * @throws FileNotFoundException
     * @throws ClassNotFoundException
     */
    public void tdaTransportUnit() throws IOException, FileNotFoundException, ClassNotFoundException {
        ArrayList<TransportUnit> arrayList = administratorFiles.readTransportUnitFile();
        for (int i = 0; i < arrayList.size(); i++) {
            TransportUnit transportUnit = arrayList.get(i);
            transportUnitMap.put(transportUnit.getIdTransportUnit(), transportUnit);
        }
    }

    /**
     * Carga la información de bodegas desde los archivos hasta las estructuras
     * de datos.
     *
     * @throws IOException
     * @throws FileNotFoundException
     * @throws ClassNotFoundException
     * @throws GraphException
     */
    public void tdaCellar() throws IOException, FileNotFoundException, ClassNotFoundException, GraphException {
        ArrayList<Cellar> arrayList = administratorFiles.readCellarFile();
        for (int i = 0; i < arrayList.size(); i++) {
            Cellar cellar = arrayList.get(i);
            cellarGraph.insertVertx(cellar);
        }
    }

    public int calculateDistanceInKilometer(double userLat, double userLng,
            double venueLat, double venueLng) {

        double latDistance = Math.toRadians(userLat - venueLat);
        double lngDistance = Math.toRadians(userLng - venueLng);

        double a = Math.sin(latDistance / 2) * Math.sin(latDistance / 2)
                + Math.cos(Math.toRadians(userLat)) * Math.cos(Math.toRadians(venueLat))
                * Math.sin(lngDistance / 2) * Math.sin(lngDistance / 2);

        double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));

        return (int) (Math.round(6371 * c));
    }

    /**
     * Carga la información de orden de distribución desde los archivos hasta
     * las estructuras de datos.
     *
     * @throws IOException
     * @throws FileNotFoundException
     * @throws ClassNotFoundException
     */
    public void tdaDistributionOrder() throws IOException, FileNotFoundException, ClassNotFoundException {
        ArrayList<DistributionOrder> arrayList = administratorFiles.readFile();
        for (int i = 0; i < arrayList.size(); i++) {
            DistributionOrder distributionOrder = arrayList.get(i);
            distributionOrderList.add(distributionOrder);
        }
    }

    /**
     * Carga la información de usuarios desde los archivos hasta las estructuras
     * de datos.
     *
     * @throws IOException
     * @throws FileNotFoundException
     * @throws ClassNotFoundException
     */
    public void tdaUser() throws IOException, FileNotFoundException, ClassNotFoundException {
        ArrayList<User> arrayList = administratorFiles.readUserFile();
        for (int i = 0; i < arrayList.size(); i++) {
            User user = arrayList.get(i);
            userList.add(user);
        }
    }
}
