package me.weekbelt.reservation.web.controller;

import lombok.RequiredArgsConstructor;
import me.weekbelt.reservation.domain.category.CategoryRepository;
import me.weekbelt.reservation.web.form.category.CategoryDto;
import me.weekbelt.reservation.web.form.category.CategoryResponse;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.Link;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api")
public class CategoryApiController {

    private final CategoryRepository categoryRepository;

    @Value("${request.base.uri}")
    private String requestBaseUri;

    @GetMapping("/v1/categories")
    public ResponseEntity<?> getCategoryResponseV1() {
        List<CategoryDto> categoryDtoList = categoryRepository.findCategoryDtoList();
        CategoryResponse categoryResponse = makeCategoryResponseModel(categoryDtoList);
        return ResponseEntity.ok(categoryResponse);
    }

    private CategoryResponse makeCategoryResponseModel(List<CategoryDto> categoryDtoList) {
        CategoryResponse categoryResponse = CategoryResponse.builder()
                .items(categoryDtoList)
                .size(categoryDtoList.size())
                .build();
        categoryResponse.add(linkTo(methodOn(CategoryApiController.class).getCategoryResponseV1()).withSelfRel());
        categoryResponse.add(Link.of(requestBaseUri + "/api/v1/displayinfos?categoryId=1").withRel("exhibition-products"));
        categoryResponse.add(Link.of(requestBaseUri + "/api/v1/displayinfos?categoryId=2").withRel("musical-products"));
        categoryResponse.add(Link.of(requestBaseUri + "/api/v1/displayinfos?categoryId=3").withRel("concert-products"));
        categoryResponse.add(Link.of(requestBaseUri + "/api/v1/displayinfos?categoryId=4").withRel("classic-products"));
        categoryResponse.add(Link.of(requestBaseUri + "/api/v1/displayinfos?categoryId=5").withRel("play-products"));
        categoryResponse.add(Link.of(requestBaseUri + "/docs/index.html#resources-category-list").withRel("profile"));
        return categoryResponse;
    }

}
