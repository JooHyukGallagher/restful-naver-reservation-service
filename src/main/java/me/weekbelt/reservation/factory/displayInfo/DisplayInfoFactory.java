package me.weekbelt.reservation.factory.displayInfo;

import me.weekbelt.reservation.domain.displayInfo.DisplayInfo;
import me.weekbelt.reservation.domain.productImage.ProductImage;
import me.weekbelt.reservation.factory.product.ProductFactory;
import me.weekbelt.reservation.web.form.displayInfo.DisplayInfoResponse;
import me.weekbelt.reservation.web.form.displayInfoImage.DisplayInfoImageDto;
import me.weekbelt.reservation.web.form.displayInfoImage.DisplayInfoResponseModel;
import me.weekbelt.reservation.web.form.product.ProductDto;
import me.weekbelt.reservation.web.form.productImage.ProductImageDto;
import me.weekbelt.reservation.web.form.productPrice.ProductPriceDto;
import org.springframework.hateoas.EntityModel;

import java.util.List;

public class DisplayInfoFactory {

    public static ProductDto displayInfoToProductDto(DisplayInfo displayInfo){
        List<ProductImage> productImages = displayInfo.getProduct().getProductImages();
        ProductDto productDto = ProductFactory.displayInfoToProductDto(displayInfo);
        productDto.addFileId(productImages.get(0).getFileInfo().getId());
        return productDto;
    }

    public static DisplayInfoResponse makeDisplayInfoResponse(ProductDto product, List<ProductImageDto> productImages,
                                                        List<DisplayInfoImageDto> displayInfoImages,
                                                        Double avgScore, List<ProductPriceDto> productPrices) {
        return DisplayInfoResponse.builder()
                .product(product)
                .productImages(productImages)
                .displayInfoImages(displayInfoImages)
                .avgScore(avgScore)
                .productPrices(productPrices)
                .build();
    }

    public static DisplayInfoResponseModel makeDisplayInfoResponseModel(EntityModel<ProductDto> product, List<ProductImageDto> productImages,
                                                                        List<DisplayInfoImageDto> displayInfoImages,
                                                                        Double avgScore, List<ProductPriceDto> productPrices) {
        return DisplayInfoResponseModel.builder()
                .product(product)
                .productImages(productImages)
                .displayInfoImages(displayInfoImages)
                .avgScore(avgScore)
                .productPrices(productPrices)
                .build();
    }
}
