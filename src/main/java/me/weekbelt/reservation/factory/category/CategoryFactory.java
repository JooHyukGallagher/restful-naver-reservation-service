package me.weekbelt.reservation.factory.category;

import me.weekbelt.reservation.web.form.category.CategoryDto;
import me.weekbelt.reservation.web.form.category.CategoryResponse;

import java.util.List;

public class CategoryFactory {

    public static CategoryResponse makeCategoryResponse(List<CategoryDto> categoryDtoList){
        return CategoryResponse.builder()
                .items(categoryDtoList)
                .size(categoryDtoList.size())
                .build();
    }
}
