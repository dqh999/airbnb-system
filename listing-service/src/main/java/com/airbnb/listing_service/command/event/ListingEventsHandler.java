package com.airbnb.listing_service.command.event;

import com.airbnb.listing_service.command.data.entity.Listing;
import org.axonframework.eventhandling.EventHandler;
import org.springframework.stereotype.Component;

@Component
public class ListingEventsHandler {

    @EventHandler
    public void on(ListingCreatedEvent event){
        Listing listing = new Listing();
    }
}
