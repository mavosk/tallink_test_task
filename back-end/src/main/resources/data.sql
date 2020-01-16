DROP TABLE IF EXISTS conference_room;
DROP TABLE IF EXISTS conference;
DROP TABLE IF EXISTS participantion;

 CREATE TABLE conference_room (
  id INT AUTO_INCREMENT  PRIMARY KEY,
  name VARCHAR(250) NOT NULL,
  location VARCHAR(250) NOT NULL,
  max_seats INTEGER(3) DEFAULT 0
);

CREATE TABLE participantion (
  id INT AUTO_INCREMENT  PRIMARY KEY,
  full_name VARCHAR(150) NOT NULL,
  conference_id INT DEFAULT NULL,
  birth_date DATE NOT NULL
);

  CREATE TABLE conference (
  id INT AUTO_INCREMENT  PRIMARY KEY,
  name VARCHAR(250) NOT NULL,
  location VARCHAR(250) NOT NULL,
  date_time DATETIME NOT NULL,
  max_seats INTEGER(3) DEFAULT NULL,
  status VARCHAR(10) DEFAULT 'ACTIVE',
  participant_num INTEGER(3) DEFAULT 0

);

/*
CREATE TABLE participant (
  id INT AUTO_INCREMENT  PRIMARY KEY,
  full_name VARCHAR(150) NOT NULL,
  birth_time DATE() NOT NULL,
);

INSERT INTO participant (full_name, birth_time) VALUES ('Marina Voskanjan', 15.10.2000);
INSERT INTO conference (name, date_time) VALUES ('Daily meeting', 15.10.2020);
 */
INSERT INTO conference_room (name, location, max_seats) VALUES
  ('M/S	Baltic	Queen	conference', 'M/S	Baltic	Queen', 124),
  ('M/S	Baltic	Silja	conference', 'M/S	 Silja Line', 100),
  ('M/S	Baltic	Romantika	conference', 'M/S	 Romantika room', 50),
  ('M/S	Baltic	Megastar	conference', 'M/S	 Megastar', 80);


