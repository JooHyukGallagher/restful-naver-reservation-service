package me.weekbelt.reservation.web.controller;

import lombok.RequiredArgsConstructor;
import me.weekbelt.reservation.domain.promotion.PromotionRepository;
import me.weekbelt.reservation.factory.promotion.PromotionFactory;
import me.weekbelt.reservation.web.form.promotion.PromotionDto;
import me.weekbelt.reservation.web.form.promotion.PromotionResponse;
import org.springframework.hateoas.CollectionModel;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@RequiredArgsConstructor
@RequestMapping("/api")
@RestController
public class PromotionApiController {

    private final PromotionRepository promotionRepository;

    @GetMapping("/v1/promotions")
    public ResponseEntity<?> promotionsV2() {
        List<PromotionDto> promotions = promotionRepository.findPromotions();
        promotions.forEach(promotionDto -> promotionDto
                .add(linkTo(methodOn(DisplayInfoApiController.class).displayInfoV2(promotionDto.getDisplayInfoId())).withSelfRel()));

        CollectionModel<PromotionDto> promotionModel = CollectionModel
                .of(promotions, linkTo(methodOn(PromotionApiController.class).promotionsV2()).withSelfRel());
        return ResponseEntity.ok(promotionModel);
    }
}
