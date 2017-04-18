//package com.vgb.expt.messaging.jms.app;
//
//import com.vgb.expt.messaging.data.Person;
//import org.springframework.stereotype.Component;
//
//@Component("jmsPersonListener")
///*** POJO class, have handleMessage(...) method.
// * The return of handleMessage(...) will be
// * automatically send back to message.getJMSReplyTo().
// */
//public class JmsPersonListener {
//
//////  response
////    public String handleMessage(Person person) {
////        System.err.println("Received person !!: " + person);
////        return "ACK for " + person.getName();
////    }
//
//        //no response
//        public void handleMessage(Person person) {
//            System.err.println("Received person (no ack): " + person);
//
//        }
//}