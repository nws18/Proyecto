
package LinkedBinaryTree;

import LinkedBinaryTree.TreeException;

/**
 *
 * @author Nicole Fonseca
 */
public interface BinaryTreeInterface {
    
    public void cancel() throws TreeException;
    public boolean isEmpty();
    public boolean exists(Object element) throws TreeException;
    public void insert(Object element) throws TreeException;
    public void delete(Object element) throws TreeException;
    public int height() throws TreeException;
    public int nodeHeight(Object element) throws TreeException;
    public int getSize() throws TreeException;
}
