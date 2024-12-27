package com.database.fitnessTracker.dto.Product;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ProductDayProgressRequest {
    private Integer ProductId;
    private Integer UserId;
    private LocalDateTime date;
}
