create sequence reservation_number_seq start with 1 increment by 1;

create table reservations (
    id bigint not null,
    guest_name varchar(255),
    reservation_time timestamp(6),
    room_number integer,
    primary key (id)
);

create table rooms (
    number integer not null,
    available boolean not null,
    beds integer not null,
    primary key (number)
);

alter table reservations add constraint FK2dewdw0feead4ww0r1rhe33yx foreign key (room_number) references rooms;
