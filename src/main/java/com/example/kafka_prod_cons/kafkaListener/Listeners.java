package com.example.kafka_prod_cons.kafkaListener;

import com.example.kafka_prod_cons.model.SecondSimpleModel;
import com.example.kafka_prod_cons.model.SimpleModel;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;


@Component
public class Listeners {

    @Autowired
    private Gson jsonConverter;
    // The firsttopic firstKafkaTopic3
    @KafkaListener(topics = "firstKafkaTopic3")  //get from queque (topic - firstKafkaTopic)
    public void getFromKafkaTopic(String simpleModel) {
        SimpleModel simpleModel1 = jsonConverter.fromJson(simpleModel, SimpleModel.class);
        System.out.println(simpleModel1);
    }
    // The second Topic secondTopic
    @KafkaListener(topics = "secondTopic")
    public void listenSecondTopic(String secondSimpleModel) {
        SecondSimpleModel secondSimpleModel1 = jsonConverter.fromJson(secondSimpleModel, SecondSimpleModel.class);
        System.out.println(secondSimpleModel1);
    }
}
