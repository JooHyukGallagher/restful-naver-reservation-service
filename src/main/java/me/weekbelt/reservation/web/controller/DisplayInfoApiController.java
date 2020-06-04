package me.weekbelt.reservation.web.controller;

import lombok.RequiredArgsConstructor;
import me.weekbelt.reservation.domain.reservationUserComment.ReservationUserCommentRepository;
import me.weekbelt.reservation.factory.displayInfo.DisplayInfoFactory;
import me.weekbelt.reservation.service.DisplayInfoImageService;
import me.weekbelt.reservation.service.ProductImageService;
import me.weekbelt.reservation.service.ProductPriceService;
import me.weekbelt.reservation.service.ProductService;
import me.weekbelt.reservation.web.form.displayInfo.DisplayInfoResponse;
import me.weekbelt.reservation.web.form.displayInfoImage.DisplayInfoImageDto;
import me.weekbelt.reservation.web.form.displayInfoImage.DisplayInfoResponseModel;
import me.weekbelt.reservation.web.form.product.ProductDto;
import me.weekbelt.reservation.web.form.product.ProductModel;
import me.weekbelt.reservation.web.form.productImage.ProductImageDto;
import me.weekbelt.reservation.web.form.productPrice.ProductPriceDto;
import org.springframework.hateoas.EntityModel;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;

@RequiredArgsConstructor
@RequestMapping("/api")
@RestController
public class DisplayInfoApiController {

    private final ProductService productService;
    private final ProductImageService productImageService;
    private final DisplayInfoImageService displayInfoImageService;
    private final ProductPriceService productPriceService;
    private final ReservationUserCommentRepository reservationUserCommentRepository;

    @GetMapping("/v1/displayinfos/{displayInfoId}")
    public DisplayInfoResponse displayInfoV1(@PathVariable Long displayInfoId){
        ProductDto product = productService.findProductDtoByDisplayInfoId(displayInfoId);
        List<ProductImageDto> productImages = productImageService.findProductImageDtoList(product.getId());
        List<DisplayInfoImageDto> displayInfoImages = displayInfoImageService.findDisplayInfoImageDtoByDisplayInfoId(displayInfoId);
        Double avgScore = reservationUserCommentRepository.commentAverageScoreByProductId(product.getId());
        List<ProductPriceDto> productPrices = productPriceService.findProductPriceDtoListByProductId(product.getId());

        return DisplayInfoFactory.makeDisplayInfoResponse(product, productImages, displayInfoImages, avgScore, productPrices);
    }

    @GetMapping("/v2/displayinfos/{displayInfoId}")
    public ResponseEntity<?> displayInfoV2(@PathVariable Long displayInfoId){
        ProductDto product = productService.findProductDtoByDisplayInfoId(displayInfoId);
        EntityModel<ProductDto> model = ProductModel.of(product, linkTo(DisplayInfoApiController.class).slash(displayInfoId).withSelfRel());
        // TODO : productDto profile 문서 링크 추가
        List<ProductImageDto> productImages = productImageService.findProductImageDtoList(product.getId());
        // TODO : productImageDto profile 문서 링크 추가
        List<DisplayInfoImageDto> displayInfoImages = displayInfoImageService.findDisplayInfoImageDtoByDisplayInfoId(displayInfoId);
        // TODO : displayInfoImageDto profile 문서 링크 추가
        Double avgScore = reservationUserCommentRepository.commentAverageScoreByProductId(product.getId());
        // TODO: avg profile 문서 링크 추가
        List<ProductPriceDto> productPrices = productPriceService.findProductPriceDtoListByProductId(product.getId());
        // TODO: productPriceDto profile 문서 링크 추가

        DisplayInfoResponseModel displayInfoResponseModel = DisplayInfoFactory.makeDisplayInfoResponseModel(model, productImages, displayInfoImages, avgScore, productPrices);
        return ResponseEntity.ok(displayInfoResponseModel);
    }

}
