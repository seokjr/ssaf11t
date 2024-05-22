Drop schema if EXISTS ssafit;
create schema if not exists ssafit;
use ssafit;

create table if not exists users(
    id varchar(30) not null primary key,
    password varchar(45) not null,
    nickname varchar(45) not null unique,
    name varchar(20) not null,
    email varchar(45) not null unique,
    profile_image varchar(45) not null default 'jumping_cat.jpg'
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
        ON UPDATE CASCADE,
	CONSTRAINT `unique_friendship`
        UNIQUE (`user1_id`, `user2_id`)
);

DELIMITER //

CREATE PROCEDURE generateUsers(IN numUsers INT)
BEGIN
    DECLARE i INT DEFAULT 1;
	DECLARE profileImage VARCHAR(20);

    WHILE i <= numUsers DO
        CASE i
            WHEN 1 THEN SET profileImage = 'first.jpg';
            WHEN 2 THEN SET profileImage = 'second.jpg';
            WHEN 3 THEN SET profileImage = 'third.jpg';
            WHEN 4 THEN SET profileImage = 'fourth.jpg';
            WHEN 5 THEN SET profileImage = 'fifth.jpg';
            ELSE SET profileImage = null;
        END CASE;

        INSERT INTO users (id, password, nickname, name, email, profile_image)
        VALUES (CONCAT('user', i), CONCAT('pass', i), CONCAT('nick', i), CONCAT('name', i), CONCAT('e@', i), profileImage);
        
        SET i = i + 1;
    END WHILE;
END //

DELIMITER ;

-- 프로시저 호출
CALL generateUsers(5);

INSERT INTO users (id, password, nickname, name, email)
VALUES ('ssafy', '1234', '싸피', '김싸피', 'ssafy@ssafy.com'),
('test', 'test', '테스트', '김싸피', 'test@ssafy.com'),
('admin', 'admin', '관리자', '김싸피', 'admin@ssafy.com'),
('ssafy123', '1234', '싸피123', '김싸피', 'ssafy123@ssafy.com');

create table if not exists guilds(
    guild_name varchar(30) not null primary key,
    tag varchar(20) not null,
    reg_date DATETIME not null default CURRENT_TIMESTAMP
);

create table if not exists guild_users(
    guild_name varchar(30) not null,
    user_id varchar(30) not null,
    status ENUM('member', 'master') DEFAULT 'member',
    primary key (guild_name, user_id),
    CONSTRAINT `fk_guild_user_id`
	FOREIGN KEY (`user_id`)
	REFERENCES `ssafit`.`users`(`id`)
	ON DELETE CASCADE
	ON UPDATE CASCADE,
    CONSTRAINT `fk_guild_name`
	FOREIGN KEY (`guild_name`)
	REFERENCES `ssafit`.`guilds`(`guild_name`)
	ON DELETE CASCADE
	ON UPDATE CASCADE
);
create table if not exists guild_boards(
    guild_name varchar(30) not null,
    user_id varchar(30) not null,
    board_title varchar(1024) not null,
    board_content varchar(1024) not null,
    view_cnt int(10) default 0,
    reg_date DATETIME not null default CURRENT_TIMESTAMP,
    primary key (guild_name, user_id, reg_date),
    CONSTRAINT `guild_user_id_fk`
	FOREIGN KEY (`user_id`)
	REFERENCES `ssafit`.`users`(`id`)
	ON DELETE CASCADE
	ON UPDATE CASCADE,
    CONSTRAINT `guild_name_fk`
	FOREIGN KEY (`guild_name`)
	REFERENCES `ssafit`.`guilds`(`guild_name`)
	ON DELETE CASCADE
	ON UPDATE CASCADE
);
