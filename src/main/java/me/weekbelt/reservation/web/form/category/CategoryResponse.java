package me.weekbelt.reservation.web.form.category;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Builder @NoArgsConstructor @AllArgsConstructor
@Getter
public class CategoryResponse {

    private Integer size;
    private List<CategoryDto> items;
}
