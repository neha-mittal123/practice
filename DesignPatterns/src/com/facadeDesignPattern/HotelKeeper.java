package com.facadeDesignPattern;

public class HotelKeeper {
    public Menu getVegMenus(){
        VegRestrauent vegRestrauent=new VegRestrauent();
        return vegRestrauent.getMenus();
    }
    public Menu getNonVegMenu(){
        NonVegRestrauent nonVegRestrauent=new NonVegRestrauent();
        return nonVegRestrauent.getMenus();
    }
    public Menu getVegNonVegBoth(){
        VegNonVegBothRestrauent vegNonVegBothRestrauent=new VegNonVegBothRestrauent();
        return vegNonVegBothRestrauent.getMenus();
    }
}
