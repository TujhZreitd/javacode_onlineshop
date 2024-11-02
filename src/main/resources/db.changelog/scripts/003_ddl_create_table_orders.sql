create table orders(
    id serial primary key,
    customer_id int references customers(id) not null,
    order_date date default current_date,
    shipping_address varchar not null,
    total_price double precision,
    order_status varchar not null
)