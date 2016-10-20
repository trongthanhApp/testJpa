
--DROP

 
    drop table T_MANAGER cascade constraints;

    drop table T_RESTAURANT cascade constraints;

    drop sequence hibernate_sequence;


--CREATE

 create sequence hibernate_sequence start with 1 increment by 1;

    create table T_MANAGER (
        id number(19,0) not null,
        first_name varchar2(255 char),
        last_name varchar2(255 char),
        id_restaurant number(19,0) not null,
        primary key (id)
    );

    create table T_RESTAURANT (
        id number(19,0) not null,
        name varchar2(255 char),
        primary key (id)
    );

    alter table T_MANAGER 
        add constraint UK_6gx2nc5en60fdumqe1a0ex3y1 unique (id_restaurant);

    alter table T_MANAGER 
        add constraint FKofm1kvlunmobdpdfnyl8m3vx6 
        foreign key (id_restaurant) 
        references T_RESTAURANT;






