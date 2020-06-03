package me.weekbelt.reservation.factory.product;

import me.weekbelt.reservation.domain.displayInfo.DisplayInfo;
import me.weekbelt.reservation.web.form.product.ProductDto;
import me.weekbelt.reservation.web.form.product.ProductResponse;
import org.springframework.data.domain.Page;

public class ProductFactory {

    public static ProductDto displayInfoToProductDto(DisplayInfo displayInfo){
        return ProductDto.builder()
                .id(displayInfo.getProduct().getId())
                .categoryId(displayInfo.getProduct().getCategory().getId())
                .displayInfoId(displayInfo.getId())
                .name(displayInfo.getProduct().getCategory().getName())
                .description(displayInfo.getProduct().getDescription())
                .content(displayInfo.getProduct().getContent())
                .event(displayInfo.getProduct().getEvent())
                .openingHours(displayInfo.getOpeningHours())
                .placeName(displayInfo.getPlaceName())
                .placeLot(displayInfo.getPlaceLot())
                .placeStreet(displayInfo.getPlaceStreet())
                .tel(displayInfo.getTel())
                .homepage(displayInfo.getHomepage())
                .email(displayInfo.getEmail())
                .createDate(displayInfo.getCreateDate())
                .modifyDate(displayInfo.getModifyDate())
                .build();
    }

    public static ProductResponse makeProductResponse(Page<ProductDto> products) {
        return ProductResponse.builder()
                .totalCount(products.getTotalElements())
                .productCount(products.getNumberOfElements())
                .products(products)
                .build();
    }
}
