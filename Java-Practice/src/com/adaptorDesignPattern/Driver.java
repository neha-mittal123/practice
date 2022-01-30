package com.adaptorDesignPattern;

public class Driver {

    public static void main(String[] args){
        SocketAdaptor socketAdaptor=new SocketAdpatorImpl();
        System.out.print(socketAdaptor.get3Volt().toString()+" ");
        System.out.print(socketAdaptor.get12Volt().toString()+" ");
        System.out.print(socketAdaptor.get120Volt().toString()+" ");
    }
}
