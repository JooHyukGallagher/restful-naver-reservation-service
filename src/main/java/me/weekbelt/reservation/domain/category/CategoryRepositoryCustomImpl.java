package me.weekbelt.reservation.domain.category;

import com.querydsl.core.types.Projections;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import me.weekbelt.reservation.web.form.category.CategoryDto;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static me.weekbelt.reservation.domain.category.QCategory.category;
import static me.weekbelt.reservation.domain.displayInfo.QDisplayInfo.displayInfo;
import static me.weekbelt.reservation.domain.product.QProduct.product;

@Transactional(readOnly = true)
@RequiredArgsConstructor
public class CategoryRepositoryCustomImpl implements CategoryRepositoryCustom {

    private final JPAQueryFactory queryFactory;

    @Override
    public List<CategoryDto> findCategoryDtoList() {
        return queryFactory
                .select(Projections.fields(CategoryDto.class,
                        category.id,
                        category.name,
                        category.name.count().intValue().as("count")))
                .from(category)
                .join(product).on(category.id.eq(product.category.id))
                .join(displayInfo).on(product.id.eq(displayInfo.product.id))
                .groupBy(category.name)
                .orderBy(category.id.asc())
                .fetch();
    }
}
