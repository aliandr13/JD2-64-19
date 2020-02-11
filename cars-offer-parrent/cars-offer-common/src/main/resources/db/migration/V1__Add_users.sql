CREATE TABLE user
 (
     id          int          NOT NULL PRIMARY KEY,
     login   CHAR(10) NOT NULL,
     password CHAR(18) NOT NULL,
     role   int NOT NULL,
     e_mail       CHAR(255)
 );
