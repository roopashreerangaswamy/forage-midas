package com.jpmc.midascore.service;

import com.jpmc.midascore.entity.TransactionRecord;
import com.jpmc.midascore.entity.UserRecord;
import com.jpmc.midascore.foundation.Transaction;
import com.jpmc.midascore.repository.TransactionRecordRepository;
import com.jpmc.midascore.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import com.jpmc.midascore.entity.Incentive;



import java.time.LocalDateTime;

@Service
public class TransactionService {
    @Autowired
    private RestTemplate restTemplate;


    @Autowired
    private UserRepository userRepository;

    @Autowired
    private TransactionRecordRepository transactionRecordRepository;

    public void processTransaction(Transaction transaction) {
        UserRecord sender = userRepository.findById(transaction.getSenderId()).orElse(null);
        UserRecord recipient = userRepository.findById(transaction.getRecipientId()).orElse(null);
        Incentive incentive = restTemplate.postForObject(
                "http://localhost:8080/incentive",
                transaction,
                Incentive.class
        );
        double incentiveAmount = incentive.getAmount();




        if (sender == null || recipient == null) {
            return; // sender or recipient not found
        }

        if (sender.getBalance() < transaction.getAmount()) {
            return; // insufficient balance
        }

        // Deduct and add balances
        sender.setBalance((float)(sender.getBalance() - transaction.getAmount()));
        recipient.setBalance((float)(recipient.getBalance() + transaction.getAmount() + incentiveAmount));



        userRepository.save(sender);
        userRepository.save(recipient);

        TransactionRecord record = new TransactionRecord();
        record.setAmount(transaction.getAmount());
        record.setSender(sender);
        record.setRecipient(recipient);
        record.setTimestamp(LocalDateTime.now());
        record.setIncentive(incentiveAmount);


        transactionRecordRepository.save(record);
        UserRecord wilbur = userRepository.findByName("wilbur").orElse(null);
        if (wilbur != null) {
            System.out.println("Wilbur's final balance: " + wilbur.getBalance());
        }



    }
}
