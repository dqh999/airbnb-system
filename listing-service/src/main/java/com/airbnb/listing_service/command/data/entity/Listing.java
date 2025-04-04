package com.airbnb.listing_service.command.data.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@Entity
@Table(name = "listings")
@FieldDefaults(level = AccessLevel.PRIVATE)
@Data
public class Listing {
    @Id
    String id;
    @Column(name = "host_id")
    String hostId;
    String title;
    String description;
    double price;
    String location;
}
