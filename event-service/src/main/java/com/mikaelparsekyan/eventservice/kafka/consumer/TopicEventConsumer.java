package com.mikaelparsekyan.eventservice.kafka.consumer;

import com.google.gson.Gson;
import com.mikaelparsekyan.common.dto.EventDTO;
import com.mikaelparsekyan.common.kafka.Topic;
import com.mikaelparsekyan.eventservice.service.EventService;
import lombok.RequiredArgsConstructor;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class TopicEventConsumer implements TopicConsumer<ConsumerRecord<String, String>> {

    private final EventService eventService;
    private final Gson gson;

    @KafkaListener(id = "TopicEventConsumer", topics = Topic.Constants.CREATE_EVENT)
    public void listen(ConsumerRecord<String, String> message) {
        EventDTO event = gson.fromJson(message.value(), EventDTO.class);
        this.eventService.saveEvent(event);
    }
}
