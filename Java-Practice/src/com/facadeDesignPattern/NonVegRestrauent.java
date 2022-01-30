package com.facadeDesignPattern;

public class NonVegRestrauent implements Hotel{
    @Override
    public Menu getMenus() {
        return (Menu)new NonVegMenu("chickenTikka","chickenBiryani");
    }
}
