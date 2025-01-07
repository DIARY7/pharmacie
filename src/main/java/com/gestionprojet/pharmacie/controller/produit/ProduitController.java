package com.gestionprojet.pharmacie.controller.produit;

import com.gestionprojet.pharmacie.entity.produit.Produit;
import com.gestionprojet.pharmacie.entity.produit.TypeProduit;
import com.gestionprojet.pharmacie.repository.produit.CategorieProduitRepo;
import com.gestionprojet.pharmacie.repository.produit.LaboratoireRepo;
import com.gestionprojet.pharmacie.repository.produit.ProduitRepo;
import com.gestionprojet.pharmacie.repository.produit.TypeProduitRepo;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ProduitController {
    @Autowired
    CategorieProduitRepo catProRepo;

    @Autowired
    ProduitRepo prodRepo;

    @Autowired
    TypeProduitRepo typeProdRepo;

    @Autowired
    LaboratoireRepo laboRepo;

    @GetMapping("/produit")
    public ModelAndView getAllProduit(){
        ModelAndView mv= new ModelAndView("template");
        mv.addObject("page", "pages/liste/liste-produit");
        mv.addObject("liste", prodRepo.findAll());
        return mv;
    }

    @GetMapping("/produit/form")
    public ModelAndView toForm(@RequestParam(required=false) String message){
        ModelAndView mv = new ModelAndView("template");
        mv.addObject("page","pages/insertion/insert-produit");
        mv.addObject("listeCategorie",catProRepo.findAll());
        mv.addObject("listeLabo", laboRepo.findAll() );
        if (message!=null){
            mv.addObject("message",message);
        }
        return mv;
    } 

    @PostMapping("/produit/new")
    public String save(@RequestParam(required = false) String nom, @RequestParam String description,@RequestParam(name="age_min") int ageMin
    ,@RequestParam int id_categorie_produit,@RequestParam int id_labo,@RequestParam LocalDate date_fabrication,@RequestParam LocalDate date_peremption){
        try {
            Produit produit = new Produit(nom, description, ageMin,catProRepo.findById(id_categorie_produit).orElseThrow(()->new Exception("Categorie n'existe pas")));
            produit.setLaboratoire(laboRepo.findById(id_labo).orElseThrow(()-> new Exception("Labo inexistant")));
            produit.setDateFabrication(date_fabrication);
            produit.setDatePeremption(date_peremption);

            prodRepo.save(produit);
        } catch (Exception e) {
            e.printStackTrace();
            return "redirect:/produit/form?message="+e.getMessage();
        }
        return "redirect:/produit/form?message=Insertion%20reussi";
        
    }

    /* Type produit */
    @GetMapping("/type-produit")
    public ModelAndView getAll(){
        ModelAndView mv = new ModelAndView("template");
        mv.addObject("page","pages/liste/liste-type-produit");
        mv.addObject("liste", typeProdRepo.findAll());
        return mv;
    } 

    @GetMapping("/type-produit/form")
    public ModelAndView toFormTypeProduit(@RequestParam(required=false) String message){
        ModelAndView mv = new ModelAndView("template");
        mv.addObject("page","pages/insertion/insert-type-produit");
        if (message!=null){
            mv.addObject("message",message);
        }
        return mv;
    }  

    @PostMapping("/type-produit/new")
    public String saveTypeProduit(@RequestParam String val){
        try {
            TypeProduit typeProduit = new TypeProduit(val);
            typeProdRepo.save(typeProduit);
        } catch (Exception e) {
            e.printStackTrace();
            return "redirect:/type-produit/form?message="+e.getMessage();
        }
        return "redirect:/type-produit/form?message=Insertion%20reussi";
        
    }

    /*-------------------------------------------------*/
}
