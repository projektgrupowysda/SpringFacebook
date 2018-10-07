package com.sda.SpringFacebook.controller;

import com.sda.SpringFacebook.model.Event;
import com.sda.SpringFacebook.request.CreateEventRequest;
import com.sda.SpringFacebook.services.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
public class EventController {
    private EventService eventService;

    @Autowired
    public EventController(EventService eventService) {
        this.eventService = eventService;
    }

    @PostMapping("/createEvent")
    @ResponseStatus(HttpStatus.CREATED)
    public void createEvent(@RequestBody CreateEventRequest request) {
        eventService.createEvent(request);
    }

    @GetMapping("/showAllEvents")
    public Page<Event> findAll(@PageableDefault(size = 10) Pageable pageable) {
        return eventService.findAllEvents(pageable);
    }

    @GetMapping("/{idEvent}/addGuest/{userToAddId}")
    public void addToGuestList(@PathVariable String idEvent, @PathVariable String userToAddId) {
        eventService.addToGuestsList(idEvent, userToAddId);
    }
}
