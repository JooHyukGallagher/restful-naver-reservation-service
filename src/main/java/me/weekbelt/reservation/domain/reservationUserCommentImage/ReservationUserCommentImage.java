package me.weekbelt.reservation.domain.reservationUserCommentImage;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Getter @NoArgsConstructor
@Entity
public class ReservationUserCommentImage {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
}
