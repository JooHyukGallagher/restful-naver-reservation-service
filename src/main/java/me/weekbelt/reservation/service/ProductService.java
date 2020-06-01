package me.weekbelt.reservation.service;

import lombok.RequiredArgsConstructor;
import me.weekbelt.reservation.domain.ImageType;
import me.weekbelt.reservation.domain.displayInfo.DisplayInfo;
import me.weekbelt.reservation.domain.displayInfo.DisplayInfoRepository;
import me.weekbelt.reservation.domain.productImage.ProductImage;
import me.weekbelt.reservation.domain.productImage.ProductImageRepository;
import me.weekbelt.reservation.factory.product.ProductFactory;
import me.weekbelt.reservation.web.form.product.ProductDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class ProductService {

    private final DisplayInfoRepository displayInfoRepository;
    private final ProductImageRepository productImageRepository;

    public Page<ProductDto> findProductDtoListByCategoryId(Long categoryId, Pageable pageable) {
        Page<DisplayInfo> displayInfoPage = displayInfoRepository
                .findDisplayInfoPageByCategoryId(categoryId, pageable);

        return displayInfoPage.map(displayInfo -> {
            List<ProductImage> productImages = productImageRepository
                    .findProductImageByProductIdAndType(displayInfo.getProduct().getId(), ImageType.th);

            ProductDto productDto = ProductFactory.displayInfoToProductDto(displayInfo);
            productDto.addFileId(productImages.get(0).getFileInfo().getId());
            return productDto;
        });
    }

    public ProductDto findProductDtoByDisplayInfoId(Long displayInfoId) {
        DisplayInfo displayInfo = displayInfoRepository.findDisplayInfoById(displayInfoId);
        ProductImage productImage = productImageRepository.findProductImageByProductIdAndType(displayInfo.getProduct().getId(), ImageType.ma).get(0);
        ProductDto productDto = ProductFactory.displayInfoToProductDto(displayInfo);
        productDto.addFileId(productImage.getFileInfo().getId());
        return productDto;
    }
}
