DROP TABLE IF EXISTS 
    "type",
    vendor,
    item,
    product
CASCADE;

CREATE TABLE IF NOT EXISTS "type" (
    type_id serial,
    name varchar(35),
    CONSTRAINT pk_type PRIMARY KEY (type_id)
);

CREATE TABLE IF NOT EXISTS vendor (
    vendor_id serial,
    name text UNIQUE,
    CONSTRAINT pk_vendor PRIMARY KEY (vendor_id)
);

CREATE TABLE IF NOT EXISTS item (
    item_id serial,
    type_id int,
    name text,
    CONSTRAINT pk_item PRIMARY KEY (item_id),
    CONSTRAINT fk_item_type_id FOREIGN KEY (type_id) REFERENCES "type" (type_id)
);

CREATE TABLE IF NOT EXISTS product (
    product_id serial,
    parent_id int,
    amount int,
    price float,
    vendor_id int,
    CONSTRAINT pk_product PRIMARY KEY (product_id),
    CONSTRAINT fk_product_vendor_id FOREIGN KEY (vendor_id) REFERENCES vendor (vendor_id),
    CONSTRAINT fk_product_product_id FOREIGN KEY (parent_id) REFERENCES product (product_id)
);

