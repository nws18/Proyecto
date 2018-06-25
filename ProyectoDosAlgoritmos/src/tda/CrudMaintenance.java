package tda;


import LinkedBinaryTree.TreeException;
import domain.Batch;
import domain.Category;
import domain.Cellar;
import domain.Product;
import domain.TransportUnit;
import domain.User;
import java.util.Iterator;
import lab_grafos_algoritmos.GraphException;
import org.apache.commons.codec.digest.DigestUtils;
import static tda.LoadTda.batchMap;
import static tda.LoadTda.categoryMap;
import static tda.LoadTda.cellarGraph;
import static tda.LoadTda.productsBinaryTree;
import static tda.LoadTda.transportUnitMap;
import static tda.LoadTda.userList;

/**
 * Clase para el mantenimiento de cada entidad.
 *
 * @author Nicole Fonseca, Wilmer Mata, Sergio Siles
 */
public class CrudMaintenance {
    /**
     * Verifica que el usuario y contraseña que está almacenada en MD5 existeen los archivos
     * @param user
     * @param password
     * @return 
     */

    public Boolean validateUser(String user, String password) {
        String verifyMD5 = DigestUtils.md5Hex(password);
        for (int i = 0; i < userList.size(); i++) {
            User userAux = userList.get(i);
            if (userAux.getUser().equalsIgnoreCase(user)) {
                if (userAux.getPassword().equalsIgnoreCase(verifyMD5)) {
                    return true;
                }
            }
        }
        return false;
    }
    /**
     * Dependiendo del rol que tenga el usuario previamente validado en validateUser,lanza la ventana correspondiente.
     * @param user
     * @return 
     */

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
    /**
     * Añade productos a un árbol binario.
     * @param name
     * @param unitMeasured
     * @param unitValue
     * @param totalWeight
     * @param description
     * @param idBatch
     * @param idCategory
     * @param price
     * @param url
     * @throws TreeException 
     */

    public void addProduct(String name, String unitMeasured, int unitValue, int totalWeight, String description, int idBatch, int idCategory, double price, String url) throws TreeException {
        Product product = new Product(idProduct(), name, unitMeasured, unitValue, totalWeight, description, idBatch, idCategory, price, url);
        productsBinaryTree.insert(product);
    }
    /**
     * Recorre el árbol binario de productos y el agrega un número más al ID del último producto.
     * @return
     * @throws TreeException 
     */
    
    private int idProduct() throws TreeException{
        int j = 0;
        for (int i = 0; i < productsBinaryTree.getSize(); i++) {
            Product product = (Product) productsBinaryTree.recorreArbol().get(i);
            if(product.getIdProduct() >  j) {
                j = product.getIdProduct();
            } 
        }
        return j+1;
    }
    
    /**
     * Mediante un nombre ingresado, borra un producto del árbol binario.
     * @param name
     * @throws TreeException 
     */
    
    public void deleteProduct(String name) throws TreeException {
        for (int i = 0; i < productsBinaryTree.getSize(); i++) {
            Product product = (Product) productsBinaryTree.recorreArbol().get(i);
            if(product.getName().equals(name)) {
                productsBinaryTree.delete(product);
            }
        }
    }
    
    /**
     * Por medio de un nombre, se recorre el árbol binario de producto y retorna el producto.
     * @param name
     * @return
     * @throws TreeException 
     */

    public Product getProduct(String name) throws TreeException {
        for (int i = 0; i < productsBinaryTree.getSize(); i++) {
            Product product = (Product) productsBinaryTree.recorreArbol().get(i);
            if (product.getName().equalsIgnoreCase(name)) {
                return product;
            }
        }
        return null;
    }
    
    /**
     * Por medio de un nombre, recorre el árbol binario y veridica que este exista.
     * @param name
     * @return
     * @throws TreeException 
     */

    public Boolean existsProduct(String name) throws TreeException {
        for (int i = 0; i < productsBinaryTree.getSize(); i++) {
            Product product = (Product) productsBinaryTree.recorreArbol().get(i);
            if (name.equalsIgnoreCase(product.getName())) {
                return true;
            }
        }
        return false;
    }
    
    /**
     * Mediante un nombre y el método existsProducto, habilita la modificación del producto.
     * @param name
     * @param newName
     * @param newUnitMeasured
     * @param newUnitValue
     * @param newTotalWeight
     * @param newDescription
     * @param newIdCategory
     * @param newPrice
     * @param newUrl
     * @param newIdBatch
     * @throws TreeException 
     */

    public void updateProduct(String name, String newName,String newUnitMeasured, int newUnitValue, int newTotalWeight, String newDescription, int newIdCategory, double newPrice, String newUrl, int newIdBatch) throws TreeException {
        if(existsProduct(name)) {
            Product oldName = getProduct(name);
            Product oldUnitMeasured = getProduct(name);
            Product oldUnitValue = getProduct(name);
            Product oldTotalWeight = getProduct(name);
            Product oldDescription = getProduct(name);
            Product oldIdCategory = getProduct(name);
            Product oldPrice = getProduct(name);
            Product oldUrl = getProduct(name);
            Product oldBatch = getProduct(name);
            
            oldName.setName(newName);
            oldUnitMeasured.setUnitMeasured(newUnitMeasured);
            oldUnitValue.setUnitValue(newUnitValue);
            oldTotalWeight.setTotalWeight(newTotalWeight);
            oldDescription.setDescription(newDescription);
            oldIdCategory.setIdCategory(newIdCategory);
            oldPrice.setPrice(newPrice);
            oldUrl.setUrl(newUrl);
            oldBatch.setIdBatch(newIdBatch);
        }
    }
    
    /**
     * Permite añadir una nueva categoría y respectiva descripción a un categoryMap.
     * @param name
     * @param description 
     */

    public void addCategory(String name, String description) {
        Category category = new Category(idCategory(), name, description);
        categoryMap.put(name, category);
    }
    
    /**
     * Recorre el categoryMap y al último elemento le suma un número.
     * @return 
     */

    private int idCategory() {
        Iterator iterator = categoryMap.keySet().iterator();
        while (iterator.hasNext()) {
            String key = (String) iterator.next();
            Category category = categoryMap.get(key);
            if(category.getIdCategory() == categoryMap.size()-1) {
                return category.getIdCategory()+1;
            }
        }
        return -1;
    }
    
    /**
     * Mediante un nombre, itera el categoryMap y si el nombre existe en el categoryMap, permite eliminarlo.
     * @param name 
     */
    
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
    }
    
    /**
     * Itera el categoryMap y retorna la categoría ingresada como parámetro.
     * @param name
     * @return 
     */
    
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
    
    /**
     * Verifica la existencia de una categoría mediante la iteración del category map y retorna un true en caso de encontrarlo.
     * @param name
     * @return 
     */
    
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
    
    /**
     * Verifica la existencia de una categoría y habilita la edición de la misma.
     * @param name
     * @param newName
     * @param newDescription 
     */

    public void updateCategory(String name, String newName, String newDescription) {
        if(existsCategory(name)) {
            Category oldName = getCategory(name);
            Category oldDescription = getCategory(name);
            
            oldName.setName(newName);
            oldDescription.setDescription(newDescription);
        }
    }

    /**
     * Agrega un nuevo lote al batchMap.
     * @param batchCode
     * @param packedDate
     * @param expirationDate 
     */
    public void addBacth(String batchCode, String packedDate, String expirationDate) {
        Batch batch = new Batch(idBatch(), batchCode, packedDate, expirationDate);
        batchMap.put(idBatch(), batch);
    }
    
    /**
     * Verifica el id del último lote y le agrega un 1 para ir aumentando a los nuevos lotes.
     * @return 
     */
    
    private int idBatch() {
        Batch batch = batchMap.get(batchMap.size()-1);
        return batch.getIdBatch()+1;
    }

    
    /**
     * Permite la eliminación de un lote mediante la iteración del batchMap y verificando la existencia del lote que entra como parámetro.
     * @param batchCode 
     */
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
    }
    
    /**
     * Itera el bathMap para encontrar un lote que entra como parámetro y si existe lo retorna.
     * @param batchCode
     * @return 
     */
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
    
    /**
     * Verifica la existencia de un lote, mediante la iteración de batchMap.
     * @param batchCode
     * @return 
     */
    
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

    /**
     * Permite la actualización de un lote.
     * @param batchCode
     * @param newBatchCode
     * @param newExpirationDate 
     */
    
    public void updateBatch(String batchCode, String newBatchCode, String newExpirationDate) {
        if(existsBatch(batchCode)) {
            Batch oldBatchCode = getBatch(batchCode);
            Batch oldExpirationDate = getBatch(batchCode);
            
            oldBatchCode.setBatchCode(newBatchCode);
            oldExpirationDate.setExpirationDate(newExpirationDate);
        }
    }
    
    /**
     * Ingresa una nueva unidad de transporte a su mapa correspondiente.
     * @param plate
     * @param minCapacity
     * @param maxCapacity
     * @param url 
     */

    public void addTransportUnit(String plate, int minCapacity, int maxCapacity, String url) {
        TransportUnit transportUnit = new TransportUnit(idTransport(), plate, minCapacity, maxCapacity, url);
        transportUnitMap.put(idTransport(), transportUnit);
    }
    
    /**
     *Verifica el id de la última unidad de transporte  y le agrega un 1 para ir aumentando a las nuevas unidades.
     * @return 
     */
    
    private int idTransport() {
        TransportUnit transportUnit = transportUnitMap.get(transportUnitMap.size()-1);
        return transportUnit.getIdTransportUnit()+1;
    }
    
    /**
     * Permite eliminar una unidad de transporte, mediante la iteración del mapa de transportes y verificando la existencia de la misma.
     * @param plate 
     */

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
    }
    /**
     * Itera el mapa y si encuentra la placa correspondiente retorna la unidad de transporte.
     * @param plate
     * @return 
     */
    
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
    
    /**
     * Verifica la existencia de una unidad de transporte y retorna true si es así.
     * @param plate
     * @return 
     */
    
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
    
    /**
     * Permite actualizar una unidad de transporte específica.
     * @param plate
     * @param newPlate
     * @param newMinCapacity
     * @param newMaxCapacity
     * @param newUrl 
     */

    public void updateTransportUnit(String plate, String newPlate, int newMinCapacity, int newMaxCapacity, String newUrl) {
        if(existsTransportUnit(plate)) {
            TransportUnit oldPlate  = getTransportUnit(plate);
            TransportUnit oldMinCapacity = getTransportUnit(plate);
            TransportUnit oldMaxCapacity = getTransportUnit(plate);
            TransportUnit oldUrl = getTransportUnit(plate);
            
            oldPlate.setPlate(newPlate);
            oldMinCapacity.setMinCapacity(newMinCapacity);
            oldMaxCapacity.setMaxCapacity(newMaxCapacity);
            oldUrl.setUrl(newUrl);
        }
    }
    
    /**
     * Permite añadir una nueva bodega.
     * @param name
     * @param latitude
     * @param length
     * @param distance
     * @param url
     * @throws GraphException 
     */
    
    public void addCellar(String name, String latitude, String length, float distance, String url) throws GraphException {
        Cellar cellar = new Cellar(idCellar(), name, latitude, length, distance, url);
        cellarGraph.insertVertx(cellar);
    }
    
    /**
     * Verifica el id de la última bodega y le agrega un 1 para ir aumentando a las nuevas bodegas.
     * @return
     * @throws GraphException 
     */
    
    private int idCellar() throws GraphException {
        Cellar cellar = (Cellar) cellarGraph.list().get(cellarGraph.list().size()-1);
        return cellar.getIdCellar()+1;
    }
    
    /**
     * Recorre el grafo de bodegas y elimina una en específico.
     * @param name
     * @throws GraphException 
     */

    public void deleteCellar(String name) throws GraphException {
        for (int i = 0; i < cellarGraph.list().size(); i++) {
            Cellar cellar = (Cellar) cellarGraph.list().get(i);
            if(cellar.getName().equals(name)) {
                cellarGraph.deleteVertex(cellar);
            }
        }
    }
    
    /**
     * Retorna una bodega en específico, recorriendo el grafo de bodegas.
     * @param name
     * @return
     * @throws GraphException 
     */
    
    public Cellar getCellar(String name) throws GraphException {
        for (int i = 0; i < cellarGraph.getSize(); i++) {
            Cellar cellar = (Cellar) cellarGraph.list().get(i);
            if(cellar.getName().equals(name)) {
                return cellar;
            }
        }
        return null;
    }
    
    /**
     * Retorna true si existe una bodega en el grafo.
     * @param name
     * @return
     * @throws GraphException 
     */
    
    public Boolean existsCellar(String name) throws GraphException {
        for (int i = 0; i < cellarGraph.getSize(); i++) {
            Cellar cellar = (Cellar) cellarGraph.list().get(i);
            if(cellar.getName().equals(name)) {
                return true;
            }
        }
        return false;
    }
    
    /**
     * Permite actualizar una bodega en específico.
     * @param name
     * @param newName
     * @param newLatitude
     * @param newLength
     * @param newDistance
     * @param url
     * @throws GraphException 
     */

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
        }
    }
    
    /**
     * Permite añadir un nuevo usuario a una lista.
     * @param name
     * @param role
     * @param NameUser
     * @param password 
     */

    public void addUser(String name, String role, String NameUser, String password) {
        String verifyMD5 = DigestUtils.md5Hex(password);
        User user = new User(idUser(), name, role, NameUser, verifyMD5);
        userList.add(user);
    }
    
    /**
     * Verifica el id del último usuario y le agrega un 1 para ir aumentando a los nuevos usuarios. 
     * @return 
     */
    
    private int idUser(){
        User user = userList.get(userList.size()-1);
        return user.getIdUser()+1;
    }
    
    /**
     * Recorre una lista de usuarios y si lo encuentra permite eliminar uno en específico. 
     * @param userName 
     */

    public void deleteUser(String userName) {
        for (int i = 0; i < userList.size(); i++) {
            User user =userList.get(i);
            if(user.getUser().equals(userName)) {
                userList.remove(user);
            }
        }
    }
    
    /**
     * Recorre la lista de usuarios y retorna el usuario en específico.
     * @param userName
     * @return 
     */
    
    public User getUser(String userName) {
        for (int i = 0; i < userList.size(); i++) {
            User user = userList.get(i);
            if (user.getUser().equals(userName)) {
                return user;
            }
        }
        return null;
    }
    
    /**
     * Verifica la existencia de un usuario en específico y retorna true si existe.
     * @param userName
     * @return 
     */
    
    public Boolean existsUser(String userName) {
        for (int i = 0; i < userList.size(); i++) {
            User user = userList.get(i);
            if (user.getUser().equals(userName)) {
                return true;
            }
        }
        return false;
    }
    
    /**
     * Permite actualizar un usuario en específico y su contraseña se convierte a MD5.
     * @param userName
     * @param newName
     * @param newRole
     * @param newUserName
     * @param newPassword 
     */

    public void updateUser(String userName, String newName, String newRole, String newUserName, String newPassword) {
        String verifyMD5 = DigestUtils.md5Hex(newPassword);
        if (existsUser(userName)) {
            User oldName = getUser(userName);
            User oldRole = getUser(userName);
            User oldUserName = getUser(userName);
            User oldPassword = getUser(userName);
            
            oldName.setName(newName);
            oldRole.setRole(newRole);
            oldUserName.setUser(newUserName);
            oldPassword.setPassword(verifyMD5);
        }
    }
}
