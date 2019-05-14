create table receipts
(
  receipt_id    int auto_increment
    primary key,
  receipt_name  varchar(50)                not null,
  receipt_price decimal(8, 2) default 0.00 not null,
  receipt_date  datetime                   not null
);

create table residents
(
  resident_id  int         not null,
  login        varchar(50) not null,
  password     varchar(50) not null,
  name         varchar(50) null,
  surname      varchar(50) null,
  phone_number varchar(12) null,
  constraint residents_resident_id_uindex
    unique (resident_id)
);

create table debts
(
  debt_id     int                        not null,
  debt_amount decimal(8, 2) default 0.00 null,
  resident_id int                        not null,
  receipt_id  int                        not null,
  constraint debts_debt_id_uindex
    unique (debt_id),
  constraint debts_resident_id_uindex
    unique (resident_id),
  constraint debts_receipts_receipt_id_fk
    foreign key (receipt_id) references receipts (receipt_id),
  constraint debts_receipts_resident_id_fk
    foreign key (resident_id) references residents (resident_id)
);

alter table debts
  add primary key (debt_id);

create table straightens
(
  straighten_id int        not null
    primary key,
  deadline      date       not null,
  is_cleaned    tinyint(1) null,
  resident_id   int        not null,
  constraint straightens_fk
    foreign key (resident_id) references residents (resident_id)
);

CREATE TABLE `roles` (
  `role_id` int(11) NOT NULL AUTO_INCREMENT,
  `role` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`role_id`)
);

INSERT INTO `roles` (`role_id`, `role`)
VALUES
	(1,'ADMIN'),(0,'USER');

CREATE TABLE `resident_roles` (
  `resident_id` int(11) NOT NULL,
  `role_id` int(11) NOT NULL,
  PRIMARY KEY (`resident_id`,`role_id`),
  CONSTRAINT `FK_RESIDENT_ID` FOREIGN KEY (`resident_id`) REFERENCES `residents` (`resident_id`),
  CONSTRAINT `FK_ROLE_ID` FOREIGN KEY (`role_id`) REFERENCES `roles` (`role_id`)
);

INSERT INTO `residents` (`resident_id`,`login`,`password`,`name`,`surname`,`phone_number`)
VALUES('1','resadmin','respassword','Adminisław','Admowski','788555222'),
      ('2','resuser','respassword','User','Userski','+48233444333');

INSERT INTO `resident_roles` (`resident_id`, `role_id`)
VALUES(1,1),
      (2,0);

