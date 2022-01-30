package com.facadeDesignPattern;

public class Driver {

    public static void main(String [] args){
        HotelKeeper hotelKeeper=new HotelKeeper();
        System.out.println(hotelKeeper.getVegMenus());
        System.out.println(hotelKeeper.getNonVegMenu());
        System.out.println(hotelKeeper.getVegNonVegBoth());
    }
}
