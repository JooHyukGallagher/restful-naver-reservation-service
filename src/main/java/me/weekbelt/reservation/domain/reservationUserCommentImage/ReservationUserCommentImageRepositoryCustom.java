package me.weekbelt.reservation.domain.reservationUserCommentImage;

import java.util.List;

public interface ReservationUserCommentImageRepositoryCustom {
    List<ReservationUserCommentImage> findReservationUserCommentImagesByReservationUserCommentId(Long reservationUserCommentId);
}
