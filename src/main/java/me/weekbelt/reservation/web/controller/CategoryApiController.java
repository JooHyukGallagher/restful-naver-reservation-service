package me.weekbelt.reservation.web.controller;

import lombok.RequiredArgsConstructor;
import me.weekbelt.reservation.domain.category.CategoryRepository;
import me.weekbelt.reservation.web.form.category.CategoryDto;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.Link;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api")
public class CategoryApiController {

    private final CategoryRepository categoryRepository;

    @GetMapping("/v1/categories")
    public ResponseEntity<?> getCategoryResponseV1() {
        List<CategoryDto> categoryDtoList = categoryRepository.findCategoryDtoList();
        CollectionModel<CategoryDto> model = makeCategoriesModel(categoryDtoList);
        return ResponseEntity.ok(model);
    }

    private CollectionModel<CategoryDto> makeCategoriesModel(List<CategoryDto> categoryDtoList) {
        CollectionModel<CategoryDto> model = CollectionModel.of(categoryDtoList, linkTo(CategoryApiController.class).withSelfRel());
        model.add(Link.of("/api/v1/displayinfos?categoryId=1").withRel("exhibition-products"));
        model.add(Link.of("/api/v1/displayinfos?categoryId=2").withRel("musical-products"));
        model.add(Link.of("/api/v1/displayinfos?categoryId=3").withRel("concert-products"));
        model.add(Link.of("/api/v1/displayinfos?categoryId=4").withRel("classic-products"));
        model.add(Link.of("/api/v1/displayinfos?categoryId=5").withRel("play-products"));
        model.add(Link.of("/docs/index.html#resources-category-list").withRel("profile"));
        return model;
    }

}
