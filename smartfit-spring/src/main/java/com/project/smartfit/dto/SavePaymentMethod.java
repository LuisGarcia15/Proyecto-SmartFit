package com.project.smartfit.dto;

public class SavePaymentMethod {

    private String fullName;
    private String numberCard;
    private String numberCVC;
    private String dateCard;
    private String flag;

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getNumberCard() {
        return numberCard;
    }

    public void setNumberCard(String numberCard) {
        this.numberCard = numberCard;
    }

    public String getNumberCVC() {
        return numberCVC;
    }

    public void setNumberCVC(String numberCVC) {
        this.numberCVC = numberCVC;
    }

    public String getDateCard() {
        return dateCard;
    }

    public void setDateCard(String dateCard) {
        this.dateCard = dateCard;
    }

    public String getFlag() {
        return flag;
    }

    public void setFlag(String flag) {
        this.flag = flag;
    }
}
