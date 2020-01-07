CREATE TABLE user
 (
     id          int          NOT NULL PRIMARY KEY AUTO_INCREMENT,
     login   CHAR(10) NOT NULL,
     password CHAR(18) NOT NULL,
     role   CHAR(10) NOT NULL,
     e_mail       CHAR(10)

 )