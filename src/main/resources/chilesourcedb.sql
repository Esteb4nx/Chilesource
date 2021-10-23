# 23 oct. 2021 Jorge Mainhard
CREATE DATABASE chilesourcedb /*!40100 COLLATE 'utf8mb4_general_ci' */;

USE chilesourcedb;

DROP TABLE if EXISTS role;
CREATE TABLE role (
	role_id INT UNSIGNED NOT NULL AUTO_INCREMENT PRIMARY KEY,
	role_name VARCHAR(50) NOT NULL
);

DROP TABLE if EXISTS user;
CREATE TABLE user (
	user_id INT UNSIGNED NOT NULL AUTO_INCREMENT PRIMARY KEY,
	user_name VARCHAR(100) NOT NULL,
	user_password VARCHAR(100) NOT NULL,
	user_email VARCHAR(100) NOT NULL,
	role_id INT UNSIGNED NOT NULL,
	PRIMARY KEY (user_id),
	CONSTRAINT fk_role FOREIGN KEY (role_id) REFERENCES role(role_id)
);

SHOW TABLES;

DROP TABLE if EXISTS commentary;
CREATE TABLE commentary (
	commentary_id INT UNSIGNED NOT NULL AUTO_INCREMENT,
	c_content TEXT NOT NULL,
	c_date DATETIME NOT NULL,
	c_likes INT UNSIGNED DEFAULT 0,
	post_id INT NOT NULL,
	PRIMARY KEY (commentary_id)
	CONSTRAINT fk_post FOREIGN KEY (post_id) REFERENCES post(post_id)
);

DROP TABLE if EXISTS post;
CREATE TABLE post (
	post_id INT UNSIGNED NOT NULL AUTO_INCREMENT PRIMARY KEY,
	# post_commentary VARCHAR(n) NOT NULL # creo que esta columna no va, FIXME: en ese caso eliminar del ERD
	post_title VARCHAR(120) NOT NULL,
	post_body TEXT NOT NULL,
	post_date DATETIME NOT NULL,
);






DROP TABLE if EXISTS category;
CREATE TABLE category (
	category_id INT UNSIGNED NOT NULL AUTO_INCREMENT,
	category_name VARCHAR(255) NOT NULL,
	PRIMARY KEY (category_id)
);

CREATE TABLE super_category (
	scategory_id INT UNSIGNED NOT NULL AUTO_INCREMENT,
	scategory_name VARCHAR(255) NOT NULL,
);








