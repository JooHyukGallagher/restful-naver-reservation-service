package me.weekbelt.reservation.web.form.promotion;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.RepresentationModel;

@Builder @NoArgsConstructor @AllArgsConstructor
@Getter
public class PromotionDto extends RepresentationModel<PromotionDto> {

    private Long id;

    private Long productId;

    private Long categoryId;

    private Long displayInfoId;

    private String categoryName;

    private String description;

    private Long fileId;
}
