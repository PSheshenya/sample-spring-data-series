--drop table Foo;

create table Foo (
    id IDENTITY,
    name VARCHAR(200),
    dob DATE,
    email VARCHAR(100),
    constraint pk_foo primary key (id)
);
----
create table Master (
    id IDENTITY,
    name VARCHAR(200),
    foo INTEGER,
    foo_key VARCHAR(200)
);

create table Detail (
    id IDENTITY,
    name VARCHAR(200),
    master INTEGER,
    master_key VARCHAR(200)
);
----
----
create table Book (
    id IDENTITY,
    title VARCHAR(200),


    created_by VARCHAR(200),
    created_at DATE,
    updated_by VARCHAR(200),
    update_at DATE
);

create table Author (
    id IDENTITY,
    name VARCHAR(200)
);

create table Book_Author (
    book INTEGER,
    author INTEGER
);
----