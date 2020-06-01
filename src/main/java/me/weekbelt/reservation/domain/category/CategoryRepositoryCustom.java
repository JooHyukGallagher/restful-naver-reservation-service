package me.weekbelt.reservation.domain.category;

import me.weekbelt.reservation.web.form.category.CategoryDto;

import java.util.List;

public interface CategoryRepositoryCustom {
    List<CategoryDto> findCategoryDtoList();
}
