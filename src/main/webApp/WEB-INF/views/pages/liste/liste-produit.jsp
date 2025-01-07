<%@ page language="java" contentType="text/html;charset=UTF-8" %>
<%@ page import="java.util.List" %>
<%@ page import="com.gestionprojet.pharmacie.entity.produit.Produit" %>
<%  
    List<Produit> listeProduits = (List) request.getAttribute("liste");
%>
<div class="container-xxl flex-grow-1 container-p-y">
    <h4 class="fw-bold py-3 mb-4"> Liste produits</h4>
    <div class="card">
      <div class="table-responsive text-nowrap">
        <table class="table table-striped">
          <thead>
            <tr>
              <th>Id</th>
              <th>Nom</th>
              <th>Categorie</th>
              <th>Age_min</th>
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
                        <td><%= prod.getAgeMin() %></td>
                        <td><%= prod.getDescription() %></td>
                    </tr>
            <%    }
            %>
            </tbody>
        </table>
      </div>
    </div>
</div>