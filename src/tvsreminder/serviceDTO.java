/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tvsreminder;

/**
 *
 * @author Casual
 */
public class serviceDTO {

    private String chasis;
    private String model;
    private String custName;
    private String custPhone1;
    private String custPhone2;
    private String custAdd;
    private String fServiceDate;
    private String lServiceDate;
    private String nServiceDate;
    private int kilometers;
    private String eby;
    private String edtm;
    private boolean rowFound = false;

    public serviceDTO() {
    }

    public serviceDTO(String chasis, String model, int kilometers, String custName, String custPhone1, String custPhone2, String custAdd, String fServiceDate, String lServiceDate, String nServiceDate, String eby, String edtm) {
        this.chasis = chasis;
        this.model = model;
        this.kilometers = kilometers;
        this.custName = custName;
        this.custPhone1 = custPhone1;
        this.custPhone2 = custPhone2;
        this.custAdd = custAdd;
        this.fServiceDate = fServiceDate;
        this.lServiceDate = lServiceDate;
        this.nServiceDate = nServiceDate;
        this.eby = eby;
        this.edtm = edtm;
    }

    public String getChasis() {
        return chasis;
    }

    public void setChasis(String chasis) {
        this.chasis = chasis;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getCustName() {
        return custName;
    }

    public void setCustName(String custName) {
        this.custName = custName;
    }

    public String getCustPhone1() {
        return custPhone1;
    }

    public void setCustPhone1(String custPhone1) {
        this.custPhone1 = custPhone1;
    }

    public String getCustPhone2() {
        return custPhone2;
    }

    public void setCustPhone2(String custPhone2) {
        this.custPhone2 = custPhone2;
    }

    public String getCustAdd() {
        return custAdd;
    }

    public void setCustAdd(String custAdd) {
        this.custAdd = custAdd;
    }

    public String getfServiceDate() {
        return fServiceDate;
    }

    public void setfServiceDate(String fServiceDate) {
        this.fServiceDate = fServiceDate;
    }

    public String getlServiceDate() {
        return lServiceDate;
    }

    public void setlServiceDate(String lServiceDate) {
        this.lServiceDate = lServiceDate;
    }

    public String getnServiceDate() {
        return nServiceDate;
    }

    public void setnServiceDate(String nServiceDate) {
        this.nServiceDate = nServiceDate;
    }

    public String getEby() {
        return eby;
    }

    public void setEby(String eby) {
        this.eby = eby;
    }

    public String getEdtm() {
        return edtm;
    }

    public void setEdtm(String edtm) {
        this.edtm = edtm;
    }

    public int getKilometers() {
        return kilometers;
    }

    public void setKilometers(int kilometers) {
        this.kilometers = kilometers;
    }

    public boolean isRowFound() {
        return rowFound;
    }

    public void setRowFound(boolean rowFound) {
        this.rowFound = rowFound;
    }

}
