package com.producer.kafka.producer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;
import lombok.extern.slf4j.Slf4j;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.producer.kafka.domain.Liquidation;

@Service
@Slf4j
public class LiquidationProducer {
  @Autowired
  KafkaTemplate<String, Liquidation> kafkaTemplate;


  public void sendElasticTopic(Liquidation liquidation) throws JsonProcessingException {

    kafkaTemplate.send("liquidations", liquidation);
  }
}
