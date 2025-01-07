package com.gestionprojet.pharmacie.controller.produit;

import com.gestionprojet.pharmacie.entity.produit.Laboratoire;
import com.gestionprojet.pharmacie.repository.produit.LaboratoireRepo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class LaboratoireController {
    @Autowired
    LaboratoireRepo laboRepo;

    @GetMapping("/laboratoire")
    public ModelAndView getAll(){
        ModelAndView mv = new ModelAndView("template");
        mv.addObject("page","pages/liste/liste-laboratoire");
        mv.addObject("liste", laboRepo.findAll());
        return mv;
    } 

    @GetMapping("/laboratoire/form")
    public ModelAndView toForm(@RequestParam(required=false) String message){
        ModelAndView mv = new ModelAndView("template");
        mv.addObject("page","pages/insertion/insert-laboratoire");
        if (message!=null){
            mv.addObject("message",message);
        }
        return mv;
    }  

    @PostMapping("/laboratoire/new")
    public String save(@RequestParam String nom, @RequestParam String lieu){
        try {
            Laboratoire labo = new Laboratoire(nom, lieu); 
            laboRepo.save(labo);
        } catch (Exception e) {
            e.printStackTrace();
            return "redirect:/laboratoire/form?message="+e.getMessage();
        }
        return "redirect:/laboratoire/form?message=Insertion%20reussi";
        
    }
}
