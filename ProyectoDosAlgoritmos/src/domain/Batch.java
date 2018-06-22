
package domain;

import java.util.Date;

/**
 *
 * @author Nicole Fonseca, Wilmer Mata, Sergio Siles
 */
public class Batch  implements java.io.Serializable{
    
    private int idBatch;
    private String batchCode;
    private Date packedDate;
    private Date expirationDate;

    public Batch() {
    }

    public Batch(int idBatch, String batchCode, Date packedDate, Date expirationDate) {
        this.idBatch = idBatch;
        this.batchCode = batchCode;
        this.packedDate = packedDate;
        this.expirationDate = expirationDate;
    }

    /**
     * @return the idBatch
     */
    public int getIdBatch() {
        return idBatch;
    }

    /**
     * @param idBatch the idBatch to set
     */
    public void setIdBatch(int idBatch) {
        this.idBatch = idBatch;
    }

    /**
     * @return the batchCode
     */
    public String getBatchCode() {
        return batchCode;
    }

    /**
     * @param batchCode the batchCode to set
     */
    public void setBatchCode(String batchCode) {
        this.batchCode = batchCode;
    }

    /**
     * @return the packedDate
     */
    public Date getPackedDate() {
        return packedDate;
    }

    /**
     * @param packedDate the packedDate to set
     */
    public void setPackedDate(Date packedDate) {
        this.packedDate = packedDate;
    }

    /**
     * @return the expirationDate
     */
    public Date getExpirationDate() {
        return expirationDate;
    }

    /**
     * @param expirationDate the expirationDate to set
     */
    public void setExpirationDate(Date expirationDate) {
        this.expirationDate = expirationDate;
    }

    @Override
    public String toString() {
        return "Batch{" + "idBatch=" + idBatch + ", batchCode=" + batchCode + ", packedDate=" + packedDate + ", expirationDate=" + expirationDate + '}';
    }
    
}
