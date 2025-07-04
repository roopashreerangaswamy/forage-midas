package com.jpmc.midascore;

import com.jpmc.midascore.foundation.Transaction;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class KafkaConsumer {

    private static final Logger logger = LoggerFactory.getLogger(KafkaConsumer.class);

    @KafkaListener(
            topics = "${general.kafka-topic}",
            groupId = "midas-group",
            containerFactory = "kafkaListenerContainerFactory"
    )
    public void listen(ConsumerRecord<String, Transaction> record) {
        Transaction transaction = record.value();
        logger.info("Received transaction: {}", transaction);
    }
}
