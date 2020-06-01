package me.weekbelt.reservation.factory.productPrice;

import me.weekbelt.reservation.domain.productPrice.ProductPrice;
import me.weekbelt.reservation.web.form.productPrice.ProductPriceDto;

public class ProductPriceFactory {

    public static ProductPriceDto productPriceToProductPriceDto(ProductPrice productPrice, Long productId){
        return ProductPriceDto.builder()
                .id(productPrice.getId())
                .productId(productId)
                .priceTypeName(productPrice.getPriceTypeName())
                .price(productPrice.getPrice())
                .discountRate(productPrice.getDiscountRate())
                .createDate(productPrice.getCreateDate())
                .modifyDate(productPrice.getModifyDate())
                .build();
    }
}
