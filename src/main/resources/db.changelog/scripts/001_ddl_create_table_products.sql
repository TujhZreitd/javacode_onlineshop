create table products(
    id serial primary key,
    name varchar not null,
    description varchar not null,
    price double precision,
    quantity_stock int
)