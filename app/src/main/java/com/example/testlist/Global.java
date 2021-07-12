package com.example.testlist;

public class Global {
    private static Global instance = new Global();

    // Getter-Setters
    public static Global getInstance() {
        return instance;
    }

    public static void setInstance(Global instance) {
        Global.instance = instance;
    }

    private String notification_index="0";


    private Global() {

    }


    public String getValue() {
        return notification_index;
    }


    public void setValue(String notification_index) {
        this.notification_index = notification_index;
    }



}

