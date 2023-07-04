package com.HarmyFounder.HIeffect.services;

import com.HarmyFounder.HIeffect.models.Event;
import com.HarmyFounder.HIeffect.repositories.EventRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class EventService {

    @Autowired
    private EventRepository eventRepository;

    public List<Event> getAll() {
        return eventRepository.findAll();
    }

    public List<Event> getByTag(String filter){
        return eventRepository.findByTag(filter);
    }

    public Event create(Event event) {
        event.setCreationDate(LocalDateTime.now());
        return eventRepository.save(event);
    }

    public Event update(Event eventToBEUpdated, Event updatedEvent){
        BeanUtils.copyProperties(updatedEvent,eventToBEUpdated,"id");
        return eventRepository.save(eventToBEUpdated);
    }

    public void delete(Event event){
        eventRepository.delete(event);
    }

}
