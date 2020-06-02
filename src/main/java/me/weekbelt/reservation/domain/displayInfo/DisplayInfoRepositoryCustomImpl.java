package me.weekbelt.reservation.domain.displayInfo;

import com.querydsl.core.QueryResults;
import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static me.weekbelt.reservation.domain.category.QCategory.category;
import static me.weekbelt.reservation.domain.displayInfo.QDisplayInfo.displayInfo;
import static me.weekbelt.reservation.domain.product.QProduct.product;

@RequiredArgsConstructor
@Transactional(readOnly = true)
public class DisplayInfoRepositoryCustomImpl implements DisplayInfoRepositoryCustom {

    private final JPAQueryFactory queryFactory;

    @Override
    public Page<DisplayInfo> findDisplayInfoPageByCategoryId(Long categoryId, Pageable pageable) {
        QueryResults<DisplayInfo> results = queryFactory
                .selectFrom(displayInfo)
                .join(displayInfo.product, product).fetchJoin()
                .join(product.category, category).fetchJoin()
                .where(categoryIdEq(categoryId))
                .limit(pageable.getPageSize())
                .offset(pageable.getOffset())
                .fetchResults();

        List<DisplayInfo> content = results.getResults();
        long total = results.getTotal();
        return new PageImpl<>(content, pageable, total);
    }


    @Override
    public DisplayInfo findDisplayInfoById(Long displayInfoId) {
        return queryFactory
                .selectFrom(displayInfo)
                .join(displayInfo.product, product).fetchJoin()
                .join(product.category, category).fetchJoin()
                .where(displayInfo.id.eq(displayInfoId))
                .fetchOne();
    }

    private BooleanExpression categoryIdEq(Long categoryId) {
        if (categoryId == null || categoryId == 0) {
            return null;
        }
        return product.category.id.eq(categoryId);
    }
}
