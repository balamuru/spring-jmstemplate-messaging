//package com.vgb.expt.messaging.jms.app;
//
//import com.vgb.expt.messaging.jms.SpringJmsConsumer;
//import org.springframework.context.support.ClassPathXmlApplicationContext;
//
//public class SpringJmsConsumerApp {
//    public static void main(String[] args) throws Exception {
//        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(
//                "applicationContext-jms.xml");
//
//        try {
//            SpringJmsConsumer springJmsConsumer = (SpringJmsConsumer) context
//                    .getBean("springJmsConsumer");
////            System.out.println("Consumer receives " + springJmsConsumer.receiveStringMessage());
//
//            System.out.println("Consumer receives " + springJmsConsumer.receivePersonMessage());
//        } finally {
//            context.close();
//        }
//    }
//}