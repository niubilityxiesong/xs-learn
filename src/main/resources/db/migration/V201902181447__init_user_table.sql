create table `user`(
	id bigint(20) primary key auto_increment,
	username varchar(50),
    password varchar(50),
	introduce varchar(200),
	article_number int(20)
) default charset utf8;