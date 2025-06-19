/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author HUAWEI D15
 */
public class Kamar {

    /**
     * @return the id
     */
    public Integer getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * @return the nomorKamar
     */
    public String getNomorKamar() {
        return nomorKamar;
    }

    /**
     * @param nomorKamar the nomorKamar to set
     */
    public void setNomorKamar(String nomorKamar) {
        this.nomorKamar = nomorKamar;
    }

    /**
     * @return the tipeKamar
     */
    public String getTipeKamar() {
        return tipeKamar;
    }

    /**
     * @param tipeKamar the tipeKamar to set
     */
    public void setTipeKamar(String tipeKamar) {
        this.tipeKamar = tipeKamar;
    }

    /**
     * @return the harga
     */
    public String getHarga() {
        return harga;
    }

    /**
     * @param harga the harga to set
     */
    public void setHarga(String harga) {
        this.harga = harga;
    }

    /**
     * @return the status
     */
    public String getStatus() {
        return status;
    }

    /**
     * @param status the status to set
     */
    public void setStatus(String status) {
        this.status = status;
    }
    private Integer id;
    private String nomorKamar;
    private String tipeKamar;
    private String harga;
    private String status;
}
