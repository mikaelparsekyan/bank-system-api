package com.mikaelparsekyan.common.kafka;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public enum Topic {
    TopicEventCreate(Constants.CREATE_EVENT);
    
    private final String topicName;

    public interface Constants {
        String CREATE_EVENT = "event";
    }
}
