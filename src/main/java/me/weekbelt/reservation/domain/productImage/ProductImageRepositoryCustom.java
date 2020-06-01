package me.weekbelt.reservation.domain.productImage;

import me.weekbelt.reservation.domain.ImageType;

import java.util.List;

public interface ProductImageRepositoryCustom {
    List<ProductImage> findProductImageByProductIdAndType(Long productId, ImageType type);
}
