package com.facadeDesignPattern;

public class VegNonVegBothRestrauent implements Hotel{
    @Override
    public Menu getMenus() {
        return (Menu) new VegNonVegBoth("paneerTikka","chickenBiryani");
    }
}
