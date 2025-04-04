package com.airbnb.listing_service.command.event;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.experimental.FieldDefaults;

@FieldDefaults(level = AccessLevel.PRIVATE)
@Getter
@AllArgsConstructor
public class ListingCreatedEvent {
    String id;
    String hostId;
    String title;
    String description;
    double price;
    String location;
}