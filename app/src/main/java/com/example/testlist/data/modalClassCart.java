package com.example.testlist.data;


public class modalClassCart {
    private String user;
    private String product;
    private String quantity;

    private int id;

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getProduct() {
        return product;
    }
    public void setProduct(String product) {
        this.product = product;
    }
    public String getQuantity() {
        return quantity;
    }
    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }



    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


    public modalClassCart(String user, String product,String quantity) {
        this.user = user;
        this.product = product;
        this.quantity=quantity;


    }
}