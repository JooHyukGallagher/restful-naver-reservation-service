package me.weekbelt.reservation.web.controller;

import lombok.RequiredArgsConstructor;
import me.weekbelt.reservation.domain.category.CategoryRepository;
import me.weekbelt.reservation.factory.category.CategoryFactory;
import me.weekbelt.reservation.web.form.category.CategoryDto;
import me.weekbelt.reservation.web.form.category.CategoryResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api")
public class CategoryApiController {

    private final CategoryRepository categoryRepository;

    @GetMapping("/v1/categories")
    public CategoryResponse getCategoryResponse(){
        List<CategoryDto> categoryDtoList = categoryRepository.findCategoryDtoList();
        return CategoryFactory.makeCategoryResponse(categoryDtoList);
    }

}
