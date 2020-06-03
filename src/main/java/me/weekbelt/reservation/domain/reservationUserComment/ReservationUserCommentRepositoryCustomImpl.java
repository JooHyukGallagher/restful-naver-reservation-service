package me.weekbelt.reservation.domain.reservationUserComment;

import com.querydsl.core.QueryResults;
import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import me.weekbelt.reservation.domain.product.QProduct;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static me.weekbelt.reservation.domain.product.QProduct.*;
import static me.weekbelt.reservation.domain.reservationInfo.QReservationInfo.reservationInfo;
import static me.weekbelt.reservation.domain.reservationUserComment.QReservationUserComment.reservationUserComment;

@RequiredArgsConstructor
@Transactional(readOnly = true)
public class ReservationUserCommentRepositoryCustomImpl implements ReservationUserCommentRepositoryCustom {

    private final JPAQueryFactory queryFactory;

    @Override
    public Double commentAverageScoreByProductId(Long productId) {
        return queryFactory
                .select(reservationUserComment.score.avg())
                .from(reservationUserComment)
                .where(productIdEq(productId))
                .fetchOne();
    }

    @Override
    public Page<ReservationUserComment> findReservationUserCommentsByProductId(Long productId, Pageable pageable) {
        QueryResults<ReservationUserComment> results = queryFactory
                .selectFrom(reservationUserComment)
                .join(reservationUserComment.reservationInfo, reservationInfo).fetchJoin()
                .join(reservationUserComment.product, product).fetchJoin()
                .where(productIdEq(productId))
                .limit(pageable.getPageSize())
                .offset(pageable.getOffset())
                .orderBy(reservationUserComment.id.desc())
                .fetchResults();

        List<ReservationUserComment> content = results.getResults();
        long total = results.getTotal();
        return new PageImpl<>(content, pageable, total);
    }

    private BooleanExpression productIdEq(Long productId) {
        if (productId == null || productId == 0){
            return null;
        }
        return reservationUserComment.product.id.eq(productId);
    }
}
