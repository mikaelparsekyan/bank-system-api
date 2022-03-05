package com.mikaelparsekyan.eventservice.kafka.consumer;

import com.google.gson.Gson;
import com.mikaelparsekyan.eventservice.kafka.topic.Topic;
import com.mikaelparsekyan.eventservice.persistence.model.Event;
import com.mikaelparsekyan.eventservice.persistence.repository.EventRepository;
import lombok.RequiredArgsConstructor;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class TopicUserCreationConsumer implements TopicConsumer<ConsumerRecord<String, String>> {

    private final EventRepository eventRepository;
    private final Gson gson;

    @KafkaListener(id = "TopicConsumerEventConsumer", topics = Topic.USER_CREATION)
    public void listen(ConsumerRecord<String, String> message) {
        Event event = gson.fromJson(message.value(), Event.class);
        this.eventRepository.save(event);
        //logger.info("Successfully saved event with id= {}", savedEntity.getId());
        //return modelMapper.map(savedEntity, EventDTO.class);
    }
}
