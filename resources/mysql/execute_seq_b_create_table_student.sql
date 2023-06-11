USE test;
CREATE TABLE IF NOT EXISTS student (
    id VARCHAR(36) NOT NULL,
    name VARCHAR(255) NOT NULL,
    age INT NOT NULL,
    PRIMARY KEY (id)
);
TRUNCATE TABLE student;
INSERT INTO student(id, name, age) VALUES ('45215570-0296-11ee-8566-acde48001122', 'John Doe', 22);
