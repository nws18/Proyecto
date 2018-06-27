
package lab_grafos_algoritmos;

import java.util.ArrayList;

/**
 *
 * @author Equipo
 */
public class AdjacencyMatrixGraph implements Graph {
    
    private Object adjacencyMatrix[][]; //matriz de adyacencia
    private int counter; //cantidad de elementos
    private int num; //tamaño de dimensión de la matriz
    private Vertice vertexList[];

    public AdjacencyMatrixGraph(int num) {
        if (num < 0) {
            System.out.println("Ingrese un tamaño válido");
            System.exit(0);
        }
        this.num = num;
        this.adjacencyMatrix = new Object[num][num];
        this.counter = 0;
        this.vertexList = new Vertice[this.num];
        initializeMatrix();
    }
    
    private void initializeMatrix() {
        for (int i = 0; i < this.num; i++) {
            for (int j = 0; j < this.num; j++) {
                this.adjacencyMatrix[i][j] = 0;
            }
            
        }
    }
    
    @Override
    public void cancel() {
        for (int i = 0; i < this.vertexList.length; i++) {
            this.vertexList[i] = null;
        }
        this.counter = 0;
        this.initializeMatrix();
    }

    @Override
    public int getSize() throws GraphException{
        if (isEmpty()) {
            throw new GraphException("El grafo está vacío");
            
        }
        return this.counter;
    }

    @Override
    public boolean existVertex(Object element) throws GraphException{
        if(isEmpty()) {
            throw new GraphException("El grafo está vacío");
        }
        
        for (int i = 0; i < this.counter; i++) {
            if(vertexList[i].element.equals(element)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean existEdge(Object v1, Object v2) throws GraphException{
        if(!existVertex(v1) ||  !existVertex(v2)) 
            throw new GraphException("Alguno o ningno de los vertices existe");
        if(!adjacencyMatrix[getPosition(v1)][getPosition(v2)].equals(0)) {
            return true;
        }
        
        return false;
    }
    
    private int getPosition(Object vertex) {
        for (int i = 0; i < counter; i++) {
            if(vertexList[i].element.equals(vertex))
                return i;
        }
        return -1;
    }

    @Override
    public void insertVertx(Object element) throws GraphException {
        if(this.counter >= this.vertexList.length) {
            throw new GraphException("El grafo está lleno");
        }
        this.vertexList[counter++] = new Vertice(element);
    }

    @Override
    public void insertEdge(Object v1, Object v2) throws GraphException {
        if(!existVertex(v1) || !existVertex(v2))
            throw new GraphException("Alguno o ninguno de los vértices existe");
        this.adjacencyMatrix[getPosition(v1)][getPosition(v2)] = 1;
        this.adjacencyMatrix[getPosition(v2)][getPosition(v1)] = 1;
    }

    @Override
    public void insertWeight(Object v1, Object v2, int weight) throws GraphException {
        if(!existEdge(v1, v2))
            throw new GraphException("Alguno o ninguno de los vértices no existe");
        this.adjacencyMatrix[getPosition(v1)][getPosition(v2)] = weight;
        this.adjacencyMatrix[getPosition(v2)][getPosition(v1)] = weight;
    }
    
    public int getWeigth(Object v1,Object v2 ) throws GraphException{
        if(!existEdge(v1, v2))
            throw new GraphException("Alguno o ninguno de los vértices no existe");
        return (int) adjacencyMatrix[getPosition(v1)][getPosition(v2)]; 
        
    }

    @Override
    public boolean isEmpty() throws GraphException{
        return this.counter == 0;
    } 

    @Override
    public String toString() {
        String  output = "GRAFO CON MATRICES DE ADYACENCIA\n";
        
        for (int i = 0; i < this.counter; i++) {
            output += "Vértice en posición " + i + " es: " + this.vertexList[i].element + "\n";
            
        }
        output += "LISTA DE ARISTAS\n";
        for (int i = 0; i < this.num; i++) {
            for (int j = 0; j < this.num; j++) {
                if(!this.adjacencyMatrix[i][j].equals(0))
                output += this.vertexList[i].element + "--------" + this.vertexList[j].element + "\n";
                
            }
        }
        return output;
    }
    
    public ArrayList list() {
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < this.counter; i++) {
            arrayList.add(this.vertexList[i].element);
        }
        return arrayList;
    }
    
    

    @Override
    public void deleteVertex(Object element) throws GraphException {
        if(existVertex(element)) {
            for (int i = 0; i < this.counter; i++) {
                if(this.vertexList[i].element.equals(element)) {
                    //eliminamos aristas disponibles
                    for (int j = 0; j < this.counter; j++) {
                        if(existEdge(element, this.vertexList[j].element)) {
                            deleteEdge(element, this.vertexList[j].element);
                        }
                    }
                    //eliminamos vértice 
                    //Mueve una posición a la izquierda todo el contenido que está
                    //a la derecha del vértice a eliminar
                    for (int j = i; j < this.counter -1; j++) {
                        this.vertexList[j] = this.vertexList[j+1];
                    }
                    this.counter--;
                }
            }
        }
    }

    @Override
    public void deleteEdge(Object v1, Object v2) throws GraphException {
        if(!existVertex(v1) || !existVertex(v2)) {
            throw new GraphException("Alguno o ninguno de los vértices existe");
        }
        this.adjacencyMatrix[getPosition(v1)][getPosition(v2)] = 0;
        this.adjacencyMatrix[getPosition(v2)][getPosition(v1)] = 0;
    }
    
    
    
}
