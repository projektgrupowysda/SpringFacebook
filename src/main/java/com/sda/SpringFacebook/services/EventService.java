package com.sda.SpringFacebook.services;

import com.sda.SpringFacebook.model.Event;
import com.sda.SpringFacebook.request.CreateEventRequest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface EventService {

    void createEvent(CreateEventRequest request);

    void addToGuestsList(String idEvent, String userToAddId);

    Page<Event> findAllEvents(Pageable pageable);


}
