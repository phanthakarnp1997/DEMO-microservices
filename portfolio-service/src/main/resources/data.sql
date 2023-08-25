-- Mock Data for User table
INSERT INTO `User` (`firstname`, `lastname`, `email`, `hash_password`, `lastlogin`, `aboutme`)
SELECT 'John', 'Doe', 'john@example.com', 'hashed_password_1', '2023-08-19 10:00:00', 'About John'
WHERE NOT EXISTS (SELECT 1 FROM `User` WHERE `email` = 'john@example.com');

INSERT INTO `User` (`firstname`, `lastname`, `email`, `hash_password`, `lastlogin`, `aboutme`)
SELECT 'Jane', 'Smith', 'jane@example.com', 'hashed_password_2', '2023-08-18 15:30:00', 'About Jane'
WHERE NOT EXISTS (SELECT 1 FROM `User` WHERE `email` = 'jane@example.com');

-- Mock Data for Job table
INSERT INTO `Job` (`companyname`, `started_at`, `ended_at`, `created_at`, `updated_at`, `is_ended`, `user_id`, `role`)
SELECT 'ABC Company', '2020-01-01', '2022-06-30', '2023-08-17 09:00:00', '2023-08-19 14:30:00', 0, 1, 'Software Developer'
WHERE NOT EXISTS (SELECT 1 FROM `Job` WHERE `companyname` = 'ABC Company');

INSERT INTO `Job` (`companyname`, `started_at`, `ended_at`, `created_at`, `updated_at`, `is_ended`, `user_id`, `role`)
SELECT 'XYZ Corporation', '2018-03-15', '2020-12-31', '2023-08-10 12:00:00', '2023-08-15 17:45:00', 1, 2, 'Project Manager'
WHERE NOT EXISTS (SELECT 1 FROM `Job` WHERE `companyname` = 'XYZ Corporation');

-- Mock Data for Socialaccount table
INSERT INTO `Socialaccount` (`url`, `name`, `is_public`, `created_at`, `updated_at`, `imageurl`, `user_id`)
SELECT 'https://twitter.com/johndoe', 'Twitter', 1, '2023-08-18 10:30:00', '2023-08-19 09:15:00', 'https://example.com/twitter_image.jpg', 1
WHERE NOT EXISTS (SELECT 1 FROM `Socialaccount` WHERE `name` = 'Twitter');

INSERT INTO `Socialaccount` (`url`, `name`, `is_public`, `created_at`, `updated_at`, `imageurl`, `user_id`)
SELECT 'https://linkedin.com/in/janesmith', 'LinkedIn', 1, '2023-08-17 15:20:00', '2023-08-19 14:00:00', 'https://example.com/linkedin_image.jpg', 2
WHERE NOT EXISTS (SELECT 1 FROM `Socialaccount` WHERE `name` = 'LinkedIn');

-- Mock Data for Education table
INSERT INTO `Education` (`degreename`, `institutename`, `instituteurl`, `started_at`, `ended_at`, `is_completed`, `created_at`, `updated_at`, `user_id`)
SELECT 'Bachelor of Science', 'University A', 'https://universitya.edu', '2015-09-01', '2019-06-30', 'Yes', '2023-08-15', '2023-08-19', 1
WHERE NOT EXISTS (SELECT 1 FROM `Education` WHERE `degreename` = 'Bachelor of Science');

INSERT INTO `Education` (`degreename`, `institutename`, `instituteurl`, `started_at`, `ended_at`, `is_completed`, `created_at`, `updated_at`, `user_id`)
SELECT 'Master of Business Administration', 'University B', 'https://universityb.edu', '2018-01-01', '2020-12-31', 'Yes', '2023-08-14', '2023-08-18', 2
WHERE NOT EXISTS (SELECT 1 FROM `Education` WHERE `degreename` = 'Master of Business Administration');

-- Mock Data for Skill table
INSERT INTO `Skill` (`name`, `imageUrl`, `created_at`, `updated_at`, `is_public`, `user_id`)
SELECT 'Java', 'https://example.com/java_icon.png', '2023-08-16 10:00:00', '2023-08-18 16:30:00', 1, 1
WHERE NOT EXISTS (SELECT 1 FROM `Skill` WHERE `name` = 'Java');

INSERT INTO `Skill` (`name`, `imageUrl`, `created_at`, `updated_at`, `is_public`, `user_id`)
SELECT 'Python', 'https://example.com/python_icon.png', '2023-08-14 09:30:00', '2023-08-19 12:15:00', 1, 2
WHERE NOT EXISTS (SELECT 1 FROM `Skill` WHERE `name` = 'Python');

-- Mock Data for Project table
INSERT INTO `Project` (`name`, `description`, `created_at`, `updated_at`, `is_published`, `user_id`, `is_opensource`)
SELECT 'Portfolio Website', 'Personal portfolio website built with HTML, CSS, and JavaScript.', '2023-08-15 14:00:00', '2023-08-18 10:45:00', 1, 1, 0
WHERE NOT EXISTS (SELECT 1 FROM `Project` WHERE `name` = 'Portfolio Website');

INSERT INTO `Project` (`name`, `description`, `created_at`, `updated_at`, `is_published`, `user_id`, `is_opensource`)
SELECT 'Online Store App', 'E-commerce web application developed using React and Node.js.', '2023-08-12 09:30:00', '2023-08-19 16:00:00', 0, 2, 1
WHERE NOT EXISTS (SELECT 1 FROM `Project` WHERE `name` = 'Online Store App');

-- Mock Data for Certification table
INSERT INTO `Certification` (`name`, `url`, `start_date`, `end_date`, `created_at`, `updated_at`, `is_published`, `user_id`)
SELECT 'Java Developer Certification', 'https://example.com/cert/java', '2020-03-01', '2022-03-01', '2023-08-15 11:00:00', '2023-08-19 09:45:00', 1, 1
WHERE NOT EXISTS (SELECT 1 FROM `Certification` WHERE `name` = 'Java Developer Certification');

INSERT INTO `Certification` (`name`, `url`, `start_date`, `end_date`, `created_at`, `updated_at`, `is_published`, `user_id`)
SELECT 'Project Management Professional', 'https://example.com/cert/pmp', '2019-06-01', '2024-06-01', '2023-08-14 14:30:00', '2023-08-18 12:15:00', 0, 2
WHERE NOT EXISTS (SELECT 1 FROM `Certification` WHERE `name` = 'Project Management Professional');

-- Mock Data for Contactme table
INSERT INTO `Contactme` (`message`, `email`, `name`, `created_at`, `ip_address`, `browser_information`)
SELECT 'I would like to discuss potential collaboration opportunities.', 'contact@example.com', 'Alice', '2023-08-16 10:30:00', '192.168.1.1', 'Chrome browser'
WHERE NOT EXISTS (SELECT 1 FROM `Contactme` WHERE `email` = 'contact@example.com');

INSERT INTO `Contactme` (`message`, `email`, `name`, `created_at`, `ip_address`, `browser_information`)
SELECT 'Interested in your projects. Please contact me.', 'info@example.com', 'Bob', '2023-08-14 15:00:00', '192.168.1.2', 'Firefox browser'
WHERE NOT EXISTS (SELECT 1 FROM `Contactme` WHERE `email` = 'info@example.com');

-- End of Script
