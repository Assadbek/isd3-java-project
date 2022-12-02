package com.example.findtutor;

import com.example.findtutor.model.Tutor;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.annotation.KafkaListener;

//@EnableKafka
@SpringBootApplication
public class FindTutorApplication {
/*

    @KafkaListener(topics="newTutor")
    public void orderListener(ConsumerRecord<Long, Tutor> record){
        System.out.println(record.partition());
        System.out.println(record.key());
        System.out.println(record.value());
    }
*/

    public static void main(String[] args) {
        SpringApplication.run(FindTutorApplication.class, args);
    }

}
