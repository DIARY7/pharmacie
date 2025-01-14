<%@ page language="java" contentType="text/html;charset=UTF-8" %>
<%@ page import="java.util.List" %>
<%@ page import="com.gestionprojet.pharmacie.entity.produit.Produit" %>
<%@ page import="com.gestionprojet.pharmacie.entity.maladie.Maladie" %>
<%@ page import="com.gestionprojet.pharmacie.entity.produit.CategorieAge" %>
<%  
    List<Produit> listeProduits = (List) request.getAttribute("liste");
     
%>
<div class="container-xxl flex-grow-1 container-p-y">
    <h4 class="fw-bold py-3 mb-4"> Liste produits</h4>
    <div class="container row" >
      <form action="/produit_conseil/filtre" method="get">
        <div class="mb-2">
          <label for="mois-label">Mois</label>
          <input type="number" name="mois" id="mois-label">
        </div>
        <div class="mb-2"></div>
        <div class="mb-2">
          <label for="form-label">Annee</label>
          <input type="number" name="annee" id="annee-label">
        </div>
        <div class="mb3" style="margin-bottom:20px;">
          <button class="btn btn-primary">Search</button>

        </div>
      </form>
    </div>
    <div class="card">
      <div class="table-responsive text-nowrap">
        <table class="table table-striped">
          <thead>
            <tr>
              <th>Id</th>
              <th>Nom</th>
              <th>Categorie</th>
              <th>Description</th>
            </tr>
          </thead>
          <tbody class="table-border-bottom-0">
            <% 
                for(Produit prod:listeProduits){ %>
                    <tr>
                        <td><i class="fab fa-angular fa-lg text-danger me-3"></i> <strong><%= prod.getId() %></strong></td>
                        <td><%= prod.getNom() %></td>
                        <td><%= prod.getCategorieProduit().getVal() %></td>
                        <td><%= prod.getDescription() %></td>
                    </tr>
            <%    }
            %>
            </tbody>
        </table>
      </div>
    </div>
</div>