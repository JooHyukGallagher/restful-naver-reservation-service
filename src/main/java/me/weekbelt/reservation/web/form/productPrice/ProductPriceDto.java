package me.weekbelt.reservation.web.form.productPrice;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Builder @NoArgsConstructor @AllArgsConstructor
@Getter
public class ProductPriceDto {

    private Long id;

    private Long productId;

    private String priceTypeName;

    private Integer price;

    private Double discountRate;

    private LocalDateTime createDate;

    private LocalDateTime modifyDate;
}
