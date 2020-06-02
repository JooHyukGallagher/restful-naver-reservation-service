package me.weekbelt.reservation.domain.reservationUserComment;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ReservationUserCommentRepositoryCustom {
    Double commentAverageScoreByProductId(Long productId);

    Page<ReservationUserComment> findReservationUserCommentsByProductId(Long productId, Pageable pageable);
}
