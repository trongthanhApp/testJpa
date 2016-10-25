create sequence hibernate_sequence start with 1 increment by 1;

    create table T_ASSO_CUSTOMER_ORDER (
        customer_id number(19,0) not null,
        order_id number(19,0) not null
    );

    create table T_CUSTOMER (
        id number(19,0) not null,
        firstName varchar2(255 char),
        lastName varchar2(255 char),
        primary key (id)
    );

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

    alter table T_ASSO_CUSTOMER_ORDER
        add constraint ASSO_CUST_ORD_ORDER_ID_FK
        foreign key (order_id)
        references T_ORDER;

    alter table T_ASSO_CUSTOMER_ORDER
        add constraint ASSO_CUST_ORD_CUSTOMER_ID_FK
        foreign key (customer_id)
        references T_CUSTOMER;

    alter table T_MANAGER
        add constraint MANAGER_RESTAURANT_ID_FK
        foreign key (restaurant_id)
        references T_RESTAURANT;

    alter table T_ORDER
        add constraint ORDER_RESTAURANT_ID_FK
        foreign key (restaurant_id)
        references T_RESTAURANT;
