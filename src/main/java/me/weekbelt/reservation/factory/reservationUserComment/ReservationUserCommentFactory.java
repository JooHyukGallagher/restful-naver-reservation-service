package me.weekbelt.reservation.factory.reservationUserComment;

import me.weekbelt.reservation.domain.reservationUserComment.ReservationUserComment;
import me.weekbelt.reservation.web.form.reservationUserComment.ReservationUserCommentDto;
import me.weekbelt.reservation.web.form.reservationUserCommentImage.ReservationUserCommentImageDto;

import java.util.List;

public class ReservationUserCommentFactory {

    public static ReservationUserCommentDto ReservationUserCommentToReservationUserCommentDto(ReservationUserComment reservationUserComment, List<ReservationUserCommentImageDto> commentImages){
        return ReservationUserCommentDto.builder()
                .id(reservationUserComment.getId())
                .productId(reservationUserComment.getProduct().getId())
                .reservationInfoId(reservationUserComment.getReservationInfo().getId())
                .score(reservationUserComment.getScore())
                .reservationEmail(reservationUserComment.getReservationInfo().getReservationEmail())
                .comment(reservationUserComment.getComment())
                .createDate(reservationUserComment.getCreateDate())
                .modifyDate(reservationUserComment.getModifyDate())
                .reservationUserCommentImages(commentImages)
                .build();
    };
}
