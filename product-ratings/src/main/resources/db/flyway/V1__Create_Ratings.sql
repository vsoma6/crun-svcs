CREATE TABLE if not exists ratings (
id integer,
review_id varchar(20),
rating integer,
category varchar(50),
PRIMARY KEY (id)
);

DELETE FROM ratings;


INSERT INTO ratings (id, review_id, rating, category)
VALUES (1001, 'R1001', 5, 'overall_experience'); 

INSERT INTO ratings (id, review_id, rating, category)
VALUES (1002, 'R1002', 3, 'overall_experience'); 