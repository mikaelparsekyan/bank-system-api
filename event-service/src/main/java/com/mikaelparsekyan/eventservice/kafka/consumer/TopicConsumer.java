package com.mikaelparsekyan.eventservice.kafka.consumer;

import org.springframework.messaging.handler.annotation.Headers;
import org.springframework.messaging.handler.annotation.Payload;

import java.util.Map;

public interface TopicConsumer<T> {
    void listen(@Payload T message);
}
