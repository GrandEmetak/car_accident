CREATE TABLE accident_types
(
    id   serial primary key,
    name varchar(2000)
);

CREATE TABLE rules
(
    id   serial primary key,
    name varchar(2000)
);

insert into accident_types (name)
values ('Две машины');
insert into accident_types (name)
values ('Машина и человек');
insert into accident_types (name)
values ('Машина и велосипед');

insert into rules (name)
values ('Статья. 1');
insert into rules (name)
values ('Статья. 2');
insert into rules (name)
values ('Статья. 3');

CREATE TABLE accident
(
    id               serial primary key,
    name             varchar(2000),
    text             varchar(2000),
    address          varchar(2000),
    accident_type_id int NOT NULL references accident_types (id),
    rule_id          INT NOT NULL REFERENCES rules (id)
);

insert into accident(name, text, address, accident_type_id, rule_id)
values ('Petr Arsentev', 'Превышение скорость на  60 км/ч ', 'ул. Большая Сухаревская 11', 1, 1);
insert into accident(name, text, address, accident_type_id, rule_id)
values ('Ivan Sobolev', 'Проезд на красный свет', 'ул. Охотный ряд 115', 1, 2);
insert into accident(name, text, address, accident_type_id, rule_id)
values ('Fedor Semenov', 'Расположение транспортных средств на проезжей части', 'ул. Обводной Вал 17', 1, 3);