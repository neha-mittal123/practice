package com.adaptorDesignPattern;

public class Socket {

    public Volt get120Volt(){
        Volt volt=new Volt(120);
        System.out.println("Socket Class called");
        return volt;
    }
}
