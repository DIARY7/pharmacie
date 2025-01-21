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
import com.gestionprojet.pharmacie.entity.produit.Fabrication;
import com.gestionprojet.pharmacie.entity.produit.Produit;
import com.gestionprojet.pharmacie.entity.vente.Commission;
import com.gestionprojet.pharmacie.entity.vente.Vente;
import com.gestionprojet.pharmacie.repository.produit.CategorieAgeRepo;
import com.gestionprojet.pharmacie.repository.produit.CategorieProduitRepo;
import com.gestionprojet.pharmacie.repository.produit.FabricationRepo;
import com.gestionprojet.pharmacie.repository.vente.ClientRepo;
import com.gestionprojet.pharmacie.repository.vente.CommissionRepo;
import com.gestionprojet.pharmacie.repository.vente.VendeurRepo;
import com.gestionprojet.pharmacie.repository.vente.VenteRepo;
import com.gestionprojet.pharmacie.service.vente.VenteService;

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

    @Autowired
    VendeurRepo vendeurRepo;

    @Autowired
    CommissionRepo commissionRepo;

    @Autowired
    VenteService venteService;

    @GetMapping("/vente")
    public ModelAndView getAllVente(){
        ModelAndView mv= new ModelAndView("template");
        mv.addObject("page", "pages/vente/liste-vente");
        mv.addObject("liste", venteRepo.findAll());
        mv.addObject("listeCatProd", catProdRepo.findAll());
        mv.addObject("listeCatAge", catAgeRepo.findAll());
        mv.addObject("listeVendeur",vendeurRepo.findAll());
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
    ,@RequestParam int id_client,@RequestParam int id_vendeur){
        try {
            Vente vente = new Vente(nombre,daty);
            Fabrication fab = fabRepo.findById(id_fabrication).orElseThrow(()-> new Exception("Fabrication innexistant"));
            vente.setClient(clientRepo.findById(id_client).orElseThrow(()-> new Exception("Client innexistant")));
            vente.setFabrication(fab);
            vente = venteRepo.save(vente);
            Commission commission = new Commission();
            commission.setVente(vente);
            commission.setPrixCommission(venteService.calculeCommission(fab));
            commission.setVendeur(vendeurRepo.findById(id_vendeur).orElseThrow(()-> new Exception("Vendeur innexistant")));
            commissionRepo.save(commission);

        } catch (Exception e) {
            e.printStackTrace();
            return "redirect:/vente/form?message="+e.getMessage();
        }
        return "redirect:/vente/form?message=Insertion%20reussi";
        
    }

    @GetMapping("/vente/filtre")
    public ModelAndView filtreVentre(@RequestParam int id_categorie_produit,int id_categorie_age ) {
        ModelAndView mv = new ModelAndView("template");
        mv.addObject("page", "pages/vente/liste-vente");
        mv.addObject("liste", venteRepo.getFiltreVente(id_categorie_produit, id_categorie_age));
        mv.addObject("listeCatProd", catProdRepo.findAll() );
        mv.addObject("listeCatAge", catAgeRepo.findAll() );
        return mv;
    }

    
    @GetMapping("/client")
    public ModelAndView getAllClient(){
        ModelAndView mv= new ModelAndView("template");
        mv.addObject("page", "pages/vente/liste-client-vente");
        mv.addObject("liste", venteRepo.findAll());
        return mv;
    }
    
    @GetMapping("/client/filtre")
    public ModelAndView getAllClientFiltre(@RequestParam LocalDate date){
        ModelAndView mv= new ModelAndView("template");
        mv.addObject("page", "pages/vente/liste-client-vente");
        mv.addObject("liste", venteRepo.getVenteAndroany(date));
        mv.addObject("daty", date);
        return mv;
    }

    @GetMapping("/vendeur_commission")
    public ModelAndView getAllCommission(){
        ModelAndView mv= new ModelAndView("template");
        mv.addObject("page", "pages/vente/liste-vendeur-commission");
        mv.addObject("liste", commissionRepo.getCommission());
        return mv;
    }
    
    @GetMapping("/vendeur_commission/filtre")
    public ModelAndView getAllCommissionPeriod(@RequestParam LocalDate date_avant,@RequestParam LocalDate date_apres){
        ModelAndView mv= new ModelAndView("template");
        mv.addObject("page", "pages/vente/liste-vendeur-commission");
        mv.addObject("liste", commissionRepo.getFiltreCommission(date_avant,date_apres));
        mv.addObject("date_avant", date_avant);
        mv.addObject("date_apres",date_apres);
        return mv;
    }


    
}
