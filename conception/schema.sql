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
CREATE TABLE categorie_age(
    id SERIAL PRIMARY KEY ,
    val VARCHAR(125),
    age_min INTEGER,
    age_max INTEGER
);

CREATE TABLE produit(
    id SERIAL PRIMARY KEY,
    nom VARCHAR,
    description TEXT,
    id_categorie_produit INTEGER,
    id_laboratoire INTEGER,
    id_categorie_age INTEGER,
    FOREIGN KEY(id_categorie_produit) REFERENCES categorie_produit(id),
    FOREIGN KEY(id_laboratoire) REFERENCES laboratoire(id),
    FOREIGN KEY(id_categorie_age) REFERENCES categorie_age(id)
);

CREATE TABLE fabrication(
    id SERIAL PRIMARY KEY,
    id_produit INTEGER,
    date_fabrication DATE,
    date_peremption DATE,
    prix DECIMAL,
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

CREATE TABLE livraison( /* Historique prix */
    id SERIAL PRIMARY KEY,
    id_fabrication INTEGER,
    prix_unitaire DECIMAL,
    daty DATE,
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

CREATE TABLE client(
    id SERIAL PRIMARY KEY ,
    nom VARCHAR(120)
);
CREATE TABLE vente(
    id SERIAL PRIMARY KEY,
    id_livraison INTEGER,
    nombre DECIMAL,
    daty DATE,
    id_client INTEGER,
    FOREIGN KEY(id_livraison) REFERENCES livraison(id),
    FOREIGN KEY(id_client) REFERENCES client(id)
);

CREATE TABLE conseil(
    id SERIAL PRIMARY KEY,
    id_produit INTEGER,
    mois int ,
    annee int,
    FOREIGN KEY(id_produit) REFERENCES produit(id)
);

CREATE TABLE sexe(
    id SERIAL PRIMARY KEY,
    valeur VARCHAR(10)  
);

CREATE TABLE vendeur(
    id SERIAL PRIMARY KEY,
    nom VARCHAR,
    id_sexe INTEGER,
    FOREIGN KEY(id_sexe) REFERENCES sexe(id);
);


CREATE TABLE commission(
    id SERIAL PRIMARY KEY,
    id_vendeur INTEGER,
    id_vente INTEGER,
    prix_commission DECIMAL,
    FOREIGN KEY(id_vendeur) REFERENCES vendeur(id),
    FOREIGN KEY(id_vente) REFERENCES vente(id)
);

/* Manao Fifo raha misy sortie */

/* Vu pour le Stock actuel */
-- CREATE OR REPLACE VIEW etat_stock as  
-- SELECT id_produit,SUM(entree) - SUM(sortie) as nombre FROM mvt_stock  

/* Mi recherche sequence */
/*SELECT pg_get_serial_sequence('produit', 'id'); */

/* Mi-reinitialiser sequence */
/* ALTER SEQUENCE public.produit_id_seq RESTART WITH 1; */
