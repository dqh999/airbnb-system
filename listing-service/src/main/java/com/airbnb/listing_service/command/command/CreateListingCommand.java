package com.airbnb.listing_service.command.command;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;
import org.axonframework.modelling.command.TargetAggregateIdentifier;

@FieldDefaults(level = AccessLevel.PRIVATE)
@Data
public class CreateListingCommand {
    @TargetAggregateIdentifier
    String id;
    String hostId;
    String title;
    String description;
    double price;
    String location;

    public CreateListingCommand(String hostId, String title, String description, double price, String location) {
        this.id = java.util.UUID.randomUUID().toString();
        this.hostId = hostId;
        this.title = title;
        this.description = description;
        this.price = price;
        this.location = location;
    }
}
