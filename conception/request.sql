SELECT 
    p.*
FROM 
    produit AS p
JOIN 
    curration AS c ON p.id = c.id_produit
JOIN 
    maladie AS m ON m.id = c.id_maladie
WHERE 
    m.id = '1'
    AND p.id_categorie_age = '1';
