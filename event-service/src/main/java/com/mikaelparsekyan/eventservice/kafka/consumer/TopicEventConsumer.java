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
public class TopicEventConsumer implements TopicConsumer<EventDTO> {

    private final EventService eventService;

    @KafkaListener(id = "TopicEventConsumer",
        topics = Topic.Constants.CREATE_EVENT,
        containerFactory = "runningListenerContainerFactory"
    )
    public void listen(EventDTO event) {
        this.eventService.saveEvent(event);
    }
}
