package me.weekbelt.reservation.web.form.reservationUserCommentImage;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Builder @NoArgsConstructor @AllArgsConstructor
@Getter
public class ReservationUserCommentImageDto {

    private Long id;

    private Long reservationInfoId;

    private Long reservationUserCommentId;

    private Long fileId;

    private String fileName;

    private String saveFileName;

    private String contentType;

    private boolean deleteFlag;

    private LocalDateTime createDate;

    private LocalDateTime modifyDate;

}
