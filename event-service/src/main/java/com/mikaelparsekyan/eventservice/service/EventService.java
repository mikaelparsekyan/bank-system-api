package com.mikaelparsekyan.eventservice.service;

import com.mikaelparsekyan.common.dto.EventDTO;
import com.mikaelparsekyan.eventservice.persistence.model.Event;
import com.mikaelparsekyan.eventservice.persistence.repository.EventRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Slf4j
@AllArgsConstructor
@Service
public class EventService {

    private final EventRepository eventRepository;
    private final ModelMapper modelMapper;

    public EventDTO saveEvent(EventDTO eventDTO) {
        Event event = this.modelMapper.map(eventDTO, Event.class);
        Event savedEntity = this.eventRepository.save(event);
        log.info("Successfully saved event with id= {}", savedEntity.getId());
        return this.modelMapper.map(savedEntity, EventDTO.class);
    }
}
