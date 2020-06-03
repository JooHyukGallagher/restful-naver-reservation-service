package me.weekbelt.reservation.factory.promotion;

import me.weekbelt.reservation.web.form.promotion.PromotionDto;
import me.weekbelt.reservation.web.form.promotion.PromotionResponse;

import java.util.List;

public class PromotionFactory {
    public static PromotionResponse makePromotionResponse(List<PromotionDto> promotions) {
        return PromotionResponse.builder()
                .size(promotions.size())
                .items(promotions)
                .build();
    }
}
