CREATE TABLE gamer(
                      id INTEGER PRIMARY KEY,
                      age INTEGER NOT NULL ,
                      name VARCHAR(250) NOT NULL,
                      email VARCHAR(250) NOT NULL
);

-- ALTER TABLE gamer DROP COLUMN id;
-- ALTER TABLE gamer DROP COLUMN age;

ALTER TABLE gamer ADD CONSTRAINT
    gamer_email_unique UNIQUE (email);
