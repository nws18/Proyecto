
package domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedList;

/**
 *
 * @author Nicole Fonseca, Wilmer Mata, Sergio Siles
 */
public class DistributionOrder  implements java.io.Serializable{
    
    private int idDistributionOrder;
    private int idOriginCellar;
    private int idDestinyCellar;
    private double totalAmount;
    private float weightTotal;
    private ArrayList<Product> productList;
    private int idOperator;
    private String orderDate;

    @Override
    public String toString() {
        return "DistributionOrder{" + "idDistributionOrder=" + idDistributionOrder + ", idOriginCellar=" + idOriginCellar + ", idDestinyCellar=" + idDestinyCellar + ", totalAmount=" + totalAmount + ", weightTotal=" + weightTotal + ", productList=" + productList + ", idOperator=" + idOperator + ", orderDate=" + orderDate + '}';
    }

    public int getIdDistributionOrder() {
        return idDistributionOrder;
    }

    public void setIdDistributionOrder(int idDistributionOrder) {
        this.idDistributionOrder = idDistributionOrder;
    }

    public int getIdOriginCellar() {
        return idOriginCellar;
    }

    public void setIdOriginCellar(int idOriginCellar) {
        this.idOriginCellar = idOriginCellar;
    }

    public int getIdDestinyCellar() {
        return idDestinyCellar;
    }

    public void setIdDestinyCellar(int idDestinyCellar) {
        this.idDestinyCellar = idDestinyCellar;
    }

    public double getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(double totalAmount) {
        this.totalAmount = totalAmount;
    }

    public float getWeightTotal() {
        return weightTotal;
    }

    public void setWeightTotal(float weightTotal) {
        this.weightTotal = weightTotal;
    }

    public ArrayList<Product> getProductList() {
        return productList;
    }

    public void setProductList(ArrayList<Product> productList) {
        this.productList = productList;
    }

    public int getIdOperator() {
        return idOperator;
    }

    public void setIdOperator(int idOperator) {
        this.idOperator = idOperator;
    }

    public String getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(String orderDate) {
        this.orderDate = orderDate;
    }

    public DistributionOrder(int idDistributionOrder, int idOriginCellar, int idDestinyCellar, double totalAmount, float weightTotal, ArrayList<Product> productList, int idOperator, String orderDate) {
        this.idDistributionOrder = idDistributionOrder;
        this.idOriginCellar = idOriginCellar;
        this.idDestinyCellar = idDestinyCellar;
        this.totalAmount = totalAmount;
        this.weightTotal = weightTotal;
        this.productList = productList;
        this.idOperator = idOperator;
        this.orderDate = orderDate;
    }

    public DistributionOrder() {
    }

}