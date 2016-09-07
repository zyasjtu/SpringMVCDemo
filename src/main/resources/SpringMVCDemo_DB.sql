  CREATE TABLE springmvcdemo_db.SpringMVCDemo_User
(
    id NVARCHAR(64) PRIMARY KEY,
    name NVARCHAR(64) NOT NULL,
    password NVARCHAR(64) NOT NULL,
    email NVARCHAR(64) DEFAULT NULL ,
    address NVARCHAR(64) DEFAULT NULL ,
    birthday DATE DEFAULT NULL ,
    discount DOUBLE DEFAULT 1.0 NOT NULL,
    type INT DEFAULT 1 NOT NULL
);