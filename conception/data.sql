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
('Gel dentaire', 'Soulage les douleurs dentaires des enfants.', 1, 1, 3),
('Vaccin Hépatite B pour adulte', 'Protège contre le virus de hépatite B.', 3, 4, 1);

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
(4,1);

/* 2e  */
INSERT INTO client(nom) VALUES('Jean');
INSERT INTO client(nom) VALUES('Jack');
INSERT INTO client(nom) VALUES('Goldman');

INSERT INTO fabrication (id_produit , date_fabrication , date_peremption , prix ) VALUES (1,'2024-01-01','2025-01-01',12000);
INSERT INTO fabrication (id_produit , date_fabrication , date_peremption , prix ) VALUES (2,'2024-01-01','2025-01-01',1000);
INSERT INTO fabrication (id_produit , date_fabrication , date_peremption , prix ) VALUES (3,'2024-01-01','2025-01-01',25000);
INSERT INTO fabrication (id_produit , date_fabrication , date_peremption , prix ) VALUES (4,'2024-01-01','2025-01-01',20000);
INSERT INTO fabrication (id_produit , date_fabrication , date_peremption , prix ) VALUES (5,'2024-01-01','2025-01-01',10000);
INSERT INTO fabrication (id_produit , date_fabrication , date_peremption , prix ) VALUES (6,'2024-01-01','2025-01-01',50000);
INSERT INTO fabrication (id_produit , date_fabrication , date_peremption , prix ) VALUES (7,'2024-01-01','2025-01-01',5000);
INSERT INTO fabrication (id_produit , date_fabrication , date_peremption , prix ) VALUES (8,'2024-01-01','2025-01-01',200000);
INSERT INTO fabrication (id_produit , date_fabrication , date_peremption , prix ) VALUES (9,'2024-01-01','2025-01-01',60000);
INSERT INTO fabrication (id_produit , date_fabrication , date_peremption , prix ) VALUES (10,'2024-01-01','2025-01-01',1000);
INSERT INTO fabrication (id_produit , date_fabrication , date_peremption , prix ) VALUES (11,'2024-01-01','2025-01-01',3000);
INSERT INTO fabrication (id_produit , date_fabrication , date_peremption , prix ) VALUES (12,'2024-01-01','2025-01-01',6500);
INSERT INTO fabrication (id_produit , date_fabrication , date_peremption , prix ) VALUES (13,'2024-01-01','2025-01-01',55500);
INSERT INTO fabrication (id_produit , date_fabrication , date_peremption , prix ) VALUES (14,'2024-01-01','2025-01-01'.25000);

--insertion des donnees dans la table con
INSERT INTO conseil (mois ,annee , id_produit ) VALUES
(1,2025,8),
(1,2025,13),
(1,2025,10),
(2,2025,4),
(2,2025,2),
(3,2025,12),
(3,2025,3);

/* Les injectables sont */

/* 
    5 - Vaccins epathite B
    6 - 
    7 -
    8 - 
 */