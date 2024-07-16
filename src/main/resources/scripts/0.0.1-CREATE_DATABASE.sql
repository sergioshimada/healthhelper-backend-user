--CREATE CUSTOMER DB


DROP SCHEMA IF EXISTS "user";

CREATE SCHEMA "user";

CREATE TABLE customer.customer (
                                   id int8 NOT NULL,
                                   address varchar(255) NOT NULL,
                                   birth_date date NOT NULL,
                                   cellphone varchar(255) NOT NULL,
                                   cep varchar(255) NOT NULL,
                                   city varchar(255) NOT NULL,
                                   complement varchar(255) NULL,
                                   cpf varchar(255) NOT NULL,
                                   creation_date timestamp NOT NULL,
                                   gender varchar(255) NOT NULL,
                                   indication varchar(255) NULL,
                                   last_update timestamp NOT NULL,
                                   "name" varchar(255) NOT NULL,
                                   "number" varchar(255) NOT NULL,
                                   state varchar(255) NOT NULL,
                                   telephone varchar(255) NULL,
                                   uuid uuid NOT NULL,
                                   CONSTRAINT customer_pkey PRIMARY KEY (id)
);