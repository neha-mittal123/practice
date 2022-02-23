package com.facadeDesignPattern;

public class NonVegMenu  extends Menu{
    String starters;
    String mainCourse;

    NonVegMenu(String starters,String mainCourse){
        this.starters=starters;
        this.mainCourse=mainCourse;
    }

    public String getStarters() {
        return starters;
    }

    public String getMainCourse() {
        return mainCourse;
    }

    @Override
    public String toString() {
        return "NonVegMenu{" +
                "starters='" + starters + '\'' +
                ", mainCourse='" + mainCourse + '\'' +
                '}';
    }
}
