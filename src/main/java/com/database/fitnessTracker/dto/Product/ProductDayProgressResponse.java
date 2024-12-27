package com.database.fitnessTracker.dto.Product;

import com.database.fitnessTracker.entity.DayProgressProduct;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ProductDayProgressResponse {
    private int Id;
    private String UserName;
    private String ProductName;
    private Integer ProductCalories;
    private Double ProductProteins;
    private Double ProductFats;
    private Double ProductCarbohydrates;

    public ProductDayProgressResponse(DayProgressProduct dayProgressProduct) {
        this.Id = dayProgressProduct.getId();
        this.UserName = dayProgressProduct.getDayProgress().getUser().getUsername();
        this.ProductName = dayProgressProduct.getProduct().getName();
        this.ProductCalories = dayProgressProduct.getProduct().getCalories();
        this.ProductProteins = dayProgressProduct.getProduct().getProteins();
        this.ProductFats = dayProgressProduct.getProduct().getFats();
        this.ProductCarbohydrates = dayProgressProduct.getProduct().getCarbohydrates();
    }
}
