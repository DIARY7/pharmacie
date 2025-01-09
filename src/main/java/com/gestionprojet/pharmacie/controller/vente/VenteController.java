package com.gestionprojet.pharmacie.controller.vente;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.gestionprojet.pharmacie.entity.produit.CategorieAge;
import com.gestionprojet.pharmacie.entity.produit.CategorieProduit;
import com.gestionprojet.pharmacie.entity.produit.Produit;
import com.gestionprojet.pharmacie.repository.produit.CategorieAgeRepo;
import com.gestionprojet.pharmacie.repository.produit.CategorieProduitRepo;
import com.gestionprojet.pharmacie.repository.produit.FabricationRepo;

@Controller
public class VenteController {
    @Autowired
    VenteRepo venteRepo;

    @Autowired
    ClientRepo clientRepo;

    @Autowired
    CategorieAgeRepo catAgeRepo;

    @Autowired
    CategorieProduitRepo catProdRepo;

    @Autowired
    FabricationRepo fabRepo;

    @GetMapping("/vente")
    public ModelAndView getAllProduit(){
        ModelAndView mv= new ModelAndView("template");
        mv.addObject("page", "pages/vente/liste-vente");
        mv.addObject("liste", venteRepo.findAll());
        mv.addObject("listeCatProd", catProdRepo.findAll() );
        mv.addObject("listeCatAge", catAgeRepo.findAll() );
        return mv;
    }

    @GetMapping("/vente/form")
    public ModelAndView toForm(@RequestParam(required=false) String message){
        ModelAndView mv = new ModelAndView("template");
        mv.addObject("page","pages/vente/insert-vente");
        /* Mbola tsy misy resaka stock */
        mv.addObject("listeFabrication", fabRepo.findAll() );
        mv.addObject("listeClient",clientRepo.findAll());
        if (message!=null){
            mv.addObject("message",message);
        }
        return mv;
    } 

    @PostMapping("/vente/new")
    public String save(@RequestParam(required = false) String nom, @RequestParam String description,@RequestParam int id_categorie_age
    ,@RequestParam int id_categorie_produit,@RequestParam int id_labo){
        try {
            Produit produit = new Produit(nom, description,catProRepo.findById(id_categorie_produit).orElseThrow(()->new Exception("Categorie n'existe pas")));
            produit.setLaboratoire(laboRepo.findById(id_labo).orElseThrow(()-> new Exception("Labo inexistant")));
            produit.setCategorieAge(catAgeRepo.findById(id_categorie_age).orElseThrow(()-> new Exception("Categorie inexistant")));
            prodRepo.save(produit);
        } catch (Exception e) {
            e.printStackTrace();
            return "redirect:/produit/form?message="+e.getMessage();
        }
        return "redirect:/produit/form?message=Insertion%20reussi";
        
    }
}
