package me.weekbelt.reservation.domain.reservationUserCommentImage;

import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import me.weekbelt.reservation.domain.reservationUserComment.QReservationUserComment;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static me.weekbelt.reservation.domain.fileInfo.QFileInfo.fileInfo;
import static me.weekbelt.reservation.domain.reservationUserComment.QReservationUserComment.reservationUserComment;
import static me.weekbelt.reservation.domain.reservationUserCommentImage.QReservationUserCommentImage.reservationUserCommentImage;

@RequiredArgsConstructor
@Transactional(readOnly = true)
public class ReservationUserCommentImageRepositoryCustomImpl implements ReservationUserCommentImageRepositoryCustom {

    private final JPAQueryFactory queryFactory;

    @Override
    public List<ReservationUserCommentImage> findReservationUserCommentImagesByReservationUserCommentId(Long reservationUserCommentId) {
        return queryFactory
                .selectFrom(reservationUserCommentImage)
                .join(reservationUserCommentImage.fileInfo, fileInfo).fetchJoin()
                .join(reservationUserCommentImage.reservationUserComment, reservationUserComment).fetchJoin()
                .where(reservationUserCommentImage.reservationUserComment.id.eq(reservationUserCommentId))
                .fetch();
    }
}
