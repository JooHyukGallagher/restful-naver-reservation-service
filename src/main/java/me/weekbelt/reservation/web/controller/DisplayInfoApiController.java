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
import me.weekbelt.reservation.web.form.product.ProductDto;
import me.weekbelt.reservation.web.form.productImage.ProductImageDto;
import me.weekbelt.reservation.web.form.productPrice.ProductPriceDto;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

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
    public DisplayInfoResponse displayInfo(@PathVariable Long displayInfoId){
        ProductDto product = productService.findProductDtoByDisplayInfoId(displayInfoId);
        List<ProductImageDto> productImages = productImageService.findProductImageDtoList(product.getId());
        List<DisplayInfoImageDto> displayInfoImages = displayInfoImageService.findDisplayInfoImageDtoByDisplayInfoId(displayInfoId);
        Double avgScore = reservationUserCommentRepository.commentAverageScoreByProductId(product.getId());
        List<ProductPriceDto> productPrices = productPriceService.findProductPriceDtoListByProductId(product.getId());

        return DisplayInfoFactory.makeDisplayInfoResponse(product, productImages, displayInfoImages, avgScore, productPrices);
    }

}
