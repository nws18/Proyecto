
package domain;

/**
 *
 * @author Nicole Fonseca, Wilmer Mata, Sergio Siles
 */
public class TableAdministrator {
    
    private String productName;
    private String cellarName;
    private String categoryName;
    private String batchCode;
    private String operatorName;

    public TableAdministrator() {
    }

    public TableAdministrator(String productName, String cellarName, String categoryName, String batchCode, String operatorName) {
        this.productName = productName;
        this.cellarName = cellarName;
        this.categoryName = categoryName;
        this.batchCode = batchCode;
        this.operatorName = operatorName;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getCellarName() {
        return cellarName;
    }

    public void setCellarName(String cellarName) {
        this.cellarName = cellarName;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public String getBatchCode() {
        return batchCode;
    }

    public void setBatchCode(String batchCode) {
        this.batchCode = batchCode;
    }

    public String getOperatorName() {
        return operatorName;
    }

    public void setOperatorName(String operatorName) {
        this.operatorName = operatorName;
    }

    @Override
    public String toString() {
        return "TableAdministrator{" + "productName=" + productName + ", cellarName=" + cellarName + ", categoryName=" + categoryName + ", batchCode=" + batchCode + ", operatorName=" + operatorName + '}';
    }
}
