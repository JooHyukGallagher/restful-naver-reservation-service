package me.weekbelt.reservation.web.form.category;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Builder @NoArgsConstructor @AllArgsConstructor
@Getter
public class CategoryDto {

    private Long id;

    private String name;

    private Integer count;

}
