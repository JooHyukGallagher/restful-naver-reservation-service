package me.weekbelt.reservation.domain.reservationUserComment;

public interface ReservationUserCommentRepositoryCustom {
    Double commentAverageScoreByProductId(Long productId);
}
