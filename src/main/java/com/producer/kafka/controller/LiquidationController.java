package com.producer.kafka.controller;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeoutException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import lombok.extern.slf4j.Slf4j;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.producer.kafka.domain.Liquidation;
import com.producer.kafka.producer.LiquidationProducer;

@Slf4j
@RestController
@RequestMapping(value = "api/v1/liquidations")
public class LiquidationController {

  @Autowired
  LiquidationProducer liquidationProducer;

  @PostMapping
  public ResponseEntity<Liquidation> createBook(@RequestBody Liquidation liquidation)
    throws JsonProcessingException, ExecutionException, InterruptedException, TimeoutException {
    log.info("before send message");
    liquidationProducer.sendElasticTopic(liquidation);
    log.info("after send message");
    return ResponseEntity.status(HttpStatus.CREATED).body(liquidation);
  }
}
