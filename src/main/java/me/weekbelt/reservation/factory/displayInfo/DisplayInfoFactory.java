package me.weekbelt.reservation.factory.displayInfo;

import me.weekbelt.reservation.domain.displayInfo.DisplayInfo;
import me.weekbelt.reservation.domain.productImage.ProductImage;
import me.weekbelt.reservation.factory.product.ProductFactory;
import me.weekbelt.reservation.web.form.product.ProductDto;

import java.util.List;

public class DisplayInfoFactory {

    public static ProductDto displayInfoToProductDto(DisplayInfo displayInfo){
        List<ProductImage> productImages = displayInfo.getProduct().getProductImages();
        ProductDto productDto = ProductFactory.displayInfoToProductDto(displayInfo);
        productDto.addFileId(productImages.get(0).getFileInfo().getId());
        return productDto;
    }
}
