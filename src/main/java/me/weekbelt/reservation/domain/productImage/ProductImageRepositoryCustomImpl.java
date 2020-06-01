package me.weekbelt.reservation.domain.productImage;

import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import me.weekbelt.reservation.domain.ImageType;
import me.weekbelt.reservation.domain.fileInfo.QFileInfo;
import me.weekbelt.reservation.domain.product.QProduct;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static me.weekbelt.reservation.domain.fileInfo.QFileInfo.fileInfo;
import static me.weekbelt.reservation.domain.product.QProduct.product;
import static me.weekbelt.reservation.domain.productImage.QProductImage.productImage;

@RequiredArgsConstructor
@Transactional(readOnly = true)
public class ProductImageRepositoryCustomImpl implements ProductImageRepositoryCustom{

    private final JPAQueryFactory queryFactory;

    @Override
    public List<ProductImage> findProductImageByProductIdAndType(Long productId, ImageType type) {
        return queryFactory.select(productImage)
                .from(productImage)
                .join(productImage.product, product).fetchJoin()
                .join(productImage.fileInfo, fileInfo).fetchJoin()
                .where(productImage.product.id.eq(productId), productImage.type.eq(type))
                .fetch();
    }
}
