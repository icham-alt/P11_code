DROP TABLE IF EXISTS hopitaux;
 
CREATE TABLE hopitaux (
  id INT AUTO_INCREMENT  PRIMARY KEY,
  Hopital_nom VARCHAR(250) NOT NULL,
  Hopital_adresse VARCHAR(250) NOT NULL,
  Specialisation VARCHAR(250) NOT NULL,
  lits_disponibles INT NOT NULL
);

CREATE TABLE Patients (
  Patient_id INT AUTO_INCREMENT  PRIMARY KEY,
  Patient_nom VARCHAR(250) NOT NULL,
  Patient_prenom VARCHAR(250) NOT NULL,
  Patient_numero VARCHAR(250) NOT NULL,
  Patient_blessure VARCHAR(250) NOT NULL,
  Patient_specialisation VARCHAR(250) NOT NULL
);
 
INSERT INTO hopitaux (Hopital_nom, Hopital_adresse, Specialisation, lits_disponibles) VALUES
  ('Hôpital Fred Brooks', '40 rue du jardin 75101 Paris', 'Cardiologie, immunologie',17),
  ('Hôpital Julia Crusher', '87 avenue de brooklin 69004 Lyon', 'Cardiologie', 0),
  ('Hôpital Beverly Bashir', '2 rue du pont 30072 Bordeaux', 'Immunologie, neuropathologie,
diagnostic', 20);