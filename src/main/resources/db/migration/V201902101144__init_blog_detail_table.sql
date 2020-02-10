create table `blog_detail`(
	id bigint(20) primary key auto_increment,
	type varchar(50),
	word_number bigint(20),
	author varchar(10)
) default charset utf8;