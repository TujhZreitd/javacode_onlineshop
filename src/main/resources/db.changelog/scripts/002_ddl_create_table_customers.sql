create table customers(
    id serial primary key,
    first_name varchar not null,
    last_name varchar not null,
    email varchar not null,
    contact_number varchar
)