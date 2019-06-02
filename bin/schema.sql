create table customer
(
   customerId IDENTITY NOT NULL,
   name varchar(255) not null,
   surname varchar(255) not null,
   primary key(customerId)
);

create table account(
   accountId IDENTITY NOT NULL,
   customerId integer not null,
   initialCredit decimal not null,
   description varchar(255) not null,
   primary key(accountId)
);

create table transaction(
   transactionId IDENTITY NOT NULL,
   accountId integer not null,
   status varchar(25),
   type varchar(25),
   amount decimal not null,
   description varchar(255) not null,
   primary key(transactionId)
);