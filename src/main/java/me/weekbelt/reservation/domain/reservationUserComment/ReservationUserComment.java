package me.weekbelt.reservation.domain.reservationUserComment;

import lombok.Getter;
import lombok.NoArgsConstructor;
import me.weekbelt.reservation.domain.BaseTimeEntity;

import javax.persistence.*;

@Getter @NoArgsConstructor
@Entity
public class ReservationUserComment extends BaseTimeEntity {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private Double score;

    @Lob
    @Column(nullable = false)
    private String comment;
}
