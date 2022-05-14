package com.chainOfResponsibility;

public abstract class Processor {
    Processor nextProcessor;

    public Processor(Processor nextProcessor){
        this.nextProcessor = nextProcessor;
    }

    public void process(int request){
        nextProcessor.process(request);
    }
}
