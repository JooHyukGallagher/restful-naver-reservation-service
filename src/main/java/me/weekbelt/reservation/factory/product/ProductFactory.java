package me.weekbelt.reservation.factory.product;

import me.weekbelt.reservation.domain.displayInfo.DisplayInfo;
import me.weekbelt.reservation.web.form.product.ProductDto;

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
}
