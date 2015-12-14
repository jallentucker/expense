INSERT INTO expense_user(user_email, user_password) VALUES ('dummy@gmail.com', '$2a$10$F.tNwMhgMazE4V49BJRN/eY86pqfIvRSabhnQ0IJePqd/sPV7a98a');

INSERT INTO status(status_type) VALUES ('Approved');
INSERT INTO status(status_type) VALUES ('Submitted');
INSERT INTO status(status_type) VALUES ('Rejected');
INSERT INTO status(status_type) VALUES ('Saved');
INSERT INTO status(status_type) VALUES ('Under Review');

INSERT INTO project(project_name, approver_id) VALUES ('pie maker', 1);
INSERT INTO project(project_name, approver_id) VALUES ('beef baster', 2);