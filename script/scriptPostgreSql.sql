set schema 'testJpa';

--DROP

drop table if exists t_restaurant cascade;

--CREATE

create table t_restaurant (
        id  serial not null,
        title varchar(255),
        primary key (id)
    );

