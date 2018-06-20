package org.james.kafka.consumer;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.james.kafka.entity.Message;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.Acknowledgment;
import org.springframework.stereotype.Component;

@Component
public class KafkaConsumer {
    private static Logger logger = LoggerFactory.getLogger(KafkaConsumer.class);

    @KafkaListener(topics = "${kafka.topic.t1}")
    public void listenT1(ConsumerRecord<?, ?> cr) {
        logger.info("{} - {} : {}", cr.topic(), cr.key(), cr.value());
    }

    @KafkaListener(topics = {"${kafka.topic.t2}", "${kafka.topic.t3}"})
    public void listenT2(ConsumerRecord<?, ?> cr) {
        logger.info("{} - {} : {}", cr.topic(), cr.key(), cr.value());
        Message msg = (Message) cr.value();
        logger.info("data : {}", msg.getData());
    }

    @KafkaListener(topics = {"${kafka.topic.t4}"})
    public void listenT4(Message msg, Acknowledgment acknowledgment) {
        msg = null;
        logger.info("data : {}", msg.getData());
        acknowledgment.acknowledge();
    }
}
