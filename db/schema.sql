create table accident
(
    id      serial primary key,
    address varchar(255),
    name    varchar(255),
    text    varchar(255)
);

insert into accident(address, name, text)
values ('ул. Большая Сухаревская 11', 'Petr Arsentev', 'Превышение скорость на  60 км/ч ');
insert into accident(address, name, text)
values ('ул. Охотный ряд 115', 'Ivan Sobolev', 'Проезд на красный свет');
insert into accident(address, name, text)
values ('ул. Обводной Вал 17', 'Fedor Semenov', 'Расположение транспортных средств на проезжей части');

create table accident_types
(
    id          serial primary key,
    name        varchar(255),
    accident_id int references accident (id)
);

create table rules
(
    id          serial primary key,
    name        varchar(255),
    accident_id int references accident (id)
);

insert into accident_types (name, accident_id)
values ('Две машины', 1);
insert into accident_types (name, accident_id)
values ('Машина и человек', 2);
insert into accident_types (name, accident_id)
values ('Машина и велосипед', 3);

insert into rules (name, accident_id)
values ('Статья. 1', 1);
insert into rules (name, accident_id)
values ('Статья. 2', 1);
insert into rules (name, accident_id)
values ('Статья. 2', 2);
insert into rules (name, accident_id)
values ('Статья. 3', 3);

