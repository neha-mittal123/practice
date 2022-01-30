package com.adaptorDesignPattern;

public class Volt {
    private int volt;

    Volt(int volt){
        this.volt=volt;
    }

    public int getVolt() {
        return volt;
    }

    public void setVolt(int volt) {
        this.volt = volt;
    }

    @Override
    public String toString() {
        return "Volt{" +
                "volt=" + volt +
                '}';
    }
}
