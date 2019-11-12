CREATE TABLE users(
    id INT UNSIGNED NOT NULL AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    surname VARCHAR(100) NOT NULL,
    phone VARCHAR(100) NOT NULL,
    mail VARCHAR(100) NOT NULL
);

INSERT INTO users (name, surname, phone, mail)
VALUES ("Admin","Admin", "7777777777", "admin@example.com");

CREATE TABLE accounts(
  id INT UNSIGNED NOT NULL AUTO_INCREMENT PRIMARY KEY,
  user_id INT UNSIGNED NOT NULL REFERENCES users (id),
  cash INT UNSIGNED
);

INSERT INTO accounts (user_id, cash)
VALUES (1, 1000);

CREATE TABLE operations(
  id INT UNSIGNED NOT NULL AUTO_INCREMENT PRIMARY KEY,
  account_id INT UNSIGNED NOT NULL REFERENCES accounts (id),
  blank VARCHAR(100) NOT NULL
);

INSERT INTO operations (account_id, blank)
VALUES (1, "Payment");
