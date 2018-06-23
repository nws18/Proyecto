
package LinkedBinaryTree;

import LinkedBinaryTree.TreeException;
import domain.Product;
import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author Nicole Fonseca
 * Clase para el manejo de objetos mediante Árboles binarios enlazados
 */
public class LinkedBinaryTree implements BinaryTreeInterface{
    
    private BinaryNode root;
    private ArrayList<Product> arrayList = new ArrayList<>();
    
    public LinkedBinaryTree() {
        this.root = null;
    }

    @Override
    public void cancel() throws TreeException {
        this.root = null;
    }

    @Override
    public boolean isEmpty() {
        return this.root == null;
    }

    @Override
    public boolean exists(Object element) throws TreeException {
        if(isEmpty()) {
            throw new TreeException("El árbol está vacío");
        } else {
            return exists(this.root, element);
        }
    }
    
    private boolean exists(BinaryNode root, Object element) {
        if(root == null)
            return false;
        else if(root.element.equals(element)) {
            return true;
        } else {
            return exists(root.left, element) || exists(root.right, element);
        }
            
    }

    @Override
    public void insert(Object element) throws TreeException {
        this.root = insert(this.root, element);
    }
    
    private BinaryNode insert(BinaryNode node, Object element) {
        if(node ==null){
            node= new BinaryNode(element);
        }else{
            if(node.left ==null)
                node.left=insert(node.left, element);
            else{
                if(node.right ==null)
                    node.right=insert(node.right, element);
                else{
                    
                    Random seed = new Random();
                    int randomValue = seed.nextInt(2);
                    if(randomValue == 1){
                        node.left=insert(node.left, element);
                    }else{
                        node.right=insert(node.right, element);
                    }
                    
                }
            }
        }
        return node;
    }

    @Override
    public void delete(Object element) throws TreeException {
        if(isEmpty()) 
            throw new TreeException("El árbol no existe");
        this.root = delete(this.root, element);
    }
    
    private BinaryNode delete(BinaryNode node, Object element) {
        if(node != null) {
            if(node.element.equals(element)) {
                if(node.left == null && node.right == null)
                    return node = null;
                else {
                    if(node.left != null && node.right == null) {
                        return node = node.left;
                    } else if(node.left == null && node.right != null) {
                        return node = node.right;
                    } else { //Cuando se tienen hijos a ambos lados es necesario seleccionar reacomodar
                        if(node.left != null && node.right != null) {
                            Object tempElement = minimum(node.right);
                            node.element = tempElement;
                            node.right = delete(node.right, tempElement);
                        }
                    }
                }
            }
            node.left = delete(node.left, element);
            node.right = delete(node.right, element);
        }
        return node;
    }
    
    private Object minimum(BinaryNode node) {

        //Cuando no tiene ningún hijo-------------------
        if (node.left != null && node.right != null) {
            if (getType(node) == 1) { //Cuando los valores a comparar son numéricos
                return Math.min(Integer.parseInt(node.element.toString()),
                        Math.min(Integer.parseInt(minimum(node.left).toString()),
                                Integer.parseInt(minimum(node.right).toString())));
            } else if (getType(node) == 2) {
                return minString(node.element.toString(),
                        minString(minimum(node.left).toString(), minimum(node.right).toString()));
            }

        }//---------------------------------------------

        //Cuando hay un hijo izquierdo-------------------
        if (node.left != null && node.right == null) {
            if (getType(node) == 1) {
                return Math.min(Integer.parseInt(node.element.toString()),
                        Integer.parseInt(minimum(node.left).toString()));

            } else if (getType(node.element) == 2) {
                return minString(node.element.toString(), minimum(node.left).toString());
            }
        }//---------------------------------------------

        //Cuando hay un hijo izquierdo-------------------
        if (node.left == null && node.right != null) {
            if (getType(node) == 1) {
                return Math.min(Integer.parseInt(node.element.toString()),
                        Integer.parseInt(minimum(node.right).toString()));
            } else if (getType(node.element) == 2) {
                return minString(node.element.toString(), minimum(node.right).toString());
            }
        }//---------------------------------------------
        return node.element; //No alcanzó ninguna de las condiciones

    }
    
    private int getType(Object element) {
        if(element instanceof Integer)
            return 1;
        if(element instanceof String)
            return 2;
        
        return -1;
    }
    
    private String minString(String elem1, String elem2) {
        if(elem1.compareTo(elem2) < 0)
            return  elem1;
        else
            return elem2;
    }

    @Override
    public int height() throws TreeException {
        if(isEmpty()) 
            throw  new TreeException("El árbol no existe");
        return height(this.root);
    }
    
    private int height(BinaryNode node) {
        if(node == null)
            return 0;
        else
            return Math.max(height(node.left), height(node.right) + 1);
        
    }

    @Override
    public int nodeHeight(Object element) throws TreeException {
        if(isEmpty())
            throw  new TreeException("El árbol no existe");
        else
            return nodeHeight(this.root, element, 0);
    }
    
    private int nodeHeight(BinaryNode node, Object element, int counter) {
        if(node == null)
            return 0;
        else {
            if(node.element.equals(element)) {
                return counter;
            } else {
                return Math.max(nodeHeight(node.left, element, ++counter), nodeHeight(node.right, element, counter));
            }
        }
    }

    @Override
    public int getSize() throws TreeException{
        if(isEmpty()) {
            throw new TreeException("El árbol está vacío");
        } else {
            return getSize(root);
        }
    }
    
    private int getSize(BinaryNode node) {
        if (node == null) {
            return  0;
        } else 
            return getSize(node.left) + 1 + getSize(node.right);
    }

    @Override
    public String toString() {
       String output = " recorridos disponibles";
        
        output += "\npreorden:\n"+preOrder(this.root);
        output += "\ninorden:\n"+order(this.root);
        output += "\npostorden:\n"+postOrder(this.root);
        
        return output;
    }
    
    private String preOrder(BinaryNode node) {
        String temp = "";
        if(node!= null) {
            temp += node.element+"\n";
            temp += preOrder(node.left);
            temp += preOrder(node.right); 
        }
         return temp;
    }
    
    private String order(BinaryNode node) {
        String temp = "";
        if(node!= null) {
            temp += order(node.left);
            temp += node.element+"\n";
            temp += order(node.right); 
        }
         return temp;
    }
    
    private String postOrder(BinaryNode node) {
        String temp = "";
        if(node!= null) {
            temp += postOrder(node.left);
            temp += postOrder(node.right);
            temp += node.element; 
        }
         return temp;
    }
    
    private ArrayList getTree(BinaryNode node) { 
        ArrayList arrayList = new ArrayList<>();

        if (node != null) {

            arrayList.add(node.element);
            arrayList.add(getTree(node.left));
            arrayList.add(getTree(node.right));
        }
        return arrayList;
    }
    
    public ArrayList recorreArbol(){ 
        recorreArbol(root,arrayList);
        return arrayList;
    }        
    private void recorreArbol(BinaryNode node,ArrayList arrayList) {
       

        if(node!= null) {
           
           arrayList.add(node.element);
           recorreArbol(node.left,arrayList);
           recorreArbol(node.right,arrayList);
           
           
            
            
        }
    }
}
