package com.vgb.expt.messaging.jms;

import com.vgb.expt.messaging.data.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jms.core.JmsMessagingTemplate;
import org.springframework.stereotype.Component;

import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.ObjectMessage;
import javax.jms.TextMessage;

@Component
public class SpringJmsConsumer {
    private JmsMessagingTemplate jmsTemplate;
    private Destination destination;

    @Autowired
    public SpringJmsConsumer(@Qualifier("jmsTemplate") JmsMessagingTemplate jmsTemplate, @Qualifier("requestQueue") Destination destination) {
        this.jmsTemplate = jmsTemplate;
        this.destination = destination;
    }

    public String receiveStringMessage() throws JMSException {
        TextMessage textMessage = (TextMessage) jmsTemplate.receive(destination);
        return textMessage.getText();
    }

    public Person receivePersonMessage() throws JMSException {
        ObjectMessage objectMessage = (ObjectMessage) jmsTemplate.receive(destination);
        return (Person) objectMessage.getObject();
    }


}