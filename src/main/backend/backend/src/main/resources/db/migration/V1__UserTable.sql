create table Users (
    Id UUID not null unique,
    username varchar(255) not null unique,
    first_name varchar(255),
    last_name varchar(255),
    password varchar(255) not null,
    email varchar(255) not null,
    create_date varchar(255) not null,
    create_time varchar(255) not null

);