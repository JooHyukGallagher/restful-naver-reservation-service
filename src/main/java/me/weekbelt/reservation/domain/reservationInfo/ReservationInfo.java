package me.weekbelt.reservation.domain.reservationInfo;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import me.weekbelt.reservation.domain.BaseTimeEntity;
import org.hibernate.annotations.ColumnDefault;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter @NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
public class ReservationInfo extends BaseTimeEntity {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 50)
    private String reservationName;

    @Column(nullable = false)
    private String reservationTel;

    @Column(nullable = false)
    private String reservationEmail;

    @Column(nullable = false)
    private LocalDateTime reservationDate;

    @Column(nullable = false)
    @ColumnDefault("false")
    private boolean cancelFlag;
}
