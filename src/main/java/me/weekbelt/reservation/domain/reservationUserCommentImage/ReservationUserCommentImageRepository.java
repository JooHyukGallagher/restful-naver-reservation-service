package me.weekbelt.reservation.domain.reservationUserCommentImage;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ReservationUserCommentImageRepository extends JpaRepository<ReservationUserCommentImage, Long>,
        ReservationUserCommentImageRepositoryCustom {
}
