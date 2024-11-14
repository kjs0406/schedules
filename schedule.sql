create table schedules
(
    schedule_id bigint auto_increment primary key,
    user_name    varchar(20)  not null,
    title       varchar(50)  not null,
    content     varchar(255) not null,
        foreign key (user_name) references user (user_name)
);

create table user
(
    user_id   bigint auto_increment primary key,
    user_name varchar(20)  not null unique,
    password  varchar(50)  not null,
    email     varchar(100) not null
);
