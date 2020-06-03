package me.weekbelt.reservation.service;

import lombok.RequiredArgsConstructor;
import me.weekbelt.reservation.domain.reservationUserComment.ReservationUserComment;
import me.weekbelt.reservation.domain.reservationUserComment.ReservationUserCommentRepository;
import me.weekbelt.reservation.web.form.reservationUserComment.ReservationUserCommentDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class ReservationUserCommentService {

    private final ReservationUserCommentRepository reservationUserCommentRepository;

    public Page<ReservationUserCommentDto> findReservationUserCommentDtoList(Long productId, Pageable pageable) {
        Page<ReservationUserComment> reservationUserCommentPage = reservationUserCommentRepository
                .findReservationUserCommentsByProductId(productId, pageable);

        return reservationUserCommentPage.map(ReservationUserCommentDto::new);
    }
}
