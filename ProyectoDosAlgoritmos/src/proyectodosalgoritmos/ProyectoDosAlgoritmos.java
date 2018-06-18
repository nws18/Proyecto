
package proyectodosalgoritmos;

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
    public static void main(String[] args) {
        LoadTda loadTda = new LoadTda();
        
        try {
            loadTda.tdaCategory();
            loadTda.tdaBatch();
            loadTda.tdaTransportUnit();
            loadTda.tdaCellar();
            loadTda.tdaDistributionOrder();
            loadTda.tdaUser();
        } catch (IOException ex) {
            Logger.getLogger(ProyectoDosAlgoritmos.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ProyectoDosAlgoritmos.class.getName()).log(Level.SEVERE, null, ex);
        } catch (GraphException ex) {
            Logger.getLogger(ProyectoDosAlgoritmos.class.getName()).log(Level.SEVERE, null, ex);
        }

        Login login = new Login();
        login.setVisible(true);
CrudMaintenance crudMaintenance = new CrudMaintenance();
crudMaintenance.deleteCategory("Refrescos");
    }

    
}
