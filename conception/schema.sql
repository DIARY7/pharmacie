CREATE DATABASE pharmacie;
\c pharmacie;
CREATE TABLE type_produit(
    id SERIAL PRIMARY KEY,
    val VARCHAR
);
CREATE TABLE categorie_produit(
    id SERIAL PRIMARY KEY,
    val VARCHAR,
    id_type_produit INTEGER,
    FOREIGN KEY(id_type_produit) REFERENCES type_produit(id)
);

CREATE TABLE laboratoire(
    id SERIAL PRIMARY KEY,
    nom VARCHAR,
    lieu VARCHAR
);

CREATE TABLE unite(
    id SERIAL,
    val VARCHAR(50)
);

CREATE TABLE produit(
    id SERIAL PRIMARY KEY,
    nom VARCHAR,
    description TEXT,
    age_min INTEGER,
    id_categorie_produit INTEGER,
    id_laboratoire INTEGER,
    FOREIGN KEY(id_categorie_produit) REFERENCES categorie_produit(id),
    FOREIGN KEY(id_laboratoire) REFERENCES laboratoire(id) 
);

CREATE TABLE fabrication(
    id SERIAL PRIMARY KEY,
    id_produit INTEGER,
    date_fabrication DATE,
    date_peremption DATE,
    FOREIGN KEY(id_produit) REFERENCES produit(id)
);
CREATE TABLE maladie(
    id SERIAL PRIMARY KEY,
    nom VARCHAR
);
CREATE TABLE curration(
    id SERIAL PRIMARY KEY,
    id_produit INTEGER,
    id_maladie INTEGER,
    FOREIGN KEY(id_maladie) REFERENCES maladie(id),
    FOREIGN KEY(id_produit) REFERENCES produit(id)
);

CREATE TABLE livraison(
    id SERIAL PRIMARY KEY,
    id_fabrication INTEGER,
    prix_unitaire DECIMAL,
    FOREIGN KEY(id_fabrication) REFERENCES fabrication(id)
);

CREATE TABLE mvt_stock(
    id SERIAL PRIMARY KEY,
    id_livraison INTEGER,
    entree DECIMAL,
    sortie DECIMAL,
    daty DATE,
    FOREIGN KEY(id_livraison) REFERENCES livraison(id)
);
/* Manao Fifo raha misy sortie */

/* Vu pour le Stock actuel */
-- CREATE OR REPLACE VIEW etat_stock as  
-- SELECT id_produit,SUM(entree) - SUM(sortie) as nombre FROM mvt_stock  

