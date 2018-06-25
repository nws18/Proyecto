
package domain;

/**
 *
 * @author Nicole Fonseca, Wilmer Mata, Sergio Siles
 */
public class Product  implements java.io.Serializable{
    
    private int idProduct;
    private String name;
    private String unitMeasured;
    private int unitValue;
    private int totalWeight;
    private String description;
    private int idBatch;
    private int idCategory;
    private double price;
    private String url;

    public Product() {
    }

    public Product(int idProduct, String name, String unitMeasured, int unitValue, int totalWeight, String description, int idLot, int idCategory, double price, String url) {
        this.idProduct = idProduct;
        this.name = name;
        this.unitMeasured = unitMeasured;
        this.unitValue = unitValue;
        this.totalWeight = totalWeight;
        this.description = description;
        this.idBatch = idLot;
        this.idCategory = idCategory;
        this.price = price;
        this.url = url;
    }

    /**
     * @return the idProduct
     */
    public int getIdProduct() {
        return idProduct;
    }

    /**
     * @param idProduct the idProduct to set
     */
    public void setIdProduct(int idProduct) {
        this.idProduct = idProduct;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the unitMeasured
     */
    public String getUnitMeasured() {
        return unitMeasured;
    }

    /**
     * @param unitMeasured the unitMeasured to set
     */
    public void setUnitMeasured(String unitMeasured) {
        this.unitMeasured = unitMeasured;
    }

    /**
     * @return the unitValue
     */
    public int getUnitValue() {
        return unitValue;
    }

    /**
     * @param unitValue the unitValue to set
     */
    public void setUnitValue(int unitValue) {
        this.unitValue = unitValue;
    }

    /**
     * @return the totalWeight
     */
    public int getTotalWeight() {
        return totalWeight;
    }

    /**
     * @param totalWeight the totalWeight to set
     */
    public void setTotalWeight(int totalWeight) {
        this.totalWeight = totalWeight;
    }

    /**
     * @return the description
     */
    public String getDescription() {
        return description;
    }

    /**
     * @param description the description to set
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * @return the idBatch
     */
    public int getIdBatch() {
        return idBatch;
    }

    /**
     * @param idBatch the idLot to set
     */
    public void setIdBatch(int idBatch) {
        this.idBatch = idBatch;
    }

    /**
     * @return the idCategory
     */
    public int getIdCategory() {
        return idCategory;
    }

    /**
     * @param idCategory the idCategory to set
     */
    public void setIdCategory(int idCategory) {
        this.idCategory = idCategory;
    }

    /**
     * @return the price
     */
    public double getPrice() {
        return price;
    }

    /**
     * @param price the price to set
     */
    public void setPrice(double price) {
        this.price = price;
    }

    /**
     * @return the url
     */
    public String getUrl() {
        return url;
    }

    /**
     * @param url the url to set
     */
    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public String toString() {
        return "Product{" + "idProduct=" + idProduct + ", name=" + name + ", unitMeasured=" + unitMeasured + ", unitValue=" + unitValue + ", totalWeight=" + totalWeight + ", description=" + description + ", idLot=" + idBatch + ", idCategory=" + idCategory + ", price=" + price + ", url=" + url + '}';
    }
    
}
