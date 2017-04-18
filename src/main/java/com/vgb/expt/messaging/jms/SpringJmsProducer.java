package com.vgb.expt.messaging.jms;

import com.vgb.expt.messaging.data.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.jms.core.JmsMessagingTemplate;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;
import org.springframework.stereotype.Component;

import javax.jms.*;
import java.util.UUID;


@Component
public class SpringJmsProducer {
    private JmsMessagingTemplate jmsTemplate;
    private Destination requestQueue;
//    private Destination responseQueue;

    @Autowired
    public SpringJmsProducer(@Qualifier("jmsTemplate") JmsMessagingTemplate jmsTemplate,
                             @Qualifier("requestQueue") Destination requestQueue
//                             @Qualifier("responseQueue") Destination responseQueue
    ) {
        this.jmsTemplate = jmsTemplate;
        this.requestQueue = requestQueue;
//        this.responseQueue = responseQueue;
    }


//    public void sendStringMessage(final String msg) {
//        System.out.println("Producer sends " + msg);
//        jmsTemplate.send(requestQueue, new MessageCreator() {
//            public Message createMessage(Session session) throws JMSException {
//                return session.createTextMessage(msg);
//            }});
//    }

    public String sendPersonMessageAndReceiveResponse(final Person person) {
        System.out.println("Producer sends " + person);
//        final String correlationId = UUID.randomUUID().toString();
//        MessageCreator messageCreator = new MessageCreator() {
//            public Message createMessage(Session session) throws JMSException {
//
//                final Message message = session.createObjectMessage(person);
//                message.setJMSCorrelationID(correlationId);
//                message.setJMSReplyTo(responseQueue);
//
//
//                System.err.println("##### sending :" + message);
//
//                return message;
//            }
//        };


//        jmsTemplate.sendAndReceive(requestQueue, null);
//
//        jmsTemplate.convertSendAndReceive()
//
//
//        jmsTemplate.send(requestQueue, messageCreator);


//        Message response = jmsTemplate.receiveSelected(responseQueue, correlationId);
//        Message response = jmsTemplate.receive(responseQueue);
//        System.err.println("### <<<<< recvd  : " + response);


//        jmsTemplate.sendAndReceive(responseQueue, messageCreator.createMessage(se));

        String resp = jmsTemplate.convertSendAndReceive(requestQueue, person, String.class);
        System.err.println("##### response ====>  : " + resp);
        return resp;
    }




}