
package LinkedBinaryTree;

/**
 *
 * @author Nicole Fonseca
 */
public class BinaryNode {
    
    public Object element;
    public BinaryNode left, right;
    public int counter;

    public BinaryNode(Object element) {
        this.element = element;
        this.left = this.right = null;
        this.counter++;
    }
    
    
    
}
