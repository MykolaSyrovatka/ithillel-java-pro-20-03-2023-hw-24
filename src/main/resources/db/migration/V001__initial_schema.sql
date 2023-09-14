CREATE TABLE "order" (
                         "id" SERIAL,
                         "date" TIMESTAMP,
                         "cost" DOUBLE PRECISION,
                         PRIMARY KEY (id)
);

CREATE TABLE "product" (
                           "id" SERIAL,
                           "name" VARCHAR (50),
                           "cost" DOUBLE PRECISION,
                           PRIMARY KEY (id)
);

CREATE TABLE "order_product" (
                                 "id" SERIAL,
                                 "order_id" INT,
                                 "product_id" INT,
                                 PRIMARY KEY (id),
                                 FOREIGN KEY (order_id) REFERENCES "order"(id),
                                 FOREIGN KEY (product_id) REFERENCES "product"(id)
);