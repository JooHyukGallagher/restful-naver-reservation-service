package me.weekbelt.reservation.web.controller;

import lombok.RequiredArgsConstructor;
import me.weekbelt.reservation.service.ProductService;
import me.weekbelt.reservation.web.form.product.ProductDto;
import me.weekbelt.reservation.web.form.product.ProductResponse;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RequestMapping("/api")
@RestController
public class ProductApiController {

    private final ProductService productService;

    @GetMapping("/v1/displayinfos")
    public ProductResponse getProductResponse(Long categoryId,
                                              @PageableDefault(size = 4) Pageable pageable) {
        Page<ProductDto> products = productService.findProductResponseByCategoryId(categoryId, pageable);

        return ProductResponse.builder()
                .totalCount(products.getTotalElements())
                .productCount(products.getNumberOfElements())
                .products(products)
                .build();
    }
}
