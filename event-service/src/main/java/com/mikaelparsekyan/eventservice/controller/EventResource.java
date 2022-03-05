package com.mikaelparsekyan.eventservice.controller;

import com.mikaelparsekyan.eventservice.service.EventService;
import com.mikaelparsekyan.eventservice.service.dto.EventDTO;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@AllArgsConstructor
@RestController
@RequestMapping("/events")
public class EventResource {
    
    private final EventService eventService;

    @PostMapping
    public void postEvent(@RequestBody @Valid EventDTO eventDTO) {
        this.eventService.sendEvent(eventDTO);
    }
}
