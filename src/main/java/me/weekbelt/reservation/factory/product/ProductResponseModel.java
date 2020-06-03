package me.weekbelt.reservation.factory.product;

import me.weekbelt.reservation.web.controller.ProductApiController;
import me.weekbelt.reservation.web.form.product.ProductDto;
import org.springframework.hateoas.EntityModel;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;

public class ProductResponseModel extends EntityModel<ProductDto> {
}
