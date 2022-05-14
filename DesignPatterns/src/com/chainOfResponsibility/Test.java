package com.chainOfResponsibility;

/*Decoupling a sender and receiver of a command
Picking a processing strategy at processing-time

Advantages of Chain of Responsibility Design Pattern :


        1.)To reduce the coupling degree. Decoupling it will request the sender and receiver.
        2.)Simplified object. The object does not need to know the chain structure.
        3.)Enhance flexibility of object assigned duties. By changing the members within the chain or change their order, allow dynamic adding or deleting responsibility.
        4.)Increase the request processing new class of very convenient.

        DisAdvantages of Chain of Responsibility Design Pattern :


        1.)The request must be received not guarantee.
        2.)The performance of the system will be affected, but also in the code debugging is not easy may cause cycle call.
        3.)It may not be easy to observe the characteristics of operation, due to debug.*/

public class Test {

    public static void main(String args[]){
        Chain chain = new Chain();

        chain.process(90);
        chain.process(-1);
        chain.process(0);
    }
}
