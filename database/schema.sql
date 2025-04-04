create table roles
(
    id   varchar(45) primary key,
    name varchar(45) not null
);
create table users
(
    id            varchar(45) primary key,
    role_id       varchar(45) not null,
    full_name     varchar(45) not null,
    email         varchar(45) not null,
    provider_type varchar(45) not null,
    provider_id   varchar(45) not null
);
create table listings
(
    id          varchar(45) primary key,
    host_id     varchar(45)    not null,
    title       varchar(45)    not null,
    description varchar(255),
    thumbnail   text,
    price       decimal(10, 2) not null,
    location    varchar(255)   not null
);
create table listing_images
(
    id         varchar(45) primary key,
    listing_id varchar(45) not null,
    url        text,
    foreign key (listing_id) references listings (id)
);
create table amenities
(
    id   varchar(45) primary key,
    name varchar(45) not null
);
create table listing_amenities
(
    id         varchar(45) primary key,
    listing_id varchar(45) not null,
    amenity_id varchar(45) not null,
    foreign key (listing_id) references listings (id),
    foreign key (amenity_id) references amenities (id)
);
create table bookings
(
    id         varchar(45) primary key,
    listing_id varchar(45) not null,
    user_id    varchar(45) not null,
    start_date date        not null,
    end_date   date        not null
);
create table payments
(
    id         varchar(45) primary key,
    booking_id varchar(45)    not null,
    amount     decimal(10, 2) not null,
    status     varchar(20)    not null
);