package me.weekbelt.reservation.web.form.promotion;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Builder @NoArgsConstructor @AllArgsConstructor
@Getter
public class PromotionResponse {

    private Integer size;

    private List<PromotionDto> items;
}
