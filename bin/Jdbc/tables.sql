CREATE TABLE parking (
    parking_id int,
    person_name varchar(255),
    vehicle_num varchar(255),
    time_of_entry time,
    date_of_entry date,
    payment_method varchar(255),
    hours_parked int,
    phone_num varchar(10),
    PRIMARY KEY (parking_id),
);


CREATE TABLE history (
    id int NOT NULL AUTO_INCREMENT,
    parking_id int,
    person_name varchar(255),
    vehicle_num varchar(255),
    time_of_entry time,
    date_of_entry date,
    payment_method varchar(255),
    hours_parked int,
    phone_num varchar(10),
    -- Username varchar(255),
    PRIMARY KEY (id),
    -- FOREIGN KEY (Username) REFERENCES login(Username)
);

CREATE TABLE history (
    parking_id int,
    person_name varchar(255),
    vehicle_num varchar(255),
    time_of_entry time,
    date_of_entry date,
    payment_method varchar(255),
    hours_parked int,
    phone_num varchar(10)
);

CREATE TABLE register (
    fname varchar(255),
    lname varchar(255),
    Username varchar(255),
    Password varchar(255),
    dob varchar(255),
    phone varchar(255),
    email varchar(255)
);

CREATE TABLE login (
    Username varchar(255),
    Password varchar(255)
);



insert into history values("4","cvdfv","qwqwe","11:32:22","2021-10-10","NetBanking","21","231");

SELECT parking_id,date_of_entry,time_of_entry,hours_parked FROM parking where TIMESTAMPDIFF(HOUR,CONCAT(date_of_entry, ' ', time_of_entry),NOW()) > hours_parked;