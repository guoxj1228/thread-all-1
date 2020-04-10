package com.xj.实战java高并发程序设计.diqizhang;

import akka.actor.UntypedAbstractActor;

public class Greeter extends UntypedAbstractActor {

    public static enum Msg{
        GREET,DONE;
    }

    @Override
    public void onReceive(Object message) throws Throwable, Throwable {
        if (message == Msg.GREET){
            System.out.println("hello world!");
            getSender().tell(Msg.DONE, getSelf());
        } else{
            unhandled(message);
        }
    }
}
