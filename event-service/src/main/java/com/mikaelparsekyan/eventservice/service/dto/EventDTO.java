package com.mikaelparsekyan.eventservice.service.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class EventDTO {

    @NotNull
    private String status;

    @NotNull
    private String userId;
}
