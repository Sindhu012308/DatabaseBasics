/*
CREATE TABLE person
(
	id INTEGER NOT NULL,
	name VARCHAR(255) NOT NULL,
	location VARCHAR(255),
	birth_date TIMESTAMP,
	primary key(id)
);
*/

INSERT INTO PERSON(id, name, location,birth_date) 
	values(10001, 'Sasi', 'Vijayawada', sysdate()); 

INSERT INTO PERSON(id, name, location,birth_date) 
values(10002, 'James', 'Chicago', sysdate()); 

INSERT INTO PERSON(id, name, location,birth_date) 
values(10003, 'Ashley', 'Charlotte', sysdate()); 