package me.weekbelt.reservation.web.form.reservationUserComment;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import me.weekbelt.reservation.domain.reservationUserComment.ReservationUserComment;
import me.weekbelt.reservation.factory.reservationUserCommentImage.ReservationUserCommentImageFactory;
import me.weekbelt.reservation.web.form.reservationUserCommentImage.ReservationUserCommentImageDto;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

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

    private List<ReservationUserCommentImageDto> reservationUserCommentImages;

    public ReservationUserCommentDto(ReservationUserComment reservationUserComment) {
        this.id = reservationUserComment.getId();
        this.productId = reservationUserComment.getProduct().getId();
        this.reservationInfoId = reservationUserComment.getReservationInfo().getId();
        this.score = reservationUserComment.getScore();
        this.reservationEmail = reservationUserComment.getReservationInfo().getReservationEmail();
        this.comment = reservationUserComment.getComment();
        this.createDate = reservationUserComment.getCreateDate();
        this.modifyDate = reservationUserComment.getModifyDate();
        this.reservationUserCommentImages = reservationUserComment.getReservationUserCommentImages().stream()
                .map(ReservationUserCommentImageFactory::reservationUserCommentImageToReservationUserCommentImageDto)
                .collect(Collectors.toList());
    }
}
