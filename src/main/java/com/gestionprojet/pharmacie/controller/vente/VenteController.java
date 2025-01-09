package com.gestionprojet.pharmacie.controller.vente;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.gestionprojet.pharmacie.entity.produit.CategorieAge;
import com.gestionprojet.pharmacie.entity.produit.CategorieProduit;
import com.gestionprojet.pharmacie.entity.produit.Produit;
import com.gestionprojet.pharmacie.entity.vente.Vente;
import com.gestionprojet.pharmacie.repository.produit.CategorieAgeRepo;
import com.gestionprojet.pharmacie.repository.produit.CategorieProduitRepo;
import com.gestionprojet.pharmacie.repository.produit.FabricationRepo;
import com.gestionprojet.pharmacie.repository.vente.ClientRepo;
import com.gestionprojet.pharmacie.repository.vente.VenteRepo;

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
    public String save(@RequestParam int id_fabrication , @RequestParam double nombre,@RequestParam LocalDate daty
    ,@RequestParam int id_client){
        try {
            Vente vente = new Vente(nombre,daty);
            
        } catch (Exception e) {
            e.printStackTrace();
            return "redirect:/vente/form?message="+e.getMessage();
        }
        return "redirect:/vente/form?message=Insertion%20reussi";
        
    }
}
