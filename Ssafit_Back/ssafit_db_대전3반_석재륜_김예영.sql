create schema if not exists ssafit;
use ssafit;

create table if not exists user(
    id varchar(30) not null primary key,
    password varchar(45) not null
);

create table if not exists video(
    video_id varchar(45) not null primary key,
    title varchar(256) not null, 
    part_name varchar(10) not null,
    channel_name varchar(45) not null,
    video_url varchar(1024) not null,
    img_source varchar(1024) not null
);

create table if not exists comment(
	user_id varchar(30) not null,
	video_id varchar(45) not null,
	comment_title varchar(45) not null,
    comment_content varchar(1024) not null,
    view_cnt int(10) default 0,
    reg_date DATETIME not null default CURRENT_TIMESTAMP,
    primary key (user_id, reg_date),
    constraint `user_idfk`
    foreign key (`user_id`)
    references `ssafit`.`user`(`id`)
    on delete cascade
    on update cascade,
    constraint `video_idfk`
    foreign key (`video_id`)
    references `ssafit`.`video`(`video_id`)
    on delete cascade
    on update cascade
);

