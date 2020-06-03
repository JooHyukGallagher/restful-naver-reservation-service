package me.weekbelt.reservation.web.form.reservationUserComment;

import lombok.Builder;
import lombok.Getter;
import org.springframework.data.domain.Page;

@Builder
@Getter
public class ReservationUserCommentResponse {

    private Long totalCount;

    private Integer commentCount;

    private Page<ReservationUserCommentDto> reservationUSerComments;
}
