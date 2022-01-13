package com.example.kafka_prod_cons.controller;

import com.example.kafka_prod_cons.model.SecondSimpleModel;
import com.example.kafka_prod_cons.model.SimpleModel;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/kafka")
public class KafkaConsumerController {

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    @Autowired
    private Gson jsonConverter;

// The firsttopic firstKafkaTopic3
    @PostMapping("/toQueue")  //send to queque (topic - firstKafkaTopic)
    public void postToQueue(@RequestBody SimpleModel simpleModel) {
        kafkaTemplate.send("firstKafkaTopic3", jsonConverter.toJson(simpleModel));
    }

    // The second topic secondTopic
    @PostMapping("/second")
    public void postToKafkaSecondTopic(@RequestBody SecondSimpleModel secondSimpleModel){
        kafkaTemplate.send("secondTopic", jsonConverter.toJson(secondSimpleModel));
    }
}
