DROP TABLE IF EXISTS conference_room;
DROP TABLE IF EXISTS conference;
DROP TABLE IF EXISTS participation;


 CREATE TABLE conference_room (
  id INT AUTO_INCREMENT  PRIMARY KEY,
  name VARCHAR(250) NOT NULL,
  location VARCHAR(250) NOT NULL,
  max_seats INTEGER(3) DEFAULT 0
);

CREATE TABLE participation (
  id INT AUTO_INCREMENT  PRIMARY KEY,
  full_name VARCHAR(150) NOT NULL,
  conference_id INT DEFAULT NULL,
  birth_date VARCHAR(50) NOT NULL
);

  CREATE TABLE conference (
  id INT AUTO_INCREMENT  PRIMARY KEY,
  name VARCHAR(250) NOT NULL,
  location VARCHAR(250) NOT NULL,
  date VARCHAR(50) NOT NULL,
  max_seats INTEGER(3) DEFAULT NULL,
  status VARCHAR(10) DEFAULT 'ACTIVE'

);

INSERT INTO conference_room (name, location, max_seats) VALUES
  ('M/S	Baltic	Queen	conference', 'M/S	Baltic	Queen', 124),
  ('M/S	Baltic	Silja	conference', 'M/S	 Silja Line', 100),
  ('M/S	Baltic	Romantika	conference', 'M/S	 Romantika room', 50),
  ('M/S	Baltic	Megastar	conference', 'M/S	 Megastar', 80);


