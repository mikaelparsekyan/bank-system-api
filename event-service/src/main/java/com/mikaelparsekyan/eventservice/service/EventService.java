package com.mikaelparsekyan.eventservice.service;

import com.mikaelparsekyan.eventservice.kafka.topic.Topic;
import com.mikaelparsekyan.eventservice.service.dto.EventDTO;
import lombok.AllArgsConstructor;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class EventService {

    private final KafkaTemplate<String, Object> kafkaTemplate;
    
    public EventDTO sendEvent(EventDTO eventDTO) {
        kafkaTemplate.send(Topic.USER_CREATION, eventDTO);
        return null;
    }
}
