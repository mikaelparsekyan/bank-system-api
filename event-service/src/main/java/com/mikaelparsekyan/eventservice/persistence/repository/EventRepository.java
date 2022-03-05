package com.mikaelparsekyan.eventservice.persistence.repository;

import com.mikaelparsekyan.eventservice.persistence.model.Event;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface EventRepository extends JpaRepository<Event, UUID> {

}
