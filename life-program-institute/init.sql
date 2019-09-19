create database life_program_institute;
use database life_program_institute;
create table `user`(
    user_id varchar(32) not null,
    user_name varchar(30) not null,
    birthday varchar(20),
    height int COMMENT '身高/cm',
    weight int COMMENT '体重/斤',
    create_time timestamp default now(),
    update_time timestamp default current_timestamp on update current_timestamp ,
    password varchar(32) not null,
    delete_flag int default 0,
    primary key (user_id)
);

create table `user_skill`(
    user_skill_id varchar(32) not null,
    skill_id varchar(32) not null,
    user_id varchar(32) not null,
    exp int default 0,
    create_time timestamp default now(),
    update_time timestamp default current_timestamp on update current_timestamp ,
    delete_flag int default 0,
    primary key (user_skill_id)
);

create table `skill`(
    skill_id varchar(32) not null,
    skill_name varchar(30) not null,
    skill_desc varchar(100),
    create_time timestamp default now(),
    update_time timestamp default current_timestamp on update current_timestamp ,
    delete_flag int default 0,
    primary key(skill_name)
);

create table `article`(
    article_id varchar(32) not null,
    article_name varchar(50) not null,
    user_skill_id varchar(32) not null,
    article_content LONGTEXT not null,
    article_desc varchar(50),
    create_time timestamp default now(),
    update_time timestamp default current_timestamp on update current_timestamp ,
    delete_flag int default 0,
    primary key (article_id)
);