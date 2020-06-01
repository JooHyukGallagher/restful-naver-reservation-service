package me.weekbelt.reservation.web.form.displayInfo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import me.weekbelt.reservation.domain.productPrice.ProductPrice;
import me.weekbelt.reservation.web.form.displayInfoImage.DisplayInfoImageDto;
import me.weekbelt.reservation.web.form.product.ProductDto;
import me.weekbelt.reservation.web.form.productImage.ProductImageDto;
import me.weekbelt.reservation.web.form.productPrice.ProductPriceDto;

import java.util.List;

@Builder @NoArgsConstructor @AllArgsConstructor
@Getter
public class DisplayInfoResponse {

    private ProductDto product;

    private List<ProductImageDto> productImages;

    private List<DisplayInfoImageDto> displayInfoImages;

    private Double avgScore;

    private List<ProductPriceDto> productPrices;
}
