package com.chainOfResponsibility;

public class ZeroProcessor extends Processor{
    public ZeroProcessor(Processor nextProcessor) {
        super(nextProcessor);
    }

    public void process(int request){
        if (request == 0)
        {
            System.out.println("ZeroProcessor : " + request);
        }
        else
        {
            super.process(request);
        }
    }
}
