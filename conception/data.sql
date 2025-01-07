-- Insertion de données dans la table type_produit
INSERT INTO type_produit (val) VALUES 
('Médicament'),
('Complément alimentaire'),
('Cosmétique');

-- Insertion de données dans la table categorie_produit
INSERT INTO categorie_produit (val, id_type_produit) VALUES 
('Analgésiques', 1),
('Vitamines', 2),
('Crèmes hydratantes', 3);

-- Insertion de données dans la table produit
INSERT INTO produit (nom, description, age_min, id_categorie_produit) VALUES 
('Paracétamol', 'Soulage la douleur et réduit la fièvre.', 12, 1),
('Vitamine C', 'Renforce le système immunitaire.', 3, 2),
('Crème hydratante visage', 'Hydrate et protège la peau.', 0, 3);

-- Insertion de données dans la table laboratoire
INSERT INTO laboratoire (nom, lieu) VALUES 
('Laboratoire Sanofi', 'Paris, France'),
('Laboratoire Bayer', 'Berlin, Allemagne'),
('Laboratoire Roche', 'Bâle, Suisse');