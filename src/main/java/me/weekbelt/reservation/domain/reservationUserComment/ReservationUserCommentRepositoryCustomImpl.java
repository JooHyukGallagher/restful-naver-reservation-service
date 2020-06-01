package me.weekbelt.reservation.domain.reservationUserComment;

import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.transaction.annotation.Transactional;

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
                .where(reservationUserComment.product.id.eq(productId))
                .fetchOne();
    }
}
