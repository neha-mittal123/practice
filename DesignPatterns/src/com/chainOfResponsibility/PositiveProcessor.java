package com.chainOfResponsibility;

public class PositiveProcessor extends Processor{
    public PositiveProcessor(Processor nextProcessor) {
        super(nextProcessor);
    }

    public void process(int request){
        if (request > 0)
        {
            System.out.println("PositiveProcessor : " + request);
        }
        else
        {
            super.process(request);
        }
    }
}
