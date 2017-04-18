//package com.vgb.expt.messaging.jms.app;
//
//
//import org.apache.activemq.command.ActiveMQTextMessage;
//import org.springframework.stereotype.Component;
//
//import javax.jms.*;
//
//@Component("consumerListener")
//public class ConsumerListener implements MessageListener {
//    public void onMessage(Message message) {
//        try {
//            System.err.println("###############!!!!!!!!! handling message in listener " + ((ObjectMessage) message).getObject());
//
//
//
//        } catch (JMSException e) {
//            e.printStackTrace();
//        }
//    }
//}
