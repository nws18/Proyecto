/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

/**
 *
 * @author Wilmer Mata Sergio Siles Nicole Fonseca
 */
public class TableProduct {
    
    private int quantity;
    private String product;
    private int amount;
    private int weight;
    private String category;

    @Override
    public String toString() {
        return "TableProduct{" + "quantity=" + quantity + ", product=" + product + ", amount=" + amount + ", weight=" + weight + ", category=" + category + '}';
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getProduct() {
        return product;
    }

    public void setProduct(String product) {
        this.product = product;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public TableProduct(int quantity, String product, int amount, int weight, String category) {
        this.quantity = quantity;
        this.product = product;
        this.amount = amount;
        this.weight = weight;
        this.category = category;
    }

    public TableProduct() {
    }
    
}
