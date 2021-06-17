CREATE TABLE person (
    id UUID NOT NULL PRIMARY KEY,
    name VARCHAR(255) NOT NULL
);

INSERT INTO person VALUES (uuid_generate_v4(), 'James Pique');
INSERT INTO person VALUES (uuid_generate_v4(), 'James Bond');
INSERT INTO person VALUES (uuid_generate_v4(), 'Christen Press');
INSERT INTO person VALUES (uuid_generate_v4(), 'Alex Morgan');
INSERT INTO person VALUES (uuid_generate_v4(), 'Lionel Messi');
INSERT INTO person VALUES (uuid_generate_v4(), 'Christiano Ronaldo');