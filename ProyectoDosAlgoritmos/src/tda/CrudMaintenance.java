package tda;

import Exception.TreeException;
import domain.Batch;
import domain.Category;
import domain.Cellar;
import domain.Product;
import domain.TransportUnit;
import domain.User;
import java.util.Date;
import java.util.Iterator;
import lab_grafos_algoritmos.GraphException;
import static tda.LoadTda.batchMap;
import static tda.LoadTda.categoryMap;
import static tda.LoadTda.cellarGraph;
import static tda.LoadTda.tempTree;
//import static tda.LoadTda.productsBinaryTree;
import static tda.LoadTda.transportUnitMap;
import static tda.LoadTda.userList;

/**
 * Clase para el mantenimiento de cada entidad.
 *
 * @author Nicole Fonseca, Wilmer Mata, Sergio Siles
 */
public class CrudMaintenance {

    public Boolean validateUser(String user, String password) {
        for (int i = 0; i < userList.size(); i++) {
            User userAux = userList.get(i);
            if (userAux.getUser().equals(user)) {
                if (userAux.getPassword().equals(password)) {
                    return true;
                }
            }

        }
        return false;
    }

    public int validateRole(String user) {
        for (int i = 0; i < userList.size(); i++) {
            User userAux = userList.get(i);
            if (userAux.getUser().equals(user)) {
                if (userAux.getRole().equals("Operador")) {
                    return 1;
                } else if (userAux.getRole().equals("Administrador")) {
                    return 2;
                }
            }
        }
        return -1;
    }

    public void addProduct(String name, String unitMeasured, int unitValue, int totalWeight, String description, int idBatch, int idCategory, int price, String url) throws TreeException {
        Product product = new Product(idProduct(), name, unitMeasured, unitValue, totalWeight, description, idBatch, idCategory, price, url);
        tempTree.add(product);
        System.out.println(tempTree.toString());
    }
    
    private int idProduct(){
        return -1;
    }
    
    public void deleteProduct(String name) throws TreeException {
        for (int i = 0; i < tempTree.size(); i++) {
            Product product = (Product) tempTree.get(i);
            if(product.getName().equals(name)) {
                tempTree.remove(product);
            }
        }
        System.out.println(tempTree.toString());
    }

    public Product getProduct(String name) {
        for (int i = 0; i < tempTree.size(); i++) {
            Product product = (Product) tempTree.get(i);
            if (product.getName().equalsIgnoreCase(name)) {
                return product;
            }
        }
        return null;
    }

    public Boolean existsProduct(String name) {
        for (int i = 0; i < tempTree.size(); i++) {
            Product product = (Product) tempTree.get(i);
            if (name.equalsIgnoreCase(product.getName())) {
                return true;
            }
        }
        return false;
    }

    public void updateProduct(String name, String newName,String newUnitMeasured, int newUnitValue, int newTotalWeight, String newDescription, int newIdCategory, int newPrice, String newUrl) {
        if(existsProduct(name)) {
            Product oldName = getProduct(name);
            Product oldUnitMeasured = getProduct(name);
            Product oldUnitValue = getProduct(name);
            Product oldTotalWeight = getProduct(name);
            Product oldDescription = getProduct(name);
            Product oldIdCategory = getProduct(name);
            Product oldPrice = getProduct(name);
            Product oldUrl = getProduct(name);
            
            oldName.setName(newName);
            oldUnitMeasured.setUnitMeasured(newUnitMeasured);
            oldUnitValue.setUnitValue(newUnitValue);
            oldTotalWeight.setTotalWeight(newTotalWeight);
            oldDescription.setDescription(newDescription);
            oldIdCategory.setIdCategory(newIdCategory);
            oldPrice.setPrice(newPrice);
            oldUrl.setUrl(newUrl);
            System.out.println(tempTree.toString());
        }
    }

    public void addCategory(String name, String description) {
        Category category = new Category(idCategory(), name, description);
        categoryMap.put(name, category);
        System.out.println(categoryMap.toString());
    }

    public int idCategory() {
        Iterator iterator = categoryMap.keySet().iterator();
        while (iterator.hasNext()) {
            String key = (String) iterator.next();
        }
        return -1;
    }
    
    public void deleteCategory(String name) {
        Iterator iterator = categoryMap.keySet().iterator();
        try {
            while (iterator.hasNext()) {
                String key = (String) iterator.next();
                Category category = categoryMap.get(key);
                if (name.equals(category.getName())) {
                    categoryMap.remove(key);
                }
            }
        } catch (Exception e) {
        }
        System.out.println(categoryMap.toString());
    }
    
    public Category getCategory(String name) {
        Iterator iterator = categoryMap.keySet().iterator();
        try {
            while (iterator.hasNext()) {
                String key = (String) iterator.next();
                Category category = categoryMap.get(key);
                if (category.getName().equals(name)) {
                    return category;
                }
            }
        } catch (Exception e) {
        }
        return null;
    }
    
    public Boolean existsCategory(String name) {
        Iterator iterator = categoryMap.keySet().iterator();
        try {
            while (iterator.hasNext()) {
                String key = (String) iterator.next();
                Category category = categoryMap.get(key);
                if (category.getName().equals(name)) {
                    return true;
                }
            }
        } catch (Exception e) {
        }
        return false;
    }

    public void updateCategory(String name, String newName, String newDescription) {
        if(existsCategory(name)) {
            Category oldName = getCategory(name);
            Category oldDescription = getCategory(name);
            
            oldName.setName(newName);
            oldDescription.setDescription(newDescription);
            System.out.println(categoryMap.toString());
        }
    }

    public void addBacth(String batchCode, String packedDate, Date expirationDate) {
        Batch batch = new Batch(idBatch(), batchCode, packedDate, expirationDate);
        batchMap.put(idBatch(), batch);
        System.out.println(batchMap.toString());
    }
    
    private int idBatch() {
        return -1;
    }

    public void deleteBacth(String batchCode) {
        Iterator iterator = batchMap.keySet().iterator();
        try {
            while (iterator.hasNext()) {
                int key =  (int) iterator.next();
                Batch batch = batchMap.get(key);
                if (batchCode.equals(batch.getBatchCode())) {
                    batchMap.remove(key);
                }
            }
        } catch (Exception e) {
        }
        System.out.println(batchMap.toString());
    }
    
    public Batch getBatch(String batchCode) {
        Iterator iterator = batchMap.keySet().iterator();
        try {
            while (iterator.hasNext()) {
                int key = (int) iterator.next();
                Batch batch = batchMap.get(key);
                if (batch.getBatchCode().equals(batchCode)) {
                    return batch;
                }
            }
        } catch (Exception e) {
        }
        return null;
    }
    
    public Boolean existsBatch(String batchCode) {
        Iterator iterator = batchMap.keySet().iterator();
        try {
            while (iterator.hasNext()) {
                int key = (int) iterator.next();
                Batch batch = batchMap.get(key);
                if (batch.getBatchCode().equals(batchCode)) {
                    return true;
                }
            }
        } catch (Exception e) {
        }
        return false;
    }

    public void updateBacth(String batchCode, String newBatchCode, String newPackedDate, Date newExpirationDate) {
        if(existsBatch(batchCode)) {
            Batch oldBatchCode = getBatch(batchCode);
            Batch oldPackedDate = getBatch(batchCode);
            Batch oldExpirationDate = getBatch(batchCode);
            
            oldBatchCode.setBatchCode(newBatchCode);
            oldPackedDate.setPackedDate(newPackedDate);
            oldExpirationDate.setExpirationDate(newExpirationDate);
            System.out.println(batchMap.toString());
        }
    }

    public void addTransportUnit(String plate, int minCapacity, int maxCapacity, String url) {
        TransportUnit transportUnit = new TransportUnit(idTransport(), plate, minCapacity, maxCapacity, url);
        transportUnitMap.put(idTransport(), transportUnit);
        System.out.println(transportUnitMap.toString());
    }
    
    private int idTransport() {
        return -1;
    }

    public void deleteTransportUnit(String plate) {
        Iterator iterator = transportUnitMap.keySet().iterator();
        try {
            while (iterator.hasNext()) {
                int key =  (int) iterator.next();
                TransportUnit transportUnit = transportUnitMap.get(key);
                if (plate.equals(transportUnit.getPlate())) {
                    transportUnitMap.remove(key);
                }
            }
        } catch (Exception e) {
        }
        System.out.println(transportUnitMap.toString());
    }
    
    public TransportUnit getTransportUnit(String plate) {
        Iterator iterator = transportUnitMap.keySet().iterator();
        try {
            while (iterator.hasNext()) {
                int key = (int) iterator.next();
                TransportUnit transportUnit = transportUnitMap.get(key);
                if (transportUnit.getPlate().equals(plate)) {
                    return transportUnit;
                }
            }
        } catch (Exception e) {
        }
        return null;
    }
    
    public Boolean existsTransportUnit(String plate) {
        Iterator iterator = transportUnitMap.keySet().iterator();
        try {
            while (iterator.hasNext()) {
                int key = (int) iterator.next();
                TransportUnit transportUnit = transportUnitMap.get(key);
                if (transportUnit.getPlate().equals(plate)) {
                    return true;
                }
            }
        } catch (Exception e) {
        }
        return false;
    }

    public void updateTransportUnit(String plate, String newPlate, int newMinCapacity, int newMaxCapacity, String newUrl) {
        if(existsTransportUnit(plate)) {
            TransportUnit oldPlate  = getTransportUnit(plate);
            TransportUnit oldMinCapacity = getTransportUnit(plate);
            TransportUnit oldMaxCapacuty = getTransportUnit(plate);
            TransportUnit oldUrl = getTransportUnit(plate);
            
            oldPlate.setPlate(newPlate);
            oldMinCapacity.setMinCapacity(newMinCapacity);
            oldMaxCapacuty.setMaxCapacity(newMaxCapacity);
            oldUrl.setUrl(plate);
            System.out.println(transportUnitMap.toString());
        }
    }
    
    public void addCellar(String name, String latitude, String length, float distance, String url) throws GraphException {
        Cellar cellar = new Cellar(idCellar(), name, latitude, length, distance, url);
        cellarGraph.insertVertx(cellar);
        System.out.println(cellarGraph.toString());
    }
    
    private int idCellar() {
        return -1;
    }

    public void deleteCellar(String name) throws GraphException {
        for (int i = 0; i < cellarGraph.list().size(); i++) {
            Cellar cellar = (Cellar) cellarGraph.list().get(i);
            if(cellar.getName().equals(name)) {
                cellarGraph.deleteVertex(cellar);
            }
        }
        System.out.println(cellarGraph.toString());
    }
    
    public Cellar getCellar(String name) throws GraphException {
        for (int i = 0; i < cellarGraph.getSize(); i++) {
            Cellar cellar = (Cellar) cellarGraph.list().get(i);
            if(cellar.getName().equals(name)) {
                return cellar;
            }
        }
        return null;
    }
    
    public Boolean existsCellar(String name) throws GraphException {
        for (int i = 0; i < cellarGraph.getSize(); i++) {
            Cellar cellar = (Cellar) cellarGraph.list().get(i);
            if(cellar.getName().equals(name)) {
                return true;
            }
        }
        return false;
    }

    public void updateCellar(String name, String newName, String newLatitude, String newLength, float newDistance, String url) throws GraphException {
        if(existsCellar(name)) {
            Cellar oldName = getCellar(name);
            Cellar oldLatitude = getCellar(name);
            Cellar oldLenght = getCellar(name);
            Cellar oldDistance = getCellar(name);
            Cellar oldUrl = getCellar(name);
            
            oldName.setName(newName);
            oldLatitude.setLatitude(newLatitude);
            oldLenght.setLength(newLength);
            oldDistance.setDistance(newDistance);
            oldUrl.setUrl(url);
            System.out.println(cellarGraph.toString());
        }
    }

    public void addUser(String name, String role, String NameUser, String password) {
        User user = new User(idUser(), name, role, NameUser, password);
        userList.add(user);
        System.out.println(userList.toString());
    }
    
    private int idUser(){
        return -1;
    }

    public void deleteUser(String userName) {
        for (int i = 0; i < userList.size(); i++) {
            User user =userList.get(i);
            if(user.getUser().equals(userName)) {
                userList.remove(user);
            }
        }
        System.out.println(userList.toString());
    }
    
    public User getUser(String userName) {
        for (int i = 0; i < userList.size(); i++) {
            User user = userList.get(i);
            if (user.getUser().equals(userName)) {
                return user;
            }
        }
        return null;
    }
    
    public Boolean existsUser(String userName) {
        for (int i = 0; i < userList.size(); i++) {
            User user = userList.get(i);
            if (user.getUser().equals(userName)) {
                return true;
            }
        }
        return false;
    }

    public void updateUser(String userName, String newName, String newRole, String newUserName, String newPassword) {
        if (existsUser(userName)) {
            User oldName = getUser(userName);
            User oldRole = getUser(userName);
            User oldUserName = getUser(userName);
            User oldPassword = getUser(userName);
            
            oldName.setName(newName);
            oldRole.setRole(newRole);
            oldUserName.setUser(newUserName);
            oldPassword.setPassword(newPassword);
            System.out.println(userList.toString());
        }
    }
}
