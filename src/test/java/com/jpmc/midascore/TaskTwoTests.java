package com.jpmc.midascore;

import com.jpmc.midascore.foundation.Transaction;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.kafka.test.context.EmbeddedKafka;
import org.springframework.test.annotation.DirtiesContext;


@SpringBootTest(properties = {"spring.kafka.consumer.auto-offset-reset=earliest"})
@DirtiesContext
@EmbeddedKafka(partitions = 1, topics = { "test-topic" }) // embedded Kafka with 1 partition
public class TaskTwoTests {

    private static final Logger logger = LoggerFactory.getLogger(TaskTwoTests.class);

    @Autowired
    private KafkaProducer kafkaProducer;

    @Autowired
    private FileLoader fileLoader;

    @Test
    void task_two_verifier() throws InterruptedException {
        String[] transactionLines = fileLoader.loadStrings("/test_data/poiuytrewq.uiop");
        for (String transactionLine : transactionLines) {
            kafkaProducer.send(transactionLine);
        }

        logger.info("==================================================");
        logger.info("Watch debugger for incoming transactions.");
        logger.info("==================================================");

        Thread.sleep(10000);  // give time to receive and process messages
    }
}
