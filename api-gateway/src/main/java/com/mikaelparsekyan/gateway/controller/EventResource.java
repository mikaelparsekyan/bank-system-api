package com.mikaelparsekyan.gateway.controller;

import com.google.gson.Gson;
import com.mikaelparsekyan.common.dto.EventDTO;
import com.mikaelparsekyan.common.kafka.Topic;
import com.mikaelparsekyan.common.util.ResponseObject;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@AllArgsConstructor
@RestController
@RequestMapping("/v1/events")
public class EventResource {

    private final KafkaTemplate<String, String> kafkaTemplate;
    private final Gson gson;

    @PostMapping
    public ResponseEntity<Object> sendEvent(@RequestBody @Valid EventDTO eventDTO) {
        kafkaTemplate.send(Topic.Constants.CREATE_EVENT, gson.toJson(eventDTO));
        return new ResponseEntity<>(ResponseObject.build("Kafka message sent."), HttpStatus.OK);
    }
}
