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
('injectables',1);

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
('Alfa-aylase','reduit les maux de gorge',3,1,2),
('Vaccin Hépatite B', 'Protège contre le virus de hépatite B.', 1, 4, 1),
('Sérum Physiologique', 'Hydrate et nettoie les voies respiratoires.', 1, 4, 2),
('Antihistaminique Injectable', 'Réduit les réactions allergiques sévères.', 1, 4, 3),
('Fer Injectable', 'Traitement anémie chez les enfants.', 1, 4, 2),
('Insuline', 'Régule le taux de sucre dans le sang.', 1, 4, 1),
('Sirop contre la toux', 'Soulage la toux chez les enfants.', 1, 1, 1),
('Gélules Oméga 3', 'Améliore la santé cognitive.', 2, 2, 3),
('Crème solaire enfant', 'Protège la peau des rayons UV.', 1, 3, 2),
('Gel dentaire', 'Soulage les douleurs dentaires des enfants.', 1, 1, 3);

-- Insertion de données dans la table maladie
INSERT INTO maladie (nom) VALUES 
('maux de gorge'),
('fatigue'),
('irritation de la peaux'),
('Hépatite B'),
('Congestion nasale'),
('Allergies sévères'),
('Anémie'),
('Diabète');

-- Insertion de données dans la table curration
INSERT INTO curration (id_produit,id_maladie) VALUES 
(1,1),
(2,2),
(3,3),
(4,1),
((SELECT id FROM produit WHERE nom = 'Vaccin Hépatite B'), (SELECT id FROM maladie WHERE nom = 'Hépatite B')),
((SELECT id FROM produit WHERE nom = 'Sérum Physiologique'), (SELECT id FROM maladie WHERE nom = 'Congestion nasale')),
((SELECT id FROM produit WHERE nom = 'Antihistaminique Injectable'), (SELECT id FROM maladie WHERE nom = 'Allergies sévères')),
((SELECT id FROM produit WHERE nom = 'Fer Injectable'), (SELECT id FROM maladie WHERE nom = 'Anémie')),
((SELECT id FROM produit WHERE nom = 'Insuline'), (SELECT id FROM maladie WHERE nom = 'Diabète'));

 

