Drop schema if EXISTS ssafit;
create schema if not exists ssafit;
use ssafit;

create table if not exists users(
    id varchar(30) not null primary key,
    password varchar(45) not null,
    nickname varchar(45) not null unique,
    name varchar(20) not null,
    email varchar(45) not null unique
);

create table if not exists jjim(
	jjim_id INT not null AUTO_INCREMENT,
    user_id varchar(30) not null,
    video_id varchar(45) not null,
    video_title varchar(256) not null,
    channel_name varchar(45) not null,
    publish_time varchar(1024) not null,
    img_source varchar(1024) not null,
    primary key (jjim_id, user_id, video_id),
    constraint `fk_user_id`
    foreign key (`user_id`)
    references `ssafit`.`users`(`id`)
    on delete cascade
    on update cascade
);

create table if not exists comment(
	review_id INT not null AUTO_INCREMENT,
	user_id varchar(30) not null,
	video_id varchar(45) not null,
    video_title varchar(256) not null,
	channel_name varchar(45) not null,
    comment_content varchar(1024) not null,
    view_cnt int(10) default 0,
    reg_date DATETIME not null default CURRENT_TIMESTAMP,
    primary key (review_id, user_id, video_id),
    constraint `fk_user_id_comment`
    foreign key (`user_id`)
    references `ssafit`.`users`(`id`)
    on delete cascade
    on update cascade
);
create table if not exists plans(
	user_id varchar(30) not null,
    plan_reg_date DATETIME not null default CURRENT_TIMESTAMP,
    plan_expire_date DATETIME not null default CURRENT_TIMESTAMP,
    plan varchar(45) not null,
    is_ok boolean not null default false,
    primary key (user_id, plan_reg_date, plan),
    constraint `user_idfk`
    foreign key (`user_id`)
    references `ssafit`.`users`(`id`)
    on delete cascade
    on update cascade
);

create table if not EXISTS friendships(
	friendship_id INT PRIMARY KEY AUTO_INCREMENT,
    user1_id VARCHAR(30) NOT NULL,
    user2_id VARCHAR(30) NOT NULL,
    status ENUM('pending', 'accepted') DEFAULT 'pending',
    CONSTRAINT `fk_user1_id`
        FOREIGN KEY (`user1_id`)
        REFERENCES `ssafit`.`users`(`id`)
        ON DELETE CASCADE
        ON UPDATE CASCADE,
    CONSTRAINT `fk_user2_id`
        FOREIGN KEY (`user2_id`)
        REFERENCES `ssafit`.`users`(`id`)
        ON DELETE CASCADE
        ON UPDATE CASCADE
);

DELIMITER //
CREATE PROCEDURE generateUsers(IN numUsers INT)
BEGIN
    DECLARE i INT DEFAULT 1;
    
    WHILE i <= numUsers DO
        INSERT INTO users (id, password, nickname, name, email)
        VALUES (CONCAT('user', i), CONCAT('pass', i), CONCAT('nick', i), CONCAT('name', i), CONCAT('e@', i));
        
        SET i = i + 1;
    END WHILE;
END //
DELIMITER ;

-- 프로시저 호출
CALL generateUsers(7);