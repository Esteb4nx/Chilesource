# 23 oct. 2021 Jorge Mainhard
DROP DATABASE IF EXISTS chilesourcedb;
CREATE DATABASE chilesourcedb /*!40100 COLLATE 'utf8mb4_general_ci' */;

USE chilesourcedb;

#################
##### Tables
##################
DROP TABLE IF EXISTS session;
CREATE TABLE session (
    session_id INT UNSIGNED NOT NULL AUTO_INCREMENT,
    PRIMARY KEY (session_id)
);

DROP TABLE IF EXISTS role;
CREATE TABLE role (
	role_id INT UNSIGNED NOT NULL AUTO_INCREMENT,
	role_name VARCHAR(50) NOT NULL,
	PRIMARY KEY (role_id)
);

DROP TABLE IF EXISTS user;
CREATE TABLE user (
	user_id INT UNSIGNED NOT NULL AUTO_INCREMENT,
	user_name VARCHAR(100) NOT NULL,
	user_password VARCHAR(100) NOT NULL,
	user_email VARCHAR(100) NOT NULL,
	role_id INT UNSIGNED NOT NULL,
	PRIMARY KEY (user_id),
	CONSTRAINT fk_user_role
	    FOREIGN KEY (role_id) REFERENCES role(role_id)
);

# FIXME: Diseño ERD category pertenece a 1 super_category y super_category tiene n category
DROP TABLE IF EXISTS super_category;
CREATE TABLE super_category (
    scategory_id INT UNSIGNED NOT NULL AUTO_INCREMENT,
    scategory_name VARCHAR(255) NOT NULL,
    PRIMARY KEY (scategory_id)
);

DROP TABLE IF EXISTS category;
CREATE TABLE category (
    category_id INT UNSIGNED NOT NULL AUTO_INCREMENT,
    category_name VARCHAR(255) NOT NULL,
    super_category_id INT UNSIGNED,
    PRIMARY KEY (category_id),
    CONSTRAINT fk_category_super_category
        FOREIGN KEY (super_category_id) REFERENCES super_category(scategory_id)
);


DROP TABLE IF EXISTS post;
CREATE TABLE post (
    post_id INT UNSIGNED NOT NULL AUTO_INCREMENT,
    /* post_commentary VARCHAR(n) NOT NULL # creo que esta columna no va, FIXME: en ese caso eliminar del ERD */
    post_title VARCHAR(120) NOT NULL,
    post_body TEXT NOT NULL,
    post_date DATETIME NOT NULL,
    post_category_id INT UNSIGNED NOT NULL,
    PRIMARY KEY (post_id),
    CONSTRAINT fk_post_category
        FOREIGN KEY (post_category_id) REFERENCES category(category_id)
);

# POSIBLE FIXME ERD: Interpreté Relación Favorite-User como User guarda N Favorites y Favorite Guarda 1 User
DROP TABLE IF EXISTS favorite;
CREATE TABLE favorite (
    fav_id INT NOT NULL AUTO_INCREMENT,
    fav_date DATETIME NOT NULL,
    post_id INT UNSIGNED NOT NULL,
    user_id INT UNSIGNED NOT NULL,
    PRIMARY KEY (fav_id),
    CONSTRAINT fk_favorite_post
      FOREIGN KEY (post_id) REFERENCES post(post_id),
    CONSTRAINT fk_favorite_user
      FOREIGN KEY (user_id) REFERENCES user(user_id)
);

DROP TABLE IF EXISTS commentary;
CREATE TABLE commentary (
	commentary_id INT UNSIGNED NOT NULL AUTO_INCREMENT,
	c_content TEXT NOT NULL,
	c_date DATETIME NOT NULL,
	c_likes INT UNSIGNED DEFAULT 0,
	post_id INT UNSIGNED NOT NULL,
	PRIMARY KEY (commentary_id),
    CONSTRAINT fk_commentary_post
        FOREIGN KEY (post_id) REFERENCES post(post_id)
);

SHOW TABLES;

#################
##### FIN Tables DDL
##################












