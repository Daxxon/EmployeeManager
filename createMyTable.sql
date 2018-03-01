DROP TABLE employees;
CREATE TABLE employees (
  id SERIAL PRIMARY KEY,
  firstName VARCHAR(64) NOT NULL,
  lastName VARCHAR(64) NOT NULL,
  position VARCHAR(255) NULL
);
