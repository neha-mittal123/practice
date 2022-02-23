package com.adaptorDesignPattern;

public class SocketAdpatorImpl extends Socket implements SocketAdaptor {

    @Override
    public Volt get12Volt() {
        Volt volt=get120Volt();
        return convertVolts(volt,10);
    }

    @Override
    public Volt get3Volt() {
        Volt volt=get120Volt();
        return convertVolts(volt,40);
    }

    private Volt convertVolts(Volt volt, int i) {
        return new Volt(volt.getVolt()/i);
    }

    @Override
    public Volt get120Volt() {
        return super.get120Volt();
    }
}
