package com.airbnb.listing_service.command.data.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@Entity
@Table(name = "listing_images")
@FieldDefaults(level = AccessLevel.PRIVATE)
@Data
public class ListingImage {
    @Id
    String id;
    @Column(name = "listing_id")
    String listingId;
    @Column(name = "url")
    String URL;
}
