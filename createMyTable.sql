DROP TABLE employee;
CREATE TABLE employee (
  id SERIAL PRIMARY KEY,
  first_name VARCHAR(64) NOT NULL,
  last_name VARCHAR(64) NOT NULL,
  position VARCHAR(255) NULL
);
