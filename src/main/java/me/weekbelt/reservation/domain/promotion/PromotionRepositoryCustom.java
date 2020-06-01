package me.weekbelt.reservation.domain.promotion;

import me.weekbelt.reservation.web.form.promotion.PromotionDto;

import java.util.List;

public interface PromotionRepositoryCustom {
    List<PromotionDto> findPromotions();
}
