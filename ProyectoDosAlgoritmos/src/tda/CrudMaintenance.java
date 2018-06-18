package tda;

import domain.Category;
import domain.Product;
import domain.User;
import java.util.Iterator;
import static tda.LoadTda.categoryMap;
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

    public void addProduct() {
    }

    public void deleteProduct() {
    }

//    public Product getProduct(String name) {
////        for (int i = 0; i <= productList.size() - 1; i++) {
////            Administrator administrator = (Administrator) administratorList.get(i);
////            if (administrator.getMail().equalsIgnoreCase(mail)) {
////                return administrator;
////            }
////        }
////        return null;
//    }

    public Boolean existsProduct(String name) {
//        for (int i = 0; i <= agentList.size() - 1; i++) {
//            Agent agent = (Agent) agentList.get(i);
//            String user = agent.getMail();
//            if (mail.equalsIgnoreCase(user)) {
//                return true;
//            }
//        }
        return false;
    }

    public void updateProduct() {
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
        
        while (iterator.hasNext()) {
            String key = (String) iterator.next();
            if (name.equals(categoryMap.get(key))) {
               Category nameCategory = categoryMap.get(key);
               categoryMap.remove(nameCategory);
            }
        }
        System.out.println(categoryMap.toString());
    }

    public void updateCategory() {
    }

    public void addBacth() {
    }

    public void deleteBacth() {
    }

    public void updateBacth() {
    }

    public void addTransportUnit() {
    }

    public void deleteTransportUnit() {
    }

    public void updateTransportUnit() {
    }

    public void addUser() {
    }

    public void deleteUser() {
    }

    public void updateUser() {
    }

    public void addCellar() {
    }

    public void deleteCellar() {
    }

    public void updateCellar() {
    }

}
