package com.gestionprojet.pharmacie.controller.produit;

import com.gestionprojet.pharmacie.entity.produit.Produit;
import com.gestionprojet.pharmacie.entity.produit.TypeProduit;
import com.gestionprojet.pharmacie.repository.maladie.MaladieRepo;
import com.gestionprojet.pharmacie.repository.produit.CategorieAgeRepo;
import com.gestionprojet.pharmacie.repository.produit.CategorieProduitRepo;
import com.gestionprojet.pharmacie.repository.produit.ConseilRepo;
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

    @Autowired
    CategorieAgeRepo catAgeRepo;

    @Autowired
    MaladieRepo maladieRepo;

    @Autowired
    ConseilRepo conseilRepo;

    @GetMapping("/produit")
    public ModelAndView getAllProduit(){
        ModelAndView mv= new ModelAndView("template");
        mv.addObject("page", "pages/liste/liste-produit");
        mv.addObject("liste", prodRepo.findAll());
        mv.addObject("listeCategorieAge", catAgeRepo.findAll() );
        mv.addObject("listeMaladie", maladieRepo.findAll());
        return mv;
    }

    @GetMapping("/produit/form")
    public ModelAndView toForm(@RequestParam(required=false) String message){
        ModelAndView mv = new ModelAndView("template");
        mv.addObject("page","pages/insertion/insert-produit");
        mv.addObject("listeCategorie",catProRepo.findAll());
        mv.addObject("listeLabo", laboRepo.findAll() );
        mv.addObject("listeCategorieAge", catAgeRepo.findAll() );
        if (message!=null){
            mv.addObject("message",message);
        }
        return mv;
    } 

    @PostMapping("/produit/new")
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

    @GetMapping("/produit/filtre")
    public ModelAndView filtreProduit(@RequestParam int id_maladie,int id_categorie_age) {
        ModelAndView mv = new ModelAndView("template");
        mv.addObject("page", "pages/liste/liste-produit");
        mv.addObject("liste", prodRepo.getFiltreProducts(id_maladie, id_categorie_age));
        mv.addObject("listeCategorieAge", catAgeRepo.findAll());
        mv.addObject("listeMaladie", maladieRepo.findAll());
        return mv;
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

    @PostMapping("/produit_conseil/new")
    public String saveConseil(@RequestParam int id_produit  , @RequestParam int mois,@RequestParam int annee){
        try {
            Conseil conseil = new Conseil(mois,annee,prodRepo.findById(id_produit).orElseThrow(()-> new Exception("Produit introuvable") )) ;
            conseilRepo.save(conseil);
        } catch (Exception e) {
            e.printStackTrace();
            return "redirect:/produit_conseil/form?message="+e.getMessage();
        }
        return "redirect:/produit_conseil/form?message=Insertion%20reussi";
    }

    
    @GetMapping("/produit_conseil/form")
    public ModelAndView toFormProduitConseil(@RequestParam(required=false) String message){
        ModelAndView mv = new ModelAndView("template");
        mv.addObject("page","pages/insertion/insert-conseil");
        mv.addObject( "liste_produit" , prodRepo.findAll());
        if (message!=null){
            mv.addObject("message",message);
        }
        return mv;
    }
    
    @GetMapping("/produit_conseil/filtre")
    public ModelAndView filtreProduitConseil(@RequestParam int mois,int annee) {
        ModelAndView mv = new ModelAndView("template");
        mv.addObject("page", "pages/liste/liste-produit-conseil");
        mv.addObject("liste", conseilRepo.getFiltreConseil(mois, annee));
        return mv;
    }

    @GetMapping("/produit_conseil")
    public ModelAndView getAllProduitConseil(){
        ModelAndView mv= new ModelAndView("template");
        mv.addObject("page", "pages/liste/liste-produit");
        mv.addObject("liste", conseilRepo.getFiltreConseil(LocalDate.now().getMonthValue(), LocalDate.now().getYear()));
        return mv;
    }

}
