CREATE TABLE IF NOT EXISTS USERS (
                                     id BIGINT AUTO_INCREMENT PRIMARY KEY,
                                     username VARCHAR(255) NOT NULL,
    email VARCHAR(255) NOT NULL
    );


CREATE TABLE IF NOT EXISTS TASKS (
                       id BIGINT AUTO_INCREMENT PRIMARY KEY,
                       name VARCHAR(255) NOT NULL,
                       description TEXT,
                       assignee VARCHAR(255),
                       creator VARCHAR(255),
                       status VARCHAR(50)
);

show tables