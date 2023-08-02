package com.gabrielmttl.amqp;


import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@AllArgsConstructor
public class RabbitMQMessageProducer {

    private final AmqpTemplate amqpTemplate;

    public void publish(Object payload,
                        String exchange,
                        String routingKey) {
        log.info("Sending message to exchange: {}, routing key: {}, payload: {}",
                exchange, routingKey, payload);
        amqpTemplate.convertAndSend(exchange, routingKey, payload);
        log.info("Published to {} using routing Key {}. Payload: {}",
                exchange, routingKey, payload);
    }
}
