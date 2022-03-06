package com.mikaelparsekyan.eventservice.controller;

import com.mikaelparsekyan.common.util.ResponseObject;
import com.mikaelparsekyan.eventservice.service.EventService;
import com.mikaelparsekyan.eventservice.service.dto.EventDTO;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity saveEvent(@RequestBody @Valid EventDTO eventDTO) {
        EventDTO savedDto = this.eventService.saveEvent(eventDTO);
        return new ResponseEntity<>(ResponseObject.build(savedDto, "Successfully saved event."), HttpStatus.OK);
    }
}
