CREATE TABLE person (
    id UUID NOT NULL PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    birthday DATE,
    email VARCHAR(50) NOT NULL,
    address VARCHAR(255),
    password VARCHAR(30) NOT NULL,
    UNIQUE(email)
);

-- Temporary data to be used
INSERT INTO person (id, password, name, birthday, email, address) VALUES (uuid_generate_v4(), 'password', 'Shiela Mae Catapan', '1989-08-30', 'smcatapan@gmail.com', 'Bogo City, Cebu, Philippines');
INSERT INTO person (id, password, name, birthday, email, address) VALUES (uuid_generate_v4(), 'abcd', 'Samuel Coe', '2021-04-29', 'scoe0@ebay.com', '97363 Upham Place');
INSERT INTO person (id, password, name, birthday, email, address) VALUES (uuid_generate_v4(), 'abcd', 'Ediva Marshall', '2020-10-05', 'emarshall1@is.gd', '499 Golf Parkway');
INSERT INTO person (id, password, name, birthday, email, address) VALUES (uuid_generate_v4(), 'abcd', 'Aldus Kik', null, 'akik2@patch.com', '8347 Springs Circle');
INSERT INTO person (id, password, name, birthday, email, address) VALUES (uuid_generate_v4(), 'abcd', 'Horatio Willcott', null, 'hwillcott3@issuu.com', '29 Ryan Terrace');
INSERT INTO person (id, password, name, birthday, email, address) VALUES (uuid_generate_v4(), 'abcd', 'Hadley Kasbye', '2020-07-02', 'hkasbye4@fotki.com', '8750 Hooker Circle');
INSERT INTO person (id, password, name, birthday, email, address) VALUES (uuid_generate_v4(), 'abcd', 'Athena Kinner', null, 'akinner5@usa.gov', '42 Quincy Court');
INSERT INTO person (id, password, name, birthday, email, address) VALUES (uuid_generate_v4(), 'abcd', 'Gavin Yeskin', null, 'gyeskin6@google.com.au', '20 Dexter Parkway');
INSERT INTO person (id, password, name, birthday, email, address) VALUES (uuid_generate_v4(), 'abcd', 'Jillana Josey', '2020-12-28', 'jjosey7@diigo.com', '9517 Troy Trail');
INSERT INTO person (id, password, name, birthday, email, address) VALUES (uuid_generate_v4(), 'abcd', 'Evin Hayen', '2021-05-17', 'ehayen8@mashable.com', '2510 Anthes Court');
INSERT INTO person (id, password, name, birthday, email, address) VALUES (uuid_generate_v4(), 'abcd', 'Carlin Baggelley', '2021-04-10', 'cbaggelley9@businesswire.com', '4155 Nancy Court');
INSERT INTO person (id, password, name, birthday, email, address) VALUES (uuid_generate_v4(), 'abcd', 'Seth McQuaide', null, 'smcquaidea@exblog.jp', '68335 Reinke Drive');
INSERT INTO person (id, password, name, birthday, email, address) VALUES (uuid_generate_v4(), 'abcd', 'Cordelia Union', null, 'cunionb@gmpg.org', '95 School Avenue');
INSERT INTO person (id, password, name, birthday, email, address) VALUES (uuid_generate_v4(), 'abcd', 'Amos Scrannage', null, 'ascrannagec@weebly.com', '0 Cordelia Alley');
INSERT INTO person (id, password, name, birthday, email, address) VALUES (uuid_generate_v4(), 'abcd', 'Wini Jales', null, 'wjalesd@dell.com', '97606 Eastlawn Avenue');
INSERT INTO person (id, password, name, birthday, email, address) VALUES (uuid_generate_v4(), 'abcd', 'Bay Dewen', null, 'bdewene@unblog.fr', '5409 Lindbergh Center');
INSERT INTO person (id, password, name, birthday, email, address) VALUES (uuid_generate_v4(), 'abcd', 'Marigold Gethouse', null, 'mgethousef@trellian.com', '34517 Armistice Court');
INSERT INTO person (id, password, name, birthday, email, address) VALUES (uuid_generate_v4(), 'abcd', 'Nichole Cheater', null, 'ncheaterg@wordpress.org', '3 Cherokee Drive');
INSERT INTO person (id, password, name, birthday, email, address) VALUES (uuid_generate_v4(), 'abcd', 'Kathye MacGahey', null, 'kmacgaheyh@umich.edu', '6561 Burrows Drive');
INSERT INTO person (id, password, name, birthday, email, address) VALUES (uuid_generate_v4(), 'abcd', 'Jyoti O''Shavlan', null, 'joshavlani@odnoklassniki.ru', '0 Golf Hill');
INSERT INTO person (id, password, name, birthday, email, address) VALUES (uuid_generate_v4(), 'abcd', 'Catherin Macbane', null, 'cmacbanej@wikispaces.com', '6571 Armistice Alley');
INSERT INTO person (id, password, name, birthday, email, address) VALUES (uuid_generate_v4(), 'abcd', 'Letizia Beadles', null, 'lbeadlesk@msu.edu', '37 Hooker Junction');
INSERT INTO person (id, password, name, birthday, email, address) VALUES (uuid_generate_v4(), 'abcd', 'Alonzo Vidgen', null, 'avidgenl@myspace.com', '37018 Esch Plaza');
INSERT INTO person (id, password, name, birthday, email, address) VALUES (uuid_generate_v4(), 'abcd', 'Phedra O''Corrane', null, 'pocorranem@irs.gov', '98300 Declaration Circle');
INSERT INTO person (id, password, name, birthday, email, address) VALUES (uuid_generate_v4(), 'abcd', 'Jessie Beldom', null, 'jbeldomn@shutterfly.com', '911 Green Hill');
INSERT INTO person (id, password, name, birthday, email, address) VALUES (uuid_generate_v4(), 'abcd', 'Aurea Borborough', '2020-07-23', 'aborborougho@intel.com', '4239 Loeprich Alley');
INSERT INTO person (id, password, name, birthday, email, address) VALUES (uuid_generate_v4(), 'abcd', 'Francine Rooms', null, 'froomsp@netscape.com', '7 Valley Edge Place');
INSERT INTO person (id, password, name, birthday, email, address) VALUES (uuid_generate_v4(), 'abcd', 'Marthe MacGillivrie', null, 'mmacgillivrieq@google.com.br', '90 Marcy Pass');
INSERT INTO person (id, password, name, birthday, email, address) VALUES (uuid_generate_v4(), 'abcd', 'Kathe Mc Coughan', null, 'kmcr@seesaa.net', '7 Utah Pass');
INSERT INTO person (id, password, name, birthday, email, address) VALUES (uuid_generate_v4(), 'abcd', 'Ezekiel Fidelus', null, 'efideluss@mapy.cz', '39555 Carberry Plaza');
INSERT INTO person (id, password, name, birthday, email, address) VALUES (uuid_generate_v4(), 'abcd', 'Enriqueta Diggell', null, 'ediggellt@canalblog.com', '59 Continental Place');
