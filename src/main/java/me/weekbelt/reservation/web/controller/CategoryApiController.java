package me.weekbelt.reservation.web.controller;

import lombok.RequiredArgsConstructor;
import me.weekbelt.reservation.domain.category.CategoryRepository;
import me.weekbelt.reservation.factory.category.CategoryFactory;
import me.weekbelt.reservation.web.form.category.CategoryDto;
import me.weekbelt.reservation.web.form.category.CategoryResponse;
import me.weekbelt.reservation.web.form.category.CategoryResponseModel;
import org.springframework.hateoas.CollectionModel;
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

    @GetMapping("/v1/categories")
    public CategoryResponse getCategoryResponseV1(){
        List<CategoryDto> categoryDtoList = categoryRepository.findCategoryDtoList();
        return CategoryFactory.makeCategoryResponse(categoryDtoList);
    }

    @GetMapping("/v2/categories")
    public ResponseEntity<?> getCategoryResponseV2(){
        List<CategoryDto> categoryDtoList = categoryRepository.findCategoryDtoList();
        CollectionModel<CategoryDto> categoryModels = CategoryResponseModel
                .of(categoryDtoList, linkTo(methodOn(CategoryApiController.class).getCategoryResponseV2()).withSelfRel());
        // TODO: CategoryDto profile문서 링크 추가
        return ResponseEntity.ok(categoryModels);
    }

}
