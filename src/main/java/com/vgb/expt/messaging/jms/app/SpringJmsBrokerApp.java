//package com.vgb.expt.messaging.jms.app;
//
//import org.apache.activemq.broker.BrokerFactory;
//import org.apache.activemq.broker.BrokerService;
//
//import java.net.URI;
//
//public class SpringJmsBrokerApp {
//    public static void main(String[] args) throws Exception {
//        BrokerService broker = BrokerFactory.createBroker(new URI(
//                "broker:(tcp://localhost:61616)"));
//        broker.start();
//
//        System.out.println("Starting JMS Broker");
//        try {
//            Thread.sleep(100000000);
//        } finally {
//            System.out.println("Terminating JMS Broker");
//            broker.stop();
//        }
//    }
//}