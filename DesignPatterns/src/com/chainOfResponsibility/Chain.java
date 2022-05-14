package com.chainOfResponsibility;

public class Chain {
    Processor chain;

    public Chain(){
        buildChain();
    }

    private void buildChain() {
        chain = new NegativeProcessor(new ZeroProcessor(new PositiveProcessor(null)));
    }

    public void process(int request){
        chain.process(request);
    }
}
