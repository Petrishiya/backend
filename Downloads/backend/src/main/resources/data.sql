INSERT INTO users (username, email) VALUES ('joe', 'joe@example.com');
INSERT INTO users (username, email) VALUES ('jane', 'jan@example.com');

INSERT INTO tasks (name, description, assignee, creator, status)
VALUES ('Task 1', 'Description 1', 'john', 'jane_doe', 'TODO');

INSERT INTO tasks (name, description, assignee, creator, status)
VALUES ('Task 2', 'Description 2', 'jane_doe', 'johe', 'IN_PROGRESS');


select * from USERS;