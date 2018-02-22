
CREATE TABLE user_details  (userId INT NOT NULL, userName VARCHAR(255) NOT NULL UNIQUE, 
password VARCHAR(255), displayName VARCHAR(255),  PRIMARY KEY(userId));

drop TABLE user_details ;

INSERT INTO USER_DETAILS (userId, userName, password, displayName) VALUES (1, 'Root1', 'root', 'root');
INSERT INTO USER_DETAILS (userId, userName, password, displayName) VALUES (2, 'Root2', 'root', 'root');
INSERT INTO USER_DETAILS (userId, userName, password, displayName) VALUES (3, 'Root3', 'root', 'root');
INSERT INTO USER_DETAILS (userId, userName, password, displayName) VALUES (4, 'Root4', 'root', 'root');
select * from user_details;

select * from user_details where userId=3


