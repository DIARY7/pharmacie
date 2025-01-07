select * from (select * from produit as p JOIN curration as c on p.id=c.id_produit JOIN maladie as m on m.id=c.id_maladie JOIN categorie_age where m.nom="maux de gorge") as mm where SELECT 
    p.nom AS nom_medicament,
    p.description AS description_medicament
FROM 
    produit p
JOIN 
    curration c ON p.id = c.id_produit
JOIN 
    maladie m ON c.id_maladie = m.id
JOIN 
    categorie_age ca ON p.age_min >= ca.age_min AND (p.age_min <= ca.age_max OR ca.age_max IS NULL)
WHERE 
    m.nom = 'maux de gorge'
    AND ca.val = 'enfant';
