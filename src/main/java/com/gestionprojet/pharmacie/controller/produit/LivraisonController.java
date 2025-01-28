package com.gestionprojet.pharmacie.controller.produit;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.gestionprojet.pharmacie.entity.Livraison;
import com.gestionprojet.pharmacie.repository.LivraisonRepo;
import com.gestionprojet.pharmacie.repository.produit.FabricationRepo;
import com.gestionprojet.pharmacie.repository.produit.ProduitRepo;
import com.gestionprojet.pharmacie.service.produit.FabricationService;

@Controller
public class LivraisonController {
    @Autowired
    FabricationRepo fabRepo;

    @Autowired
    ProduitRepo prodRepo;

    @Autowired
    LivraisonRepo livraisonRepo;

    @GetMapping("/livraison")
    public ModelAndView getAllLivraison(){
        ModelAndView mv= new ModelAndView("template");
        mv.addObject("page", "pages/liste/liste-livraison");
        mv.addObject("liste", livraisonRepo.findAll());
        return mv;
    }

    @GetMapping("/livraison/form")
    public ModelAndView toForm(@RequestParam(required=false) String message){
        ModelAndView mv = new ModelAndView("template");
        mv.addObject("page","pages/insertion/insert-livraison");
        mv.addObject("listeFabrication", fabRepo.findAll());
        if (message!=null){
            mv.addObject("message",message);
        }
        return mv;
    } 

    @PostMapping("/livraison/new")
    public String save(@RequestParam int id_fabrication , @RequestParam double prix_unitaire , @RequestParam LocalDate daty ){
        try {
            Livraison livraison = new Livraison(fabRepo.findById(id_fabrication).orElseThrow(()-> new Exception("Fabrication introuvable")), prix_unitaire);
            livraison.setDaty(daty);
        } catch (Exception e) {
            e.printStackTrace();
            return "redirect:/livraison/form?message="+e.getMessage();
        }
        return "redirect:/livraison/form?message=Insertion%20reussi";
        
    }

    @GetMapping("/livraison/filtre")
    public ModelAndView filtreProduit(@RequestParam LocalDate date_avant,@RequestParam LocalDate date_apres) {
        ModelAndView mv = new ModelAndView("template");
        mv.addObject("page", "pages/liste/liste-livraison");
        mv.addObject("liste", livraisonRepo.getLivraisonfiltre(date_avant, date_apres));        
        return mv;
    }
}
