package org.james.kafka.controller;

import org.james.kafka.entity.Message;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.util.concurrent.ListenableFutureCallback;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SampleController {

    public static Logger logger = LoggerFactory.getLogger(SampleController.class);

    @Autowired
    private KafkaTemplate<String, Object> kafkaTemplate;

    @RequestMapping("/send")
    public String send(String topic, String key, String data) {
        ListenableFuture<SendResult<String, Object>> future  = kafkaTemplate.send(topic, key, new Message(1, data));
        future.addCallback(new ListenableFutureCallback<SendResult<String, Object>>() {
            @Override
            public void onFailure(Throwable throwable) {
                logger.error("Failed to send message to kafka. {}", throwable);
            }

            @Override
            public void onSuccess(SendResult<String, Object> sendResult) {
                logger.info("Send message to kafka.");
            }
        });

        return "SUCCESS";
    }
}
