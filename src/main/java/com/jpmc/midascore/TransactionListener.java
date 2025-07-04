package com.jpmc.midascore;

import com.jpmc.midascore.foundation.Transaction;
import com.jpmc.midascore.service.TransactionService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import java.util.concurrent.atomic.AtomicInteger;

@Component
public class TransactionListener {

    private static final Logger logger = LoggerFactory.getLogger(TransactionListener.class);

    @Value("${general.kafka-topic}")
    private String topic;

    private final AtomicInteger counter = new AtomicInteger(0);

    @Autowired
    private TransactionService transactionService;

    @KafkaListener(topics = "${general.kafka-topic}", groupId = "${spring.kafka.consumer.group-id}")
    public void listen(Transaction transaction) {
        transactionService.processTransaction(transaction);
    }

    public String getTopic() {
        return topic;
    }
}
