DROP TABLE IF EXISTS users_roles;
DROP TABLE IF EXISTS users;
DROP TABLE IF EXISTS roles;

CREATE TABLE users (
	id INT AUTO_INCREMENT PRIMARY KEY,
	name VARCHAR NOT NULL,
	username VARCHAR NOT NULL,
	password VARCHAR NOT NULL 
);

CREATE TABLE roles (
	id INT AUTO_INCREMENT PRIMARY KEY,
	role VARCHAR NOT NULL
);

CREATE TABLE users_roles (
	user_id INT NOT NULL,
	role_id INT NOT NULL,
	PRIMARY KEY (user_id, role_id)
);

INSERT INTO roles (id, role) VALUES (1, 'ROLE_ADMIN');
INSERT INTO roles (id, role) VALUES (2, 'ROLE_USER');

INSERT INTO users (id, name, username, password) VALUES (1, 'Leonardo', 'leo', '$2a$10$CqjbH07YcHSMJBWWSfYYJehqg013i7IVL2W3Vm.CAhUHR7MCrF1yG');
INSERT INTO users_roles (user_id, role_id) VALUES (1, 1);

INSERT INTO users (id, name, username, password) VALUES (2, 'Lucas', 'lucas', '$2a$10$CqjbH07YcHSMJBWWSfYYJehqg013i7IVL2W3Vm.CAhUHR7MCrF1yG');
INSERT INTO users_roles (user_id, role_id) VALUES (2, 2);
