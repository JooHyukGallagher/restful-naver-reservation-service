package me.weekbelt.reservation.web.form.product;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.domain.Page;

import java.util.List;

@Builder @NoArgsConstructor @AllArgsConstructor
@Getter
public class ProductResponse {

    private Long totalCount;

    private Integer productCount;

    private Page<ProductDto> products;

}
