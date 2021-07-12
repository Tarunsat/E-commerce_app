package com.example.testlist.data;


public class modalClassUser {
    private String userName;
    private String userPass;
    private String userMobile;

    private int id;

    public String getUserName()
    {
        return userName;
    }
    public void setUserName(String userName)
    {
        this.userName = userName;
    }
    public String getUserPass()
    {
        return userPass;
    }



    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


    public modalClassUser(String itemName,String itemPrice) {
        this.userName = itemName;
        this.userPass = itemPrice;


    }


}
