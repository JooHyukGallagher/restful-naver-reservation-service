package me.weekbelt.reservation.web.controller;

import lombok.RequiredArgsConstructor;
import me.weekbelt.reservation.service.ReservationUserCommentService;
import me.weekbelt.reservation.web.form.reservationUserComment.ReservationUserCommentDto;
import me.weekbelt.reservation.web.form.reservationUserComment.ReservationUserCommentResponse;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RequestMapping("/api")
@RestController
public class ReservationApiController {

    private final ReservationUserCommentService reservationUserCommentService;

    @GetMapping("/v1/comments")
    public ReservationUserCommentResponse comments(@RequestParam Long productId,
                                                   @PageableDefault(size = 5) Pageable pageable){
        Page<ReservationUserCommentDto> reservationUserComments = reservationUserCommentService
                .findReservationUserCommentDtoList(productId, pageable);

        return ReservationUserCommentResponse.builder()
                .totalCount(reservationUserComments.getTotalElements())
                .commentCount(reservationUserComments.getNumberOfElements())
                .reservationUSerComments(reservationUserComments)
                .build();
    }
}
