package me.weekbelt.reservation.service;

import lombok.RequiredArgsConstructor;
import me.weekbelt.reservation.domain.productPrice.ProductPrice;
import me.weekbelt.reservation.domain.productPrice.ProductPriceRepository;
import me.weekbelt.reservation.factory.productPrice.ProductPriceFactory;
import me.weekbelt.reservation.web.form.productPrice.ProductPriceDto;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class ProductPriceService {

    private final ProductPriceRepository productPriceRepository;

    public List<ProductPriceDto> findProductPriceDtoListByProductId(Long productId) {
        List<ProductPrice> productPrices = productPriceRepository.findProductPricesByProductIdOrderByIdDesc(productId);
        return productPrices.stream()
                .map(productPrice -> ProductPriceFactory.productPriceToProductPriceDto(productPrice, productId))
                .collect(Collectors.toList());
    }
}
