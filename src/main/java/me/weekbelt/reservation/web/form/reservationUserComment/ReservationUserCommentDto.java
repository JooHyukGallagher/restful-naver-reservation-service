package me.weekbelt.reservation.web.form.reservationUserComment;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Builder @NoArgsConstructor @AllArgsConstructor
@Getter
public class ReservationUserCommentDto {

    private Long id;

    private Long productId;

    private Long reservationInfoId;

    private Double score;

    private String reservationEmail;

    private String comment;

    private LocalDateTime createDate;

    private LocalDateTime modifyDate;
}
