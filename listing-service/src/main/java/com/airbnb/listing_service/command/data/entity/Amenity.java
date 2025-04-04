package com.airbnb.listing_service.command.data.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@Entity
@Table(name = "amenities")
@FieldDefaults(level = AccessLevel.PRIVATE)
@Data
public class Amenity {
    @Id
    String id;
    String name;
}
