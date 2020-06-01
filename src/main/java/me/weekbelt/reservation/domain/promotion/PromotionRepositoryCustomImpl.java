package me.weekbelt.reservation.domain.promotion;

import com.querydsl.core.types.Projections;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import me.weekbelt.reservation.domain.ImageType;
import me.weekbelt.reservation.domain.category.QCategory;
import me.weekbelt.reservation.domain.fileInfo.QFileInfo;
import me.weekbelt.reservation.domain.product.QProduct;
import me.weekbelt.reservation.domain.productImage.QProductImage;
import me.weekbelt.reservation.web.form.promotion.PromotionDto;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static me.weekbelt.reservation.domain.category.QCategory.category;
import static me.weekbelt.reservation.domain.fileInfo.QFileInfo.fileInfo;
import static me.weekbelt.reservation.domain.product.QProduct.*;
import static me.weekbelt.reservation.domain.productImage.QProductImage.productImage;
import static me.weekbelt.reservation.domain.promotion.QPromotion.promotion;

@RequiredArgsConstructor
@Transactional(readOnly = true)
public class PromotionRepositoryCustomImpl implements PromotionRepositoryCustom{

    private final JPAQueryFactory queryFactory;

    @Override
    public List<PromotionDto> findPromotions() {
        return queryFactory
                .select(Projections.fields(PromotionDto.class,
                        promotion.id,
                        promotion.product.id.as("productId"),
                        promotion.product.category.id.as("categoryId"),
                        promotion.product.category.name.as("categoryName"),
                        promotion.product.description.as("description"),
                        fileInfo.id.as("fileId")))
                .from(promotion)
                .join(product).on(product.id.eq(promotion.product.id)).fetchJoin()
                .leftJoin(productImage).on(productImage.product.id.eq(product.id)).fetchJoin()
                .join(fileInfo).on(fileInfo.id.eq(productImage.fileInfo.id)).fetchJoin()
                .where(productImage.type.eq(ImageType.th))
                .fetch();
    }
}
