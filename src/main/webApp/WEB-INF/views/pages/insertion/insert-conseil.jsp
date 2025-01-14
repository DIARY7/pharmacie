<%@ page language="java" contentType="text/html;charset=UTF-8" %>
<%@ page import="java.util.List" %>
<%@ page import="com.gestionprojet.pharmacie.entity.produit.Produit" %>
<% 
  List<Produit> listeProduit = (List<Produit>) request.getAttribute("liste_produit");
%>
<div class="col-md-8">
    <div class="card mb-4">
      <h5 class="card-header">Insertion Conseil</h5>
      <div class="card-body">
        <form action="/produit_conseil/new" method="POST">
            <div class="mb-3">
              <label for=""class="form-label" >Produit : </label>
              <select class="form-select" name="id_produit">
                <% for(Produit prod: listeProduit){ %>
                  <option value="<%= prod.getId() %>"><%= prod.getNom()  %></option>
                <% } %>
              </select>
            </div>
            <div class="mb-3">
                <label for="age_min" class="form-label">Mois </label>
                <input
                  type="number"
                  class="form-control"
                  name="mois"
                  value="14"
                />
              </div>

              <div class="mb-3">
                <label for="age_min" class="form-label">Annee </label>
                <input
                  type="number"
                  class="form-control"
                  name="annee"
                  value="2025"
                />
              </div>
              <button type="submit" class="btn btn-primary">Valider</button>
        </form>
      </div>  
    </div>
</div>