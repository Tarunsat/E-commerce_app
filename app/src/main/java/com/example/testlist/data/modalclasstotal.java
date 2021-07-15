package com.example.testlist.data;




public class modalclasstotal  {
    private String user;
    private String product;
    private String quantity;
    private String price;


    private int id;

    public String getUser() {
        return user;
    }





    public String getProduct() {
        return product;
    }
    public void setProduct(String product) {
        this.product = product;
    }
    public String getQuantity() {
        if(quantity == null)
        {
            return "0";
        }
        else
        {
            return quantity;
        }

    }
    public String getPrice() {
        return price;
    }



    public void setPrice(String price) {
        this.price = price;
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


    public modalclasstotal(String quantity, String price) {

        this.price = price;
        this.quantity=quantity;



    }
}