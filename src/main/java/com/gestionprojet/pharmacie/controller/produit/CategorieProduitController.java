package com.gestionprojet.pharmacie.controller.produit;

import com.gestionprojet.pharmacie.entity.produit.CategorieProduit;
import com.gestionprojet.pharmacie.repository.produit.CategorieProduitRepo;
import com.gestionprojet.pharmacie.repository.produit.TypeProduitRepo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class CategorieProduitController {
    
    @Autowired
    CategorieProduitRepo catProRepo;

    @Autowired
    TypeProduitRepo typeProduitRepo;

    @GetMapping("/categorie-produit")
    public ModelAndView getAll(){
        ModelAndView mv = new ModelAndView("template");
        mv.addObject("page","pages/liste/liste-categorie-produit");
        mv.addObject("liste", catProRepo.findAll());
        return mv;
    } 

    @GetMapping("/categorie-produit/form")
    public ModelAndView toForm(@RequestParam(required=false) String message){
        ModelAndView mv = new ModelAndView("template");
        mv.addObject("page","pages/insertion/insert-categorie-produit");
        mv.addObject("listeTypeProduit", typeProduitRepo.findAll());
        if (message!=null){
            mv.addObject("message",message);
        }
        return mv;
    }  

    @PostMapping("/categorie-produit/new")
    public String save(@RequestParam String val, @RequestParam int id_type_produit){
        try {
            CategorieProduit catProduit = new CategorieProduit(val, typeProduitRepo.findById(id_type_produit).orElseThrow(()-> new Exception("Type produit n'existe pas")) );
            catProRepo.save(catProduit);
        } catch (Exception e) {
            e.printStackTrace();
            return "redirect:/categorie-produit/form?message="+e.getMessage();
        }
        return "redirect:/categorie-produit/form?message=Insertion%20reussi";
        
    }
}
