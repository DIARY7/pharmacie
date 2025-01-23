package com.gestionprojet.pharmacie.controller.produit;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.gestionprojet.pharmacie.entity.produit.Produit;
import com.gestionprojet.pharmacie.repository.produit.ProduitRepo;
import com.gestionprojet.pharmacie.service.produit.FabricationService;

@Controller
public class FabricationController {

    @Autowired
    FabricationService fabService;

    @Autowired
    ProduitRepo prodRepo;

    @GetMapping("/fabrication")
    public ModelAndView getAllfabrication(){
        ModelAndView mv= new ModelAndView("template");
        mv.addObject("page", "pages/liste/liste-fabrication");
        mv.addObject("liste", fabService.getAll());
        return mv;
    }

    @GetMapping("/fabrication/form")
    public ModelAndView toForm(@RequestParam(required=false) String message){
        ModelAndView mv = new ModelAndView("template");
        mv.addObject("page","pages/insertion/insert-fabrication");
        mv.addObject("listeProduit",prodRepo.findAll());
        if (message!=null){
            mv.addObject("message",message);
        }
        return mv;
    } 

    @PostMapping("/fabrication/new")
    public String save(@RequestParam int id_produit,@RequestParam LocalDate date_fabrication , @RequestParam LocalDate date_peremption,@RequestParam double prix ){
        try {
            fabService.save(id_produit, date_fabrication, date_peremption,prix);
        } catch (Exception e) {
            e.printStackTrace();
            return "redirect:/fabrication/form?message="+e.getMessage();
        }
        return "redirect:/fabrication/form?message=Insertion%20reussi";
        
    }
}
