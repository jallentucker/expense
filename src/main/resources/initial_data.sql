INSERT INTO expense_user(user_email, user_password) VALUES ('dummy@gmail.com', '$2a$10$F.tNwMhgMazE4V49BJRN/eY86pqfIvRSabhnQ0IJePqd/sPV7a98a');

INSERT INTO status(status_type) VALUES ('Approved');
INSERT INTO status(status_type) VALUES ('Submitted');
INSERT INTO status(status_type) VALUES ('Rejected');
INSERT INTO status(status_type) VALUES ('Saved');
INSERT INTO status(status_type) VALUES ('Under Review');

INSERT INTO report(report_name, user_id) VALUES ('Dummy Report', 1);

INSERT INTO project(project_name, approver_id) VALUES ('pie maker', 1);
INSERT INTO project(project_name, approver_id) VALUES ('beef baster', 1);


INSERT INTO line_item_type(line_item_type) VALUES ('Mileage');
INSERT INTO line_item_type(line_item_type) VALUES ('Per Diem');
INSERT INTO line_item_type(line_item_type) VALUES ('Lodging');
INSERT INTO line_item_type(line_item_type) VALUES ('Travel');
INSERT INTO line_item_type(line_item_type) VALUES ('Meals');
INSERT INTO line_item_type(line_item_type) VALUES ('Entertainment');
INSERT INTO line_item_type(line_item_type) VALUES ('Parking');
INSERT INTO line_item_type(line_item_type) VALUES ('Other');
