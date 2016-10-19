
--DROP

 drop table t_restaurant cascade constraints;

 drop sequence hibernate_sequence

--CREATE

 create table t_restaurant (
        id number(10,0) not null,
        title varchar2(255 char),
        primary key (id)
    );






