package com.mikaelparsekyan.gateway.controller;

import com.mikaelparsekyan.common.dto.EventDTO;
import com.mikaelparsekyan.common.kafka.Topic;
import com.mikaelparsekyan.common.util.ResponseObject;
import javax.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("/v1/events")
public class EventResource {

    @Autowired
    private final KafkaTemplate<String, Object> kafkaTemplate;

    @PostMapping
    public ResponseEntity<Object> sendEvent(@RequestBody @Valid EventDTO eventDTO) {
        kafkaTemplate.send(Topic.Constants.CREATE_EVENT, eventDTO);
        return new ResponseEntity<>(ResponseObject.build("Kafka message sent."), HttpStatus.OK);
    }
}
