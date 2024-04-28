DROP TABLE IF EXISTS hopitaux;
 
CREATE TABLE hopitaux (
  id INT AUTO_INCREMENT  PRIMARY KEY,
  Hopital_nom VARCHAR(250) NOT NULL,
  hopitaladresse VARCHAR(250) NOT NULL,
  Specialisation VARCHAR(250) NOT NULL,
  lits_disponibles INT NOT NULL
);

CREATE TABLE Patients (
  Patient_id INT AUTO_INCREMENT  PRIMARY KEY,
  Patient_nom VARCHAR(250) NOT NULL,
  Patient_prenom VARCHAR(250) NOT NULL,
  Patient_numero VARCHAR(250) NOT NULL,
  Patient_blessure VARCHAR(250) NOT NULL,
  Patient_specialisation VARCHAR(250) NOT NULL,
  Patient_localisation VARCHAR(250) NOT NULL
);
 
/**INSERT INTO hopitaux (Hopital_nom, hopitaladresse, Specialisation, lits_disponibles) VALUES
  ('Hôpital Fred Brooks', '40 rue du jardin, Paris, France', 'Cardiologie, immunologie',17),
  ('Hôpital Julia Crusher', '87 avenue de brooklin, Lyon, France', 'Cardiologie', 0),
  ('Hôpital Beverly Bashir', '2 rue du pont, Bordeaux, France', 'Immunologie, neuropathologie, diagnostic', 20),
  ('Hôpital Pierre Dupont', '10 rue de la Paix, Paris, France', 'Chirurgie générale, orthopédie', 15),
  ('Hôpital Marie Curie', '15 boulevard Pasteur, Lyon, France', 'Oncologie, radiothérapie', 25),
  ('Hôpital Charles de Gaulle', '30 avenue des Champs-Élysées, Paris, France', 'Neurologie, neurochirurgie', 12),
  ('Hôpital Jean Jaurès', '5 rue Jean Jaurès, Toulouse, France', 'Pédiatrie, néonatologie', 18),
  ('Hôpital Louis Pasteur', '25 rue Louis Pasteur, Nantes, France', 'Gastro-entérologie, hépatologie', 22),
  ('Hôpital Victor Hugo', '8 avenue Victor Hugo, Nice, France', 'Ophtalmologie, ORL', 10),
  ('Hôpital René Descartes', '12 rue Descartes, Bordeaux, France', 'Rhumatologie, dermatologie', 16),
  ('Hôpital Emile Zola', '20 boulevard Emile Zola, Lille, France', 'Endocrinologie, diabétologie', 21),
  ('Hôpital François Mitterrand', '4 avenue François Mitterrand, Nancy, France', 'Pneumologie, allergologie', 19),
  ('Hôpital Simone Veil', '17 avenue Simone Veil, Rennes, France', 'Gynécologie, obstétrique', 14),
  ('Hôpital Jacques Cartier', '6 rue Jacques Cartier, Nanterre, France', 'Urologie, néphrologie', 13),
  ('Hôpital Georges Pompidou', '20 rue Leblanc, Paris, France', 'Hématologie, oncologie pédiatrique', 11),
  ('Hôpital Antoine Béclère', '157 rue de la Porte de Trivaux, Clamart, France', 'Chirurgie cardio-thoracique, pneumologie', 9),
  ('Hôpital Albert Schweitzer', '2 rue Louis Pasteur, Colmar, France', 'Médecine interne, infectiologie', 23),
  ('Hôpital Paul Brousse', '12 avenue Paul Vaillant-Couturier, Villejuif, France', 'Hématologie, immunologie', 24),
  ('Hôpital Saint-Louis', '1 avenue Claude Vellefaux, Paris, France', 'Hématologie, oncologie', 8),
  ('Hôpital Robert Debré', '48 boulevard Sérurier, Paris, France', 'Pédiatrie, néphrologie pédiatrique', 7);**/
