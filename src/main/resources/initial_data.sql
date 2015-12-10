INSERT INTO expense_user(user_email, user_password) VALUES ('dummy', 'password1')
INSERT INTO expense_user(user_email, user_password) VALUES ('dummy2', 'password2')

INSERT INTO status(status_type) VALUES ('Approved');
INSERT INTO status(status_type) VALUES ('Submitted');
INSERT INTO status(status_type) VALUES ('Rejected');
INSERT INTO status(status_type) VALUES ('Saved');
INSERT INTO status(status_type) VALUES ('Under Review');

INSERT INTO project(project_name, approver_id) VALUES ('pie maker', 1);
INSERT INTO project(project_name, approver_id) VALUES ('beef baster', 2);