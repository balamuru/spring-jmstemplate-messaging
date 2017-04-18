package com.vgb.expt.messaging.jms.app;

import com.vgb.expt.messaging.data.Address;
import com.vgb.expt.messaging.data.Person;
import com.vgb.expt.messaging.jms.SpringJmsProducer;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Random;

public class SpringJmsProducerApp {


    public static void main(String[] args) throws Exception {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(
                "applicationContext-jms.xml");

        try {
            SpringJmsProducer springJmsProducer = (SpringJmsProducer) context
                    .getBean("springJmsProducer");
//            springJmsProducer.sendStringMessage("Hi " + new Date());


            for (int i = 0; i < 100; i++) {
                Person person = createPerson(i);
                String resp = springJmsProducer.sendPersonMessageAndReceiveResponse(person);
                if (!resp.equals(person.getName())) {
                    throw new Exception("Expected response [" + person.getName() + "] but got [" + resp+"]");
                }
            }



        } finally {
            context.close();
        }
    }


    private static Person createPerson(int i) {
        Person person = new Person("John Doe_" + i+"_"+ nextInt(), (int) (1 + System.currentTimeMillis() % 20),
                new Address("1000", "some street", "Tx", "USA", "75080")
        );

        return person;
    }

    private static Random random = new Random(System.currentTimeMillis());

    private static int nextInt() {
        return random.nextInt(1000);
    }
}