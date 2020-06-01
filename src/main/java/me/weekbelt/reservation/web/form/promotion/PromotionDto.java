package me.weekbelt.reservation.web.form.promotion;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Builder @NoArgsConstructor @AllArgsConstructor
@Getter
public class PromotionDto {

    private Long id;

    private Long productId;

    private Long categoryId;

    private String categoryName;

    private String description;

    private Long fileId;
}
