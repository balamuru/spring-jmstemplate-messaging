package com.vgb.expt.messaging.jms.app;


import com.vgb.expt.messaging.data.Person;
import org.apache.activemq.command.ActiveMQTextMessage;
import org.springframework.jms.listener.SessionAwareMessageListener;
import org.springframework.stereotype.Component;

import javax.jms.*;
import java.io.Serializable;

@Component("consumerSessionAwareListener")
public class ConsumerSessionAwareListener implements SessionAwareMessageListener {

    public void onMessage(Message message, Session session) throws JMSException {
        try {
            Serializable object = ((ObjectMessage) message).getObject();
            Person person = (Person)object;
//            System.err.println("###############!!!!!!!!! handling object in session aware listener " + person);
//            System.err.println("#### session : " + session);
            System.err.println("#### message : " + message);

//            acknowledge the receipt
            TextMessage textMessage = new ActiveMQTextMessage();
            textMessage.setJMSCorrelationID(message.getJMSCorrelationID());
//            textMessage.setJMSCorrelationID(message.getJMSMessageID());
            textMessage.setText(person.getName());

            // Message send back to the replyTo address of the income message.
            // Like replying an email somehow.
            MessageProducer producer = session.createProducer(message.getJMSReplyTo());
            producer.send(textMessage);
        } catch (JMSException e) {
            e.printStackTrace();
        }
    }
}
