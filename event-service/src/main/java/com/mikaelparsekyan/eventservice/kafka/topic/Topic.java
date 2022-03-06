package com.mikaelparsekyan.eventservice.kafka.topic;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@SuppressWarnings("squid:S115")
public enum Topic {
    TopicUserCreated(Constants.USER_CREATED);
    
    private final String topicName;

    public interface Constants {
        String USER_CREATED = "user_created";
    }
}
