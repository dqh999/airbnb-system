package com.airbnb.listing_service.command.aggregate;

import com.airbnb.listing_service.command.command.CreateListingCommand;
import com.airbnb.listing_service.command.event.ListingCreatedEvent;
import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.modelling.command.AggregateIdentifier;

import static org.axonframework.modelling.command.AggregateLifecycle.apply;

@FieldDefaults(level = AccessLevel.PRIVATE)
@Data
@NoArgsConstructor
public class ListingAggregate {
    @AggregateIdentifier
    String id;
    String hostId;
    String title;
    String description;
    double price;
    String location;

    @CommandHandler
    public ListingAggregate(CreateListingCommand command) {
        apply(new ListingCreatedEvent(
                command.getId(),
                command.getHostId(),
                command.getTitle(),
                command.getDescription(),
                command.getPrice(),
                command.getLocation()
        ));
    }

    @EventSourcingHandler
    public void on(ListingCreatedEvent event) {
        this.id = event.getId();
        this.hostId = event.getHostId();
        this.title = event.getTitle();
        this.description = event.getDescription();
        this.price = event.getPrice();
        this.location = event.getLocation();
    }

}
