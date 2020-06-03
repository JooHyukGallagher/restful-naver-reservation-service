package me.weekbelt.reservation.factory.reservationUserCommentImage;

import me.weekbelt.reservation.domain.reservationUserCommentImage.ReservationUserCommentImage;
import me.weekbelt.reservation.web.form.reservationUserCommentImage.ReservationUserCommentImageDto;

public class ReservationUserCommentImageFactory {

    public static ReservationUserCommentImageDto reservationUserCommentImageToReservationUserCommentImageDto(
            ReservationUserCommentImage reservationUserCommentImage){

        return ReservationUserCommentImageDto.builder()
                .id(reservationUserCommentImage.getId())
                .reservationInfoId(reservationUserCommentImage.getReservationInfo().getId())
                .reservationUserCommentId(reservationUserCommentImage.getReservationUserComment().getId())
                .fileId(reservationUserCommentImage.getFileInfo().getId())
                .fileName(reservationUserCommentImage.getFileInfo().getFileName())
                .saveFileName(reservationUserCommentImage.getFileInfo().getSaveFileName())
                .contentType(reservationUserCommentImage.getFileInfo().getContentType())
                .deleteFlag(reservationUserCommentImage.getFileInfo().isDeleteFlag())
                .createDate(reservationUserCommentImage.getFileInfo().getCreateDate())
                .modifyDate(reservationUserCommentImage.getFileInfo().getModifyDate())
                .build();
    }
}
