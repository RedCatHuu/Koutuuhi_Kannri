
DROP TABLE IF EXISTS Traffic;

create table IF NOT EXISTS Users (
	id identity primary key,
	name varchar(40) NOT NULL,
	mail varchar(80) NOT NULL,
	password varchar(60) NOT NULL,
	role char(1) NOT NULL,
	create_date timestamp,
	update_date timestamp,
	delete_date timestamp
);


create table Traffic (
	trafficid identity primary key,
	user_id BIGINT NOT NULL,
	dateofuse date NOT NULL,
	means varchar(255) NOT NULL,
	sector varchar(255) NOT NULL,
	road char(1) NOT NULL,
	cost int NOT NULL,
	constraint fk_user foreign key (user_id) references Users(id)
);