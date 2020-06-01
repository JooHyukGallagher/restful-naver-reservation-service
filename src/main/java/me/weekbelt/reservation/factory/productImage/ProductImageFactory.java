package me.weekbelt.reservation.factory.productImage;

import me.weekbelt.reservation.domain.productImage.ProductImage;
import me.weekbelt.reservation.web.form.productImage.ProductImageDto;

public class ProductImageFactory {

    public static ProductImageDto productImageToProductImageDto(ProductImage productImage){
        return ProductImageDto.builder()
                .productId(productImage.getProduct().getId())
                .productImageId(productImage.getId())
                .type(productImage.getType())
                .fileInfoId(productImage.getFileInfo().getId())
                .fileName(productImage.getFileInfo().getFileName())
                .saveFileName(productImage.getFileInfo().getSaveFileName())
                .contentType(productImage.getFileInfo().getContentType())
                .deleteFlag(productImage.getFileInfo().isDeleteFlag())
                .createDate(productImage.getFileInfo().getCreateDate())
                .modifyDate(productImage.getFileInfo().getModifyDate())
                .build();
    }
}
