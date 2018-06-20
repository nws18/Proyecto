
package proyectodosalgoritmos;

import Exception.TreeException;
import gui.Login;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import lab_grafos_algoritmos.GraphException;
import tda.CrudMaintenance;
import tda.LoadTda;

/**
 *
 * @author Nicole Fonseca, Wilmer Mata, Sergio Siles
 */
public class ProyectoDosAlgoritmos {

    /**
     * Ventana principal login.
     * @param args the command line arguments
     */
    public static void main(String[] args) throws GraphException{
        LoadTda loadTda = new LoadTda();
        
        try {
            loadTda.tdaProduct();
            loadTda.tdaCategory();
            loadTda.tdaBatch();
            loadTda.tdaTransportUnit();
            loadTda.tdaCellar();
            loadTda.tdaDistributionOrder();
            loadTda.tdaUser();
        } catch (IOException | ClassNotFoundException | GraphException | TreeException ex) {
            Logger.getLogger(ProyectoDosAlgoritmos.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        CrudMaintenance crudMaintenance = new CrudMaintenance();
        
        Login login = new Login();
        login.setVisible(true);
    }

    
}
