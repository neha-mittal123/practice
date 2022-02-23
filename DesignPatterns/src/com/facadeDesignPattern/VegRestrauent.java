package com.facadeDesignPattern;

public class VegRestrauent implements Hotel{
    @Override
    public Menu getMenus() {
        return (Menu) new VegMenu("paneerTikka","dalMakhani");
    }
}
