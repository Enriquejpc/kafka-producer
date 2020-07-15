package com.producer.kafka.configuration;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

@Configuration
public class KafkaProducerConfig {

  /**
   * Bean to define kafka client configuration.
   * @return NewTopic Object.
   */
  @Bean
  public NewTopic newTopic(){
    return TopicBuilder.name("liquidations")
      .partitions(3)
      .replicas(3)
      .build();
  }
}
