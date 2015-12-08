INSERT INTO users(user_password, user_email) VALUES ('hello', 'jon@jon.com');

INSERT INTO status(status_type) VALUES ('Approved');
INSERT INTO status(status_type) VALUES ('Submitted');
INSERT INTO status(status_type) VALUES ('Rejected');
INSERT INTO status(status_type) VALUES ('Saved');
INSERT INTO status(status_type) VALUES ('Under Review');

INSERT INTO report(report_name, status_id) VALUES ('hello', 1);
