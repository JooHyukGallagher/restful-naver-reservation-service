package me.weekbelt.reservation.web.form.category;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import me.weekbelt.reservation.web.controller.CategoryApiController;
import org.springframework.hateoas.EntityModel;

import java.util.List;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@Builder @NoArgsConstructor @AllArgsConstructor
@Getter
public class CategoryResponse extends EntityModel<CategoryResponse> {

    private Integer size;
    private List<CategoryDto> items;

}
