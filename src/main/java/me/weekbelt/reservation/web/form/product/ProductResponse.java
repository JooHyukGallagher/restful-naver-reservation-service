package me.weekbelt.reservation.web.form.product;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Builder @NoArgsConstructor @AllArgsConstructor
@Getter
public class ProductResponse {

    private Integer totalCount;

    private Integer productCount;

    private List<ProductDto> products;
}
