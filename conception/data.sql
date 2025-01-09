 -- Insertion de données dans la table type_produit
INSERT INTO type_produit (val) VALUES 
('Médicament'),
('Complément alimentaire'),
('Cosmétique');

-- Insertion de données dans la table categorie_produit
INSERT INTO categorie_produit (val, id_type_produit) VALUES 
('Analgésiques', 1),
('Vitamines', 2),
('Crèmes hydratantes', 3),
('Injectable',1);

INSERT INTO laboratoire (nom, lieu) VALUES 
('Laboratoire Sanofi', 'Paris, France'),
('Laboratoire Bayer', 'Berlin, Allemagne'),
('Laboratoire Roche', 'Bâle, Suisse');

-- Insertion de données dans la table Categorie_age
INSERT INTO categorie_age (age_min,age_max,val) VALUES 
(0,10,'enfant'),
(10,20,'addolescent'),
(20,120,'adulte');


-- Insertion de données dans la table produit
INSERT INTO produit (nom, description, id_categorie_age, id_categorie_produit,id_laboratoire) VALUES 
('Paracétamol', 'Soulage la douleur et réduit la fièvre.',1, 1,2),
('Vitamine C', 'Renforce le système immunitaire.', 2, 2,3),
('Crème hydratante visage', 'Hydrate et protège la peau.',1,3,1),
('Alfa-aylase','reduit les maux de gorge',3,1,2);

-- Insertion de données dans la table maladie
INSERT INTO maladie (nom) VALUES 
('maux de gorge'),
('fatigue'),
('irritation de la peaux');

-- Insertion de données dans la table curration
INSERT INTO curration (id_produit,id_maladie) VALUES 
(1,1),
(2,2),
(3,3),
(4,1);

/* 2e  */
INSERT INTO client(nom) VALUES("Jean");
INSERT INTO client(nom) VALUES("Jack");
INSERT INTO client(nom) VALUES("Goldman");

INSERT INTO fabrication (id_produit , date_fabrication , date_peremption ) VALUES (1,'2024-01-01','2025-01-01');
INSERT INTO fabrication (id_produit , date_fabrication , date_peremption ) VALUES (2,'2024-01-01','2025-01-01');
INSERT INTO fabrication (id_produit , date_fabrication , date_peremption ) VALUES (3,'2024-01-01','2025-01-01');
INSERT INTO fabrication (id_produit , date_fabrication , date_peremption ) VALUES (4,'2024-01-01','2025-01-01');