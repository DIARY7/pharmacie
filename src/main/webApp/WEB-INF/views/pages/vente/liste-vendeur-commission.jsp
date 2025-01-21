<%@ page language="java" contentType="text/html;charset=UTF-8" %>
<%@ page import="java.util.List" %>
<%@ page import="java.time.LocalDate" %>
<%@ page import="com.gestionprojet.pharmacie.entity.vente.Vente" %>
<%@ page import="com.gestionprojet.pharmacie.dto.CommissionDto" %>

<%  
    List<CommissionDto> listeCommission = (List) request.getAttribute("liste");
    LocalDate date_avant =(LocalDate)request.getAttribute("date_avant");    
    LocalDate date_apres =(LocalDate)request.getAttribute("date_apres");
%>
<div class="container-xxl flex-grow-1 container-p-y">
    <h4 class="fw-bold py-3 mb-4"> Liste Clients</h4>
    <div class="container row" >
      <form action="/vendeur_commission/filtre" method="get">
        <div class="mb-3">
          <label for="form-label">Date Min : </label>
          <input type="date" class="form-control" name="date_avant" id="" value="<% if(date_avant!=null) out.print(date_avant); else out.print(LocalDate.now()); %>">
        </div>

        <div class="mb-3">
            <label for="form-label">Date Max : </label>
            <input type="date" class="form-control" name="date_apres" id="" value="<% if(date_apres!=null) out.print(date_apres); else out.print(LocalDate.now()); %>">
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
              <th>Id Vendeur</th>
              <th>Nom Vendeur</th>
              <th>Commission</th>
            </tr>
          </thead>
          <tbody class="table-border-bottom-0">
            <% 
                for(CommissionDto comDto: listeCommission){ %>
                    <tr>
                        <td><i class="fab fa-angular fa-lg text-danger me-3"></i> <strong><%= vente.getClient().getId() %></strong></td>
                        <td> <%=comDto.getCommission().getVedeur().getId() %> </td>
                        <td><%= comDto.getCommission().getVedeur().getNom() %></td>
                        <td><%= comDto.getTotal() %></td>
                    </tr>
            <%    }
            %>
            </tbody>
        </table>
      </div>
    </div>
</div>