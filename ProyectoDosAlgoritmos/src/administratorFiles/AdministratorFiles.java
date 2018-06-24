
package administratorFiles;

import domain.Batch;
import domain.Category;
import domain.Cellar;
import domain.DistributionOrder;
import domain.Product;
import domain.TransportUnit;
import domain.User;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

/**
 * Clase para leer la información de los archivos y escribir en ellos.
 * @author Nicole Fonseca, Wilmer Mata, Sergio Siles
 */
public class AdministratorFiles implements java.io.Serializable{
    
    /**
     * Escribe en el archivo los objetos de tipo Batch.
     * @param arrayList
     * @throws FileNotFoundException
     * @throws IOException 
     */
    public void writeBatchFile(ArrayList<Batch> arrayList) throws FileNotFoundException, IOException{ 
      ObjectOutputStream salida=new ObjectOutputStream(new FileOutputStream("Batch.txt"));
      salida.writeObject(arrayList);
      salida.close();
    }
    
    /**
     * Lee del archivo los objetos de tipo Batch.
     * @return ArrayList
     * @throws FileNotFoundException
     * @throws IOException
     * @throws ClassNotFoundException 
     */
    public ArrayList<Batch> readBatchFile() throws FileNotFoundException, IOException, ClassNotFoundException{
      ObjectInputStream entrada=new ObjectInputStream(new FileInputStream("Batch.txt"));
      ArrayList<Batch> arrayList = (ArrayList<Batch>)entrada.readObject();
      return arrayList;
    }
    
    /**
     * Escribe en el archivo los objetos de tipo Category.
     * @param arrayList
     * @throws FileNotFoundException
     * @throws IOException 
     */
    public void writeCategoryFile(ArrayList<Category> arrayList) throws FileNotFoundException, IOException{
      ObjectOutputStream salida=new ObjectOutputStream(new FileOutputStream("Category.txt"));
      salida.writeObject(arrayList);
      salida.close();
    }
    
    /**
     * Lee del archivo los objetos de tipo Category.
     * @return ArrayList
     * @throws FileNotFoundException
     * @throws IOException
     * @throws ClassNotFoundException 
     */
    public ArrayList<Category> readCategoryFile() throws FileNotFoundException, IOException, ClassNotFoundException{
      ObjectInputStream entrada=new ObjectInputStream(new FileInputStream("Category.txt"));
      ArrayList<Category> arrayList = (ArrayList<Category>)entrada.readObject();
      return arrayList;
    }
    
    /**
     * Escribe en el archivo los objetos de tipo Cellar.
     * @param arrayList
     * @throws FileNotFoundException
     * @throws IOException 
     */
    public void writeCellarFile(ArrayList<Cellar> arrayList) throws FileNotFoundException, IOException{   
      ObjectOutputStream salida=new ObjectOutputStream(new FileOutputStream("Cellar.txt"));
      salida.writeObject(arrayList);
      salida.close();
    }
    
    /**
     * Lee del archivo los objetos de tipo Cellar.
     * @return ArrayList
     * @throws FileNotFoundException
     * @throws IOException
     * @throws ClassNotFoundException 
     */
    public ArrayList<Cellar> readCellarFile() throws FileNotFoundException, IOException, ClassNotFoundException{   
      ObjectInputStream entrada=new ObjectInputStream(new FileInputStream("Cellar.txt"));
      ArrayList<Cellar> arrayList = (ArrayList<Cellar>)entrada.readObject();
      return arrayList;
    }
    
    /**
     * Escribe en el archivo los objetos de tipo DistributionOrder.
     * @param arrayList
     * @throws FileNotFoundException
     * @throws IOException 
     */
    public void writeDistributionOrderFile(ArrayList<DistributionOrder> arrayList) throws FileNotFoundException, IOException{
      ObjectOutputStream salida=new ObjectOutputStream(new FileOutputStream("DistributionOrder.txt"));
      salida.writeObject(arrayList);
      salida.close();
    }
    
    /**
     * Lee del archivo los objetos de tipo DistributionOrder.
     * @return ArrayList
     * @throws FileNotFoundException
     * @throws IOException
     * @throws ClassNotFoundException 
     */
    public ArrayList<DistributionOrder> readFile() throws FileNotFoundException, IOException, ClassNotFoundException{
      ObjectInputStream entrada=new ObjectInputStream(new FileInputStream("DistributionOrder.txt"));
      ArrayList<DistributionOrder> arrayList = (ArrayList<DistributionOrder>)entrada.readObject();
      return arrayList;
    }
    
    /**
     * Escribe en el archivo los objetos de tipo Product.
     * @param arrayList
     * @throws FileNotFoundException
     * @throws IOException 
     */
    public void writeProductFile(ArrayList<Product> arrayList) throws FileNotFoundException, IOException{   
      ObjectOutputStream salida=new ObjectOutputStream(new FileOutputStream("Product.txt"));
      salida.writeObject(arrayList);
      salida.close();
    }
    
    /**
     * Lee del archivo los objetos de tipo Product.
     * @return ArrayList
     * @throws FileNotFoundException
     * @throws IOException
     * @throws ClassNotFoundException 
     */
    public ArrayList<Product> readProductFile() throws FileNotFoundException, IOException, ClassNotFoundException{ 
      ObjectInputStream entrada=new ObjectInputStream(new FileInputStream("Product.txt"));
      ArrayList<Product> arrayList = (ArrayList<Product>)entrada.readObject();
      return arrayList;
    }
    
    /**
     * Escribe en el archivo los objetos de tipo TransportUnit.
     * @param arrayList
     * @throws FileNotFoundException
     * @throws IOException 
     */
    public void writeTransportUnitFile(ArrayList<TransportUnit> arrayList) throws FileNotFoundException, IOException{
  
      ObjectOutputStream salida=new ObjectOutputStream(new FileOutputStream("TransportUnit.txt"));
      salida.writeObject(arrayList);
      salida.close();
    }
    
    /**
     * Lee del archivo los objetos de tipo TransportUnit.
     * @return ArrayList
     * @throws FileNotFoundException
     * @throws IOException
     * @throws ClassNotFoundException 
     */
    public ArrayList<TransportUnit> readTransportUnitFile() throws FileNotFoundException, IOException, ClassNotFoundException{  
      ObjectInputStream entrada=new ObjectInputStream(new FileInputStream("TransportUnit.txt"));
      ArrayList<TransportUnit> arrayList = (ArrayList<TransportUnit>)entrada.readObject();
      return arrayList;
    }
    
    /**
     * Escribe en el archivo los objetos de tipo User.
     * @param arrayList
     * @throws FileNotFoundException
     * @throws IOException 
     */
    public void writeUserFile(ArrayList<User> arrayList) throws FileNotFoundException, IOException{  
      ObjectOutputStream salida=new ObjectOutputStream(new FileOutputStream("User.txt"));
      salida.writeObject(arrayList);
      salida.close();
    }
    
    /**
     * Lee del archivo los objetos de tipo User.
     * @return ArrayList
     * @throws FileNotFoundException
     * @throws IOException
     * @throws ClassNotFoundException 
     */
    public ArrayList<User> readUserFile() throws FileNotFoundException, IOException, ClassNotFoundException{    
      ObjectInputStream entrada=new ObjectInputStream(new FileInputStream("User.txt"));
      ArrayList<User> arrayList = (ArrayList<User>)entrada.readObject();
      return arrayList;
    }
}
