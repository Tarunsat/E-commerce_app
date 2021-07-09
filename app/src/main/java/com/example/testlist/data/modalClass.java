package com.example.testlist.data;

public class modalClass {
    private String itemName;
    private String itemPrice;
    private String itemStock;
    private String itemImage;
    private int id;

    public String getItemName() {
        return itemName;
    }
    public void setItemName(String itemName) {
        this.itemName = itemName;
    }
    public String getItemPrice() {
        return itemPrice;
    }
    public void setItemPrice(String itemPrice) {
        this.itemPrice = itemPrice;
    }
    public String getItemStock() {
        return itemStock;
    }
    public void setItemStock(String itemStock) {
        this.itemStock = itemStock;
    }
    public String getItemImage() {
        return itemImage;
    }
    public void setItemImage(String itemImage) {
        this.itemImage = itemImage;
    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


        public modalClass(String itemName,String itemPrice,String itemStock, String itemImage) {
            this.itemName = itemName;
            this.itemPrice = itemPrice;
            this.itemStock = itemStock;
            this.itemImage = itemImage;
        }

}
