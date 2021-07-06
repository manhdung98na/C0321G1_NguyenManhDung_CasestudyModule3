drop database if exists furama_resort;
create database furama_resort;
use furama_resort;
SET foreign_key_checks = 0;
CREATE TABLE position (
    position_id INT PRIMARY KEY,
    position_name VARCHAR(45)
);
CREATE TABLE education_degree (
    education_degree_id INT PRIMARY KEY,
    education_degree_name VARCHAR(45)
);
CREATE TABLE division (
    division_id INT PRIMARY KEY,
    division_name VARCHAR(45)
);
CREATE TABLE `role` (
    role_id INT PRIMARY KEY,
    role_name VARCHAR(255)
);
CREATE TABLE `user` (
    username VARCHAR(255) PRIMARY KEY,
    `password` VARCHAR(255)
);
CREATE TABLE user_role (
    role_id INT,
    username VARCHAR(255),
    PRIMARY KEY (role_id , username)
);

CREATE TABLE customer_type (
    customer_type_id INT PRIMARY KEY,
    customer_type_name VARCHAR(45)
);
CREATE TABLE service_type (
    service_type_id INT PRIMARY KEY,
    service_type_name VARCHAR(45)
);
CREATE TABLE rent_type (
    rent_type_id INT PRIMARY KEY,
    rent_type_name VARCHAR(45),
    rent_type_cost DOUBLE
);
CREATE TABLE attach_service (
    attach_service_id INT PRIMARY KEY,
    attach_service_name VARCHAR(45),
    attach_service_cost DOUBLE,
    attach_service_unit INT,
    attach_service_status VARCHAR(45)
);

CREATE TABLE employee (
    employee_id INT PRIMARY KEY,
    employee_name VARCHAR(45),
    employee_birthday DATE,
    employee_id_card VARCHAR(45),
    employee_salary DOUBLE CHECK (employee_salary > 0),
    employee_phone VARCHAR(45) UNIQUE,
    employee_email VARCHAR(45) UNIQUE,
    employee_address VARCHAR(45),
    position_id INT,
    education_degree_id INT,
    division_id INT,
    username VARCHAR(255) UNIQUE,
    FOREIGN KEY (position_id)
        REFERENCES position (position_id)
        ON UPDATE CASCADE ON DELETE CASCADE,
    FOREIGN KEY (education_degree_id)
        REFERENCES education_degree (education_degree_id)
        ON UPDATE CASCADE ON DELETE CASCADE,
    FOREIGN KEY (division_id)
        REFERENCES division (division_id)
        ON UPDATE CASCADE ON DELETE CASCADE,
    FOREIGN KEY (username)
        REFERENCES `user` (username)
        ON UPDATE CASCADE ON DELETE CASCADE
);

CREATE TABLE customer (
    customer_id VARCHAR(15) PRIMARY KEY,
    customer_type_id INT,
    customer_name VARCHAR(45),
    customer_birthday DATE,
    customer_gender VARCHAR(20),
    customer_id_card VARCHAR(45) UNIQUE,
    customer_phone VARCHAR(45) UNIQUE,
    customer_email VARCHAR(45) UNIQUE,
    customer_address VARCHAR(45),
    FOREIGN KEY (customer_type_id)
        REFERENCES customer_type (customer_type_id)
        ON UPDATE CASCADE ON DELETE CASCADE
);

CREATE TABLE service (
    service_id VARCHAR(15) PRIMARY KEY,
    service_name VARCHAR(45),
    service_area INT CHECK (service_area > 0),
    service_cost DOUBLE,
    service_max_people INT CHECK (service_max_people > 0),
    rent_type_id INT,
    service_type_id INT,
    standard_room VARCHAR(45),
    description_other_convenience VARCHAR(45),
    pool_area DOUBLE,
    number_of_floors INT,
    FOREIGN KEY (rent_type_id)
        REFERENCES rent_type (rent_type_id)
        ON UPDATE CASCADE ON DELETE CASCADE,
    FOREIGN KEY (service_type_id)
        REFERENCES service_type (service_type_id)
        ON UPDATE CASCADE ON DELETE CASCADE
);

CREATE TABLE contract (
    contract_id INT PRIMARY KEY,
    contract_start_date DATETIME,
    contract_end_date DATETIME,
    contract_deposit DOUBLE,
    contract_total_money DOUBLE,
    employee_id INT,
    customer_id VARCHAR(15),
    service_id VARCHAR(15),
    FOREIGN KEY (employee_id)
        REFERENCES employee (employee_id)
        ON UPDATE CASCADE ON DELETE CASCADE,
    FOREIGN KEY (customer_id)
        REFERENCES customer (customer_id)
        ON UPDATE CASCADE ON DELETE CASCADE,
    FOREIGN KEY (service_id)
        REFERENCES service (service_id)
        ON UPDATE CASCADE ON DELETE CASCADE
);

CREATE TABLE contract_detail (
    contract_detail_id INT PRIMARY KEY,
    contract_id INT,
    attach_service_id INT,
    quantity INT CHECK (quantity > 0),
    FOREIGN KEY (contract_id)
        REFERENCES contract (contract_id)
        ON UPDATE CASCADE ON DELETE CASCADE,
    FOREIGN KEY (attach_service_id)
        REFERENCES attach_service (attach_service_id)
        ON UPDATE CASCADE ON DELETE CASCADE
);

-- insert
insert into education_degree value(1, 'Trung cấp'), (2, 'Cao đẳng'), (3, 'Đại học'), (4, 'Sau đại học');
insert into position value(1, 'Lễ tân'), (2, 'Phục vụ'), (3, 'Chuyên viên'), (4, 'Giám sát'), (5, 'Quản lý'), (6, 'Giám đốc');
insert into division value(1, 'Sale - Marketing'), (2, 'Hành chính'), (3, 'Phục vụ'), (4, 'Quản lý');
insert into customer_type value(1, 'Diamond'), (2, 'Platinium'), (3, 'Gold'), (4, 'Silver'), (5, 'Member');
insert into rent_type value(1, 'Năm', 35000000), (2, 'Tháng', 300000), (3, 'Ngày', 150000), (4, 'Giờ', 80000);
insert into attach_service value(1, 'massage', 500000, 1, 'available'), 
								(2, 'karaoke', 200000, 1, 'available'),
								(3, 'thức ăn', 150000, 1, 'available'),
								(4, 'nước uống', 20000, 1, 'available'),
								(5, 'thuê xe di chuyển tham quan resort', 250000, 1, 'available');
insert into service_type value (1, 'Villa'), (2, 'House'), (3, 'Room');
insert into customer value ('KH-0001', 1, 'Mạnh Dũng', '1998-10-12', 'Male', '123123111', '0949470470', 'mdung@gmail.com', 'Nghệ An'),
('KH-0002', 4, 'Bảo Hoàng', '2000-02-08', 'Male', '123123222', '0949470123', 'bhoang@gmail.com', 'Huế'),
('KH-0003', 2, 'Lê Ly', '1996-05-11', 'Female', '123123333', '0949470704', 'lly@gmail.com', 'Đà Nẵng'),
('KH-0004', 5, 'Phạm Toàn', '1999-12-22', 'Unknown', '123123444', '0949470740', 'ptoan@gmail.com', 'Quảng Nam');
