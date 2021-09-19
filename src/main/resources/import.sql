insert into role values (1, 'ROLE_USER');
insert into role values (2, 'ROLE_ADMIN');

insert into user(id, name, username, password, enabled) values (100, "jame", "jame", "$2a$10$dGGZGOCVNtpkvBdwPNH3K.O0EMVbgRcPz0y/CPq0cW9jcXw7YR8Wi", true);
insert into user(id, name, username, password, enabled) values (101, "Charles", "Charles", "$2a$10$dGGZGOCVNtpkvBdwPNH3K.O0EMVbgRcPz0y/CPq0cW9jcXw7YR8Wi", true);
insert into user(id, name, username, password, enabled) values (102, "Sam", "Sam", "$2a$10$dGGZGOCVNtpkvBdwPNH3K.O0EMVbgRcPz0y/CPq0cW9jcXw7YR8Wi", true);
insert into user(id, name, username, password, enabled) values (103, "Michel", "Michel", "$2a$10$dGGZGOCVNtpkvBdwPNH3K.O0EMVbgRcPz0y/CPq0cW9jcXw7YR8Wi", true);

insert into user_authorities values (100, 1);
insert into user_authorities values (101, 1);
insert into user_authorities values (102, 1);	
insert into user_authorities values (102, 2);
insert into user_authorities values (103, 1);

insert into paymentmethod(id, name, code, status) values (1, "VISA", "VISA", "ACTIVE");
insert into paymentmethod(id, name, code, status) values (2, "MasterCard", "MASTERCARD", "ACTIVE");
insert into paymentmethod(id, name, code, status) values (3, "JCB", "JCB", "ACTIVE");
insert into paymentmethod(id, name, code, status) values (4, "China Union Pay", "CHINA_UNION_PAY", "ACTIVE");


