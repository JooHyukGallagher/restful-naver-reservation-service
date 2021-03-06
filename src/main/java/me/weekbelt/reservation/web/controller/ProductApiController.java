package me.weekbelt.reservation.web.controller;

import lombok.RequiredArgsConstructor;
import me.weekbelt.reservation.factory.product.ProductResponseModel;
import me.weekbelt.reservation.service.ProductService;
import me.weekbelt.reservation.web.form.product.ProductDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.data.web.PagedResourcesAssembler;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.PagedModel;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;

@RequiredArgsConstructor
@RequestMapping("/api")
@RestController
public class ProductApiController {

    private final ProductService productService;

    @GetMapping("/v1/displayinfos")
    public ResponseEntity<?> getProductResponseV1(Long categoryId, @PageableDefault(size = 4) Pageable pageable,
                                                  PagedResourcesAssembler<ProductDto> assembler) {
        Page<ProductDto> products = productService.findProductDtoListByCategoryId(categoryId, pageable);
        PagedModel<EntityModel<ProductDto>> pagedModels = makeProductPageModel(assembler, products);
        return ResponseEntity.ok(pagedModels);
    }

    private PagedModel<EntityModel<ProductDto>> makeProductPageModel(PagedResourcesAssembler<ProductDto> assembler, Page<ProductDto> products) {
        PagedModel<EntityModel<ProductDto>> pagedModels = assembler
                .toModel(products, productDto -> ProductResponseModel.of(productDto,
                        linkTo(ProductApiController.class).slash(productDto.getId()).withSelfRel()));
        pagedModels.add(Link.of("/docs/index.html#resources-product-list").withRel("profile"));
        return pagedModels;
    }
}
