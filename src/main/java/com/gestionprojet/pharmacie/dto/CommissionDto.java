package com.gestionprojet.pharmacie.dto;

import com.gestionprojet.pharmacie.entity.vente.Commission;

import lombok.Data;
@Data
public class CommissionDto {
    Commission commission;
    double total;
    
    public CommissionDto(Commission commission, double total) {
        this.commission=commission;
        this.total=total;
    }

}
