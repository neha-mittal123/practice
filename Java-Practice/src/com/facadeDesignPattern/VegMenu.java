package com.facadeDesignPattern;

public class VegMenu extends Menu{
    String starters;
    String mainCourse;

    VegMenu(String starters,String mainCourse){
        this.starters=starters;
        this.mainCourse=mainCourse;
    }

    public String getMainCourse() {
        return mainCourse;
    }

    public String getStarters() {
        return starters;
    }

    @Override
    public String toString() {
        return "VegMenu{" +
                "starters='" + starters + '\'' +
                ", mainCourse='" + mainCourse + '\'' +
                '}';
    }
}
