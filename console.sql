-- create table main_schema.employee (
--     id serial primary key not null,
--     uuid varchar(36),
--     firstname varchar not null,
--     lastname varchar not null
-- )

-- create  table main_schema.sections(
--     id serial primary key not null,
--     name varchar(2) UNIQUE not null
-- );

-- create  table main_schema.accesses (
--   id serial primary key not null ,
--   md5_access_code char(32) unique,
--   access_section integer[] not null,
--   access_rooms integer[] not null
-- );
insert into main_schema.sections (name)
values ('D');

insert into main_schema.rooms (name, section_id)
values ('1', 5);
insert into main_schema.rooms (name, section_id)
values ('2', 5);
insert into main_schema.rooms (name, section_id)
values ('3', 5);
insert into main_schema.rooms (name, section_id)
values ('4', 5);
--
-- create  table main_schema.rooms(
--     id serial primary key not null ,
--     name varchar(2) UNIQUE not null
-- );

SELECT generate_series(1, 2) AS id, md5('dfdsf') AS descr;

create table some_table
(
    some_column varchar[][]
);

insert into some_table (some_column)
values ('{{S1,S2},{7,8,8}}');

-- MD5 update /////////////////
create or replace function generate_md5() returns trigger as
$$
begin
    update accesses set md5_access_code = md5(rooms::text) WHERE id = NEW.id;
    return new;
end ;
$$ LANGUAGE plpgsql;

create or replace trigger md5_access_trigger
    after INSERT
    ON accesses
    for each row
execute function generate_md5();
-- insert into main_schema.accesses (sections, rooms, access_name)
-- VALUES (Array [1], Array [1,2,3], 'S1_1,2,3');
-- MD5 update /////////////////
-- generate md5 access


-- update dateTime
create or replace function update_datetime_card() returns trigger as

$$
begin
    update employee_card
    set created_at = now()::timestamp(0),
        expires_in = now()::timestamp(0) + interval '1 year'
    where id = new.id;

    return new;
end;

$$ LANGUAGE plpgsql;

create or replace trigger update_create_expires_card
    after insert
    on employee_card
    for each row
execute function update_datetime_card();
-- update dateTime


create or replace function generate_room_name() returns trigger as

$$
declare
    section_name varchar;
    room_count   int;
begin
    section_name = (Select sections.name
                    from sections,
                         rooms
                    where new.section_id = sections.id
                    limit 1);
    room_count = (select count(*) from rooms where section_id = new.section_id);

    update rooms
    set name = concat(section_name::text, room_count::text)
    where id = new.id;
    return new;
end;
$$ LANGUAGE plpgsql;


create or replace trigger update_room_name
    after insert
    on rooms
    for each row
execute function generate_room_name();


ALTER sequence accesses_id_seq restart with 1;

-- add sections
insert into sections (name)
values ('D');

-- add rooms
insert into rooms (section_id)
values (4);

-- add employee
insert into employee (firstname, lastname)
VALUES ('Dzyba', 'Andrei');


-- add access
insert into accesses (rooms, access_name)
values (Array ['A1','B1','C1'], 'A1,B1,C1');

-- add card
insert into employee_card (user_id, is_active, access_id)
values (2, false, 2);

insert into employee_card (user_id,is_active,access_id) values ( 1 , false, 2);

select count(*)
from rooms
where section_id = 1;

insert into rooms (section_id)
values (5);

insert into main_schema.employee_card(user_id, is_active, access_id)
VALUES (12, true, 6707);


select *
from employee,
     employee_card,
     accesses
where employee.id = employee_card.user_id;

select *
from main_schema.rooms,
     main_schema.sections
where sections.name = 'C'
  and section_id = sections.id;

-- insert into main_schema.employee (firstname,lastname) values ('Dzuba','Andrey');

alter table main_schema.employee_card
    ADD FOREIGN KEY (access_id) REFERENCES accesses (id);

-- INSERT INTO main_schema.employee_card (UUID, CREATED_AT, EXPIRES_IN,user_id,is_active)
-- VALUES ('57be3908-a3be-4ae0-a878-8c196480a449',now()::timestamp(0),now()::timestamp(0)+ interval '1 year',1,true);
-- select now() + interval '1 year';

-- update main_schema.employee set uuid = sele

--
-- SELECT now()::timestamp(0);
-- select  *  from main_schema.employee_card where user_id = 1

insert into main_schema.employee (firstname, lastname)
VALUES ('Averchich', 'Natalya');

