package me.weekbelt.reservation.web.controller;

import lombok.RequiredArgsConstructor;
import me.weekbelt.reservation.domain.promotion.PromotionRepository;
import me.weekbelt.reservation.web.form.promotion.PromotionDto;
import me.weekbelt.reservation.web.form.promotion.PromotionResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@RequestMapping("/api")
@RestController
public class PromotionApiController {

    private final PromotionRepository promotionRepository;

    @GetMapping("/v1/promotions")
    public PromotionResponse promotions() {
        List<PromotionDto> promotions = promotionRepository.findPromotions();
        return makePromotionResponse(promotions);
    }

    private PromotionResponse makePromotionResponse(List<PromotionDto> promotions) {
        return PromotionResponse.builder()
                .size(promotions.size())
                .items(promotions)
                .build();
    }
}
