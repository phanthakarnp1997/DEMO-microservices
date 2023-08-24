-- Create Schema
CREATE SCHEMA IF NOT EXISTS `portfolio` DEFAULT CHARACTER SET utf8;
USE `portfolio`;

-- Table User
CREATE TABLE IF NOT EXISTS `User` (
                                      `user_id` BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY,
                                      `firstname` VARCHAR(45) NULL,
                                      `lastname` VARCHAR(45) NULL,
                                      `email` VARCHAR(100) NULL,
                                      `hash_password` LONGTEXT NULL,
                                      `lastlogin` DATETIME NULL,
                                      `aboutme` LONGTEXT NULL
);


-- Table Socialaccount
CREATE TABLE IF NOT EXISTS `Socialaccount` (
                                               `socialaccount_id` BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY,
                                               `url` LONGTEXT NULL,
                                               `name` VARCHAR(100) NULL,
                                               `is_public` TINYINT NULL,
                                               `created_at` DATETIME NULL,
                                               `updated_at` DATETIME NULL,
                                               `imageurl` LONGTEXT NULL,
                                               `user_id` BIGINT NOT NULL,
                                               CONSTRAINT `fk_SocialAccount_user1` FOREIGN KEY (`user_id`) REFERENCES `User` (`user_id`)
                                                   ON DELETE NO ACTION ON UPDATE NO ACTION
);

-- Table Education
CREATE TABLE IF NOT EXISTS `Education` (
                                           `education_id` BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY,
                                           `degreename` VARCHAR(255) NULL,
                                           `institutename` VARCHAR(255) NULL,
                                           `instituteurl` LONGTEXT NULL,
                                           `started_at` VARCHAR(45) NULL,
                                           `ended_at` VARCHAR(45) NULL,
                                           `is_completed` VARCHAR(45) NULL,
                                           `created_at` DATE NULL,
                                           `updated_at` DATE NULL,
                                           `user_id` BIGINT NOT NULL,
                                           CONSTRAINT `fk_Education_user1` FOREIGN KEY (`user_id`) REFERENCES `User` (`user_id`)
                                               ON DELETE NO ACTION ON UPDATE NO ACTION
);

-- Table Skill
CREATE TABLE IF NOT EXISTS `Skill` (
                                       `skill_id` BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY,
                                       `name` VARCHAR(45) NULL,
                                       `imageUrl` LONGTEXT NULL,
                                       `created_at` DATETIME NULL,
                                       `updated_at` DATETIME NULL,
                                       `is_public` TINYINT NULL,
                                       `user_id` BIGINT NOT NULL,
                                       CONSTRAINT `fk_Skill_user1` FOREIGN KEY (`user_id`) REFERENCES `User` (`user_id`)
                                           ON DELETE NO ACTION ON UPDATE NO ACTION
);

-- Table Project
CREATE TABLE IF NOT EXISTS `Project` (
                                         `project_id` BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY,
                                         `name` VARCHAR(255) NULL,
                                         `description` LONGTEXT NULL,
                                         `created_at` DATETIME NULL,
                                         `updated_at` DATETIME NULL,
                                         `is_published` TINYINT NULL,
                                         `Projectcol` VARCHAR(45) NULL,
                                         `user_id` BIGINT NOT NULL,
                                         `is_opensource` TINYINT NULL,
                                         CONSTRAINT `fk_Project_user1` FOREIGN KEY (`user_id`) REFERENCES `User` (`user_id`)
                                             ON DELETE NO ACTION ON UPDATE NO ACTION
);

-- Table Certification
CREATE TABLE IF NOT EXISTS `Certification` (
                                               `certificate_id` BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY,
                                               `name` VARCHAR(255) NULL,
                                               `url` LONGTEXT NULL,
                                               `start_date` DATE NULL,
                                               `end_date` DATE NULL,
                                               `created_at` DATETIME NULL,
                                               `updated_at` DATETIME NULL,
                                               `is_published` TINYINT NULL,
                                               `user_id` BIGINT NOT NULL,
                                               CONSTRAINT `fk_Certification_user1` FOREIGN KEY (`user_id`) REFERENCES `User` (`user_id`)
                                                   ON DELETE NO ACTION ON UPDATE NO ACTION
);

-- Table Contactme
CREATE TABLE IF NOT EXISTS `Contactme` (
                                           `contactme_id` BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY,
                                           `message` VARCHAR(300) NULL,
    `email` VARCHAR(100) NULL,
    `name` VARCHAR(60) NULL,
    `created_at` VARCHAR(45) NULL,
    `ip_address` VARCHAR(15) NULL,
    `browser_information` LONGTEXT NULL
    );