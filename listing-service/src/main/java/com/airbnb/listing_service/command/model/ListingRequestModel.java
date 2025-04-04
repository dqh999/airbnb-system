package com.airbnb.listing_service.command.model;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@FieldDefaults(level = AccessLevel.PRIVATE)
@Data
public class ListingRequestModel {
    String id;
    String ownerId;
    String title;
    String description;
    double price;
    String address;
}
