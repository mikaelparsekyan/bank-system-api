package com.mikaelparsekyan.common.dto;

import com.mikaelparsekyan.common.enumeration.EventStatus;
import com.mikaelparsekyan.common.enumeration.EventType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class EventDTO {
    
    private EventStatus status = EventStatus.UNKNOWN; 

    @NotNull
    private EventType type;

    @NotNull
    private String userId;
}
