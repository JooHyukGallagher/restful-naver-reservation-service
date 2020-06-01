package me.weekbelt.reservation.service;

import lombok.RequiredArgsConstructor;
import me.weekbelt.reservation.domain.ImageType;
import me.weekbelt.reservation.domain.productImage.ProductImage;
import me.weekbelt.reservation.domain.productImage.ProductImageRepository;
import me.weekbelt.reservation.factory.productImage.ProductImageFactory;
import me.weekbelt.reservation.web.form.productImage.ProductImageDto;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class ProductImageService {

    private final ProductImageRepository productImageRepository;

    public List<ProductImageDto> findProductImageDtoList(Long productId){
        List<ProductImage> productImages = productImageRepository
                .findProductImageByProductIdAndType(productId, ImageType.ma);

        return productImages.stream().map(ProductImageFactory::productImageToProductImageDto)
                .collect(Collectors.toList());
    }
}
