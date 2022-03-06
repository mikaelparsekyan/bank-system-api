package com.mikaelparsekyan.eventservice.kafka.consumer;

import com.google.gson.Gson;
import com.mikaelparsekyan.eventservice.kafka.topic.Topic;
import com.mikaelparsekyan.eventservice.service.EventService;
import com.mikaelparsekyan.eventservice.service.dto.EventDTO;
import lombok.RequiredArgsConstructor;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class TopicUserCreationConsumer implements TopicConsumer<ConsumerRecord<String, String>> {

    private final EventService eventService;
    private final Gson gson;

    @KafkaListener(id = "TopicUserCreatedConsumer", topics = Topic.Constants.USER_CREATED)
    public void listen(ConsumerRecord<String, String> message) {
        EventDTO event = gson.fromJson(message.value(), EventDTO.class);
        this.eventService.saveEvent(event);
    }
}
