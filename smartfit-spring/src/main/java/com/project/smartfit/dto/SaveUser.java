package com.project.smartfit.dto;

/*DTO que se encarga de transportar los datos para salvarse mediante
* una Entity en la BD. no incluye el rol pues solo existe un rol en
* la app*/
public class SaveUser {

    private String user;
    private String password;
    private SaveClient client;
    private SaveClientAddress clientAddress;
    private SaveContactPerson contactPerson;
    private SavePaymentMethod paymentMethod;
    private SavePayment payment;
    private SaveClientPlanTrainingUnit clientPlanTrainingUnit;

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public SaveClient getClient() {
        return client;
    }

    public void setClient(SaveClient client) {
        this.client = client;
    }

    public SaveClientAddress getClientAddress() {
        return clientAddress;
    }

    public void setClientAddress(SaveClientAddress clientAddress) {
        this.clientAddress = clientAddress;
    }

    public SavePayment getPayment() {
        return payment;
    }

    public void setPayment(SavePayment payment) {
        this.payment = payment;
    }

    public SavePaymentMethod getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(SavePaymentMethod paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public SaveContactPerson getContactPerson() {
        return contactPerson;
    }

    public void setContactPerson(SaveContactPerson contactPerson) {
        this.contactPerson = contactPerson;
    }

    public SaveClientPlanTrainingUnit getClientPlanTrainingUnit() {
        return clientPlanTrainingUnit;
    }

    public void setClientPlanTrainingUnit(SaveClientPlanTrainingUnit clientPlanTrainingUnit) {
        this.clientPlanTrainingUnit = clientPlanTrainingUnit;
    }

    @Override
    public String toString() {
        return "SaveUser{" +
                "user='" + user + '\'' +
                ", password='" + password + '\'' +
                ", client=" + client +
                ", clientAddress=" + clientAddress +
                ", contactPerson=" + contactPerson +
                ", paymentMethod=" + paymentMethod +
                ", payment=" + payment +
                ", clientPlanTrainingUnit=" + clientPlanTrainingUnit +
                '}';
    }
}