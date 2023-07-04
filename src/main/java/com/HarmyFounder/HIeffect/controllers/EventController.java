package com.HarmyFounder.HIeffect.controllers;

import com.HarmyFounder.HIeffect.models.Event;
import com.HarmyFounder.HIeffect.models.User;
import com.HarmyFounder.HIeffect.services.EventService;
import com.HarmyFounder.HIeffect.services.MailSendService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import javax.mail.MessagingException;
import java.util.List;

@RestController
@RequestMapping("/events")
public class EventController {

    @Autowired
    private EventService eventService;

    @Autowired
    private MailSendService mailSendService;


    @GetMapping("/all")
    public List<Event> getAll(){
        return eventService.getAll();
    }

    @GetMapping("/{id}")
    public Event getCertain(@PathVariable("id") Event event){
        return event;
    }

    @PostMapping("/create")
    public Event createEvent(@RequestBody Event event, @RequestParam int hour, @RequestParam int minute, @AuthenticationPrincipal User user) throws MessagingException {
        mailSendService.sendMessageNotification(user,hour,minute);
        return eventService.create(event);
    }

    @PostMapping("/findByTag")
    public List<Event> getByTag(@RequestParam String filter){
        return eventService.getByTag(filter);
    }

    @PutMapping("/{id}/edit")
    public Event updateEvent(@PathVariable("id")Event eventToBeUpdated, @RequestBody Event updatedEvent){
        return eventService.update(eventToBeUpdated,updatedEvent);
    }

    @DeleteMapping("/{id}")
    public void deleteEvent(@PathVariable("id")Event event){
        eventService.delete(event);
    }



}
