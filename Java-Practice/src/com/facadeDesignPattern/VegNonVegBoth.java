package com.facadeDesignPattern;

public class VegNonVegBoth extends Menu {
    String starters;
    String mainCourse;

    VegNonVegBoth(String starters,String mainCourse){
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
        return "VegNonVegBoth{" +
                "starters='" + starters + '\'' +
                ", mainCourse='" + mainCourse + '\'' +
                '}';
    }
}
