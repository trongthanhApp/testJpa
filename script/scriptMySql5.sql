--DROP

drop table if exists t_restaurant;

--CREATE

create table t_restaurant (
        id integer not null auto_increment,
        title varchar(255),
        primary key (id)
    );
    
    
    
    