package me.weekbelt.reservation.domain.reservationInfoPrice;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Getter @NoArgsConstructor
@Entity
public class ReservationInfoPrice {

    @Id @GeneratedValue
    private Long id;

    @Column(nullable = false)
    private int count;
}
