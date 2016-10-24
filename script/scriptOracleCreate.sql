create sequence hibernate_sequence start with 1 increment by 1;

    create table T_MANAGER (
        id number(19,0) not null,
        first_name varchar2(255 char),
        last_name varchar2(255 char),
        restaurant_id number(19,0) not null,
        primary key (id)
    );

    create table T_ORDER (
        id number(19,0) not null,
        title varchar2(255 char),
        restaurant_id number(19,0),
        primary key (id)
    );

    create table T_RESTAURANT (
        id number(19,0) not null,
        name varchar2(255 char),
        primary key (id)
    );

    alter table T_MANAGER
        add constraint UK_clksxwt9uo8mfxqfbaqe6pvsq unique (restaurant_id);

    alter table T_MANAGER
        add constraint RESTAURANT_ID_FK
        foreign key (restaurant_id)
        references T_RESTAURANT;

    alter table T_ORDER
        add constraint RESTAURANT_ID_FK
        foreign key (restaurant_id)
        references T_RESTAURANT;
