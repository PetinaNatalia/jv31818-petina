CREATE TABLE users(
    id INT UNSIGNED NOT NULL AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    surname VARCHAR(100) NOT NULL,
    username VARCHAR(100) NOT NULL,
    password VARCHAR(100) NOT NULL,
    phone VARCHAR(100) NOT NULL,
    mail VARCHAR(100) NOT NULL
);

INSERT INTO users (name, surname,username, password, phone, mail)
VALUES ("John","Smith", "admin", "admin", "7777777777", "homamilae123@mail.ru");

INSERT INTO users (name, surname, username, password, phone, mail)
VALUES ("Alisa","Myer", "test", "test", "5555555555", "homamilae123@mail.ru");

CREATE TABLE roles(
    id INT UNSIGNED NOT NULL AUTO_INCREMENT PRIMARY KEY,
    role VARCHAR(100) NOT NULL);

INSERT INTO roles (role)
VALUES ("ADMIN");

INSERT INTO roles (role)
VALUES ("USR");

CREATE TABLE user_roles(
    user_id INT UNSIGNED NOT NULL,
    role_id INT UNSIGNED NOT NULL
   );

INSERT INTO user_roles (user_id, role_id)
VALUES (1, 1);

INSERT INTO user_roles (user_id, role_id)
VALUES (2, 2);

CREATE TABLE accounts(
  id INT UNSIGNED NOT NULL AUTO_INCREMENT PRIMARY KEY,
  user_id INT UNSIGNED NOT NULL REFERENCES users (id),
  ammount INT UNSIGNED
);

INSERT INTO accounts (user_id, ammount)
VALUES (1, 10);
INSERT INTO accounts (user_id, ammount)
VALUES (2, 20);

CREATE TABLE operations(
  id INT UNSIGNED NOT NULL AUTO_INCREMENT PRIMARY KEY,
  account_id INT UNSIGNED NOT NULL REFERENCES accounts (id),
  target_account_id INT UNSIGNED NOT NULL REFERENCES accounts (id),
  operation_type INT NOT NULL,
  operation_ammount INT NOT NULL
);

INSERT INTO operations (account_id, target_account_id, operation_type, operation_ammount)
VALUES (1, 2, 1, 50);
