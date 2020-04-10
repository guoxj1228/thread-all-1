package com.xj.实战java高并发程序设计.diqizhang;

import akka.actor.*;

public class Hello extends UntypedAbstractActor {

    ActorRef greeter;

    @Override
    public void preStart() {
        greeter = getContext().actorOf(Props.create(Greeter.class), "greeter");
        System.out.println("Greenter Actor Path: "+greeter.path());
        greeter.tell(Greeter.Msg.GREET, getSelf());
    }

    @Override
    public void onReceive(Object message){
        if (message == Greeter.Msg.DONE){
            greeter.tell(Greeter.Msg.GREET, getSelf());
            getContext().stop(getSelf());
        }else{
            unhandled(message);
        }
    }

    public static void main(String[] args) {
        ActorSystem system = ActorSystem.create("Hello");
    }
}
