package com.vgb.expt.messaging.jms.app;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringJmsConsumerListenerApp {
    public static void main(String[] args) throws Exception {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(
                "applicationContext-jms.xml");

        try {

            Thread.sleep(1000000);
        } finally {
            context.close();
        }
    }
}