package me.weekbelt.reservation.web.form.displayInfoImage;

import lombok.Builder;
import lombok.Getter;
import me.weekbelt.reservation.domain.productImage.ProductImage;
import me.weekbelt.reservation.web.form.displayInfo.DisplayInfoResponse;
import me.weekbelt.reservation.web.form.product.ProductDto;
import me.weekbelt.reservation.web.form.productImage.ProductImageDto;
import me.weekbelt.reservation.web.form.productPrice.ProductPriceDto;
import org.springframework.hateoas.EntityModel;

import java.util.List;

@Builder
@Getter
public class DisplayInfoResponseModel extends EntityModel<DisplayInfoResponseModel> {

    private ProductDto product;

    private List<ProductImageDto> productImages;

    private List<DisplayInfoImageDto> displayInfoImages;

    private Double avgScore;

    private List<ProductPriceDto> productPrices;
}
